package it.unimib.disco.bimib.cyTRON.controller;

import java.util.Map;

import org.cytoscape.command.AvailableCommands;
import org.cytoscape.command.CommandExecutorTaskFactory;
import org.cytoscape.work.SynchronousTaskManager;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.work.TaskObserver;

public class CommandExecutor {

    private final CommandExecutorTaskFactory commandTaskFactory;
    private final AvailableCommands availableCommands;
    private final SynchronousTaskManager taskManager;

    public CommandExecutor(CommandExecutorTaskFactory commandTaskFactory, AvailableCommands availableCommands, SynchronousTaskManager taskManager) {
        this.commandTaskFactory = commandTaskFactory;
        this.availableCommands = availableCommands;
        this.taskManager = taskManager;
    }

    public void executeCommand(String namespace, String command, Map<String, Object> args, TaskObserver observer) {
        // Throw exception if command can't be found
    	if (!this.availableCommands.getNamespaces().contains(namespace) || !this.availableCommands.getCommands(namespace).contains(command)) {
            throw new RuntimeException("Can't find command " + namespace + " " + command);
        }
        
    	// Execute tasks
        TaskIterator taskIterator = this.commandTaskFactory.createTaskIterator(namespace, command, args, observer);
        this.taskManager.execute(taskIterator);
    }
}
