package it.unimib.disco.bimib.cyTRON.controller;

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
		// remove the node
		patternTreeModel.removeNodeFromParent(node);
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
    	
    	// add the hypothesis
    	dataset.addHypothesis(pattern, label, effect, cause);
    	
    	// update the pattern list
    	updatePatternsList(dataset);
    	
    	// update the lists of events and types
    	datasetController.updateLists(dataset);
    }
    
    public void addGroupHypothesis() {
    	
    }
    
    public void addHomologousHypothesis() {
    	
    }
    
    public void deletePattern(Dataset dataset, int patternIndex, DatasetController datasetController) {
    	// get the pattern
    	Pattern pattern = patternsListModel.getElementAt(patternIndex);
    	
    	// delete the pattern from the dataset
    	dataset.deletePattern(pattern);
    	
    	// update the pattern list
    	updatePatternsList(dataset);
    	
    	// update the lists of events and types
    	datasetController.updateLists(dataset);
    }
    
    public void deleteHypothesis() {
    	
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
    @SuppressWarnings("rawtypes")
	public DefaultListModel getPatternsListModel() {
        return patternsListModel;
    }
    
    @SuppressWarnings("rawtypes")
	public DefaultListModel getHypothesesListModel() {
        return hypothesesListModel;
    }
}
