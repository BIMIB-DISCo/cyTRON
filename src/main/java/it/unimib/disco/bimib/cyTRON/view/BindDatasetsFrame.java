package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.R.RConnectionManager;
import it.unimib.disco.bimib.cyTRON.controller.DatasetController;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class BindDatasetsFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 7131553139414246373L;
	
	private final MainFrame mainFrame;
    private final DatasetController datasetController;
    private final int datasetIndex1;
    private final String bind;
    
    private final DefaultComboBoxModel<String> defaultComboBoxModel;
    
    public BindDatasetsFrame(MainFrame mainFrame, DatasetController datasetController, int datasetIndex1, String bind) {
        // get the variables
        this.mainFrame = mainFrame;
        this.datasetController = datasetController;
        this.datasetIndex1 = datasetIndex1;
        this.bind = bind;
        
        // create the default combo box model from the list of types
        this.defaultComboBoxModel = new DefaultComboBoxModel<>();
        for (Object dataset : this.datasetController.getDatasetsListModel().toArray()) {
            this.defaultComboBoxModel.addElement(dataset.toString());
        }
        this.defaultComboBoxModel.removeElementAt(this.datasetIndex1);
        
        // draw the interface
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bindLabel = new javax.swing.JLabel();
        datasetLabel1 = new javax.swing.JLabel();
        newNameLabel = new javax.swing.JLabel();
        newNameTextField = new javax.swing.JTextField();
        datasetTextField = new javax.swing.JTextField();
        bindButton = new javax.swing.JButton();
        datasetLabel2 = new javax.swing.JLabel();
        datasetComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bind " + bind);
        setMinimumSize(new java.awt.Dimension(640, 360));
        setSize(new java.awt.Dimension(640, 360));

        bindLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        bindLabel.setText("Bind " + bind);

        datasetLabel1.setText("Dataset:");

        newNameLabel.setText("New name:");

        datasetTextField.setEditable(false);
        datasetTextField.setText(((it.unimib.disco.bimib.cyTRON.model.Dataset) datasetController.getDatasetsListModel().get(datasetIndex1)).toString());

        bindButton.setText("Bind");
        bindButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bindButtonActionPerformed(evt);
            }
        });

        datasetLabel2.setText("Dataset:");

        datasetComboBox.setModel(defaultComboBoxModel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bindButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bindLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newNameLabel)
                            .addComponent(datasetLabel2)
                            .addComponent(datasetLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datasetTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                            .addComponent(datasetComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newNameTextField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(bindLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datasetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datasetLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datasetLabel2)
                    .addComponent(datasetComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newNameLabel)
                    .addComponent(newNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addComponent(bindButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bindButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bindButtonActionPerformed
        // get the new name and the index of the second type
        String newName = newNameTextField.getText();
        int datasetIndex2 = datasetComboBox.getSelectedIndex();
        if (datasetIndex2 >= datasetIndex1) {
            datasetIndex2++;
        }
        
        // check the input
        if (newName.length() == 0) {
            newNameTextField.setBackground(Color.RED);
            return;
        } else {
        	newNameTextField.setBackground(Color.WHITE);
        }

    	// bind the datasets
		this.datasetController.bind(datasetIndex1, datasetIndex2, newName, this.bind);

		// if the last console message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// close the frame
	        dispose();
		} else {
			JOptionPane.showConfirmDialog(this, RConnectionManager.getTextConsole().getLastConsoleMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
		}
    }//GEN-LAST:event_bindButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bindButton;
    private javax.swing.JLabel bindLabel;
    private javax.swing.JComboBox<String> datasetComboBox;
    private javax.swing.JLabel datasetLabel1;
    private javax.swing.JLabel datasetLabel2;
    private javax.swing.JTextField datasetTextField;
    private javax.swing.JLabel newNameLabel;
    private javax.swing.JTextField newNameTextField;
    // End of variables declaration//GEN-END:variables
}
