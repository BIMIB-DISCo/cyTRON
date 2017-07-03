/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.controller.HypothesesController;
import it.unimib.disco.bimib.cyTRON.model.Event;
import it.unimib.disco.bimib.cyTRON.model.Gene;
import javax.swing.DefaultComboBoxModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class AddHypothesisFrame extends javax.swing.JFrame {

    private final HypothesesController hypothesesController;
    private final DatasetController datasetController;
    
    private final DefaultTreeCellRenderer defaultTreeCellRenderer;
    private final DefaultComboBoxModel<String> operationsDefaultComboBoxModel;
    private final DefaultComboBoxModel<Gene> genesDefaultComboBoxModel;
    private final DefaultComboBoxModel<Event> eventsDefaultComboBoxModel;
    
    public AddHypothesisFrame(HypothesesController hypothesesController, DatasetController datasetController) {
        // instantiate the controllers
        this.hypothesesController = hypothesesController;
        this.datasetController = datasetController;
        
        // modify the render of the tree
        defaultTreeCellRenderer = new DefaultTreeCellRenderer();
        defaultTreeCellRenderer.setLeafIcon(null);
        defaultTreeCellRenderer.setOpenIcon(null);
        defaultTreeCellRenderer.setClosedIcon(null);
        
        // create the default combo box models
        operationsDefaultComboBoxModel = new DefaultComboBoxModel(new String[]{"AND", "OR", "XOR"});
        genesDefaultComboBoxModel = new DefaultComboBoxModel(datasetController.getGenesListModel().toArray());
        eventsDefaultComboBoxModel = new DefaultComboBoxModel(datasetController.getEventsListModel().toArray());
        
        // draws the interface
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nodeButtonGroup = new javax.swing.ButtonGroup();
        expressioinPanel = new javax.swing.JPanel();
        expressionScrollPane = new javax.swing.JScrollPane();
        expressionTree = new javax.swing.JTree();
        addNodeButton = new javax.swing.JButton();
        operationRadioButton = new javax.swing.JRadioButton();
        geneRadioButton = new javax.swing.JRadioButton();
        eventRadioButton = new javax.swing.JRadioButton();
        operationComboBox = new javax.swing.JComboBox<>();
        geneComboBox = new javax.swing.JComboBox<>();
        eventComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(960, 540));
        setSize(new java.awt.Dimension(960, 540));

        expressioinPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Expression"));

        expressionTree.setModel(hypothesesController.getExpressionTreeModel());
        expressionTree.setCellRenderer(defaultTreeCellRenderer);
        expressionTree.setShowsRootHandles(true);
        expressionScrollPane.setViewportView(expressionTree);

        addNodeButton.setText("Add...");
        addNodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNodeButtonActionPerformed(evt);
            }
        });

        nodeButtonGroup.add(operationRadioButton);
        operationRadioButton.setSelected(true);
        operationRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operationRadioButtonActionPerformed(evt);
            }
        });

        nodeButtonGroup.add(geneRadioButton);

        nodeButtonGroup.add(eventRadioButton);

        operationComboBox.setModel(operationsDefaultComboBoxModel);

        geneComboBox.setModel(genesDefaultComboBoxModel);

        eventComboBox.setModel(eventsDefaultComboBoxModel);

        javax.swing.GroupLayout expressioinPanelLayout = new javax.swing.GroupLayout(expressioinPanel);
        expressioinPanel.setLayout(expressioinPanelLayout);
        expressioinPanelLayout.setHorizontalGroup(
            expressioinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(expressioinPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(expressioinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(expressionScrollPane)
                    .addGroup(expressioinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(expressioinPanelLayout.createSequentialGroup()
                            .addComponent(operationRadioButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(operationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(expressioinPanelLayout.createSequentialGroup()
                            .addComponent(geneRadioButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(geneComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(expressioinPanelLayout.createSequentialGroup()
                            .addComponent(eventRadioButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(eventComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(expressioinPanelLayout.createSequentialGroup()
                            .addGap(107, 107, 107)
                            .addComponent(addNodeButton))))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        expressioinPanelLayout.setVerticalGroup(
            expressioinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(expressioinPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(expressionScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(expressioinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(operationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(operationRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(expressioinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(geneRadioButton)
                    .addComponent(geneComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(expressioinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eventComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addNodeButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(expressioinPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(403, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(expressioinPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addNodeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNodeButtonActionPerformed
        // get the selected node
        DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) expressionTree.getSelectionPath().getLastPathComponent();

        Object childObject = null;
        if (operationRadioButton.isSelected()) {
            childObject = operationComboBox.getSelectedItem();
        } else if (geneRadioButton.isSelected()) {
            childObject = geneComboBox.getSelectedItem();
        } else if (eventRadioButton.isSelected()) {
            childObject = eventComboBox.getSelectedItem();
        }

        // add the object to the tree
        hypothesesController.addNode(parentNode, childObject);
        
        // expand the parent
        expressionTree.expandPath(expressionTree.getSelectionPath());
    }//GEN-LAST:event_addNodeButtonActionPerformed

    private void operationRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operationRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_operationRadioButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNodeButton;
    private javax.swing.JComboBox<Event> eventComboBox;
    private javax.swing.JRadioButton eventRadioButton;
    private javax.swing.JPanel expressioinPanel;
    private javax.swing.JScrollPane expressionScrollPane;
    private javax.swing.JTree expressionTree;
    private javax.swing.JComboBox<Gene> geneComboBox;
    private javax.swing.JRadioButton geneRadioButton;
    private javax.swing.ButtonGroup nodeButtonGroup;
    private javax.swing.JComboBox<String> operationComboBox;
    private javax.swing.JRadioButton operationRadioButton;
    // End of variables declaration//GEN-END:variables
}
