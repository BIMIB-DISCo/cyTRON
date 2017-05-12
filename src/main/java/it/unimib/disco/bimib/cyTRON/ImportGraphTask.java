package it.unimib.disco.bimib.cyTRON;

import java.io.File;
import java.util.HashMap;

import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.FinishStatus;
import org.cytoscape.work.ObservableTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.TaskObserver;
import org.cytoscape.work.Tunable;

import org.rosuda.JRI.Rengine;

public class ImportGraphTask extends AbstractTask {

    private static Rengine re = null;
    private final CommandExecutor commandExecutor;

    public ImportGraphTask(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Tunable(description = "Input file",
            params = "fileCategory=unspecified;input=true")
    public File inputFile;

    @Tunable(description = "Output file",
            params = "fileCategory=unspecified;input=true")
    public File outputFile;
    
    @Override
    public void run(TaskMonitor monitor) {
        
        // Start the execution of the REngine to execute an R script
        if (!Rengine.versionCheck()) {
            System.err.println("** Version mismatch - Java files don't match library version.");
            // TODO: scegliere come segnalare l'errore
            return;
        }

        if (re == null) {
            re = new Rengine(null, false, new TextConsole());
        }

        if (!re.waitForR()) {
            System.out.println("Cannot load R");
            // TODO: scegliere un modo per segnalare l'erroe
            return;
        }
        
        // TODO: debug line
        System.out.println("path:" + inputFile.getAbsolutePath());
        
        // Execution of the R Script
        re.eval("source('" + inputFile.getAbsolutePath().replace('\\', '/') + "')");
        
        // Load Network command execution
        TaskObserver t = new TaskObserver() {
            @Override
            public void taskFinished(ObservableTask arg0) {
                System.out.println("TaskFinished");
            }

            @Override
            public void allFinished(FinishStatus arg0) {
                System.out.println("TaskAllFinished");

            }
        };

        HashMap<String, Object> mappa = new HashMap<>();
        mappa.put("file", outputFile);
        commandExecutor.executeCommand("network", "load file", mappa, t);
        // TODO: debug line
        System.out.println("Command executed");
    }
}
