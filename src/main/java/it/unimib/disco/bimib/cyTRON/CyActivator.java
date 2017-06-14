package it.unimib.disco.bimib.cyTRON;

import java.util.Properties;
import java.util.Set;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.command.AvailableCommands;
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
import org.cytoscape.work.ServiceProperties;
import org.cytoscape.work.SynchronousTaskManager;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.work.TaskManager;
import org.cytoscape.work.undo.UndoSupport;
import org.osgi.framework.BundleContext;

import it.unimib.disco.bimib.cyTRON.controller.CommandExecutor;
import it.unimib.disco.bimib.cyTRON.controller.ImportGraphTaskFactory;
import it.unimib.disco.bimib.cyTRON.controller.MenuAction;
import it.unimib.disco.bimib.cyTRON.controller.SetLayoutPropertiesListener;

public class CyActivator extends AbstractCyActivator {

    @Override
    public void start(BundleContext context) throws Exception {
    	// Print java.library.path
    	System.out.println("java.library.path: " + System.getProperty("java.library.path"));
    	
        // ImportGraphTask properties
        Properties importGraphProperties = new Properties();
        importGraphProperties.put(ServiceProperties.COMMAND_NAMESPACE, "cytron");
        importGraphProperties.put(ServiceProperties.COMMAND, "import");
        
        // Properties
        Properties setLayoutPropertiesListenerProperties = new Properties();
        Properties menuActionProperties = new Properties();
        Properties dummyLayoutWrapperHierarchicProperties = new Properties();
        
        // Visual services
        VisualMappingManager visualMappingManager = getService(context, VisualMappingManager.class);
        VisualStyleFactory visualStyleFactory = getService(context, VisualStyleFactory.class);
        VisualMappingFunctionFactory visualMappingFunctionFactoryDiscrete = getService(context, VisualMappingFunctionFactory.class, "(mapping.type=discrete)");
        VisualMappingFunctionFactory visualMappingFunctionFactoryPassthrough = getService(context, VisualMappingFunctionFactory.class, "(mapping.type=passthrough)");

        // CyNetwork services
        CyNetworkViewManager cyNetworkViewManager = getService(context, CyNetworkViewManager.class);
        CyNetworkViewFactory cyNetworkViewFactory = getService(context, CyNetworkViewFactory.class);
        
        // CyLayout service
        CyLayoutAlgorithmManager cyLayoutAlgorithmManager = getService(context, CyLayoutAlgorithmManager.class);

        // Task services
        TaskManager taskManager = getService(context, TaskManager.class);
        CommandExecutorTaskFactory commandExecutorTaskFactory = getService(context, CommandExecutorTaskFactory.class);
        
        // Command
        SynchronousTaskManager synchTaskManager = getService(context, SynchronousTaskManager.class);
        AvailableCommands availableCommands = getService(context, AvailableCommands.class);
        CommandExecutor commandExecutor = new CommandExecutor(commandExecutorTaskFactory, availableCommands, synchTaskManager);

        // MenuAction
        CyApplicationManager cyApplicationManager = getService(context, CyApplicationManager.class);
        MenuAction menuAction = new MenuAction(cyApplicationManager, commandExecutor, "menuAction");
        
        // Layout properties listener
        SetLayoutPropertiesListener setLayoutPropertiesListener = new SetLayoutPropertiesListener(
        		cyNetworkViewManager,
        		cyNetworkViewFactory,
                cyLayoutAlgorithmManager,
                taskManager,
                visualStyleFactory,
                visualMappingManager,
                visualMappingFunctionFactoryDiscrete,
                visualMappingFunctionFactoryPassthrough
                );

        // Custom services
        ImportGraphTaskFactory importGraphTaskFactory = new ImportGraphTaskFactory(commandExecutor);

        // Retrieval of the yFiles for hierarchic layout
        final NetworkViewTaskFactory networkViewTaskFactoryHierarchic = getService(context, NetworkViewTaskFactory.class, "(title=Hierarchic)");
        final DummyLayoutWrapper dummyLayoutWrapperHierarchic = new DummyLayoutWrapper(networkViewTaskFactoryHierarchic, "hierarchic", "yFiles Hierarchic Layout", getService(context, UndoSupport.class));

        // Services registration
        registerAllServices(context, importGraphTaskFactory, importGraphProperties);
        registerAllServices(context, setLayoutPropertiesListener, setLayoutPropertiesListenerProperties);
        registerAllServices(context, menuAction, menuActionProperties);
        registerService(context, dummyLayoutWrapperHierarchic, CyLayoutAlgorithm.class, dummyLayoutWrapperHierarchicProperties);
    }

    // Wrapper for yFiles
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
