package it.unimib.disco.bimib.cyTRON.view;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import it.unimib.disco.bimib.cyTRON.R.RConnectionManager;
import it.unimib.disco.bimib.cyTRON.controller.DatasetController;

public class EventsSelectionFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = -7637877718070830203L;
	
	private final MainFrame mainFrame;
    private final DatasetController datasetController;
    private final int datasetIndex;

    public EventsSelectionFrame(MainFrame mainFrame, DatasetController datasetController, int datasetIndex) {
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
        selectedEventsScrollPane = new javax.swing.JScrollPane();
        selectedEventsList = new javax.swing.JList<>();
        selectionLabel = new javax.swing.JLabel();
        frequenceLabel = new javax.swing.JLabel();
        ctrlLabel1 = new javax.swing.JLabel();
        selectedEventsLabel = new javax.swing.JLabel();
        ctrlLabel2 = new javax.swing.JLabel();
        filteredEventsScrollPane = new javax.swing.JScrollPane();
        filteredEventsList = new javax.swing.JList<>();
        removeLabel = new javax.swing.JLabel();
        minimumFrequenceSpinner = new javax.swing.JSpinner();
        negativeLabel = new javax.swing.JLabel();
        fromFileButton = new javax.swing.JButton();
        fileTextField = new javax.swing.JTextField();
        tabLabel = new javax.swing.JLabel();
        keepRadioButton = new javax.swing.JRadioButton();
        removeRadioButton = new javax.swing.JRadioButton();
        selectButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Events Selection");
        setMaximumSize(new java.awt.Dimension(670, 500));
        setMinimumSize(new java.awt.Dimension(670, 500));
        setSize(new java.awt.Dimension(670, 500));

        selectedEventsList.setModel(datasetController.getEventsListModel());
        selectedEventsList.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        selectedEventsScrollPane.setViewportView(selectedEventsList);

        selectionLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        selectionLabel.setText("Events Selection");

        frequenceLabel.setText("Minimum frequence:");

        ctrlLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        ctrlLabel1.setText("ctrl/cmd-click to select multiple events (do not select for default)");

        selectedEventsLabel.setText("Events to keep:");

        ctrlLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        ctrlLabel2.setText("ctrl/cmd-click to select multiple events (do not select for default)");

        filteredEventsList.setModel(datasetController.getEventsListModel());
        filteredEventsList.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        filteredEventsList.setMaximumSize(new java.awt.Dimension(90, 528));
        filteredEventsScrollPane.setViewportView(filteredEventsList);

        removeLabel.setText("Events to remove:");

        minimumFrequenceSpinner.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(-0.01f), Float.valueOf(-0.01f), Float.valueOf(1.0f), Float.valueOf(0.01f)));

        negativeLabel.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        negativeLabel.setText("negative value for default");

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

        tabLabel.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        tabLabel.setText("tab-separated values file containing, on each line, gene and type of the events to select");

        typeButtonGroup.add(keepRadioButton);
        keepRadioButton.setSelected(true);
        keepRadioButton.setText("keep");

        typeButtonGroup.add(removeRadioButton);
        removeRadioButton.setText("remove");

        selectButton.setText("Select");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectionLabel)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(frequenceLabel)
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(negativeLabel)
                            .addComponent(minimumFrequenceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fromFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectedEventsLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ctrlLabel1)
                                    .addComponent(ctrlLabel2)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(fileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(keepRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(removeRadioButton)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(filteredEventsScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tabLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(selectedEventsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectButton)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(selectionLabel)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(frequenceLabel)
                    .addComponent(minimumFrequenceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(negativeLabel)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectedEventsLabel)
                    .addComponent(selectedEventsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctrlLabel2)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeLabel)
                    .addComponent(filteredEventsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctrlLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fromFileButton)
                        .addComponent(keepRadioButton)
                        .addComponent(removeRadioButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(selectButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        // get the values
        Float minimumFrequence = (Float) minimumFrequenceSpinner.getValue();
        int[] selectedEventsIndex = selectedEventsList.getSelectedIndices();
        int[] filteredEventsIndex = filteredEventsList.getSelectedIndices();
        
        // select the samples
        datasetController.selectEvents(minimumFrequence, selectedEventsIndex, filteredEventsIndex, datasetIndex);
        
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

        // get the indexes of the selected events
        int[] eventsIndexes = datasetController.selectEventsFromFile(file);

        // if there are no selected samples
        if (eventsIndexes.length == 0) {
            // show a message
            JOptionPane.showConfirmDialog(this, "No events selected from file.", "", JOptionPane.PLAIN_MESSAGE);
        } else {
        	// select the multiple samples and scroll to the first multiple sample
        	if (keepRadioButton.isSelected()) {
        		selectedEventsList.setSelectedIndices(eventsIndexes);
        		selectedEventsList.ensureIndexIsVisible(eventsIndexes[0]);
			} else if (removeRadioButton.isSelected()) {
				filteredEventsList.setSelectedIndices(eventsIndexes);
				filteredEventsList.ensureIndexIsVisible(eventsIndexes[0]);
			}
        }
    }//GEN-LAST:event_fromFileButtonActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ctrlLabel1;
    private javax.swing.JLabel ctrlLabel2;
    private javax.swing.JTextField fileTextField;
    private javax.swing.JList<String> filteredEventsList;
    private javax.swing.JScrollPane filteredEventsScrollPane;
    private javax.swing.JLabel frequenceLabel;
    private javax.swing.JButton fromFileButton;
    private javax.swing.JRadioButton keepRadioButton;
    private javax.swing.JSpinner minimumFrequenceSpinner;
    private javax.swing.JLabel negativeLabel;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel removeLabel;
    private javax.swing.JRadioButton removeRadioButton;
    private javax.swing.JButton selectButton;
    private javax.swing.JLabel selectedEventsLabel;
    private javax.swing.JList<String> selectedEventsList;
    private javax.swing.JScrollPane selectedEventsScrollPane;
    private javax.swing.JLabel selectionLabel;
    private javax.swing.JLabel tabLabel;
    private javax.swing.ButtonGroup typeButtonGroup;
    // End of variables declaration//GEN-END:variables
}
