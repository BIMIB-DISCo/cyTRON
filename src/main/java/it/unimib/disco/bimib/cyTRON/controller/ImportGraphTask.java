package it.unimib.disco.bimib.cyTRON.controller;

import java.io.File;
import java.util.HashMap;

import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.FinishStatus;
import org.cytoscape.work.ObservableTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.TaskObserver;
import org.cytoscape.work.Tunable;

import org.rosuda.JRI.Rengine;

import it.unimib.disco.bimib.cyTRON.model.RConnectionManager;

public class ImportGraphTask extends AbstractTask {

    private final CommandExecutor commandExecutor;
    
    @Tunable(description = "Input file", params = "fileCategory=unspecified;input=true")
    public File inputFile;

    @Tunable(description = "Output file", params = "fileCategory=unspecified;input=true")
    public File outputFile;
    
    public ImportGraphTask(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }
    
    @Override
    public void run(TaskMonitor taskMonitor) {
        
    	// Check libraries consistency
    	if (!RConnectionManager.versionCheck()) {
			return;
		}

    	// Get Rengine
        Rengine rEngine = RConnectionManager.getConnection();
        
        // Check R
        if (!RConnectionManager.waitForR()) {
        	return;
		}
        
        // Read input file in R
        System.out.println("Input file path: " + this.inputFile.getAbsolutePath());
        rEngine.eval("source('" + this.inputFile.getAbsolutePath().replace('\\', '/') + "')");
        
        // Execute command
        TaskObserver taskObserver = new TaskObserver() {
            @Override
            public void taskFinished(ObservableTask arg0) {
                System.out.println("TaskFinished");
            }

            @Override
            public void allFinished(FinishStatus arg0) {
                System.out.println("AllFinished");
            }
        };

        HashMap<String, Object> map = new HashMap<>();
        map.put("file", this.outputFile);
        this.commandExecutor.executeCommand("network", "load file", map, taskObserver);
    }
}
