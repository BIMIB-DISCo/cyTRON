package it.unimib.disco.bimib.cyTRON;

import java.util.Properties;
import java.util.Set;

import org.cytoscape.app.swing.CySwingAppAdapter;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.command.AvailableCommands;
import org.cytoscape.command.CommandExecutorTaskFactory;
import org.cytoscape.model.CyNode;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.service.util.CyServiceRegistrar;
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

public class CyActivator extends AbstractCyActivator {

    @Override
    public void start(BundleContext context) throws Exception {
        // ImportGraphTask Properties
        Properties importGraphProperties = new Properties();
        importGraphProperties.put(ServiceProperties.COMMAND_NAMESPACE, "cytron");
        importGraphProperties.put(ServiceProperties.COMMAND, "import");
        
        // SetLayoutPropertiesListener Properties
        Properties listenerProperties = new Properties();
        
        // MenuAction Properties
        Properties menuActionProperties = new Properties();
        
        // Layout Properties
        Properties layoutProperties = new Properties();
        
        
        // Services used in SetLayoutPropertiesListener
        VisualMappingManager vmmServiceRef = getService(context,
                VisualMappingManager.class);
        VisualStyleFactory visualStyleFactoryServiceRef
                = getService(context, VisualStyleFactory.class);

        VisualMappingFunctionFactory vmfFactoryC = getService(context,
                VisualMappingFunctionFactory.class, "(mapping.type=continuous)");

        VisualMappingFunctionFactory vmfFactoryP = getService(context,
                VisualMappingFunctionFactory.class, "(mapping.type=passthrough)");

        VisualMappingFunctionFactory vmfFactoryD = getService(context,
                VisualMappingFunctionFactory.class, "(mapping.type=discrete)");

        CyNetworkViewManager networkViewManager = getService(context,
                CyNetworkViewManager.class);

        CyNetworkViewFactory networkViewFactory = getService(context,
                CyNetworkViewFactory.class);

        CyLayoutAlgorithmManager algorithmManager = getService(context,
                CyLayoutAlgorithmManager.class);

        TaskManager taskManager = getService(context,
                TaskManager.class);

        VisualStyleFactory vsFactory = getService(context,
                VisualStyleFactory.class);

        VisualMappingManager vmManager = getService(context,
                VisualMappingManager.class);

        CyServiceRegistrar registrar = getService(context,
                CyServiceRegistrar.class);

        CommandExecutorTaskFactory commandFactory = getService(context,
                CommandExecutorTaskFactory.class);

        AvailableCommands availableCommands = getService(context,
                AvailableCommands.class);

        SynchronousTaskManager synchTaskManager = getService(context,
                SynchronousTaskManager.class);

        // Service used in MenuAction and ImportGraphTask
        CommandExecutor commandExecutor = new CommandExecutor(commandFactory,
                availableCommands, synchTaskManager);

        // Services used in MenuAction
        CySwingAppAdapter adapter = getService(context, CySwingAppAdapter.class);
        
        CyApplicationManager cyApplicationManager = getService(context,
                CyApplicationManager.class);

        // New services objects creation
        SetLayoutPropertiesListener listener = new SetLayoutPropertiesListener(
                        networkViewManager,
                        networkViewFactory,
                        algorithmManager,
                        taskManager,
                        visualStyleFactoryServiceRef,
                        vmmServiceRef,
                        vmfFactoryD,
                        vmfFactoryP);

        ImportGraphTaskFactory factory;
        factory = new ImportGraphTaskFactory(commandExecutor);

        MenuAction m = new MenuAction(cyApplicationManager,
                adapter, commandExecutor, "ciao");

        // Retrivial of the yFiles -> hierarchic layout
        final NetworkViewTaskFactory hierarchic = getService(context,
                NetworkViewTaskFactory.class, "(title=Hierarchic)");

        final DummyLayoutWrapper wrapped = new DummyLayoutWrapper(hierarchic,
                "hierarchic", "yFiles Hierarchic Layout",
                getService(context, UndoSupport.class));
        
        registerAllServices(context, factory, importGraphProperties);
        registerAllServices(context, listener, listenerProperties);
        registerAllServices(context, m, menuActionProperties);
        registerService(context, wrapped, CyLayoutAlgorithm.class, layoutProperties);
    }

    // Wrapper used to encapsulate the yFiles -> hierarchic layout
    private static final class DummyLayoutWrapper extends AbstractLayoutAlgorithm {

        private final NetworkViewTaskFactory tf;

        public DummyLayoutWrapper(final NetworkViewTaskFactory tf,
                String computerName, String humanName,
                UndoSupport undoSupport) {
            super(computerName, humanName, undoSupport);
            this.tf = tf;
        }

        @Override
        public TaskIterator createTaskIterator(CyNetworkView networkView,
                Object arg1,
                Set<View<CyNode>> arg2,
                String arg3) {
            return tf.createTaskIterator(networkView);
        }
    }
}
