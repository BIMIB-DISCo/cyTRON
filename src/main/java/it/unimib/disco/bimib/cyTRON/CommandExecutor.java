package it.unimib.disco.bimib.cyTRON;

import java.util.Map;

import org.cytoscape.command.AvailableCommands;
import org.cytoscape.command.CommandExecutorTaskFactory;
import org.cytoscape.work.SynchronousTaskManager;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.work.TaskObserver;

public class CommandExecutor {
	private CommandExecutorTaskFactory commandTaskFactory;
	private AvailableCommands availableCommands;
	private SynchronousTaskManager taskManager;
	
	public CommandExecutor(CommandExecutorTaskFactory commandTaskFactory,
			AvailableCommands availableCommands,
			SynchronousTaskManager taskManager) {
		this.commandTaskFactory = commandTaskFactory;
		this.availableCommands = availableCommands;
		this.taskManager = taskManager;
	}
	
	public void executeCommand(String namespace, String command, Map<String, Object> args, TaskObserver observer) {
		if (!availableCommands.getNamespaces().contains(namespace)
				|| !availableCommands.getCommands(namespace).contains(command))
			throw new RuntimeException("Can't find command " + namespace + " " + command);
		TaskIterator ti = commandTaskFactory.createTaskIterator(namespace, command, args, observer);
		taskManager.execute(ti);
	}
}
