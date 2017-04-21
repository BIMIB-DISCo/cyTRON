package org.cytoscape.cytron.cyTRON.internal;

import java.util.Properties;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.service.util.CyServiceRegistrar;
import org.cytoscape.view.layout.CyLayoutAlgorithmManager;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.view.vizmap.VisualMappingFunctionFactory;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.view.vizmap.VisualStyleFactory;
import org.cytoscape.work.ServiceProperties;
import org.cytoscape.work.TaskManager;
import org.osgi.framework.BundleContext;

public class CyActivator extends AbstractCyActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		
		CyApplicationManager cyApplicationManager = getService(context, CyApplicationManager.class);
		
		//MenuAction action = new MenuAction(cyApplicationManager, "Hello World App");
		
		Properties importGraphProperties = new Properties();
		importGraphProperties.setProperty("preferredMenu", "Apps");
		importGraphProperties.setProperty("title", "cyTRON");
		importGraphProperties.put(ServiceProperties.COMMAND, "import");
		importGraphProperties.put(ServiceProperties.COMMAND_NAMESPACE, "cytron");
		
		Properties listenerProperties = new Properties();
		
		VisualMappingManager vmmServiceRef = getService(context, VisualMappingManager.class);
		VisualStyleFactory visualStyleFactoryServiceRef = getService(context, VisualStyleFactory.class);
		
		VisualMappingFunctionFactory vmfFactoryC = getService(context, VisualMappingFunctionFactory.class,
				"(mapping.type=continuous)");
		
		VisualMappingFunctionFactory vmfFactoryP = getService(context, VisualMappingFunctionFactory.class,
				"(mapping.type=passthrough)");
		
		VisualMappingFunctionFactory vmfFactoryD = getService(context, VisualMappingFunctionFactory.class,
				"(mapping.type=discrete)");
		
		CyNetworkViewManager networkViewManager = getService(context, 
				CyNetworkViewManager.class);
		
		CyNetworkViewFactory networkViewFactory = getService(context,
				CyNetworkViewFactory.class);
		
		CyLayoutAlgorithmManager algorithmManager = getService(context,
				CyLayoutAlgorithmManager.class);
		
		TaskManager taskManager = getService(context, TaskManager.class);
		
		VisualStyleFactory vsFactory = getService(context, VisualStyleFactory.class);
		
		VisualMappingManager vmManager = getService(context, VisualMappingManager.class);
		
		CyServiceRegistrar registrar = getService(context, CyServiceRegistrar.class);
		
		SetLayoutPropertiesListener listener = new SetLayoutPropertiesListener(networkViewManager, 
				networkViewFactory,
				algorithmManager, 
				taskManager,
				visualStyleFactoryServiceRef, 
				vmmServiceRef,
				vmfFactoryD, 
				vmfFactoryP);
		
		
				
		ImportGraphTaskFactory factory = new ImportGraphTaskFactory(cyApplicationManager, 
				vmmServiceRef, 
				visualStyleFactoryServiceRef, 
				vmfFactoryC, 
				vmfFactoryP,
				registrar);
		
		registerAllServices(context, factory, importGraphProperties);
		registerAllServices(context, listener, listenerProperties);
		
		//registerAllServices(context, action, properties);
	}

}
