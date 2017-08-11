package it.unimib.disco.bimib.cyTRON;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import org.cytoscape.application.swing.AbstractCyAction;

import it.unimib.disco.bimib.cyTRON.cytoscape.CommandExecutor;
import it.unimib.disco.bimib.cyTRON.view.MainFrame;

public class MenuAction extends AbstractCyAction {

	private final CommandExecutor commandExecutor;
	
	public MenuAction(CommandExecutor commandExecutor) {
		// set the name and the menu of the action
		super("cyTRON");
		setPreferredMenu("Apps");
		
		// get the command executor
		this.commandExecutor = commandExecutor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// creates the main frame and shows it
		JFrame.setDefaultLookAndFeelDecorated(true);
		MainFrame mainFrame = new MainFrame(commandExecutor);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}

}
