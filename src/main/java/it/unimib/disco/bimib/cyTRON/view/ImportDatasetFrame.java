package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.R.RConnectionManager;
import it.unimib.disco.bimib.cyTRON.controller.DatasetController;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ImportDatasetFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = -3735699826971726858L;
	
	private final DatasetController datasetController;
	private final MainFrame mainFrame;

    public ImportDatasetFrame(DatasetController datasetController, MainFrame mainFrame) {
        // get the controller and the main frame
        this.datasetController = datasetController;
        this.mainFrame = mainFrame;
        
        // draw the interface
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        typeButtonGroup = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JTextField();
        panel = new javax.swing.JPanel();
        importLabel = new javax.swing.JLabel();
        pathLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        pathTextField = new javax.swing.JTextField();
        typeLabel = new javax.swing.JLabel();
        genotypesRadioButton = new javax.swing.JRadioButton();
        mafRadioButton = new javax.swing.JRadioButton();
        gisticRadioButton = new javax.swing.JRadioButton();
        importButton = new javax.swing.JButton();
        loadRadioButton = new javax.swing.JRadioButton();
        workspaceRadioButton = new javax.swing.JRadioButton();
        eventTypeLabel = new javax.swing.JLabel();
        eventTypeTextField = new javax.swing.JTextField();
        trimLabel = new javax.swing.JLabel();
        trimCheckBox = new javax.swing.JCheckBox();
        separatorLabel = new javax.swing.JLabel();
        separatorTextField = new javax.swing.JTextField();
        tcgaLabel = new javax.swing.JLabel();
        tcgaCheckBox = new javax.swing.JCheckBox();
        mergeMutationisTypesLabel = new javax.swing.JLabel();
        mergeMutationsTypesCheckBox = new javax.swing.JCheckBox();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Import Dataset");
        setBounds(new java.awt.Rectangle(0, 0, 960, 540));
        setMaximumSize(new java.awt.Dimension(960, 540));
        setMinimumSize(new java.awt.Dimension(960, 540));
        setPreferredSize(new java.awt.Dimension(960, 540));

        importLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        importLabel.setText("Import Dataset from File");

        pathLabel.setText("File:");

        nameLabel.setText("Dataset name:");

        pathTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pathTextFieldMouseClicked(evt);
            }
        });

        typeLabel.setText("Type:");

        typeButtonGroup.add(genotypesRadioButton);
        genotypesRadioButton.setSelected(true);
        genotypesRadioButton.setText("genotypes");
        genotypesRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                genotypesRadioButtonStateChanged(evt);
            }
        });

        typeButtonGroup.add(mafRadioButton);
        mafRadioButton.setText("MAF");
        mafRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mafRadioButtonStateChanged(evt);
            }
        });

        typeButtonGroup.add(gisticRadioButton);
        gisticRadioButton.setText("GISTIC");
        gisticRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                gisticRadioButtonStateChanged(evt);
            }
        });

        importButton.setText("Import");
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });

        typeButtonGroup.add(loadRadioButton);
        loadRadioButton.setText("load");
        loadRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                loadRadioButtonStateChanged(evt);
            }
        });

        typeButtonGroup.add(workspaceRadioButton);
        workspaceRadioButton.setText("workspace");
        workspaceRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                workspaceRadioButtonStateChanged(evt);
            }
        });

        eventTypeLabel.setText("Event type:");

        eventTypeTextField.setText("variant");

        trimLabel.setText("Trim:");

        trimCheckBox.setSelected(true);
        trimCheckBox.setText(" ");
        trimCheckBox.setEnabled(false);

        separatorLabel.setText("Separator:");

        separatorTextField.setText("\\t");
        separatorTextField.setEnabled(false);

        tcgaLabel.setText("TCGA:");

        tcgaCheckBox.setSelected(true);
        tcgaCheckBox.setText(" ");
        tcgaCheckBox.setEnabled(false);

        mergeMutationisTypesLabel.setText("Merge mutations types:");

        mergeMutationsTypesCheckBox.setSelected(true);
        mergeMutationsTypesCheckBox.setText(" ");
        mergeMutationsTypesCheckBox.setEnabled(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(importButton))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(importLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(pathLabel)
                            .addComponent(typeLabel)
                            .addComponent(eventTypeLabel)
                            .addComponent(trimLabel)
                            .addComponent(separatorLabel))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameTextField)
                            .addComponent(pathTextField)
                            .addComponent(eventTypeTextField)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(trimCheckBox)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(genotypesRadioButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(gisticRadioButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(mafRadioButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(loadRadioButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(workspaceRadioButton))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(separatorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tcgaLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(tcgaCheckBox)
                                        .addGap(18, 18, 18)
                                        .addComponent(mergeMutationisTypesLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(mergeMutationsTypesCheckBox)))
                                .addGap(0, 253, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(importLabel)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel)
                    .addComponent(genotypesRadioButton)
                    .addComponent(mafRadioButton)
                    .addComponent(loadRadioButton)
                    .addComponent(workspaceRadioButton)
                    .addComponent(gisticRadioButton))
                .addGap(13, 13, 13)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathLabel)
                    .addComponent(pathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventTypeLabel))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trimCheckBox)
                    .addComponent(trimLabel))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(separatorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separatorLabel)
                    .addComponent(tcgaLabel)
                    .addComponent(tcgaCheckBox)
                    .addComponent(mergeMutationisTypesLabel)
                    .addComponent(mergeMutationsTypesCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(importButton)
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

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
    	// get the parameters
    	String name = nameTextField.getText();
        String path = pathTextField.getText();
        String eventType = eventTypeTextField.getText();
        Boolean trim = trimCheckBox.isSelected();
        String separator = separatorTextField.getText();
        Boolean tcga = tcgaCheckBox.isSelected();
        Boolean mergeMutationsTypes = mergeMutationsTypesCheckBox.isSelected();
        
        // check the parameters
        if (name.length() == 0 && nameTextField.isEnabled()) {
        	nameTextField.setBackground(Color.RED);
		} else {
			nameTextField.setBackground(Color.WHITE);
        }
        if (path.length() == 0) {
        	pathTextField.setBackground(Color.RED);
		} else {
			pathTextField.setBackground(Color.WHITE);
        }
        if (eventType.length() == 0 && eventTypeTextField.isEnabled()) {
        	eventTypeTextField.setBackground(Color.RED);
		} else {
			eventTypeTextField.setBackground(Color.WHITE);
        }
        if (separator.length() == 0 && separatorTextField.isEnabled()) {
        	separatorTextField.setBackground(Color.RED);
		} else {
			separatorTextField.setBackground(Color.WHITE);
        }
        
        try {
        	if ((name.length() > 0 || !nameTextField.isEnabled()) && path.length() > 0 &&
        			(eventType.length() > 0 || !eventTypeTextField.isEnabled()) && (separator.length() > 0 || !separatorTextField.isEnabled())) {
        		// import the dataset
    			if (genotypesRadioButton.isSelected()) {
    			    datasetController.importDataset(DatasetController.GENOTYPES, name, path, eventType, trim, separator, tcga, mergeMutationsTypes);
    			} else if (gisticRadioButton.isSelected()) {
    			    datasetController.importDataset(DatasetController.GISTIC, name, path, eventType, trim, separator, tcga, mergeMutationsTypes);
    			} else if (mafRadioButton.isSelected()) {
    			    datasetController.importDataset(DatasetController.MAF, name, path, eventType, trim, separator, tcga, mergeMutationsTypes);
    			} else if (loadRadioButton.isSelected()) {
                    datasetController.importDataset(DatasetController.LOAD, name, path, eventType, trim, separator, tcga, mergeMutationsTypes);
                } else if (workspaceRadioButton.isSelected()) {
                    datasetController.importWorkspace(path);
                }
    			
    			// if the last console message is regular
    			if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
    				// if a workspace is imported
    				if (workspaceRadioButton.isSelected()) {
                        // clear the labels
    					mainFrame.clearNumberLabels();
                    }
    				
    				// close the frame
        	        dispose();
    			} else {
    				JOptionPane.showConfirmDialog(this, RConnectionManager.getTextConsole().getLastConsoleMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
    			}
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showConfirmDialog(this, "The specified file does not exist.", RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
		}
    }                                            

    private void pathTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathTextFieldMouseClicked
        // create the file chooser
        JFileChooser fileChooser = new JFileChooser();
        
        // check the return option
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                // update the text field
                pathTextField.setText(fileChooser.getSelectedFile().getCanonicalPath());
            } catch (IOException e) {
            	e.printStackTrace();
            }
        }
    }//GEN-LAST:event_pathTextFieldMouseClicked

    private void workspaceRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_workspaceRadioButtonStateChanged
        if (workspaceRadioButton.isSelected()) {
            nameTextField.setEnabled(false);
            eventTypeTextField.setEnabled(false);
            trimCheckBox.setEnabled(false);
            separatorTextField.setEnabled(false);
            tcgaCheckBox.setEnabled(false);
            mergeMutationsTypesCheckBox.setEnabled(false);
        }
    }//GEN-LAST:event_workspaceRadioButtonStateChanged

    private void genotypesRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_genotypesRadioButtonStateChanged
        if (genotypesRadioButton.isSelected()) {
            nameTextField.setEnabled(true);
            eventTypeTextField.setEnabled(true);
            trimCheckBox.setEnabled(false);
            separatorTextField.setEnabled(false);
            tcgaCheckBox.setEnabled(false);
            mergeMutationsTypesCheckBox.setEnabled(false);
        }
    }//GEN-LAST:event_genotypesRadioButtonStateChanged

    private void mafRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mafRadioButtonStateChanged
        if (mafRadioButton.isSelected()) {
            nameTextField.setEnabled(true);
            eventTypeTextField.setEnabled(false);
            trimCheckBox.setEnabled(false);
            separatorTextField.setEnabled(true);
            tcgaCheckBox.setEnabled(true);
            mergeMutationsTypesCheckBox.setEnabled(true);
        }
    }//GEN-LAST:event_mafRadioButtonStateChanged

    private void gisticRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_gisticRadioButtonStateChanged
        if (gisticRadioButton.isSelected()) {
        	nameTextField.setEnabled(true);
            eventTypeTextField.setEnabled(false);
            trimCheckBox.setEnabled(true);
            separatorTextField.setEnabled(false);
            tcgaCheckBox.setEnabled(false);
            mergeMutationsTypesCheckBox.setEnabled(false);
        }
    }//GEN-LAST:event_gisticRadioButtonStateChanged

    private void loadRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_loadRadioButtonStateChanged
        if (loadRadioButton.isSelected()) {
            nameTextField.setEnabled(true);
            eventTypeTextField.setEnabled(false);
            trimCheckBox.setEnabled(false);
            separatorTextField.setEnabled(false);
            tcgaCheckBox.setEnabled(false);
            mergeMutationsTypesCheckBox.setEnabled(false);
        }
    }//GEN-LAST:event_loadRadioButtonStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel eventTypeLabel;
    private javax.swing.JTextField eventTypeTextField;
    private javax.swing.JRadioButton genotypesRadioButton;
    private javax.swing.JRadioButton gisticRadioButton;
    private javax.swing.JButton importButton;
    private javax.swing.JLabel importLabel;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JRadioButton loadRadioButton;
    private javax.swing.JRadioButton mafRadioButton;
    private javax.swing.JLabel mergeMutationisTypesLabel;
    private javax.swing.JCheckBox mergeMutationsTypesCheckBox;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel pathLabel;
    private javax.swing.JTextField pathTextField;
    private javax.swing.JLabel separatorLabel;
    private javax.swing.JTextField separatorTextField;
    private javax.swing.JCheckBox tcgaCheckBox;
    private javax.swing.JLabel tcgaLabel;
    private javax.swing.JCheckBox trimCheckBox;
    private javax.swing.JLabel trimLabel;
    private javax.swing.ButtonGroup typeButtonGroup;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JRadioButton workspaceRadioButton;
    // End of variables declaration//GEN-END:variables
}
