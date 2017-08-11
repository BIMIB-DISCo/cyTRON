package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.R.RConnectionManager;
import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.controller.HypothesesController;
import it.unimib.disco.bimib.cyTRON.model.Event;
import it.unimib.disco.bimib.cyTRON.model.Gene;

import java.util.List;
import javax.swing.JOptionPane;

public class AddHomologousHypothesisFrame extends javax.swing.JFrame {

    private final HypothesesController hypothesesController;
    private final DatasetController datasetController;
    private final MainFrame mainFrame;
    private final HypothesesPanel hypothesesPanel;
    
    public AddHomologousHypothesisFrame(HypothesesController hypothesesController, DatasetController datasetController, MainFrame mainFrame, HypothesesPanel hypothesesPanel) {
        // instantiate the controllers and the dataset index
        this.hypothesesController = hypothesesController;
        this.datasetController = datasetController;
        this.mainFrame = mainFrame;
        this.hypothesesPanel = hypothesesPanel;
        
        // draws the interface
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addHomologousButton)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(effectLabel)
                                    .addComponent(causeLabel)
                                    .addComponent(genesLabel))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ctrlLabel2)
                                    .addComponent(genesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(causeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ctrlLabel1)
                                    .addComponent(ctrlLabel3)
                                    .addComponent(effectScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
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
        
        // add the hypothesis
        hypothesesController.addHomologousHypothesis(mainFrame.getSelectedDataset(), effect, cause, genes, datasetController); 
        
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
    // End of variables declaration//GEN-END:variables
}
