package it.unimib.disco.bimib.cyTRON.controller;

import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class ImportGraphTaskFactory extends AbstractTaskFactory {

    private final CommandExecutor commandExecutor;

    public ImportGraphTaskFactory(CommandExecutor commandExecutor) {
        super();
    	this.commandExecutor = commandExecutor;
    }
    
    @Override
    public TaskIterator createTaskIterator() {
        return new TaskIterator(new ImportGraphTask(commandExecutor));
    }
}
