package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.R.RConnectionManager;
import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.controller.HypothesesController;
import it.unimib.disco.bimib.cyTRON.model.Event;
import it.unimib.disco.bimib.cyTRON.model.Gene;

import java.awt.Color;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class AddGroupHypothesisFrame extends javax.swing.JFrame {

    private final HypothesesController hypothesesController;
    private final DatasetController datasetController;
    private final MainFrame mainFrame;
    private final HypothesesPanel hypothesesPanel;
    
    private final DefaultComboBoxModel<String> operationsDefaultComboBoxModel;
    
    public AddGroupHypothesisFrame(HypothesesController hypothesesController, DatasetController datasetController, MainFrame mainFrame, HypothesesPanel hypothesesPanel) {
        // instantiate the controllers and the dataset index
        this.hypothesesController = hypothesesController;
        this.datasetController = datasetController;
        this.mainFrame = mainFrame;
        this.hypothesesPanel = hypothesesPanel;
        
        // create the default combo box models
        operationsDefaultComboBoxModel = new DefaultComboBoxModel(HypothesesController.OPERATIONS);
        
        // draws the interface
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nodeButtonGroup = new javax.swing.ButtonGroup();
        addGroupButton = new javax.swing.JButton();
        effectLabel = new javax.swing.JLabel();
        effectScrollPane = new javax.swing.JScrollPane();
        effectList = new javax.swing.JList<>();
        ctrlLabel1 = new javax.swing.JLabel();
        causeLabel = new javax.swing.JLabel();
        causeScrollPane = new javax.swing.JScrollPane();
        causeList = new javax.swing.JList<>();
        ctrlLabel2 = new javax.swing.JLabel();
        addLabel = new javax.swing.JLabel();
        genesLabel = new javax.swing.JLabel();
        genesScrollPane = new javax.swing.JScrollPane();
        genesList = new javax.swing.JList<>();
        ctrlLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        operationComboBox = new javax.swing.JComboBox<>();
        minimumCardinalityLabel = new javax.swing.JLabel();
        maximumCardinalityLabel = new javax.swing.JLabel();
        minimumProbabilityLabel = new javax.swing.JLabel();
        defaultLabel = new javax.swing.JLabel();
        minimumCardinalitySpinner = new javax.swing.JSpinner();
        maximumCardinalitySpinner = new javax.swing.JSpinner();
        minimumProbabilitySpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Group");
        setMaximumSize(new java.awt.Dimension(960, 540));
        setMinimumSize(new java.awt.Dimension(960, 540));
        setSize(new java.awt.Dimension(960, 540));

        addGroupButton.setText("Add");
        addGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGroupButtonActionPerformed(evt);
            }
        });

        effectLabel.setText("Effect:");

        effectList.setModel(datasetController.getEventsListModel());
        effectList.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        effectScrollPane.setViewportView(effectList);

        ctrlLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        ctrlLabel1.setText("ctrl/cmd-click to select multiple events (do not select for all)");

        causeLabel.setText("Cause:");

        causeList.setModel(datasetController.getEventsListModel());
        causeList.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        causeScrollPane.setViewportView(causeList);

        ctrlLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        ctrlLabel2.setText("ctrl/cmd-click to select multiple events (do not select for all)");

        addLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        addLabel.setText("Add Group");

        genesLabel.setText("Genes:");

        genesList.setModel(datasetController.getGenesListModel());
        genesList.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        genesScrollPane.setViewportView(genesList);

        ctrlLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        ctrlLabel3.setText("ctrl/cmd-click to select multiple genes");

        jLabel1.setText("Operation:");

        operationComboBox.setModel(operationsDefaultComboBoxModel);

        minimumCardinalityLabel.setText("Minimum cardinality*:");

        maximumCardinalityLabel.setText("Maximum cardinality*:");

        minimumProbabilityLabel.setText("Minimum probability*:");

        defaultLabel.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        defaultLabel.setText("* negative for default");

        minimumCardinalitySpinner.setModel(new javax.swing.SpinnerNumberModel(-1, -1, null, 1));

        maximumCardinalitySpinner.setModel(new javax.swing.SpinnerNumberModel(-1, -1, null, 1));

        minimumProbabilitySpinner.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(-0.01f), Float.valueOf(-0.01f), Float.valueOf(1.0f), Float.valueOf(0.01f)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(genesLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(operationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(genesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addGroupButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(causeLabel)
                                .addGap(42, 42, 42)
                                .addComponent(causeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(minimumProbabilityLabel)
                                .addGap(18, 18, 18)
                                .addComponent(minimumProbabilitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(addLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ctrlLabel1)
                                    .addComponent(ctrlLabel2)
                                    .addComponent(ctrlLabel3)))
                            .addComponent(defaultLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(minimumCardinalityLabel)
                                .addGap(18, 18, 18)
                                .addComponent(minimumCardinalitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(193, 193, 193)
                                .addComponent(maximumCardinalityLabel)
                                .addGap(18, 18, 18)
                                .addComponent(maximumCardinalitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(effectLabel)
                                .addGap(44, 44, 44)
                                .addComponent(effectScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(addLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(operationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genesLabel)
                    .addComponent(genesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctrlLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(effectScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(effectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctrlLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(causeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(causeLabel))
                .addGap(6, 6, 6)
                .addComponent(ctrlLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minimumCardinalityLabel)
                    .addComponent(maximumCardinalityLabel)
                    .addComponent(minimumCardinalitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maximumCardinalitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minimumProbabilityLabel)
                    .addComponent(minimumProbabilitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(defaultLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addGroupButton)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void addGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGroupButtonActionPerformed
        // get the parameters
        String operation = (String) operationComboBox.getSelectedItem();
        List<Gene> genes = genesList.getSelectedValuesList();
        List<Event> effect = effectList.getSelectedValuesList();
        List<Event> cause = causeList.getSelectedValuesList();
        Integer minimumCardinality = (Integer) minimumCardinalitySpinner.getValue();
        Integer maximumCardinality = (Integer) maximumCardinalitySpinner.getValue();
        Float minimumProbability = (Float) minimumProbabilitySpinner.getValue();
        
        // if no genes are selected
        if (genes.size() == 0) {
            // return
            genesList.setBackground(Color.RED);
            return;
        } else {
        	genesList.setBackground(Color.WHITE);
        }
        
        // add the hypothesis
        hypothesesController.addGroupHypothesis(mainFrame.getSelectedDataset(), operation, genes, effect, cause, minimumCardinality, maximumCardinality, minimumProbability, datasetController);
        
        // if the last console message is regular
    	if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
    		// update the number labels
            mainFrame.updateNumberLabels();
            hypothesesPanel.updatePatternsNumberLabel();
            
            // close the frame
            dispose();
    	} else {
    		JOptionPane.showConfirmDialog(this, RConnectionManager.getTextConsole().getLastConsoleMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
    	}
    }//GEN-LAST:event_addGroupButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addGroupButton;
    private javax.swing.JLabel addLabel;
    private javax.swing.JLabel causeLabel;
    private javax.swing.JList<Event> causeList;
    private javax.swing.JScrollPane causeScrollPane;
    private javax.swing.JLabel ctrlLabel1;
    private javax.swing.JLabel ctrlLabel2;
    private javax.swing.JLabel ctrlLabel3;
    private javax.swing.JLabel defaultLabel;
    private javax.swing.JLabel effectLabel;
    private javax.swing.JList<Event> effectList;
    private javax.swing.JScrollPane effectScrollPane;
    private javax.swing.JLabel genesLabel;
    private javax.swing.JList<Gene> genesList;
    private javax.swing.JScrollPane genesScrollPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel maximumCardinalityLabel;
    private javax.swing.JSpinner maximumCardinalitySpinner;
    private javax.swing.JLabel minimumCardinalityLabel;
    private javax.swing.JSpinner minimumCardinalitySpinner;
    private javax.swing.JLabel minimumProbabilityLabel;
    private javax.swing.JSpinner minimumProbabilitySpinner;
    private javax.swing.ButtonGroup nodeButtonGroup;
    private javax.swing.JComboBox<String> operationComboBox;
    // End of variables declaration//GEN-END:variables
}
