package it.unimib.disco.bimib.cyTRON.cytoscape;

import org.cytoscape.view.layout.CyLayoutAlgorithm;
import org.cytoscape.view.layout.CyLayoutAlgorithmManager;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.events.NetworkViewAddedEvent;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.work.TaskManager;

public class NetworkViewAddedHierarchicLayoutListener implements org.cytoscape.view.model.events.NetworkViewAddedListener {

	private final CyLayoutAlgorithmManager layoutAlgorithmManager;
	private final TaskManager taskManager;
	
	public NetworkViewAddedHierarchicLayoutListener(CyLayoutAlgorithmManager layoutAlgorithmManager, TaskManager taskManager) {
		this.layoutAlgorithmManager = layoutAlgorithmManager;
		this.taskManager = taskManager;
	}
	
	@Override
	public void handleEvent(NetworkViewAddedEvent arg0) {
		// get the view
		CyNetworkView view = arg0.getNetworkView();
		
		// set the hierarchic layout
        CyLayoutAlgorithm layout = layoutAlgorithmManager.getLayout("hierarchic");
        if (layout == null) {
            layout = layoutAlgorithmManager.getDefaultLayout();
        }
        TaskIterator taskIterator = layout.createTaskIterator(view, layout.getDefaultLayoutContext(), CyLayoutAlgorithm.ALL_NODE_VIEWS, null);
        taskManager.execute(taskIterator);
	}

}
