package it.unimib.disco.bimib.cyTRON.controller;

import it.unimib.disco.bimib.cyTRON.R.RConnectionManager;
import it.unimib.disco.bimib.cyTRON.model.Dataset;
import it.unimib.disco.bimib.cyTRON.model.Event;
import it.unimib.disco.bimib.cyTRON.model.Gene;
import it.unimib.disco.bimib.cyTRON.model.Hypothesis;
import it.unimib.disco.bimib.cyTRON.model.Pattern;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class HypothesesController {
	
	public static final String[] OPERATIONS = new String[]{"AND", "OR", "XOR"};
	
	private DefaultTreeModel patternTreeModel;
	private final DefaultListModel<Pattern> patternsListModel;
	private final DefaultListModel<Hypothesis> hypothesesListModel;
	
	public HypothesesController() {
		patternTreeModel = new DefaultTreeModel(new DefaultMutableTreeNode("Pattern"));
		patternsListModel = new DefaultListModel<>();
		hypothesesListModel = new DefaultListModel<>();
	}
	
	// ************ TREE ************ \\
	public void addNode(DefaultMutableTreeNode parentNode, Object childObject) {
		// construct the child node
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(childObject);
		
		// add the child to the model
		patternTreeModel.insertNodeInto(childNode, parentNode, parentNode.getChildCount());
	}
	
	public void removeNode(DefaultMutableTreeNode node) {
            try {
                // remove the node
		patternTreeModel.removeNodeFromParent(node);
            } catch (IllegalArgumentException e) {
            }	
	}
	
	public void clearPatternTreeModel() {
		patternTreeModel = new DefaultTreeModel(new DefaultMutableTreeNode("Pattern"));
	}
	
	public DefaultTreeModel getPatternTreeModel() {
		return patternTreeModel;
	}
	
	// ************ PATTERNS AND HYPOTHESES ************ \\
    public void addHypothesis(Dataset dataset, String label, List<Event> effect, List<Event> cause, DatasetController datasetController) {
    	// build the pattern
    	String pattern = buildPattern(patternTreeModel, (DefaultMutableTreeNode) patternTreeModel.getChild(patternTreeModel.getRoot(), 0));
    	
    	// validate the input
    	label = label.trim();
    	label = label.replace(" ", "_");
    	
    	// add the hypothesis
    	dataset.addHypothesis(pattern, label, effect, cause);
    	
    	// if the last console message is regular
    	if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
    		// update the pattern list
        	updatePatternsList(dataset);
        	
        	// update the lists of events and types
        	datasetController.updateLists(dataset);
    	}
    }
    
    public void addGroupHypothesis(Dataset dataset, String operation, List<Gene> genes, List<Event> effect, List<Event> cause, Integer minimumCardinality, Integer maximumCardinality, Float minimumProbability, DatasetController datasetController) {
    	// validate the input
        if (minimumCardinality < 2 || minimumCardinality > maximumCardinality) {
            minimumCardinality = 2;
        }
        if (maximumCardinality > genes.size() || maximumCardinality < minimumCardinality) {
            maximumCardinality = genes.size();
        }

        // add the group
    	dataset.addGroupHypothesis(operation, genes, effect, cause, minimumCardinality, maximumCardinality, minimumProbability);
    	
    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
        	// update the pattern list
        	updatePatternsList(dataset);
        	
        	// update the lists of events and types
        	datasetController.updateLists(dataset);
        }
    }
    
    public void addHomologousHypothesis(Dataset dataset, List<Event> effect, List<Event> cause, List<Gene> genes, DatasetController datasetController) {
    	// add the homologous
    	dataset.addHomologousHypothesis(effect, cause, genes);
    	
    	// if the last console message is regular
    	if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
    		// update the pattern list
        	updatePatternsList(dataset);
        	
        	// update the lists of events and types
        	datasetController.updateLists(dataset);
    	}
    }
    
    public void deletePattern(Dataset dataset, int patternIndex, DatasetController datasetController) {
    	// get the pattern
    	Pattern pattern = patternsListModel.getElementAt(patternIndex);
    	
    	// delete the pattern from the dataset
    	dataset.deletePattern(pattern);
    	
    	// if the last console message is regular
    	if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
    	   	// update the pattern list
        	updatePatternsList(dataset);
        	
        	// update the lists of events and types
        	datasetController.updateLists(dataset);
    	}
    }
    
    public void deleteHypothesis(Dataset dataset, String deletion, Object event, int patternIndex) {
    	// delete the hypotheses from the dataset
    	dataset.deleteHypothesis(deletion, event);
    	
    	// if the last console message is regular
    	if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
    		// update the hypotheses list
        	updateHypothesesList(patternIndex);
    	}
    }
    
    // ************ OTHERS ************ \\
    private String buildPattern(DefaultTreeModel patternTreeModel, DefaultMutableTreeNode node) {
    	String objectString = null;
    	
    	if (node.getUserObject() instanceof String) {
			String string = (String) node.getUserObject();
    		objectString = string + '(';
    		for (int i = 0; i < patternTreeModel.getChildCount(node); i++) {
    			objectString += buildPattern(patternTreeModel, (DefaultMutableTreeNode) patternTreeModel.getChild(node, i));
    			if (i < patternTreeModel.getChildCount(node) - 1) {
    				objectString += ", ";
    			}
    		}
    		objectString += ")";
		} else if (node.getUserObject() instanceof Gene) {
			Gene gene = (Gene) node.getUserObject();
			objectString = "'" + gene.getName() + "'"; 
		}  else if (node.getUserObject() instanceof Event) {
			Event event = (Event) node.getUserObject();
			objectString = "c('" + event.getGene().getName() + "', '" + event.getType().getName() + "')";
		}
    	
    	return objectString;
    }
    
    public boolean isPatternTreeEmpty() {
    	int rootChildNumber = patternTreeModel.getChildCount(patternTreeModel.getRoot());
    	
    	if (rootChildNumber == 0) {
			return true;
		}
    	
    	return false;
    }
    
    // ************ LIST UPDATES ************ \\
    public void updatePatternsList(Dataset dataset) {
    	patternsListModel.clear();
    	for (Pattern pattern : dataset.getPatterns()) {
    		patternsListModel.addElement(pattern);
    	}
    }
    
    public void updateHypothesesList(int patternIndex) {
    	hypothesesListModel.clear();
    	if (patternIndex != -1) {
            for (Hypothesis hypothesis : patternsListModel.get(patternIndex).getHypotheses()) {
        	hypothesesListModel.addElement(hypothesis);
            }
    	}
    }
    
    // ************ LIST GETTERS ************ \\
    public DefaultListModel getPatternsListModel() {
        return patternsListModel;
    }
    
    public DefaultListModel getHypothesesListModel() {
        return hypothesesListModel;
    }
}
