package it.unimib.disco.bimib.cyTRON;

import java.util.Properties;
import java.util.Set;

import org.cytoscape.command.CommandExecutorTaskFactory;
import org.cytoscape.model.CyNode;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.task.NetworkViewTaskFactory;
import org.cytoscape.view.layout.AbstractLayoutAlgorithm;
import org.cytoscape.view.layout.CyLayoutAlgorithm;
import org.cytoscape.view.layout.CyLayoutAlgorithmManager;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.view.model.View;
import org.cytoscape.view.vizmap.VisualMappingFunctionFactory;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.view.vizmap.VisualStyleFactory;
import org.cytoscape.work.SynchronousTaskManager;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.work.TaskManager;
import org.cytoscape.work.undo.UndoSupport;
import org.osgi.framework.BundleContext;

import it.unimib.disco.bimib.cyTRON.cytoscape.CommandExecutor;
import it.unimib.disco.bimib.cyTRON.cytoscape.NetworkAddedTroncoVisualStyleListener;
import it.unimib.disco.bimib.cyTRON.cytoscape.NetworkViewAddedHierarchicLayoutListener;

public class CyActivator extends AbstractCyActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
    	// Startting out with a nice message.
    	System.out.println("cyTRON:\tstarting (201708)...");
    	
    	// print java.library.path
    	System.out.println("cyTRON:\tjava.library.path = " + System.getProperty("java.library.path"));
    	
    	// get the services for importing the graphml file into Cytoscape
    	CommandExecutorTaskFactory commandExecutorTaskFactory = getService(bundleContext, CommandExecutorTaskFactory.class);
    	SynchronousTaskManager synchTaskManager = getService(bundleContext, SynchronousTaskManager.class);
    	
    	// instantiates the command executor
    	CommandExecutor commandExecutor = new CommandExecutor(commandExecutorTaskFactory, synchTaskManager);
    	
    	// add cyTRON in the menu
    	MenuAction menuAction = new MenuAction(commandExecutor);
    	registerAllServices(bundleContext, menuAction, new Properties());
    	
    	// add the NetworkAddedTroncoVisualStyleListener to the services
    	CyNetworkViewManager cyNetworkViewManager = getService(bundleContext, CyNetworkViewManager.class);
        CyNetworkViewFactory cyNetworkViewFactory = getService(bundleContext, CyNetworkViewFactory.class);
        VisualStyleFactory visualStyleFactory = getService(bundleContext, VisualStyleFactory.class);
        VisualMappingManager visualMappingManager = getService(bundleContext, VisualMappingManager.class);
        VisualMappingFunctionFactory visualMappingFunctionFactoryDiscrete = getService(bundleContext, VisualMappingFunctionFactory.class, "(mapping.type=discrete)");
        VisualMappingFunctionFactory visualMappingFunctionFactoryPassthrough = getService(bundleContext, VisualMappingFunctionFactory.class, "(mapping.type=passthrough)");
    	
    	NetworkAddedTroncoVisualStyleListener networkAddedTroncoVisualStyleListener = new NetworkAddedTroncoVisualStyleListener(cyNetworkViewManager, cyNetworkViewFactory,
                visualStyleFactory, visualMappingManager, visualMappingFunctionFactoryDiscrete,
                visualMappingFunctionFactoryPassthrough);
    	registerAllServices(bundleContext, networkAddedTroncoVisualStyleListener, new Properties());
    	
    	// add the NetworkViewAddedHierarchicLayoutListener to the services
    	CyLayoutAlgorithmManager cyLayoutAlgorithmManager = getService(bundleContext, CyLayoutAlgorithmManager.class);
        TaskManager taskManager = getService(bundleContext, TaskManager.class);
        
        NetworkViewAddedHierarchicLayoutListener networkViewAddedHierarchicLayoutListener = new NetworkViewAddedHierarchicLayoutListener(cyLayoutAlgorithmManager, taskManager);
        registerAllServices(bundleContext, networkViewAddedHierarchicLayoutListener, new Properties());
    	
    	// add the hierarchic layout to the services
    	// NetworkViewTaskFactory networkViewTaskFactoryHierarchic = getService(bundleContext, NetworkViewTaskFactory.class, "(title=Hierarchic)");
        // DummyLayoutWrapper dummyLayoutWrapperHierarchic = new DummyLayoutWrapper(networkViewTaskFactoryHierarchic, "hierarchic", "yFiles Hierarchic Layout", getService(bundleContext, UndoSupport.class));
    	
    	// registerService(bundleContext, dummyLayoutWrapperHierarchic, CyLayoutAlgorithm.class, new Properties());
    }

    // wrapper for yFiles
    private static final class DummyLayoutWrapper extends AbstractLayoutAlgorithm {

        private final NetworkViewTaskFactory networkViewTaskFactory;

        public DummyLayoutWrapper(final NetworkViewTaskFactory networkViewTaskFactory, String computerName, String humanName, UndoSupport undoSupport) {
            super(computerName, humanName, undoSupport);
            this.networkViewTaskFactory = networkViewTaskFactory;
        }

        @Override
        public TaskIterator createTaskIterator(CyNetworkView networkView, Object arg1, Set<View<CyNode>> arg2, String arg3) {
            return this.networkViewTaskFactory.createTaskIterator(networkView);
        }
    }
}
