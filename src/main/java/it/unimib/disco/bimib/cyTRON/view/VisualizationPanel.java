package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.R.RConnectionManager;
import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.controller.VisualizationController;
import it.unimib.disco.bimib.cyTRON.cytoscape.CommandExecutor;
import it.unimib.disco.bimib.cyTRON.model.Dataset;
import it.unimib.disco.bimib.cyTRON.model.Model;
import it.unimib.disco.bimib.cyTRON.model.Statistics;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class VisualizationPanel extends javax.swing.JPanel {

    private final VisualizationController visualizationController;
    private final DatasetController datasetController;
    private final MainFrame mainFrame;
    private final CommandExecutor commandExecutor;
    
    public VisualizationPanel(DatasetController datasetController, MainFrame mainFrame, CommandExecutor commandExecutor) {
        // get the main frame and the controllers
        this.datasetController = datasetController;
        this.mainFrame = mainFrame;
        this.commandExecutor = commandExecutor;
        visualizationController = new VisualizationController(commandExecutor);
        
        // draw the interface
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        samplesSortButtonGroup = new javax.swing.ButtonGroup();
        tabbedPane = new javax.swing.JTabbedPane();
        oncoprintPanel = new javax.swing.JPanel();
        exclusivityLabel = new javax.swing.JLabel();
        clusterSamplesLabel = new javax.swing.JLabel();
        clusterSamplesCheckBox = new javax.swing.JCheckBox();
        clusterGenesLabel = new javax.swing.JLabel();
        clusterGenesCheckBox = new javax.swing.JCheckBox();
        annotateStagesLabel = new javax.swing.JLabel();
        annotateStageTextField = new javax.swing.JTextField();
        annotateStageCheckBox = new javax.swing.JCheckBox();
        annotatehitsLabel = new javax.swing.JLabel();
        annotateHitsCheckBox = new javax.swing.JCheckBox();
        fontSizeLabel = new javax.swing.JLabel();
        fontSizeSpinner = new javax.swing.JSpinner();
        titleLabel = new javax.swing.JLabel();
        titleTextField = new javax.swing.JTextField();
        samplesNameLabel = new javax.swing.JLabel();
        samplesNameCheckBox = new javax.swing.JCheckBox();
        legendLabel = new javax.swing.JLabel();
        legendCheckBox = new javax.swing.JCheckBox();
        legendSizeLabel = new javax.swing.JLabel();
        legendSizeSpinner = new javax.swing.JSpinner();
        exclusivitySortButton = new javax.swing.JRadioButton();
        labelSortRadioButton = new javax.swing.JRadioButton();
        stageSortRadioButton = new javax.swing.JRadioButton();
        samplesGroupLabel = new javax.swing.JLabel();
        samplesGroupTextField = new javax.swing.JTextField();
        patternsLabel = new javax.swing.JLabel();
        patternsCheckBox = new javax.swing.JCheckBox();
        showOncoprintButton = new javax.swing.JButton();
        tabLabel1 = new javax.swing.JLabel();
        tabLabel2 = new javax.swing.JLabel();
        plotPanel = new javax.swing.JPanel();
        showPlotButton = new javax.swing.JButton();
        modelsLabel = new javax.swing.JLabel();
        primaFacieLabel = new javax.swing.JLabel();
        primaFacieCheckBox = new javax.swing.JCheckBox();
        disconnectedNodesLabel = new javax.swing.JLabel();
        disconnectedNodesCheckBox = new javax.swing.JCheckBox();
        scaleNodesLabel = new javax.swing.JLabel();
        scaleNodesCheckBox = new javax.swing.JCheckBox();
        confidenceLabel = new javax.swing.JLabel();
        ctrlLabel2 = new javax.swing.JLabel();
        pvalueCutoffLabel = new javax.swing.JLabel();
        pvalueCutoffSpinner = new javax.swing.JSpinner();
        modelsScrollPane = new javax.swing.JScrollPane();
        modelsList = new javax.swing.JList<>();
        confidenceScrollPane = new javax.swing.JScrollPane();
        confidenceList = new javax.swing.JList<>();
        expandHypothesesLabel = new javax.swing.JLabel();
        expandHypothesesCheckBox = new javax.swing.JCheckBox();
        defaultLabel = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(940, 660));

        exclusivityLabel.setText("Samples sort:");

        clusterSamplesLabel.setText("Cluster samples:");

        clusterSamplesCheckBox.setText(" ");

        clusterGenesLabel.setText("Cluster genes:");

        clusterGenesCheckBox.setText(" ");

        annotateStagesLabel.setText("Annotate stage:");

        annotateStageTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                annotateStageTextFieldMouseClicked(evt);
            }
        });

        annotateStageCheckBox.setText(" ");

        annotatehitsLabel.setText("Annotate hits:");

        annotateHitsCheckBox.setSelected(true);
        annotateHitsCheckBox.setText(" ");

        fontSizeLabel.setText("Font size:");

        fontSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(1.0f, 0.1f, null, 0.1f));

        titleLabel.setText("Title:");

        samplesNameLabel.setText("Samples name:");

        samplesNameCheckBox.setText(" ");

        legendLabel.setText("Legend:");

        legendCheckBox.setSelected(true);
        legendCheckBox.setText(" ");

        legendSizeLabel.setText("Legend size:");

        legendSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(0.5f, 0.1f, null, 0.1f));

        samplesSortButtonGroup.add(exclusivitySortButton);
        exclusivitySortButton.setSelected(true);
        exclusivitySortButton.setText("Exclusivity");

        samplesSortButtonGroup.add(labelSortRadioButton);
        labelSortRadioButton.setText("Label");

        samplesSortButtonGroup.add(stageSortRadioButton);
        stageSortRadioButton.setText("Stage");
        stageSortRadioButton.setToolTipText("");

        samplesGroupLabel.setText("Samples group:");

        samplesGroupTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                samplesGroupTextFieldMouseClicked(evt);
            }
        });

        patternsLabel.setText("Patterns:");

        patternsCheckBox.setText(" ");

        showOncoprintButton.setText("Show");
        showOncoprintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showOncoprintButtonActionPerformed(evt);
            }
        });

        tabLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        tabLabel1.setText("tab-separated values file containing the mapping from samples to stages (without header)");

        tabLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        tabLabel2.setText("tab-separated values file containing the mapping from samples to groups (without header)");

        javax.swing.GroupLayout oncoprintPanelLayout = new javax.swing.GroupLayout(oncoprintPanel);
        oncoprintPanel.setLayout(oncoprintPanelLayout);
        oncoprintPanelLayout.setHorizontalGroup(
            oncoprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oncoprintPanelLayout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addGroup(oncoprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oncoprintPanelLayout.createSequentialGroup()
                        .addComponent(showOncoprintButton)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oncoprintPanelLayout.createSequentialGroup()
                        .addGroup(oncoprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(annotatehitsLabel)
                            .addComponent(fontSizeLabel)
                            .addComponent(titleLabel)
                            .addComponent(annotateStagesLabel)
                            .addComponent(exclusivityLabel)
                            .addComponent(clusterSamplesLabel)
                            .addComponent(samplesNameLabel)
                            .addComponent(legendLabel)
                            .addComponent(samplesGroupLabel)
                            .addComponent(patternsLabel))
                        .addGap(18, 18, 18)
                        .addGroup(oncoprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tabLabel2)
                            .addGroup(oncoprintPanelLayout.createSequentialGroup()
                                .addGroup(oncoprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(oncoprintPanelLayout.createSequentialGroup()
                                        .addComponent(clusterSamplesCheckBox)
                                        .addGap(18, 18, 18)
                                        .addComponent(clusterGenesLabel))
                                    .addGroup(oncoprintPanelLayout.createSequentialGroup()
                                        .addComponent(exclusivitySortButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelSortRadioButton)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(oncoprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(clusterGenesCheckBox)
                                    .addComponent(stageSortRadioButton)))
                            .addComponent(patternsCheckBox)
                            .addComponent(samplesGroupTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(oncoprintPanelLayout.createSequentialGroup()
                                .addComponent(legendCheckBox)
                                .addGap(18, 18, 18)
                                .addComponent(legendSizeLabel)
                                .addGap(18, 18, 18)
                                .addComponent(legendSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(samplesNameCheckBox)
                            .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fontSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(annotateHitsCheckBox)
                            .addGroup(oncoprintPanelLayout.createSequentialGroup()
                                .addComponent(annotateStageCheckBox)
                                .addGap(18, 18, 18)
                                .addGroup(oncoprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tabLabel1)
                                    .addComponent(annotateStageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(105, 105, 105))))
        );
        oncoprintPanelLayout.setVerticalGroup(
            oncoprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oncoprintPanelLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(oncoprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exclusivityLabel)
                    .addComponent(exclusivitySortButton)
                    .addComponent(labelSortRadioButton)
                    .addComponent(stageSortRadioButton))
                .addGap(18, 18, 18)
                .addGroup(oncoprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clusterSamplesLabel)
                    .addComponent(clusterSamplesCheckBox)
                    .addComponent(clusterGenesLabel)
                    .addComponent(clusterGenesCheckBox))
                .addGap(18, 18, 18)
                .addGroup(oncoprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(annotateStagesLabel)
                    .addComponent(annotateStageCheckBox)
                    .addComponent(annotateStageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabLabel1)
                .addGap(18, 18, 18)
                .addGroup(oncoprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(annotateHitsCheckBox)
                    .addComponent(annotatehitsLabel))
                .addGap(18, 18, 18)
                .addGroup(oncoprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fontSizeLabel)
                    .addComponent(fontSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(oncoprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(oncoprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(samplesNameLabel)
                    .addComponent(samplesNameCheckBox))
                .addGap(18, 18, 18)
                .addGroup(oncoprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(legendLabel)
                    .addComponent(legendCheckBox)
                    .addComponent(legendSizeLabel)
                    .addComponent(legendSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(oncoprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(samplesGroupLabel)
                    .addComponent(samplesGroupTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabLabel2)
                .addGap(18, 18, 18)
                .addGroup(oncoprintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patternsLabel)
                    .addComponent(patternsCheckBox))
                .addGap(55, 55, 55)
                .addComponent(showOncoprintButton)
                .addContainerGap())
        );

        tabbedPane.addTab("Oncoprint", oncoprintPanel);

        showPlotButton.setText("Show");
        showPlotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPlotButtonActionPerformed(evt);
            }
        });

        modelsLabel.setText("Models:");

        primaFacieLabel.setText("Prima Facie:");

        primaFacieCheckBox.setText(" ");

        disconnectedNodesLabel.setText("Disconnected nodes:");

        disconnectedNodesCheckBox.setText(" ");

        scaleNodesLabel.setText("Scale nodes:");

        scaleNodesCheckBox.setText(" ");

        confidenceLabel.setText("Confidence:");

        ctrlLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        ctrlLabel2.setText("ctrl/cmd-click to select multiple statistics");

        pvalueCutoffLabel.setText("p-value cutoff:");

        pvalueCutoffSpinner.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.050000012f), Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(0.01f)));

        modelsList.setModel(visualizationController.getModelsListModel());
        modelsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        modelsList.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        modelsList.setSize(new java.awt.Dimension(27, 136));
        modelsList.setVisibleRowCount(-1);
        modelsScrollPane.setViewportView(modelsList);

        confidenceList.setModel(visualizationController.getStatisticsListModel());
        confidenceList.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        confidenceList.setSize(new java.awt.Dimension(27, 136));
        confidenceList.setVisibleRowCount(-1);
        confidenceScrollPane.setViewportView(confidenceList);

        expandHypothesesLabel.setText("Expand hypotheses:");

        expandHypothesesCheckBox.setSelected(true);
        expandHypothesesCheckBox.setText(" ");

        defaultLabel.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        defaultLabel.setText("do not select for default");

        javax.swing.GroupLayout plotPanelLayout = new javax.swing.GroupLayout(plotPanel);
        plotPanel.setLayout(plotPanelLayout);
        plotPanelLayout.setHorizontalGroup(
            plotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plotPanelLayout.createSequentialGroup()
                .addGroup(plotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plotPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(showPlotButton))
                    .addGroup(plotPanelLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(plotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(disconnectedNodesLabel)
                            .addComponent(primaFacieLabel)
                            .addComponent(confidenceLabel)
                            .addComponent(scaleNodesLabel)
                            .addComponent(pvalueCutoffLabel)
                            .addComponent(expandHypothesesLabel)
                            .addComponent(modelsLabel))
                        .addGap(18, 18, 18)
                        .addGroup(plotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(expandHypothesesCheckBox)
                            .addGroup(plotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(primaFacieCheckBox)
                                .addComponent(disconnectedNodesCheckBox)
                                .addComponent(scaleNodesCheckBox))
                            .addComponent(pvalueCutoffSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ctrlLabel2)
                            .addComponent(confidenceScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(defaultLabel)
                            .addComponent(modelsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 109, Short.MAX_VALUE)))
                .addContainerGap())
        );
        plotPanelLayout.setVerticalGroup(
            plotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plotPanelLayout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addGroup(plotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modelsScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelsLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(defaultLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plotPanelLayout.createSequentialGroup()
                        .addGroup(plotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(primaFacieCheckBox)
                            .addComponent(primaFacieLabel))
                        .addGap(18, 18, 18)
                        .addGroup(plotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(disconnectedNodesLabel)
                            .addComponent(disconnectedNodesCheckBox))
                        .addGap(18, 18, 18)
                        .addGroup(plotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(scaleNodesCheckBox)
                            .addComponent(scaleNodesLabel))
                        .addGap(18, 18, 18)
                        .addComponent(confidenceScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(confidenceLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctrlLabel2)
                .addGap(18, 18, 18)
                .addGroup(plotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pvalueCutoffSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pvalueCutoffLabel))
                .addGap(18, 18, 18)
                .addGroup(plotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expandHypothesesLabel)
                    .addComponent(expandHypothesesCheckBox))
                .addGap(128, 128, 128)
                .addComponent(showPlotButton)
                .addContainerGap())
        );

        tabbedPane.addTab("Plot", plotPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void annotateStageTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_annotateStageTextFieldMouseClicked
        // create the file chooser
        JFileChooser fileChooser = new JFileChooser();
        
        // check the return option
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                // update the text field
                annotateStageTextField.setText(fileChooser.getSelectedFile().getCanonicalPath());
            } catch (IOException ex) {
                Logger.getLogger(ImportDatasetFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_annotateStageTextFieldMouseClicked

    private void samplesGroupTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_samplesGroupTextFieldMouseClicked
        // create the file chooser
        JFileChooser fileChooser = new JFileChooser();
        
        // check the return option
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                // update the text field
                samplesGroupTextField.setText(fileChooser.getSelectedFile().getCanonicalPath());
            } catch (IOException ex) {
                Logger.getLogger(ImportDatasetFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_samplesGroupTextFieldMouseClicked

    private void showOncoprintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showOncoprintButtonActionPerformed
        // get the dataset
        Dataset dataset = mainFrame.getSelectedDataset();
        // if the dataset is null
        if (dataset == null) {
            // return
            return;
        }
        
        // get the stage
        boolean annotateStage = annotateStageCheckBox.isSelected();
        String annotateStagePath = annotateStageTextField.getText();
        // if there are no annotation and the path has not been provided
        if (annotateStage && !mainFrame.getSelectedDataset().hasStagesAnnotation() && annotateStagePath.length() == 0) {
            // return
            annotateStageTextField.setBackground(Color.RED);
            return;
        // else
        }  else {
        	annotateStageTextField.setBackground(Color.WHITE);
        	// if the path has been provided
        	if (annotateStage && annotateStagePath.length() > 0) {
                // annotate the stage
                visualizationController.annotateStages(dataset, annotateStagePath);
            }
        }	
        
        // if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
            // get the title
            String title = titleTextField.getText();
            // if title has been specified
            if (title.length() > 0) {
                visualizationController.annotareDescription(dataset, title);
            }

            // get the other parameters
            Boolean exclusivitySort = exclusivitySortButton.isSelected();
            Boolean labelSort = labelSortRadioButton.isSelected();
            Boolean stageSort = stageSortRadioButton.isSelected();
            Boolean clusterSamples = clusterGenesCheckBox.isSelected();
            Boolean clusterGenes = clusterGenesCheckBox.isSelected();
            Boolean annotateHits = annotateHitsCheckBox.isSelected();
            Float fontSize = (float) fontSizeSpinner.getValue();
            Boolean samplesName = samplesNameCheckBox.isSelected();
            Boolean legend = legendCheckBox.isSelected();
            Float legendSize = (float) legendSizeSpinner.getValue();
            String samplesGroupPath = samplesGroupTextField.getText();
            Boolean pattern = patternsCheckBox.isSelected();

            // show oncoprint
            try {
				visualizationController.oncoprint(dataset, exclusivitySort, labelSort, stageSort, clusterSamples, clusterGenes, annotateStage, annotateHits, fontSize, samplesName, legend, legendSize, samplesGroupPath, pattern);
			} catch (IOException e) {
				JOptionPane.showConfirmDialog(this, "oncoprint" + RConnectionManager.CHECK_INPUT, RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
			}
            
            // if the last console message is not regular
            if (!RConnectionManager.getTextConsole().isLastMessageRegular()) {
            	JOptionPane.showConfirmDialog(this, RConnectionManager.getTextConsole().getLastConsoleMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showConfirmDialog(this, RConnectionManager.getTextConsole().getLastConsoleMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_showOncoprintButtonActionPerformed

    private void showPlotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPlotButtonActionPerformed
        // get the dataset
        Dataset dataset = mainFrame.getSelectedDataset();
        
        // if the dataset is null or has an empty inference
        if (dataset == null || dataset.getInference().getAlgorithm().equals("")) {
            return;
        }

        // get the parameters
        List<Model> models = modelsList.getSelectedValuesList();
        Boolean primaFacie = primaFacieCheckBox.isSelected();
        Boolean disconnectedNodes = disconnectedNodesCheckBox.isSelected();
        Boolean scaleNodes = scaleNodesCheckBox.isSelected();
        List<Statistics> confidence = confidenceList.getSelectedValuesList();
        Float pvalueCutoff = (Float) pvalueCutoffSpinner.getValue();
        Boolean expandHypotheses = expandHypothesesCheckBox.isSelected();
        
        try {
            // get the plot
            visualizationController.plot(mainFrame.getSelectedDataset(), models, primaFacie, disconnectedNodes, scaleNodes, confidence, pvalueCutoff, expandHypotheses);
            
            // if the last console message is not regular
            if (!RConnectionManager.getTextConsole().isLastMessageRegular()) {
            	JOptionPane.showConfirmDialog(this, RConnectionManager.getTextConsole().getLastConsoleMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
            }
        } catch (IOException e) {
            Logger.getLogger(ImportDatasetFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_showPlotButtonActionPerformed

    public void updateSelectedDataset() {
    	// get the dataset
    	Dataset dataset = mainFrame.getSelectedDataset();
    	
    	// update the interface
        titleTextField.setText(dataset.getDescription());
        annotateStageCheckBox.setSelected(dataset.hasStagesAnnotation());
        visualizationController.updateModelsList(dataset);
        visualizationController.updateStatisticsList(dataset);
    }
    
    public void updateModelsList(Dataset dataset) {
    	visualizationController.updateModelsList(dataset);
    }
    
    public void updateStatisticsList(Dataset dataset) {
    	visualizationController.updateStatisticsList(dataset);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox annotateHitsCheckBox;
    private javax.swing.JCheckBox annotateStageCheckBox;
    private javax.swing.JTextField annotateStageTextField;
    private javax.swing.JLabel annotateStagesLabel;
    private javax.swing.JLabel annotatehitsLabel;
    private javax.swing.JCheckBox clusterGenesCheckBox;
    private javax.swing.JLabel clusterGenesLabel;
    private javax.swing.JCheckBox clusterSamplesCheckBox;
    private javax.swing.JLabel clusterSamplesLabel;
    private javax.swing.JLabel confidenceLabel;
    private javax.swing.JList<Statistics> confidenceList;
    private javax.swing.JScrollPane confidenceScrollPane;
    private javax.swing.JLabel ctrlLabel2;
    private javax.swing.JLabel defaultLabel;
    private javax.swing.JCheckBox disconnectedNodesCheckBox;
    private javax.swing.JLabel disconnectedNodesLabel;
    private javax.swing.JLabel exclusivityLabel;
    private javax.swing.JRadioButton exclusivitySortButton;
    private javax.swing.JCheckBox expandHypothesesCheckBox;
    private javax.swing.JLabel expandHypothesesLabel;
    private javax.swing.JLabel fontSizeLabel;
    private javax.swing.JSpinner fontSizeSpinner;
    private javax.swing.JRadioButton labelSortRadioButton;
    private javax.swing.JCheckBox legendCheckBox;
    private javax.swing.JLabel legendLabel;
    private javax.swing.JLabel legendSizeLabel;
    private javax.swing.JSpinner legendSizeSpinner;
    private javax.swing.JLabel modelsLabel;
    private javax.swing.JList<Model> modelsList;
    private javax.swing.JScrollPane modelsScrollPane;
    private javax.swing.JPanel oncoprintPanel;
    private javax.swing.JCheckBox patternsCheckBox;
    private javax.swing.JLabel patternsLabel;
    private javax.swing.JPanel plotPanel;
    private javax.swing.JCheckBox primaFacieCheckBox;
    private javax.swing.JLabel primaFacieLabel;
    private javax.swing.JLabel pvalueCutoffLabel;
    private javax.swing.JSpinner pvalueCutoffSpinner;
    private javax.swing.JLabel samplesGroupLabel;
    private javax.swing.JTextField samplesGroupTextField;
    private javax.swing.JCheckBox samplesNameCheckBox;
    private javax.swing.JLabel samplesNameLabel;
    private javax.swing.ButtonGroup samplesSortButtonGroup;
    private javax.swing.JCheckBox scaleNodesCheckBox;
    private javax.swing.JLabel scaleNodesLabel;
    private javax.swing.JButton showOncoprintButton;
    private javax.swing.JButton showPlotButton;
    private javax.swing.JRadioButton stageSortRadioButton;
    private javax.swing.JLabel tabLabel1;
    private javax.swing.JLabel tabLabel2;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleTextField;
    // End of variables declaration//GEN-END:variables
}
