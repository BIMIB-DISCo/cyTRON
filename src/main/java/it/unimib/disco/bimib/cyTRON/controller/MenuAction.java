package it.unimib.disco.bimib.cyTRON.controller;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import org.cytoscape.application.swing.AbstractCyAction;

import it.unimib.disco.bimib.cyTRON.view.MainFrame;

public class MenuAction extends AbstractCyAction {

	public MenuAction() {
		// set the name and the menu of the action
		super("cyTRON");
		setPreferredMenu("Apps");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// creates the main frame and shows it
		JFrame.setDefaultLookAndFeelDecorated(true);
		MainFrame mainFrame = new MainFrame();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}

}
