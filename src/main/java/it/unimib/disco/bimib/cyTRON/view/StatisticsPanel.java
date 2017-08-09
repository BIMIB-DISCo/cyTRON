package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.R.RConnectionManager;
import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.controller.StatisticsController;
import it.unimib.disco.bimib.cyTRON.model.Dataset;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class StatisticsPanel extends javax.swing.JPanel {

    private final StatisticsController statisticsController;
    private final DatasetController datasetController;
    private final MainFrame mainFrame;
    private final VisualizationPanel visualizationPanel;
    
    private final DefaultComboBoxModel<String> statisticsDefaultComboBoxModel;
    private final DefaultComboBoxModel<String> typessDefaultComboBoxModel;
    
    public StatisticsPanel(DatasetController datasetController, MainFrame mainFrame, VisualizationPanel visualizationPanel) {
        // get the main frame and the controllers
        statisticsController = new StatisticsController();
        this.datasetController = datasetController;
        this.mainFrame = mainFrame;
        this.visualizationPanel = visualizationPanel;
        
        // creates the models
        statisticsDefaultComboBoxModel = new DefaultComboBoxModel<>(StatisticsController.STATISTICS);
        typessDefaultComboBoxModel = new DefaultComboBoxModel<>(StatisticsController.TYPES);
        
        // draw the interface
        initComponents();
        
        // update the default for the first statistics
        statisticsComboBoxItemStateChanged(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoPanel = new javax.swing.JPanel();
        currentAlgorithmLabel = new javax.swing.JLabel();
        currentAlgorithmValueLabel = new javax.swing.JLabel();
        statisticsLabel = new javax.swing.JLabel();
        statisticsComboBox = new javax.swing.JComboBox<>();
        runButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        typeLabel = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox<>();
        bootstrapSamplingsLabel = new javax.swing.JLabel();
        bootstrapSamplingsSpinner = new javax.swing.JSpinner();
        coresRatioLabel = new javax.swing.JLabel();
        coresRatioSpinner = new javax.swing.JSpinner();
        runsLabel = new javax.swing.JLabel();
        runsSpinner = new javax.swing.JSpinner();
        groupsLabel = new javax.swing.JLabel();
        groupsSpinner = new javax.swing.JSpinner();

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

        statisticsLabel.setText("Statistics:");

        statisticsComboBox.setModel(statisticsDefaultComboBoxModel);
        statisticsComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                statisticsComboBoxItemStateChanged(evt);
            }
        });

        runButton.setText("Run");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Parameters"));

        typeLabel.setText("Type:");

        typeComboBox.setModel(typessDefaultComboBoxModel);

        bootstrapSamplingsLabel.setText("Bootstrap samplings:");

        bootstrapSamplingsSpinner.setModel(new javax.swing.SpinnerNumberModel(100, 5, 10000, 1));

        coresRatioLabel.setText("Cores ratio:");

        coresRatioSpinner.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(0.1f)));

        runsLabel.setText("Runs:");
        runsLabel.setToolTipText("");

        runsSpinner.setModel(new javax.swing.SpinnerNumberModel(10, 1, 1000, 1));

        groupsLabel.setText("Groups:");

        groupsSpinner.setModel(new javax.swing.SpinnerNumberModel(10, 1, 1000, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(typeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bootstrapSamplingsLabel)
                            .addComponent(coresRatioLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bootstrapSamplingsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(coresRatioSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(runsLabel)
                            .addComponent(groupsLabel))
                        .addGap(102, 102, 102)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(runsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(groupsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bootstrapSamplingsLabel)
                    .addComponent(bootstrapSamplingsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coresRatioLabel)
                    .addComponent(coresRatioSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(runsLabel)
                    .addComponent(runsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(groupsLabel)
                    .addComponent(groupsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(173, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(statisticsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statisticsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 727, Short.MAX_VALUE)
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
                    .addComponent(statisticsLabel)
                    .addComponent(statisticsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(runButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void statisticsComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_statisticsComboBoxItemStateChanged
        if (evt == null || evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            // get the selected algorithm
            Object statistics = statisticsComboBox.getSelectedItem();
            
            // enable/disable inputs
            if (statistics.equals(StatisticsController.BOOTSTRAP)) {
				typeComboBox.setEnabled(true);
				bootstrapSamplingsSpinner.setEnabled(true);
				coresRatioSpinner.setEnabled(true);
				runsSpinner.setEnabled(false);
				groupsSpinner.setEnabled(false);
			} else if (statistics.equals(StatisticsController.ELOSS)) {
				typeComboBox.setEnabled(false);
				bootstrapSamplingsSpinner.setEnabled(false);
				coresRatioSpinner.setEnabled(false);
				runsSpinner.setEnabled(true);
				groupsSpinner.setEnabled(true);
			} else if (statistics.equals(StatisticsController.POSTERR) || statistics.equals(StatisticsController.PREDERR)) {
				typeComboBox.setEnabled(false);
				bootstrapSamplingsSpinner.setEnabled(false);
				coresRatioSpinner.setEnabled(true);
				runsSpinner.setEnabled(true);
				groupsSpinner.setEnabled(true);
			}
        }
    }//GEN-LAST:event_statisticsComboBoxItemStateChanged

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        // get the dataset
    	Dataset dataset = mainFrame.getSelectedDataset();
    	
    	// check if a dataset is not selected
        if (dataset == null || dataset.getInference().getAlgorithm().equals("")) {
            // return
            return;
        }

        // get the confirmation
        int confirmation = JOptionPane.showConfirmDialog(this, "This operation could take a while.\nRemember to save the datasets you might reuse.\nDo you want to proceed?", "", JOptionPane.OK_CANCEL_OPTION);
        
        // if confirmed
        if (confirmation == JOptionPane.OK_OPTION) {
            // get the selected statistics
        	Object statistics = statisticsComboBox.getSelectedItem();
        	
        	// get the input for all statistics
        	String type = (String) typeComboBox.getSelectedItem();
        	Integer bootstrapSamplings = (Integer) bootstrapSamplingsSpinner.getValue();
        	Float coresRatio = (Float) coresRatioSpinner.getValue();
        	Integer runs = (Integer) runsSpinner.getValue();
        	Integer groups = (Integer) groupsSpinner.getValue();
        	
        	// get the statistics
        	StatisticsAlgorithm statisticsAlgorithm = new StatisticsAlgorithm(dataset, statisticsController, statistics, type, bootstrapSamplings, coresRatio, runs, groups);
        	statisticsAlgorithm.execute();
        	
        	// show the option pane for exiting the algorithm
        	JOptionPane.showOptionDialog(this, "Exit this window to kill the algorithm.", "", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
        	
            // cancel the thread and stop the current R command if the statistics is not completed
            if (!statisticsAlgorithm.isDone()) {
            	statisticsAlgorithm.cancel();
            // if the algorithm is not cancelled and the last message is not regular
			} else if (!statisticsAlgorithm.isCancelled() && !RConnectionManager.getTextConsole().isLastMessageRegular()) {
        		// show an error message
        		JOptionPane.showConfirmDialog(this, RConnectionManager.getTextConsole().getLastConsoleMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
        	}
			// clear the last console message
			RConnectionManager.getTextConsole().getLastConsoleMessage();
                        
                visualizationPanel.updateStatisticsList(dataset);
        }
    }//GEN-LAST:event_runButtonActionPerformed
    
    public void updateSelectedDataset() {
    	// get the selected dataset
    	Dataset dataset = mainFrame.getSelectedDataset();
    	
    	// update the current inference algorithm label
    	currentAlgorithmValueLabel.setText(dataset.getInference().getAlgorithm());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bootstrapSamplingsLabel;
    private javax.swing.JSpinner bootstrapSamplingsSpinner;
    private javax.swing.JLabel coresRatioLabel;
    private javax.swing.JSpinner coresRatioSpinner;
    private javax.swing.JLabel currentAlgorithmLabel;
    private javax.swing.JLabel currentAlgorithmValueLabel;
    private javax.swing.JLabel groupsLabel;
    private javax.swing.JSpinner groupsSpinner;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton runButton;
    private javax.swing.JLabel runsLabel;
    private javax.swing.JSpinner runsSpinner;
    private javax.swing.JComboBox<String> statisticsComboBox;
    private javax.swing.JLabel statisticsLabel;
    private javax.swing.JComboBox<String> typeComboBox;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
    
    private class StatisticsAlgorithm extends SwingWorker<Void, Void> {
    	private final Dataset dataset;
    	private final StatisticsController statisticsController;
    	private final Object statistics;
    	private final String type;
    	private final Integer bootstrapSamplings;
    	private final Float coresRatio;
    	private final Integer runs;
    	private final Integer groups;
    	
        public StatisticsAlgorithm(Dataset dataset, StatisticsController statisticsController,
        		Object statistics, String type, Integer bootstrapSamplings, Float coresRatio, Integer runs,
        		Integer groups) {
            this.dataset = dataset;
            this.statisticsController = statisticsController;
            this.statistics = statistics;
            this.type = type;
            this.bootstrapSamplings = bootstrapSamplings;
            this.coresRatio = coresRatio;
            this.runs = runs;
            this.groups = groups;
        }
        
        @Override
		protected Void doInBackground() {
        	statisticsController.statistics(dataset, statistics, type, bootstrapSamplings, coresRatio, runs, groups);
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
