/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.controller.HypothesesController;

public class HypothesesPanel extends javax.swing.JPanel {

    private final DatasetController datasetController;
    private final HypothesesController hypothesesController;
    
    public HypothesesPanel(DatasetController datasetController) {
        // get the controllers
        this.datasetController = datasetController;
        hypothesesController = new HypothesesController();
        
        // draws the interface
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addNodeButton = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(941, 662));
        setPreferredSize(new java.awt.Dimension(941, 662));

        addNodeButton.setText("Add...");
        addNodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNodeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addNodeButton)
                .addContainerGap(854, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(378, 378, 378)
                .addComponent(addNodeButton)
                .addContainerGap(255, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addNodeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNodeButtonActionPerformed
        AddHypothesisFrame addHypothesisFrame = new AddHypothesisFrame(hypothesesController, datasetController);
        addHypothesisFrame.setLocationRelativeTo(null);
	addHypothesisFrame.setVisible(true);
    }//GEN-LAST:event_addNodeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNodeButton;
    // End of variables declaration//GEN-END:variables
}
