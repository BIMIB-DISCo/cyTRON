package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.controller.HypothesesController;
import it.unimib.disco.bimib.cyTRON.model.Dataset;
import javax.swing.DefaultComboBoxModel;

public class DeleteHypothesesFrame extends javax.swing.JFrame {

    public static final String EFFECT = "Effect";
    public static final String CAUSE = "Cause";
    public static final String EVENT = "Event";
    
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
        causeRadioButton = new javax.swing.JRadioButton();
        effectRadioButton = new javax.swing.JRadioButton();
        eventRadioButton = new javax.swing.JRadioButton();
        deleteButton = new javax.swing.JButton();
        eventComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Delete Hypotheses");
        setMinimumSize(new java.awt.Dimension(640, 360));

        deleteLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        deleteLabel.setText("Delete Hypotheses");

        eventLabel.setText("Event:");

        deletionLabel.setText("Deletion:");

        typeButtonGroup.add(causeRadioButton);
        causeRadioButton.setSelected(true);
        causeRadioButton.setText(CAUSE);

        typeButtonGroup.add(effectRadioButton);
        effectRadioButton.setText(EFFECT);

        typeButtonGroup.add(eventRadioButton);
        eventRadioButton.setText(EVENT);

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
                                .addComponent(causeRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(effectRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(eventRadioButton)
                                .addGap(0, 157, Short.MAX_VALUE))
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
                    .addComponent(causeRadioButton)
                    .addComponent(effectRadioButton)
                    .addComponent(eventRadioButton))
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
        // get the event and the dataset
        Object event = eventComboBox.getSelectedItem();
        Dataset dataset = mainFrame.getSelectedDataset();
                
        // delete the hypothesis
        if (causeRadioButton.isSelected()) {
            hypothesesController.deleteHypothesis(dataset, CAUSE, event, hypothesesPanel.getPatternsSelectedIndex());
        } else if (effectRadioButton.isSelected()) {
            hypothesesController.deleteHypothesis(dataset, EFFECT, event, hypothesesPanel.getPatternsSelectedIndex());
        } else if (eventRadioButton.isSelected()) {
            hypothesesController.deleteHypothesis(dataset, EVENT, event, hypothesesPanel.getPatternsSelectedIndex());
        }
        
        // update the number of patterns and hypotheses
        hypothesesPanel.updateHypothesesNumberLabel();
        
        // close the frame
        dispose();
    }//GEN-LAST:event_deleteButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton causeRadioButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel deleteLabel;
    private javax.swing.JLabel deletionLabel;
    private javax.swing.JRadioButton effectRadioButton;
    private javax.swing.JComboBox<Object> eventComboBox;
    private javax.swing.JLabel eventLabel;
    private javax.swing.JRadioButton eventRadioButton;
    private javax.swing.JPanel panel;
    private javax.swing.ButtonGroup typeButtonGroup;
    // End of variables declaration//GEN-END:variables
}
