/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.controller.HypothesesController;
import it.unimib.disco.bimib.cyTRON.model.Dataset;

public class HypothesesPanel extends javax.swing.JPanel {
    
    private HypothesesController hypothesesController;
    private DatasetController datasetController;
    private MainFrame mainFrame;
    
    public HypothesesPanel() {
        // draws the interface
        initComponents();
    }
    
    public HypothesesPanel(DatasetController datasetController, MainFrame mainFrame) {
        // get the main frame and the controllers
        hypothesesController = new HypothesesController();
        this.datasetController = datasetController;
        this.mainFrame = mainFrame;
        
        // draws the interface
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoPanel = new javax.swing.JPanel();
        patternsLabel = new javax.swing.JLabel();
        patternsNumberLabel = new javax.swing.JLabel();
        hypothesesLabel = new javax.swing.JLabel();
        hypothesesNumberLabel = new javax.swing.JLabel();
        patternsPanel = new javax.swing.JPanel();
        addPatternButton = new javax.swing.JButton();
        patternsScrollPane = new javax.swing.JScrollPane();
        patternsList = new javax.swing.JList<>();
        deletePatternButton = new javax.swing.JButton();
        hypothesesPanel = new javax.swing.JPanel();
        hypothesesScrollPane = new javax.swing.JScrollPane();
        hypothesesList = new javax.swing.JList<>();

        setMinimumSize(new java.awt.Dimension(941, 662));
        setPreferredSize(new java.awt.Dimension(941, 662));

        infoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Info"));

        patternsLabel.setText("Patterns:");

        hypothesesLabel.setText("Hypotheses:");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(patternsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patternsNumberLabel)
                .addGap(100, 100, 100)
                .addComponent(hypothesesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hypothesesNumberLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patternsLabel)
                    .addComponent(patternsNumberLabel)
                    .addComponent(hypothesesLabel)
                    .addComponent(hypothesesNumberLabel))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        patternsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Patterns"));

        addPatternButton.setText("Add...");
        addPatternButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPatternButtonActionPerformed(evt);
            }
        });

        patternsList.setModel(hypothesesController.getPatternsListModel());
        patternsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                patternsListValueChanged(evt);
            }
        });
        patternsScrollPane.setViewportView(patternsList);

        deletePatternButton.setText("Delete");
        deletePatternButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePatternButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout patternsPanelLayout = new javax.swing.GroupLayout(patternsPanel);
        patternsPanel.setLayout(patternsPanelLayout);
        patternsPanelLayout.setHorizontalGroup(
            patternsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patternsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(patternsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patternsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addGroup(patternsPanelLayout.createSequentialGroup()
                        .addComponent(addPatternButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deletePatternButton)))
                .addContainerGap())
        );
        patternsPanelLayout.setVerticalGroup(
            patternsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patternsPanelLayout.createSequentialGroup()
                .addComponent(patternsScrollPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(patternsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPatternButton)
                    .addComponent(deletePatternButton))
                .addContainerGap())
        );

        hypothesesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Hypotheses"));

        hypothesesList.setModel(hypothesesController.getHypothesesListModel());
        hypothesesScrollPane.setViewportView(hypothesesList);

        javax.swing.GroupLayout hypothesesPanelLayout = new javax.swing.GroupLayout(hypothesesPanel);
        hypothesesPanel.setLayout(hypothesesPanelLayout);
        hypothesesPanelLayout.setHorizontalGroup(
            hypothesesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hypothesesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hypothesesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                .addContainerGap())
        );
        hypothesesPanelLayout.setVerticalGroup(
            hypothesesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hypothesesPanelLayout.createSequentialGroup()
                .addComponent(hypothesesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 143, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(patternsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hypothesesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patternsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hypothesesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addPatternButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPatternButtonActionPerformed
        AddHypothesisFrame addHypothesisFrame = new AddHypothesisFrame(hypothesesController, datasetController, mainFrame, this);
        addHypothesisFrame.setLocationRelativeTo(null);
	addHypothesisFrame.setVisible(true);
    }//GEN-LAST:event_addPatternButtonActionPerformed

    private void deletePatternButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePatternButtonActionPerformed
        // get the dataset
        Dataset dataset = (Dataset) datasetController.getDatasetsListModel().get(mainFrame.getDatasetSelectedIndex());

        // delete the pattern
        hypothesesController.deletePattern(dataset, patternsList.getSelectedIndex(), datasetController);
        
        // update the number labels
        mainFrame.updateNumberLabels();
        updatePatternsNumberLabel();
        hypothesesNumberLabel.setText("");
    }//GEN-LAST:event_deletePatternButtonActionPerformed

    private void patternsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_patternsListValueChanged
        hypothesesController.updateHypothesesList(patternsList.getSelectedIndex());
        hypothesesNumberLabel.setText(String.valueOf(hypothesesController.getHypothesesListModel().size()));
    }//GEN-LAST:event_patternsListValueChanged

    // ************ OTHERS ************ \\
    public void updatePatternsNumberLabel() {
        patternsNumberLabel.setText(String.valueOf(hypothesesController.getPatternsListModel().size()));
    }
    
    public void updateSelectedDataset(int datasetIndex) {
        // get the dataset
        Dataset dataset = (Dataset) datasetController.getDatasetsListModel().get(mainFrame.getDatasetSelectedIndex());
        
        // update lists
        hypothesesController.updatePatternsList(dataset);
        hypothesesController.updateHypothesesList(-1);
        
        // update the number labels
        updatePatternsNumberLabel();
        hypothesesNumberLabel.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPatternButton;
    private javax.swing.JButton deletePatternButton;
    private javax.swing.JLabel hypothesesLabel;
    private javax.swing.JList<String> hypothesesList;
    private javax.swing.JLabel hypothesesNumberLabel;
    private javax.swing.JPanel hypothesesPanel;
    private javax.swing.JScrollPane hypothesesScrollPane;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel patternsLabel;
    private javax.swing.JList<String> patternsList;
    private javax.swing.JLabel patternsNumberLabel;
    private javax.swing.JPanel patternsPanel;
    private javax.swing.JScrollPane patternsScrollPane;
    // End of variables declaration//GEN-END:variables
}
