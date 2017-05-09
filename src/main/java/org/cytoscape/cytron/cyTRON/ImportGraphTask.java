package org.cytoscape.cytron.cyTRON;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import org.rosuda.REngine.REngine;

public class ImportGraphTask extends AbstractTask {
	private static Rengine re = null;
	
	private CyApplicationManager cyApplicationManagerServiceRef;
	private VisualMappingManager vmmServiceRef;
	private VisualStyleFactory visualStyleFactoryServiceRef;
	private VisualMappingFunctionFactory vmfFactoryC;
	private VisualMappingFunctionFactory vmfFactoryP;
	private CyNetworkViewManager cyNetworkViewManagerServiceRef;
	private CyServiceRegistrar serviceRegistrar ;
	
	private CommandExecutorTaskFactory commandTaskFactory = null;
	private SynchronousTaskManager taskManager = null;
	private AvailableCommands availableCommands = null;

	
	public ImportGraphTask(CyApplicationManager cyApplicationManagerServiceRef,
			VisualMappingManager vmmServiceRef, 
			VisualStyleFactory visualStyleFactoryServiceRef,
			VisualMappingFunctionFactory vmfFactoryC, 
			VisualMappingFunctionFactory vmfFactoryP,
			CyServiceRegistrar registrar,
			CommandExecutorTaskFactory commandTaskFactory,
			AvailableCommands availableCommands,
			SynchronousTaskManager taskManager) {
		
		this.cyApplicationManagerServiceRef = cyApplicationManagerServiceRef;
		this.vmmServiceRef = vmmServiceRef;
		this.visualStyleFactoryServiceRef = visualStyleFactoryServiceRef;
		this.vmfFactoryC = vmfFactoryC;
		this.vmfFactoryP = vmfFactoryP;
		this.serviceRegistrar = registrar;
		this.commandTaskFactory = commandTaskFactory;
		this.availableCommands = availableCommands;
		this.taskManager = taskManager;

	}

	@Tunable(description = "Input file", params = "fileCategory=unspecified;input=true")
	public File inputFile;
	/*
	@Tunable(description = "Output file", params = "fileCategory=unspecified;input=true")
	public File outputFile;
	
	@Tunable(description="Type")
	   public boolean type = false;

	   @Tunable(description="Host name",dependsOn="type=true")
	   public String hostname="";
	*/
	public void run(TaskMonitor monitor) {
		
		if (!Rengine.versionCheck()) {
		    System.err.println("** Version mismatch - Java files don't match library version.");
		    System.exit(1);
		}
		
		if(re == null) {
			re = new Rengine(null, false, new TextConsole());
		}
		
		
		if (!re.waitForR()) {
            System.out.println("Cannot load R");
            return;
        }
		System.out.println("path:" + inputFile.getAbsolutePath());
		re.eval("source('" + inputFile.getAbsolutePath().replace('\\', '/' ) + "')");
		
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
		/*
		try{
			BufferedReader br = new BufferedReader(new FileReader(inputFile.getAbsolutePath()));
			
			
			 String line;
	         while ((line = br.readLine()) != null) {
	            if (line.contains("1313131"))
	               line = line.replace("1313131", ""+System.currentTimeMillis());
	            bw.write(line+"\n");
	         }
			
		}catch(Exception e){
			
		}*/
		
		HashMap<String, Object> mappa = new HashMap<String, Object>();
		mappa.put("file", System.getProperty("user.home") + "/test.graphml");
		executeCommand("network", "load file", mappa, t);
		System.out.println("Command executed");
		
	}
	
	public void executeCommand(String namespace, String command, Map<String, Object> args, TaskObserver observer) {
		if (!availableCommands.getNamespaces().contains(namespace)
				|| !availableCommands.getCommands(namespace).contains(command))
			throw new RuntimeException("Can't find command " + namespace + " " + command);
		TaskIterator ti = commandTaskFactory.createTaskIterator(namespace, command, args, observer);
		taskManager.execute(ti);
	}
	


}