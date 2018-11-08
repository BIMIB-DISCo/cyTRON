package it.unimib.disco.bimib.cyTRON.cytoscape;

import java.util.Collection;

import org.cytoscape.model.CyNetwork;
import org.cytoscape.view.layout.CyLayoutAlgorithm;
import org.cytoscape.view.layout.CyLayoutAlgorithmManager;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.view.model.events.NetworkViewAddedEvent;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.work.TaskManager;

public class NetworkViewAddedTroncoListener implements org.cytoscape.view.model.events.NetworkViewAddedListener {

	private final CyNetworkViewManager networkViewManager;
	private final CyLayoutAlgorithmManager layoutAlgorithmManager;
	private final TaskManager taskManager;
	
	public NetworkViewAddedTroncoListener(CyNetworkViewManager networkViewManager, CyLayoutAlgorithmManager layoutAlgorithmManager, TaskManager taskManager) {
		this.networkViewManager = networkViewManager;
		this.layoutAlgorithmManager = layoutAlgorithmManager;
		this.taskManager = taskManager;
	}
	
	@Override
	public void handleEvent(NetworkViewAddedEvent arg0) {
		// get the view
		CyNetworkView view = arg0.getNetworkView();
		CyNetwork network = view.getModel();
		
		// check if it is a TRONCO network by its information field
    	if (!NetworkAddedTroncoListener.isTroncoNetwork(network)) {
    		return;
    	}
    	
    	// destroy the view if it is not the only one, otherwise set the layout
    	Collection<CyNetworkView> views = networkViewManager.getNetworkViews(network);
    	if (views.size() > 1) {
    		networkViewManager.destroyNetworkView(view);
    	} else {
            CyLayoutAlgorithm layout = layoutAlgorithmManager.getDefaultLayout();
            TaskIterator taskIterator = layout.createTaskIterator(view, layout.getDefaultLayoutContext(), CyLayoutAlgorithm.ALL_NODE_VIEWS, null);
            taskManager.execute(taskIterator);
    	}
		
		// set the hierarchic layout
        // CyLayoutAlgorithm layout = layoutAlgorithmManager.getLayout("hierarchic");
        // if (layout == null) {
        //	layout = layoutAlgorithmManager.getDefaultLayout();
        // }
	}

}
