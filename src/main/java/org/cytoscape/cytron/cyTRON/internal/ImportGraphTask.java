package org.cytoscape.cytron.cyTRON.internal;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.command.AvailableCommands;
import org.cytoscape.command.CommandExecutorTaskFactory;
import org.cytoscape.service.util.CyServiceRegistrar;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.view.vizmap.VisualMappingFunctionFactory;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.view.vizmap.VisualStyleFactory;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.FinishStatus;
import org.cytoscape.work.ObservableTask;
import org.cytoscape.work.SynchronousTaskManager;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.TaskObserver;
import org.cytoscape.work.Tunable;


import org.rosuda.JRI.Rengine;

public class ImportGraphTask extends AbstractTask {

	
	private CyApplicationManager cyApplicationManagerServiceRef;
	private VisualMappingManager vmmServiceRef;
	private VisualStyleFactory visualStyleFactoryServiceRef;
	private VisualMappingFunctionFactory vmfFactoryC;
	private VisualMappingFunctionFactory vmfFactoryP;
	private CyNetworkViewManager cyNetworkViewManagerServiceRef;
	private CyServiceRegistrar serviceRegistrar ;
	
	CommandExecutorTaskFactory commandTaskFactory = null;
	SynchronousTaskManager taskManager = null;
	AvailableCommands availableCommands = null;

	
	public ImportGraphTask(CyApplicationManager cyApplicationManagerServiceRef,
			VisualMappingManager vmmServiceRef, 
			VisualStyleFactory visualStyleFactoryServiceRef,
			VisualMappingFunctionFactory vmfFactoryC, 
			VisualMappingFunctionFactory vmfFactoryP,
			CyServiceRegistrar registrar) {
		
		this.cyApplicationManagerServiceRef = cyApplicationManagerServiceRef;
		this.vmmServiceRef = vmmServiceRef;
		this.visualStyleFactoryServiceRef = visualStyleFactoryServiceRef;
		this.vmfFactoryC = vmfFactoryC;
		this.vmfFactoryP = vmfFactoryP;
		this.serviceRegistrar = registrar;

	}

	@Tunable(description = "Network file", params = "fileCategory=network;input=true")
	public File f;
	
	

	public void run(TaskMonitor monitor) {
		
		if (!Rengine.versionCheck()) {
		    System.err.println("** Version mismatch - Java files don't match library version.");
		    System.exit(1);
		}
		
		Rengine re = new Rengine(null, false, new TextConsole());
		
		
		if (!re.waitForR()) {
            System.out.println("Cannot load R");
            return;
        }
		
		re.eval("source('" + f.getAbsolutePath() + "')");
		TaskObserver t = new TaskObserver(){
			@Override
			public void taskFinished(ObservableTask arg0) {
				System.out.println("TaskFinished");
			}
			@Override
			public void allFinished(FinishStatus arg0) {
				System.out.println("TaskAllFinished");
				
			}
		};
		
		HashMap<String, Object> mappa = new HashMap<String, Object>();
		mappa.put("file", f.getAbsolutePath());
		executeCommand("network", "load file", mappa, t);
		
	}
	
	public <S> S getService(Class<S> serviceClass) {
		return getService(serviceClass);
	}

	public void executeCommand(String namespace, String command, Map<String, Object> args, TaskObserver observer) {
		if (commandTaskFactory == null)
			commandTaskFactory = getService(CommandExecutorTaskFactory.class);
		if (availableCommands == null)
			availableCommands = getService(AvailableCommands.class);
		if (taskManager == null)
			taskManager = getService(SynchronousTaskManager.class);
		if (!availableCommands.getNamespaces().contains(namespace)
				|| !availableCommands.getCommands(namespace).contains(command))
			throw new RuntimeException("Can’t find command " + namespace + " " + command);
		TaskIterator ti = commandTaskFactory.createTaskIterator(namespace, command, args, observer);
		taskManager.execute(ti);
	}
	


}