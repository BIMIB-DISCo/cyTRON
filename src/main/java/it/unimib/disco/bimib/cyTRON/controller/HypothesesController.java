package it.unimib.disco.bimib.cyTRON.controller;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class HypothesesController {
	
	private final DefaultTreeModel expressionTreeModel;
	
	public HypothesesController() {
		expressionTreeModel = new DefaultTreeModel(new DefaultMutableTreeNode("Expression"));
	}
	
	// ************ EXPRESSIONS ************ \\
	public void addNode(DefaultMutableTreeNode parentNode, Object childObject) {
		// construct the child node
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(childObject);
		
		// add the child to the model
		expressionTreeModel.insertNodeInto(childNode, parentNode, parentNode.getChildCount());
	}
	
	public void removeNode() {
		
	}
	
	public DefaultTreeModel getExpressionTreeModel() {
		return expressionTreeModel;
	}
	
	
	
	// ************ OTHERS ************ \\
    public void addHypothesis() {
    	
    }
    
    public void addGroupHypothesis() {
    	
    }
    
    public void addHomologousHypothesis() {
    	
    }
    
    public void deleteHypothesis() {
    	
    }
	
}
