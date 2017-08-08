package it.unimib.disco.bimib.cyTRON.cytoscape;

import java.util.Map;

import org.cytoscape.command.CommandExecutorTaskFactory;
import org.cytoscape.work.SynchronousTaskManager;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.work.TaskObserver;

public class CommandExecutor {

    private final CommandExecutorTaskFactory commandTaskFactory;
    private final SynchronousTaskManager taskManager;

    public CommandExecutor(CommandExecutorTaskFactory commandTaskFactory, SynchronousTaskManager taskManager) {
        this.commandTaskFactory = commandTaskFactory;
        this.taskManager = taskManager;
    }

    public void executeCommand(String namespace, String command, Map<String, Object> args, TaskObserver taskObserver) {
    	// execute the given command
        TaskIterator taskIterator = commandTaskFactory.createTaskIterator(namespace, command, args, taskObserver);
        taskManager.execute(taskIterator);
    }
}
