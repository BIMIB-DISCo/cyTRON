package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.R.RConnectionManager;
import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.model.Sample;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JFileChooser;

import javax.swing.JOptionPane;

public class SamplesSelectionFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 2274200170693733951L;

	private final MainFrame mainFrame;
    private final DatasetController datasetController;
    private final int datasetIndex;

    public SamplesSelectionFrame(MainFrame mainFrame, DatasetController datasetController, int datasetIndex) {
        // get the controller
        this.mainFrame = mainFrame;
        this.datasetController = datasetController;
        this.datasetIndex = datasetIndex;
        
        // draw the interface
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        typeButtonGroup = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        selectButton = new javax.swing.JButton();
        samplesScrollPane = new javax.swing.JScrollPane();
        samplesList = new javax.swing.JList<>();
        selectionLabel = new javax.swing.JLabel();
        samplesLabel = new javax.swing.JLabel();
        ctrlLabel = new javax.swing.JLabel();
        fromFileButton = new javax.swing.JButton();
        fileTextField = new javax.swing.JTextField();
        newlineLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Samples Selection");
        setMaximumSize(new java.awt.Dimension(640, 360));
        setMinimumSize(new java.awt.Dimension(640, 360));

        selectButton.setText("Select");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        samplesList.setModel(datasetController.getSamplesListModel());
        samplesList.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        samplesScrollPane.setViewportView(samplesList);

        selectionLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        selectionLabel.setText("Samples Selection");

        samplesLabel.setText("Samples to keep:");

        ctrlLabel.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        ctrlLabel.setText("ctrl/cmd-click to select multiple samples");

        fromFileButton.setText("From file");
        fromFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromFileButtonActionPerformed(evt);
            }
        });

        fileTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileTextFieldMouseClicked(evt);
            }
        });

        newlineLabel.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        newlineLabel.setText("newline-separated values file containing the ids of the samples to select");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(selectButton))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(selectionLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fromFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(samplesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(samplesScrollPane)
                            .addComponent(fileTextField)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(ctrlLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(newlineLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(selectionLabel)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(samplesLabel)
                    .addComponent(samplesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctrlLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fromFileButton)
                    .addComponent(fileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newlineLabel)
                .addGap(50, 50, 50)
                .addComponent(selectButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        // get the selected samples
        int[] samplesIndex = samplesList.getSelectedIndices();
        
        // if no samples are selected
        if (samplesIndex.length == 0) {
            // return
            samplesList.setBackground(Color.RED);
            return;
        } else {
        	samplesList.setBackground(Color.WHITE);
        }	
        
        // select the samples
        datasetController.selectSamples(samplesIndex, datasetIndex);
        
    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
        	// update the main frame
            mainFrame.updateNumberLabels();
            
            // close the frame
            dispose();
        } else {
        	JOptionPane.showConfirmDialog(this, RConnectionManager.getTextConsole().getLastConsoleMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_selectButtonActionPerformed

    private void fileTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileTextFieldMouseClicked
        // create the file chooser
        JFileChooser fileChooser = new JFileChooser();
        
        // check the return option
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                // update the text field
                fileTextField.setText(fileChooser.getSelectedFile().getCanonicalPath());
            } catch (IOException e) {
            	e.printStackTrace();
            }
        }
    }//GEN-LAST:event_fileTextFieldMouseClicked

    private void fromFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromFileButtonActionPerformed
        // get the path of the file
        String file = fileTextField.getText();
        
        // check the path
        if (file.length() == 0) {
            fileTextField.setBackground(Color.RED);
            return;
        } else {
        	fileTextField.setBackground(Color.WHITE);
        }
        
        // get the indexes of the selected samples
    	int[] samplesIndexes = datasetController.selectSamplesFromFile(file);
    	
    	// if there are no selected samples
    	if (samplesIndexes.length == 0) {
    		// show a message
    		JOptionPane.showConfirmDialog(this, "No samples selected from file.", "", JOptionPane.PLAIN_MESSAGE);
		} else {
			// select the multiple samples
        	samplesList.setSelectedIndices(samplesIndexes);
        	
        	// scroll to the first multiple sample
        	samplesList.ensureIndexIsVisible(samplesIndexes[0]);
		}
    }//GEN-LAST:event_fromFileButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ctrlLabel;
    private javax.swing.JTextField fileTextField;
    private javax.swing.JButton fromFileButton;
    private javax.swing.JLabel newlineLabel;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel samplesLabel;
    private javax.swing.JList<Sample> samplesList;
    private javax.swing.JScrollPane samplesScrollPane;
    private javax.swing.JButton selectButton;
    private javax.swing.JLabel selectionLabel;
    private javax.swing.ButtonGroup typeButtonGroup;
    // End of variables declaration//GEN-END:variables
}
