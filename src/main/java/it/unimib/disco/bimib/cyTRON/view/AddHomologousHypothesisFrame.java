package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.controller.HypothesesController;
import it.unimib.disco.bimib.cyTRON.model.Dataset;
import it.unimib.disco.bimib.cyTRON.model.Event;
import it.unimib.disco.bimib.cyTRON.model.Gene;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class AddHomologousHypothesisFrame extends javax.swing.JFrame {

    private final HypothesesController hypothesesController;
    private final DatasetController datasetController;
    private final MainFrame mainFrame;
    private final HypothesesPanel hypothesesPanel;
    
    private final DefaultComboBoxModel<String> operationsDefaultComboBoxModel;
    
    public AddHomologousHypothesisFrame(HypothesesController hypothesesController, DatasetController datasetController, MainFrame mainFrame, HypothesesPanel hypothesesPanel) {
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
        addHomologousButton = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Homologous");
        setMaximumSize(new java.awt.Dimension(960, 540));
        setMinimumSize(new java.awt.Dimension(960, 540));
        setSize(new java.awt.Dimension(960, 540));

        addHomologousButton.setText("Add");
        addHomologousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHomologousButtonActionPerformed(evt);
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
        addLabel.setText("Add Homologous");

        genesLabel.setText("Genes:");

        genesList.setModel(datasetController.getGenesListModel());
        genesList.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        genesScrollPane.setViewportView(genesList);

        ctrlLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        ctrlLabel3.setText("ctrl/cmd-click to select multiple genes (do not select for all)");

        jLabel1.setText("Operation:");

        operationComboBox.setModel(operationsDefaultComboBoxModel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addHomologousButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addLabel)
                        .addGap(832, 832, 832))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(effectLabel)
                            .addComponent(causeLabel)
                            .addComponent(genesLabel)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ctrlLabel2)
                                .addGap(541, 541, 541))
                            .addComponent(effectScrollPane)
                            .addComponent(causeScrollPane)
                            .addComponent(genesScrollPane)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(operationComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ctrlLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ctrlLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(addLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(effectLabel)
                    .addComponent(effectScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(ctrlLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(causeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(causeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctrlLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genesLabel)
                    .addComponent(genesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctrlLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(operationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addComponent(addHomologousButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void addHomologousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHomologousButtonActionPerformed
        // get the parameters
        List<Event> effect = effectList.getSelectedValuesList();
        List<Event> cause = causeList.getSelectedValuesList();
        List<Gene> genes = genesList.getSelectedValuesList();
        String operation = (String) operationComboBox.getSelectedItem();
        
        // add the hypothesis
        hypothesesController.addHomologousHypothesis(mainFrame.getSelectedDataset(), effect, cause, genes, operation, datasetController); 
        
        // update the number labels
        mainFrame.updateNumberLabels();
        hypothesesPanel.updatePatternsNumberLabel();
                
        // close the frame
        dispose();
    }//GEN-LAST:event_addHomologousButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addHomologousButton;
    private javax.swing.JLabel addLabel;
    private javax.swing.JLabel causeLabel;
    private javax.swing.JList<Event> causeList;
    private javax.swing.JScrollPane causeScrollPane;
    private javax.swing.JLabel ctrlLabel1;
    private javax.swing.JLabel ctrlLabel2;
    private javax.swing.JLabel ctrlLabel3;
    private javax.swing.JLabel effectLabel;
    private javax.swing.JList<Event> effectList;
    private javax.swing.JScrollPane effectScrollPane;
    private javax.swing.JLabel genesLabel;
    private javax.swing.JList<Gene> genesList;
    private javax.swing.JScrollPane genesScrollPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.ButtonGroup nodeButtonGroup;
    private javax.swing.JComboBox<String> operationComboBox;
    // End of variables declaration//GEN-END:variables
}
