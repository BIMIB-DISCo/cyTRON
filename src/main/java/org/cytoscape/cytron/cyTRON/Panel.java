package org.cytoscape.cytron.cyTRON;

import javax.swing.JPanel;

import org.cytoscape.work.FinishStatus;
import org.cytoscape.work.ObservableTask;
import org.cytoscape.work.TaskObserver;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class Panel extends JPanel {
	private CommandExecutor commandExecutor;
	private JFrame frame;
	private JTextField outputFileText;

	private File modelFile;

	/**
	 * Create the panel.
	 */
	public Panel(CommandExecutor commandExecutor, JFrame frame) {
		this.commandExecutor = commandExecutor;
		this.frame = frame;
		modelFile = null;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JButton modelButton = new JButton("Choose model");
		GridBagConstraints modellButtonC = new GridBagConstraints();
		modellButtonC.insets = new Insets(0, 0, 5, 0);
		modellButtonC.gridx = 6;
		modellButtonC.gridy = 1;
		add(modelButton, modellButtonC);

		JButton loadButton = new JButton("Load");
		GridBagConstraints loadButtonC = new GridBagConstraints();
		loadButtonC.insets = new Insets(0, 0, 5, 0);
		loadButtonC.gridx = 6;
		loadButtonC.gridy = 5;
		add(loadButton, loadButtonC);

		outputFileText = new JTextField();
		outputFileText.setText(System.getProperty("user.home"));
		GridBagConstraints outputFileTextC = new GridBagConstraints();
		outputFileTextC.insets = new Insets(0, 0, 5, 0);
		outputFileTextC.fill = GridBagConstraints.HORIZONTAL;
		outputFileTextC.gridx = 6;
		outputFileTextC.gridy = 3;
		add(outputFileText, outputFileTextC);
		outputFileText.setColumns(10);
		
		JButton btnHelp = new JButton("Help");
		GridBagConstraints gbc_btnHelp = new GridBagConstraints();
		gbc_btnHelp.insets = new Insets(0, 0, 0, 5);
		gbc_btnHelp.gridx = 5;
		gbc_btnHelp.gridy = 6;
		add(btnHelp, gbc_btnHelp);

		modelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(loadButton);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					modelFile = fc.getSelectedFile();
				}

			}
		});

		loadButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				File scriptFile = generateScript(modelFile.getAbsolutePath(), outputFileText.getText());
				
				TaskObserver observer = new TaskObserver() {
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
				mappa.put("inputFile", scriptFile.getAbsolutePath());
				commandExecutor.executeCommand("cytron", "import", mappa, observer);
				frame.dispose();

			}
		});
		
		btnHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBuilder parameters = new StringBuilder();
				parameters.append("model: a reconstructed model\n");
				parameters.append("models: a vector containing the name of the algorithms used\n");
				parameters.append("fontsize: for node names\n");
				parameters.append("height: for node height\n");
				parameters.append("width: for node width\n");
				parameters.append("height.logic: for logical nodes\n");
				parameters.append("pf: should I print Prima Facie?\n");
				parameters.append("disconnected: should I print disconnected nodes?\n");
				parameters.append("scale.nodes: node scaling coefficient\n");
				parameters.append("title: title of the plot\n");
				parameters.append("confidence: should I add confidence information?\n");
				parameters.append("pmin: p-value cutoff\n");
				parameters.append("label.edge.size: size of edge labels\n");
				parameters.append("expand: should I expand hypotheses?\n");
				parameters.append("genes: visualise only genes in this list\n");
				parameters.append("edge.color: edge color\n");
				parameters.append("file: string containing file name for PDF output\n");
				parameters.append("pathways: a vetor containing pathways information\n");
				parameters.append("lwd: edge base lwd\n");
				parameters.append("samples.annotation\n");
				JOptionPane.showMessageDialog(null, parameters.toString(), "Parametri disponibili", JOptionPane.QUESTION_MESSAGE);
				
			}
		});

	}
	
	
	private File generateScript(String modelPath, String outputPath) {
		StringBuilder scriptBuilder = new StringBuilder();
		
		String modelName = "";
		int lastDot = modelPath.lastIndexOf('.');
		if (modelPath.contains("\\")) {
			int lastBackslash = modelPath.lastIndexOf('\\');
			
			if (lastBackslash < lastDot)
				modelName = modelPath.substring(lastBackslash, lastDot);
			else
				modelName = modelPath.substring(lastBackslash);
		} else {
			int lastSlash = modelPath.lastIndexOf('/');
			
			if (lastSlash == -1)
				modelName = modelPath;
			else if (lastSlash < lastDot)
				modelName = modelPath.substring(lastSlash, lastDot);
			else
				modelName = modelName.substring(lastSlash);
		}
		
		scriptBuilder.append("library('TRONCO')%n");
		scriptBuilder.append("load(" + modelPath + ")%n");
		scriptBuilder.append("export.graphml(" + modelName + ", '" + outputPath + "'"
				+ "scale.nodes = 0.6, confidence = c('hg', 'tp'))");
		
		File outputFile = null;
		try {
			outputFile = File.createTempFile("cytron_script", "R");
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
			writer.write(scriptBuilder.toString());
			writer.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return outputFile;
	}

}
