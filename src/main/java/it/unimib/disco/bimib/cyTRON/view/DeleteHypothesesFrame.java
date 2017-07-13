package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.controller.HypothesesController;
import javax.swing.DefaultComboBoxModel;

public class DeleteHypothesesFrame extends javax.swing.JFrame {

    private final HypothesesController hypothesesController;
    private final DatasetController datasetController;
    private final MainFrame mainFrame;
    private final HypothesesPanel hypothesesPanel;
    
    private final DefaultComboBoxModel<Object> eventsDefaultComboBoxModel;

    public DeleteHypothesesFrame(HypothesesController hypothesesController, DatasetController datasetController, MainFrame mainFrame, HypothesesPanel hypothesesPanel) {
        // instantiate the controllers
        this.hypothesesController = hypothesesController;
        this.datasetController = datasetController;
        this.mainFrame = mainFrame;
        this.hypothesesPanel = hypothesesPanel;
        
        // construct the combo box model
        eventsDefaultComboBoxModel = new DefaultComboBoxModel(datasetController.getGenesListModel().toArray());
        for (Object pattern : hypothesesController.getPatternsListModel().toArray()) {
            eventsDefaultComboBoxModel.addElement(pattern);
        }
        
        // draw the interface
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        typeButtonGroup = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        deleteLabel = new javax.swing.JLabel();
        eventLabel = new javax.swing.JLabel();
        deletionLabel = new javax.swing.JLabel();
        effectRadioButton = new javax.swing.JRadioButton();
        causeRadioButton = new javax.swing.JRadioButton();
        bothRadioButton = new javax.swing.JRadioButton();
        deleteButton = new javax.swing.JButton();
        eventComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Delete Hypotheses");
        setMinimumSize(new java.awt.Dimension(640, 360));

        deleteLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        deleteLabel.setText("Delete Hypotheses");

        eventLabel.setText("Event:");

        deletionLabel.setText("Deletion:");

        typeButtonGroup.add(effectRadioButton);
        effectRadioButton.setSelected(true);
        effectRadioButton.setText("Effect");

        typeButtonGroup.add(causeRadioButton);
        causeRadioButton.setText("Cause");

        typeButtonGroup.add(bothRadioButton);
        bothRadioButton.setText("Both");

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        eventComboBox.setModel(eventsDefaultComboBoxModel);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(deleteButton))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(deleteLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deletionLabel)
                            .addComponent(eventLabel))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(effectRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(causeRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(bothRadioButton)
                                .addGap(0, 307, Short.MAX_VALUE))
                            .addComponent(eventComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addComponent(deleteLabel)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deletionLabel)
                    .addComponent(effectRadioButton)
                    .addComponent(causeRadioButton)
                    .addComponent(bothRadioButton))
                .addGap(14, 14, 14)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96)
                .addComponent(deleteButton)
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

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        
        
        
        if (effectRadioButton.isSelected()) {
            // datasetController.importDataset(name, path,DatasetController.GENOTYPES);
        } else if (bothRadioButton.isSelected()) {
            // datasetController.importDataset(name, path, DatasetController.GISTIC);
        } else if (causeRadioButton.isSelected()) {
            // datasetController.importDataset(name, path, DatasetController.MAF);
        }
        
        dispose();
    }//GEN-LAST:event_deleteButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bothRadioButton;
    private javax.swing.JRadioButton causeRadioButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel deleteLabel;
    private javax.swing.JLabel deletionLabel;
    private javax.swing.JRadioButton effectRadioButton;
    private javax.swing.JComboBox<Object> eventComboBox;
    private javax.swing.JLabel eventLabel;
    private javax.swing.JPanel panel;
    private javax.swing.ButtonGroup typeButtonGroup;
    // End of variables declaration//GEN-END:variables
}
