package it.unimib.disco.bimib.cyTRON;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import org.cytoscape.application.swing.AbstractCyAction;

import it.unimib.disco.bimib.cyTRON.controller.WizardController;
import it.unimib.disco.bimib.cyTRON.cytoscape.CommandExecutor;
import it.unimib.disco.bimib.cyTRON.view.MainFrame;
import it.unimib.disco.bimib.cyTRON.view.WizardFrame;

public class MenuAction extends AbstractCyAction {

	private static final long serialVersionUID = 1455107534589172944L;
	
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
		// instantiate the wizard controller
		WizardController wizardController = new WizardController();
		
		if (wizardController.showWizard()) {
			// create the wizard frame and show it
			WizardFrame widzardFrame = new WizardFrame(wizardController, commandExecutor);
			widzardFrame.setLocationRelativeTo(null);
			widzardFrame.setVisible(true);
		} else {
			// create the main frame and show it
			MainFrame mainFrame = new MainFrame(commandExecutor, true);
			mainFrame.setLocationRelativeTo(null);
			mainFrame.setVisible(true);
		}
		
		JFrame.setDefaultLookAndFeelDecorated(true);
	}
}
