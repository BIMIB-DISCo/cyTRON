package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.controller.InferenceController;
import it.unimib.disco.bimib.cyTRON.model.Dataset;
import it.unimib.disco.bimib.cyTRON.model.R.RConnectionManager;

import java.awt.Window;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class InferencePanel extends javax.swing.JPanel {

    private final InferenceController inferenceController;
    private final DatasetController datasetController;
    private final MainFrame mainFrame;
    private final StatisticsPanel statisticsPanel;
    
    private final DefaultComboBoxModel<String> algorithmDefaultComboBoxModel;
    private final DefaultComboBoxModel<String> commandDefaultComboBoxModel;
    private final DefaultListModel<String> regularizationsListModel;
    private final DefaultComboBoxModel<String> scoreDefaultComboBoxModel;
    
    public InferencePanel(DatasetController datasetController, MainFrame mainFrame, StatisticsPanel statisticsPanel) {
        // get the controllers and the main frame
    	inferenceController = new InferenceController();
        this.datasetController = datasetController;
        this.mainFrame = mainFrame;
        this.statisticsPanel = statisticsPanel;
        
        // create the models
        algorithmDefaultComboBoxModel = new DefaultComboBoxModel(InferenceController.ALGORITHMS);
        commandDefaultComboBoxModel = new DefaultComboBoxModel(InferenceController.COMMANDS);
        regularizationsListModel = new DefaultListModel();
        for (int i = 0; i < InferenceController.REGULARIZATIONS.length; i++) {
            regularizationsListModel.addElement(InferenceController.REGULARIZATIONS[i]);
        }
        scoreDefaultComboBoxModel = new DefaultComboBoxModel(InferenceController.SCORES);
        
        // draw the interface
        initComponents();
        
        // update the default for the first algorithm
        algorithmComboBoxItemStateChanged(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoPanel = new javax.swing.JPanel();
        currentAlgorithmLabel = new javax.swing.JLabel();
        currentAlgorithmValueLabel = new javax.swing.JLabel();
        parametersPanel = new javax.swing.JPanel();
        lambdaLabel = new javax.swing.JLabel();
        lambdaSpinner = new javax.swing.JSpinner();
        falsePositiveLabel = new javax.swing.JLabel();
        falsePositiveSpinner = new javax.swing.JSpinner();
        falseNegativeSpinner = new javax.swing.JSpinner();
        falseNegativeLabel = new javax.swing.JLabel();
        commandLabel = new javax.swing.JLabel();
        commandComboBox = new javax.swing.JComboBox<>();
        regularizationLabel = new javax.swing.JLabel();
        regularizationScrollPane = new javax.swing.JScrollPane();
        regularizationList = new javax.swing.JList<>();
        estimateErrorRatesLabel = new javax.swing.JLabel();
        estimateErrorRatesCheckBox = new javax.swing.JCheckBox();
        bootstrapSamplingsLabel = new javax.swing.JLabel();
        bootstrapSamplingsSpinner = new javax.swing.JSpinner();
        pValueLabel = new javax.swing.JLabel();
        pValueSpinner = new javax.swing.JSpinner();
        initialBootstrapSeedsLabel = new javax.swing.JLabel();
        initialBootstrapSeedsSpinner = new javax.swing.JSpinner();
        ctrlLabel = new javax.swing.JLabel();
        leaveLabel = new javax.swing.JLabel();
        restartsLabel = new javax.swing.JLabel();
        restartsSpinner = new javax.swing.JSpinner();
        scoreLabel = new javax.swing.JLabel();
        scoreComboBox = new javax.swing.JComboBox<>();
        raisingConditionLabel = new javax.swing.JLabel();
        raisingConditionCheckBox = new javax.swing.JCheckBox();
        runButton = new javax.swing.JButton();
        algorithmComboBox = new javax.swing.JComboBox<>();
        algorithmLabel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(940, 660));
        setMinimumSize(new java.awt.Dimension(940, 660));
        setPreferredSize(new java.awt.Dimension(940, 660));

        infoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Info"));
        infoPanel.setPreferredSize(new java.awt.Dimension(928, 46));

        currentAlgorithmLabel.setText("Current algorithm:");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentAlgorithmLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentAlgorithmValueLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(currentAlgorithmLabel)
                .addComponent(currentAlgorithmValueLabel))
        );

        parametersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Parameters"));

        lambdaLabel.setText("Lambda:");

        lambdaSpinner.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.5f), Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(0.01f)));

        falsePositiveLabel.setText("False positive error rate:");

        falsePositiveSpinner.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(0.01f)));

        falseNegativeSpinner.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(0.01f)));

        falseNegativeLabel.setText("False negative error rate:");

        commandLabel.setText("Command:");

        commandComboBox.setModel(commandDefaultComboBoxModel);

        regularizationLabel.setText("Regularization:");

        regularizationList.setModel(regularizationsListModel);
        regularizationList.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        regularizationList.setSize(new java.awt.Dimension(27, 136));
        regularizationList.setVisibleRowCount(-1);
        regularizationScrollPane.setViewportView(regularizationList);

        estimateErrorRatesLabel.setText("Estimate error rates:");

        estimateErrorRatesCheckBox.setSelected(true);
        estimateErrorRatesCheckBox.setText(" ");

        bootstrapSamplingsLabel.setText("Bootstrap samplings:");

        bootstrapSamplingsSpinner.setModel(new javax.swing.SpinnerNumberModel(100, 5, 10000, 1));

        pValueLabel.setText("P value:");

        pValueSpinner.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.05f), Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(0.01f)));

        initialBootstrapSeedsLabel.setText("Initial bootstrap seeds:");

        initialBootstrapSeedsSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        ctrlLabel.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        ctrlLabel.setText("ctrl/cmd-click to select multiple regularizations");

        leaveLabel.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        leaveLabel.setText("leave 0 for auto");

        restartsLabel.setText("Restarts:");

        restartsSpinner.setModel(new javax.swing.SpinnerNumberModel(100, 5, 10000, 1));

        scoreLabel.setText("Score:");

        scoreComboBox.setModel(scoreDefaultComboBoxModel);

        raisingConditionLabel.setText("Raising condition as a prior:");

        raisingConditionCheckBox.setSelected(true);
        raisingConditionCheckBox.setText(" ");

        javax.swing.GroupLayout parametersPanelLayout = new javax.swing.GroupLayout(parametersPanel);
        parametersPanel.setLayout(parametersPanelLayout);
        parametersPanelLayout.setHorizontalGroup(
            parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parametersPanelLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(regularizationLabel)
                    .addGroup(parametersPanelLayout.createSequentialGroup()
                        .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(initialBootstrapSeedsLabel)
                            .addComponent(restartsLabel)
                            .addComponent(scoreLabel))
                        .addGap(50, 50, 50)
                        .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(restartsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scoreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(leaveLabel)
                            .addComponent(initialBootstrapSeedsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(parametersPanelLayout.createSequentialGroup()
                        .addComponent(raisingConditionLabel)
                        .addGap(18, 18, 18)
                        .addComponent(raisingConditionCheckBox))
                    .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(regularizationScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, parametersPanelLayout.createSequentialGroup()
                            .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(falsePositiveLabel)
                                .addComponent(commandLabel)
                                .addComponent(lambdaLabel)
                                .addComponent(estimateErrorRatesLabel)
                                .addComponent(bootstrapSamplingsLabel)
                                .addComponent(pValueLabel))
                            .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(parametersPanelLayout.createSequentialGroup()
                                    .addGap(313, 313, 313)
                                    .addComponent(falseNegativeLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(falseNegativeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(parametersPanelLayout.createSequentialGroup()
                                    .addGap(43, 43, 43)
                                    .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(estimateErrorRatesCheckBox)
                                        .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(bootstrapSamplingsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pValueSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(ctrlLabel)
                                        .addComponent(commandComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(falsePositiveSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lambdaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        parametersPanelLayout.setVerticalGroup(
            parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parametersPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lambdaLabel)
                    .addComponent(lambdaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(falsePositiveLabel)
                    .addComponent(falsePositiveSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(falseNegativeLabel)
                    .addComponent(falseNegativeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commandLabel)
                    .addComponent(commandComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(regularizationLabel)
                    .addComponent(regularizationScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctrlLabel)
                .addGap(18, 18, 18)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estimateErrorRatesCheckBox)
                    .addComponent(estimateErrorRatesLabel))
                .addGap(18, 18, 18)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bootstrapSamplingsLabel)
                    .addComponent(bootstrapSamplingsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pValueSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pValueLabel))
                .addGap(18, 18, 18)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(initialBootstrapSeedsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(initialBootstrapSeedsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(leaveLabel)
                .addGap(18, 18, 18)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(restartsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restartsLabel))
                .addGap(18, 18, 18)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scoreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scoreLabel))
                .addGap(18, 18, 18)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(raisingConditionLabel)
                    .addComponent(raisingConditionCheckBox))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        runButton.setText("Run");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        algorithmComboBox.setModel(algorithmDefaultComboBoxModel);
        algorithmComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                algorithmComboBoxItemStateChanged(evt);
            }
        });

        algorithmLabel.setText("Algorithm:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(parametersPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(algorithmLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(algorithmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(runButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(algorithmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(algorithmLabel)
                    .addComponent(runButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parametersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void algorithmComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_algorithmComboBoxItemStateChanged
        if (evt == null || evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            // get the selected algorithm
            Object algorithm = algorithmComboBox.getSelectedItem();
            
            // enable/disable inputs
            if (algorithm.equals(InferenceController.CAPRESE)) {
                lambdaSpinner.setEnabled(true);
                commandComboBox.setEnabled(false);
                regularizationList.setEnabled(false);
                estimateErrorRatesCheckBox.setEnabled(false);
                bootstrapSamplingsSpinner.setEnabled(false);
                pValueSpinner.setEnabled(false);
                initialBootstrapSeedsSpinner.setEnabled(false);
                restartsSpinner.setEnabled(false);
                scoreComboBox.setEnabled(false);
                raisingConditionCheckBox.setEnabled(false);
            } else if (algorithm.equals(InferenceController.CAPRI)) {
            	lambdaSpinner.setEnabled(false);
                commandComboBox.setEnabled(true);
                regularizationList.setEnabled(true);
                estimateErrorRatesCheckBox.setEnabled(true);
                bootstrapSamplingsSpinner.setEnabled(true);
                pValueSpinner.setEnabled(true);
                initialBootstrapSeedsSpinner.setEnabled(true);
                restartsSpinner.setEnabled(true);
                scoreComboBox.setEnabled(false);
                raisingConditionCheckBox.setEnabled(false);
            } else if (algorithm.equals(InferenceController.CHOWLIU) || algorithm.equals(InferenceController.PRIM)) {
            	lambdaSpinner.setEnabled(false);
                commandComboBox.setEnabled(false);
                regularizationList.setEnabled(true);
                estimateErrorRatesCheckBox.setEnabled(true);
                bootstrapSamplingsSpinner.setEnabled(true);
                pValueSpinner.setEnabled(true);
                initialBootstrapSeedsSpinner.setEnabled(true);
                restartsSpinner.setEnabled(false);
                scoreComboBox.setEnabled(false);
                raisingConditionCheckBox.setEnabled(false);
            } else if (algorithm.equals(InferenceController.EDMONDS)) {
            	lambdaSpinner.setEnabled(false);
                commandComboBox.setEnabled(false);
                regularizationList.setEnabled(true);
                estimateErrorRatesCheckBox.setEnabled(true);
                bootstrapSamplingsSpinner.setEnabled(true);
                pValueSpinner.setEnabled(true);
                initialBootstrapSeedsSpinner.setEnabled(true);
                restartsSpinner.setEnabled(false);
                scoreComboBox.setEnabled(true);
                raisingConditionCheckBox.setEnabled(false);
            }  else if (algorithm.equals(InferenceController.GABOW)) {
            	lambdaSpinner.setEnabled(false);
                commandComboBox.setEnabled(false);
                regularizationList.setEnabled(true);
                estimateErrorRatesCheckBox.setEnabled(true);
                bootstrapSamplingsSpinner.setEnabled(true);
                pValueSpinner.setEnabled(true);
                initialBootstrapSeedsSpinner.setEnabled(true);
                restartsSpinner.setEnabled(false);
                scoreComboBox.setEnabled(true);
                raisingConditionCheckBox.setEnabled(true);
            }
            
            // update the regularizations
            if (algorithm.equals(InferenceController.EDMONDS) || algorithm.equals(InferenceController.GABOW) || algorithm.equals(InferenceController.PRIM)) {
            	if (!regularizationsListModel.contains(InferenceController.NO_REG)) {
            		regularizationsListModel.add(0, InferenceController.NO_REG);
                    regularizationList.setSelectedIndex(0);
				}
            } else {
                regularizationsListModel.removeElement(InferenceController.NO_REG);
                regularizationList.setSelectedIndices(new int[]{0, 1});
            }
        }
    }//GEN-LAST:event_algorithmComboBoxItemStateChanged

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        // get the dataset
    	Dataset dataset = mainFrame.getSelectedDataset();
    	
    	// check if a dataset is not selected
        if (dataset == null) {
            // return
            return;
        }

        // get the confirmation
        int confirmation = JOptionPane.showConfirmDialog(this, "This operation could take a while.\nRemember to save the datasets you might reuse.\nDo you want to proceed?", "", JOptionPane.OK_CANCEL_OPTION);
        
        // if confirmed
        if (confirmation == JOptionPane.OK_OPTION) {
            // get the selected algorithm
            Object algorithm = algorithmComboBox.getSelectedItem();

            // get the input for all algorithms
            Float lambda = (Float) lambdaSpinner.getValue();
            Float falsePositive = (Float) falsePositiveSpinner.getValue();
            Float falseNegative = (Float) falseNegativeSpinner.getValue();
            String command = (String) commandComboBox.getSelectedItem();
            List<String> regularization = regularizationList.getSelectedValuesList();
            Boolean estimateErrorRates = estimateErrorRatesCheckBox.isSelected();
            Integer bootstrapSamplings = (Integer) bootstrapSamplingsSpinner.getValue();
            Float pValue = (Float) pValueSpinner.getValue();
            Integer initialBootstrapSeeds = (Integer) initialBootstrapSeedsSpinner.getValue();
            Integer restarts = (Integer) restartsSpinner.getValue();        
            String score = (String) scoreComboBox.getSelectedItem();
            Boolean raisingCondition = raisingConditionCheckBox.isSelected();
            
            // get the inference
            InferenceAlgorithm inferenceAlgorithm = new InferenceAlgorithm(dataset, inferenceController, algorithm, lambda, falsePositive, falseNegative, command, regularization, estimateErrorRates, bootstrapSamplings, pValue, initialBootstrapSeeds, restarts, score, raisingCondition);
            inferenceAlgorithm.execute();
            
            // show the option pane for exiting the algorithm
            JOptionPane.showOptionDialog(this, "Exit this window to kill the algorithm.", "", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
            
            // cancel the thread and stop the current R command if the inference is not completed
            if (!inferenceAlgorithm.isDone()) {
            	inferenceAlgorithm.cancel();
            // if the algorithm is not cancelled and the last message is not regular
            } else if (!inferenceAlgorithm.isCancelled() && !RConnectionManager.getTextConsole().isLastMessageRegular()) {
        		// show an error message
        		JOptionPane.showConfirmDialog(this, RConnectionManager.getTextConsole().getLastConsoleMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
        	}
			// clear the last console message
			RConnectionManager.getTextConsole().getLastConsoleMessage();
            
    		// update the current inference algorithm label
        	currentAlgorithmValueLabel.setText(dataset.getInferenceAlgorithm());
        	statisticsPanel.updateSelectedDataset();
        }        
    }//GEN-LAST:event_runButtonActionPerformed
    
    public void updateSelectedDataset() {
    	// get the selected dataset
    	Dataset dataset = mainFrame.getSelectedDataset();
    	
    	// update the current inference algorithm label
    	currentAlgorithmValueLabel.setText(dataset.getInferenceAlgorithm());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> algorithmComboBox;
    private javax.swing.JLabel algorithmLabel;
    private javax.swing.JLabel bootstrapSamplingsLabel;
    private javax.swing.JSpinner bootstrapSamplingsSpinner;
    private javax.swing.JComboBox<String> commandComboBox;
    private javax.swing.JLabel commandLabel;
    private javax.swing.JLabel ctrlLabel;
    private javax.swing.JLabel currentAlgorithmLabel;
    private javax.swing.JLabel currentAlgorithmValueLabel;
    private javax.swing.JCheckBox estimateErrorRatesCheckBox;
    private javax.swing.JLabel estimateErrorRatesLabel;
    private javax.swing.JLabel falseNegativeLabel;
    private javax.swing.JSpinner falseNegativeSpinner;
    private javax.swing.JLabel falsePositiveLabel;
    private javax.swing.JSpinner falsePositiveSpinner;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel initialBootstrapSeedsLabel;
    private javax.swing.JSpinner initialBootstrapSeedsSpinner;
    private javax.swing.JLabel lambdaLabel;
    private javax.swing.JSpinner lambdaSpinner;
    private javax.swing.JLabel leaveLabel;
    private javax.swing.JLabel pValueLabel;
    private javax.swing.JSpinner pValueSpinner;
    private javax.swing.JPanel parametersPanel;
    private javax.swing.JCheckBox raisingConditionCheckBox;
    private javax.swing.JLabel raisingConditionLabel;
    private javax.swing.JLabel regularizationLabel;
    private javax.swing.JList<String> regularizationList;
    private javax.swing.JScrollPane regularizationScrollPane;
    private javax.swing.JLabel restartsLabel;
    private javax.swing.JSpinner restartsSpinner;
    private javax.swing.JButton runButton;
    private javax.swing.JComboBox<String> scoreComboBox;
    private javax.swing.JLabel scoreLabel;
    // End of variables declaration//GEN-END:variables
    
    private class InferenceAlgorithm extends SwingWorker<Void, Void> {
    	private final Dataset dataset;
    	private final InferenceController inferenceController;
    	private final Object algorithm;
    	private final Float lambda;
    	private final Float falsePositive;
    	private final Float falseNegative;
    	private final String command;
    	private final List<String> regularization;
    	private final Boolean estimateErrorRates;
    	private final Integer bootstrapSamplings;
    	private final Float pValue;
    	private final Integer initialBootstrapSeeds;
    	private final Integer restarts;
    	private final String score;
    	private final Boolean raisingCondition;
    	
		public InferenceAlgorithm(Dataset dataset, InferenceController inferenceController, Object algorithm, 
    			Float lambda, Float falsePositive, Float falseNegative, String command, List<String> regularization, Boolean estimateErrorRates,
    			Integer bootstrapSamplings, Float pValue, Integer initialBootstrapSeeds, Integer restarts, String score,
    			Boolean raisingCondition) {
    		this.dataset = dataset;
    		this.inferenceController = inferenceController;
    		this.algorithm = algorithm;
    		this.lambda = lambda;
    		this.falsePositive = falsePositive;
    		this.falseNegative = falseNegative;
    		this.command = command;
    		this.regularization = regularization;
    		this.estimateErrorRates = estimateErrorRates;
    		this.bootstrapSamplings = bootstrapSamplings;
    		this.pValue = pValue;
    		this.initialBootstrapSeeds = initialBootstrapSeeds;
    		this.restarts = restarts;
    		this.score = score;
    		this.raisingCondition = raisingCondition;
    	}

		@Override
		protected Void doInBackground() {
			// execute the inference algorithm
			inferenceController.inference(dataset, algorithm, lambda, falsePositive, falseNegative, command, regularization,
					estimateErrorRates, bootstrapSamplings, pValue, initialBootstrapSeeds, restarts, score, raisingCondition);
			return null;
		}
		
		@Override
		protected void done() {
			super.done();
			// close the option panel
			MainFrame.disposeJOptionPanes();
		}
		
		public void cancel() {
			// cancel the thread and stop the current R command
			RConnectionManager.getConnection().rniStop(0);
			super.cancel(true);
		}
    }
}
