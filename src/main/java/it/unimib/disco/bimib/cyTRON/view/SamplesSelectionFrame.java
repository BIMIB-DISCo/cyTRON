/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.controller.DatasetController;

public class SamplesSelectionFrame extends javax.swing.JFrame {

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Samples Selection");
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

        samplesLabel.setText("Samples:");

        ctrlLabel.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        ctrlLabel.setText("ctrl/cmd-click to select multiple samples");

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
                        .addComponent(samplesLabel)
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(ctrlLabel)
                                .addGap(0, 324, Short.MAX_VALUE))
                            .addComponent(samplesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(selectionLabel)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(samplesLabel)
                    .addComponent(samplesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctrlLabel)
                .addGap(72, 72, 72)
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
        
        // select the samples
        datasetController.selectSamples(samplesIndex, datasetIndex);
        
        // update the main frame
        mainFrame.updateNumberLabels();
        
        // close the frame
        dispose();
    }//GEN-LAST:event_selectButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ctrlLabel;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel samplesLabel;
    private javax.swing.JList<String> samplesList;
    private javax.swing.JScrollPane samplesScrollPane;
    private javax.swing.JButton selectButton;
    private javax.swing.JLabel selectionLabel;
    private javax.swing.ButtonGroup typeButtonGroup;
    // End of variables declaration//GEN-END:variables
}
