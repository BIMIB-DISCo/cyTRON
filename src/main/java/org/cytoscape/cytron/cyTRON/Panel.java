package org.cytoscape.cytron.cyTRON;

import javax.swing.JPanel;

import org.cytoscape.work.FinishStatus;
import org.cytoscape.work.ObservableTask;
import org.cytoscape.work.TaskObserver;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.GridBagConstraints;

public class Panel extends JPanel {
	private CommandExecutor commandExecutor;
	private JFrame frame;
	/**
	 * Create the panel.
	 */
	public Panel(CommandExecutor commandExecutor, JFrame frame) {
		this.commandExecutor = commandExecutor;
		this.frame = frame;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnScegliUnoScript = new JButton("Scegli uno script");
		GridBagConstraints gbc_btnScegliUnoScript = new GridBagConstraints();
		gbc_btnScegliUnoScript.gridx = 6;
		gbc_btnScegliUnoScript.gridy = 1;
		add(btnScegliUnoScript, gbc_btnScegliUnoScript);
		
		
		
		btnScegliUnoScript.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(btnScegliUnoScript);
				
				if(returnVal == JFileChooser.APPROVE_OPTION){
					File inputFile = fc.getSelectedFile();
					TaskObserver observer = new TaskObserver(){
						@Override
						public void taskFinished(ObservableTask arg0) {
							System.out.println("TaskFinished");
						}
						@Override
						public void allFinished(FinishStatus arg0) {
							System.out.println("TaskAllFinished");
							
						}
					};
					
					HashMap<String, Object> mappa = new HashMap<String, Object>();
					mappa.put("inputFile", inputFile.getAbsolutePath());
					commandExecutor.executeCommand("cytron", "import", mappa, observer);
					frame.dispose();
				}
				
			}
		});
		
	
		

	}

}
