package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.controller.ExternalToolsController;
import it.unimib.disco.bimib.cyTRON.model.Dataset;
import it.unimib.disco.bimib.cyTRON.model.Type;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ExternalToolsPanel extends javax.swing.JPanel {
    
    private final ExternalToolsController externalToolsController;
    private final DatasetController datasetController;
    private final MainFrame mainFrame;

    public ExternalToolsPanel(DatasetController datasetController, MainFrame mainFrame) {
        // get the main frame and the controllers
        externalToolsController = new ExternalToolsController();
        this.datasetController = datasetController;
        this.mainFrame = mainFrame;
        
        // draw the interface
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        exportMutexPanel = new javax.swing.JPanel();
        filePathLabel1 = new javax.swing.JLabel();
        filePathTextField1 = new javax.swing.JTextField();
        fileNameLabel1 = new javax.swing.JLabel();
        fileNameTextField1 = new javax.swing.JTextField();
        mutationLabel = new javax.swing.JLabel();
        amplificationLabel = new javax.swing.JLabel();
        deletionLabel = new javax.swing.JLabel();
        mutationComboBox = new javax.swing.JComboBox<>();
        amplificationScrollPane = new javax.swing.JScrollPane();
        amplificationList = new javax.swing.JList<>();
        deletionScrollPane = new javax.swing.JScrollPane();
        deletionList = new javax.swing.JList<>();
        ctrlLabel1 = new javax.swing.JLabel();
        ctrlLabel2 = new javax.swing.JLabel();
        exportMutexButton = new javax.swing.JButton();
        blankLabel = new javax.swing.JLabel();
        exportNbsPanel = new javax.swing.JPanel();
        fileNameLabel2 = new javax.swing.JLabel();
        fileNameTextField2 = new javax.swing.JTextField();
        filePathLabel2 = new javax.swing.JLabel();
        filePathTextField2 = new javax.swing.JTextField();
        mappingLabel = new javax.swing.JLabel();
        mappingTextField = new javax.swing.JTextField();
        tabLabel = new javax.swing.JLabel();
        exportNbsButton = new javax.swing.JButton();
        importMutexPanel = new javax.swing.JPanel();
        importMutexParametersPanel = new javax.swing.JPanel();
        importMutexButton = new javax.swing.JButton();
        fileLabel = new javax.swing.JLabel();
        fileTextField = new javax.swing.JTextField();
        fdrLabel = new javax.swing.JLabel();
        fdrSpinner = new javax.swing.JSpinner();
        goupsMutexInfoPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setMinimumSize(new java.awt.Dimension(940, 660));

        filePathLabel1.setText("File path:");

        filePathTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filePathTextField1MouseClicked(evt);
            }
        });

        fileNameLabel1.setText("File name:");

        mutationLabel.setText("Mutation:");

        amplificationLabel.setText("Amplification:");

        deletionLabel.setText("Deletion:");

        amplificationList.setModel(datasetController.getTypesListModel());
        amplificationScrollPane.setViewportView(amplificationList);

        deletionList.setModel(datasetController.getTypesListModel());
        deletionScrollPane.setViewportView(deletionList);

        ctrlLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        ctrlLabel1.setText("ctrl/cmd-click to select multiple types (do not select for default)");

        ctrlLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        ctrlLabel2.setText("ctrl/cmd-click to select multiple types (do not select for default)");

        exportMutexButton.setText("Export");
        exportMutexButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportMutexButtonActionPerformed(evt);
            }
        });

        blankLabel.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        blankLabel.setText("blank for default");

        javax.swing.GroupLayout exportMutexPanelLayout = new javax.swing.GroupLayout(exportMutexPanel);
        exportMutexPanel.setLayout(exportMutexPanelLayout);
        exportMutexPanelLayout.setHorizontalGroup(
            exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportMutexPanelLayout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addGroup(exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exportMutexPanelLayout.createSequentialGroup()
                        .addComponent(exportMutexButton)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exportMutexPanelLayout.createSequentialGroup()
                        .addGroup(exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(exportMutexPanelLayout.createSequentialGroup()
                                .addGroup(exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mutationLabel)
                                    .addComponent(filePathLabel1)
                                    .addComponent(fileNameLabel1))
                                .addGap(43, 43, 43)
                                .addGroup(exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(blankLabel)
                                    .addGroup(exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(mutationComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(filePathTextField1)
                                        .addComponent(fileNameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(exportMutexPanelLayout.createSequentialGroup()
                                .addGroup(exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(amplificationLabel)
                                    .addComponent(deletionLabel))
                                .addGap(18, 18, 18)
                                .addGroup(exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ctrlLabel2)
                                    .addGroup(exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(amplificationScrollPane)
                                        .addComponent(ctrlLabel1)
                                        .addComponent(deletionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(114, 114, 114))))
        );
        exportMutexPanelLayout.setVerticalGroup(
            exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportMutexPanelLayout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileNameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileNameLabel1))
                .addGap(18, 18, 18)
                .addGroup(exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filePathTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filePathLabel1))
                .addGap(18, 18, 18)
                .addGroup(exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mutationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mutationLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(blankLabel)
                .addGap(18, 18, 18)
                .addGroup(exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(amplificationLabel)
                    .addComponent(amplificationScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctrlLabel1)
                .addGap(18, 18, 18)
                .addGroup(exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deletionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletionLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctrlLabel2)
                .addGap(76, 76, 76)
                .addComponent(exportMutexButton)
                .addContainerGap())
        );

        tabbedPane.addTab("Export Mutex", exportMutexPanel);

        fileNameLabel2.setText("File name:");

        filePathLabel2.setText("File path:");

        filePathTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filePathTextField2MouseClicked(evt);
            }
        });

        mappingLabel.setText("Mapping:");

        mappingTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mappingTextFieldMouseClicked(evt);
            }
        });

        tabLabel.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        tabLabel.setText("tab-separated values file containing the mapping from Hugo symbols to Entrez gene ids (without header)");

        exportNbsButton.setText("Export");
        exportNbsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportNbsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout exportNbsPanelLayout = new javax.swing.GroupLayout(exportNbsPanel);
        exportNbsPanel.setLayout(exportNbsPanelLayout);
        exportNbsPanelLayout.setHorizontalGroup(
            exportNbsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exportNbsPanelLayout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(exportNbsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exportNbsPanelLayout.createSequentialGroup()
                        .addComponent(exportNbsButton)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exportNbsPanelLayout.createSequentialGroup()
                        .addGroup(exportNbsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filePathLabel2)
                            .addComponent(fileNameLabel2)
                            .addComponent(mappingLabel))
                        .addGap(43, 43, 43)
                        .addGroup(exportNbsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tabLabel)
                            .addGroup(exportNbsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(filePathTextField2)
                                .addComponent(fileNameTextField2)
                                .addComponent(mappingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(113, 113, 113))))
        );
        exportNbsPanelLayout.setVerticalGroup(
            exportNbsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportNbsPanelLayout.createSequentialGroup()
                .addContainerGap(221, Short.MAX_VALUE)
                .addGroup(exportNbsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileNameTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileNameLabel2))
                .addGap(18, 18, 18)
                .addGroup(exportNbsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filePathTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filePathLabel2))
                .addGap(18, 18, 18)
                .addGroup(exportNbsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mappingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mappingLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabLabel)
                .addGap(212, 212, 212)
                .addComponent(exportNbsButton)
                .addContainerGap())
        );

        tabbedPane.addTab("Export NBS", exportNbsPanel);

        importMutexParametersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Parameters"));

        importMutexButton.setText("Import");
        importMutexButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importMutexButtonActionPerformed(evt);
            }
        });

        fileLabel.setText("File:");

        fileTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileTextFieldMouseClicked(evt);
            }
        });

        fdrLabel.setText("FDR:");

        fdrSpinner.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.2f), Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(0.1f)));

        javax.swing.GroupLayout importMutexParametersPanelLayout = new javax.swing.GroupLayout(importMutexParametersPanel);
        importMutexParametersPanel.setLayout(importMutexParametersPanelLayout);
        importMutexParametersPanelLayout.setHorizontalGroup(
            importMutexParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importMutexParametersPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(importMutexButton)
                .addContainerGap())
            .addGroup(importMutexParametersPanelLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(importMutexParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fileLabel)
                    .addComponent(fdrLabel))
                .addGap(40, 40, 40)
                .addGroup(importMutexParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fdrSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        importMutexParametersPanelLayout.setVerticalGroup(
            importMutexParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, importMutexParametersPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(importMutexParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileLabel)
                    .addComponent(fileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(importMutexParametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fdrLabel)
                    .addComponent(fdrSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(importMutexButton))
        );

        goupsMutexInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Groups"));

        jList1.setModel(externalToolsController.getGroupsListModel());
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout goupsMutexInfoPanelLayout = new javax.swing.GroupLayout(goupsMutexInfoPanel);
        goupsMutexInfoPanel.setLayout(goupsMutexInfoPanelLayout);
        goupsMutexInfoPanelLayout.setHorizontalGroup(
            goupsMutexInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(goupsMutexInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        goupsMutexInfoPanelLayout.setVerticalGroup(
            goupsMutexInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(goupsMutexInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout importMutexPanelLayout = new javax.swing.GroupLayout(importMutexPanel);
        importMutexPanel.setLayout(importMutexPanelLayout);
        importMutexPanelLayout.setHorizontalGroup(
            importMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, importMutexPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(importMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(goupsMutexInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(importMutexParametersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        importMutexPanelLayout.setVerticalGroup(
            importMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importMutexPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(importMutexParametersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(goupsMutexInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("Import Mutex", importMutexPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exportMutexButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportMutexButtonActionPerformed
        // get the parameters 
    	Dataset dataset = mainFrame.getSelectedDataset();
        String fileName = fileNameTextField1.getText();
        String filePath = filePathTextField1.getText();
        Type mutation = (Type) mutationComboBox.getSelectedItem();
        List<Type> amplification = amplificationList.getSelectedValuesList();
        List<Type> deletion = deletionList.getSelectedValuesList();
        
        // check the parameters
        if (dataset == null) {
            return;
        }
        if (fileName.length() == 0) {
            fileNameTextField1.setBackground(Color.RED);
        } else {
        	fileNameTextField1.setBackground(Color.WHITE);
        }
        if (filePath.length() == 0) {
            filePathTextField1.setBackground(Color.RED);
        } else {
        	filePathTextField1.setBackground(Color.WHITE);
        }
        
        if (fileName.length() > 0 && filePath.length() > 0) {
                // export the mutex file
            externalToolsController.exportMutex(dataset, fileName, filePath, mutation, amplification, deletion);

            // show confirmation message
            JOptionPane.showConfirmDialog(this, "Mutex file exported.", "", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_exportMutexButtonActionPerformed

    private void exportNbsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportNbsButtonActionPerformed
        // get the parameters 
    	Dataset dataset = mainFrame.getSelectedDataset();
        String file = filePathTextField2.getText() + "/" + fileNameTextField2.getText();
        String mapping = mappingTextField.getText();
        
        // check the parameters
        if (dataset == null) {
            return;
        }
        if (file.trim().length() == 1) {
            fileNameTextField2.setBackground(Color.RED);
            filePathTextField2.setBackground(Color.RED);
        } else {
        	fileNameTextField2.setBackground(Color.WHITE);
        	filePathTextField2.setBackground(Color.WHITE);
        }
        if (mapping.length() == 0) {
            mappingTextField.setBackground(Color.RED);
        } else {
        	mappingTextField.setBackground(Color.WHITE);
        }
        
        if (file.trim().length() > 1 && mapping.length() > 0) {
            // export the nbs file
            String outputString = externalToolsController.exportNbs(dataset, file, mapping);

            // show the output message
            if (outputString.equals("")) {
                JOptionPane.showConfirmDialog(this, "NBS file exported.", "", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showConfirmDialog(this, outputString, "", JOptionPane.PLAIN_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_exportNbsButtonActionPerformed

    private void filePathTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filePathTextField1MouseClicked
        // create the file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        // check the return option
        int option = fileChooser.showOpenDialog(mainFrame);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                // update the text field
                filePathTextField1.setText(fileChooser.getSelectedFile().getCanonicalPath());
            } catch (IOException ex) {
                Logger.getLogger(ImportDatasetFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_filePathTextField1MouseClicked

    private void mappingTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mappingTextFieldMouseClicked
        // create the file chooser
        JFileChooser fileChooser = new JFileChooser();
        
        // check the return option
        int option = fileChooser.showOpenDialog(mainFrame);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                // update the text field
                mappingTextField.setText(fileChooser.getSelectedFile().getCanonicalPath());
            } catch (IOException ex) {
                Logger.getLogger(ImportDatasetFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mappingTextFieldMouseClicked

    private void filePathTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filePathTextField2MouseClicked
        // create the file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        // check the return option
        int option = fileChooser.showOpenDialog(mainFrame);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                // update the text field
                filePathTextField2.setText(fileChooser.getSelectedFile().getCanonicalPath());
            } catch (IOException ex) {
                Logger.getLogger(ImportDatasetFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_filePathTextField2MouseClicked

    private void fileTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileTextFieldMouseClicked
        // create the file chooser
        JFileChooser fileChooser = new JFileChooser();
        
        // check the return option
        int option = fileChooser.showOpenDialog(mainFrame);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                // update the text field
                fileTextField.setText(fileChooser.getSelectedFile().getCanonicalPath());
            } catch (IOException ex) {
                Logger.getLogger(ImportDatasetFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_fileTextFieldMouseClicked

    private void importMutexButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importMutexButtonActionPerformed
        // get the parameters
        String file = fileTextField.getText();
        Float fdr = (Float) fdrSpinner.getValue();
        
        // check the paramets
        if (file.length() == 0) {
            fileTextField.setBackground(Color.RED);
            return;
        } else {
        	fileTextField.setBackground(Color.WHITE);
        }
        
        // import mutex
        externalToolsController.importMutex(file, fdr);
    }//GEN-LAST:event_importMutexButtonActionPerformed

    public void updateSelectedDataset() {
        DefaultComboBoxModel<Type> defaultComboBoxModel = new DefaultComboBoxModel<Type>();
        defaultComboBoxModel.addElement(null); 
        for (Object type : datasetController.getTypesListModel().toArray()) {
            defaultComboBoxModel.addElement((Type) type);
        }
    	mutationComboBox.setModel(defaultComboBoxModel); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amplificationLabel;
    private javax.swing.JList<Type> amplificationList;
    private javax.swing.JScrollPane amplificationScrollPane;
    private javax.swing.JLabel blankLabel;
    private javax.swing.JLabel ctrlLabel1;
    private javax.swing.JLabel ctrlLabel2;
    private javax.swing.JLabel deletionLabel;
    private javax.swing.JList<Type> deletionList;
    private javax.swing.JScrollPane deletionScrollPane;
    private javax.swing.JButton exportMutexButton;
    private javax.swing.JPanel exportMutexPanel;
    private javax.swing.JButton exportNbsButton;
    private javax.swing.JPanel exportNbsPanel;
    private javax.swing.JLabel fdrLabel;
    private javax.swing.JSpinner fdrSpinner;
    private javax.swing.JLabel fileLabel;
    private javax.swing.JLabel fileNameLabel1;
    private javax.swing.JLabel fileNameLabel2;
    private javax.swing.JTextField fileNameTextField1;
    private javax.swing.JTextField fileNameTextField2;
    private javax.swing.JLabel filePathLabel1;
    private javax.swing.JLabel filePathLabel2;
    private javax.swing.JTextField filePathTextField1;
    private javax.swing.JTextField filePathTextField2;
    private javax.swing.JTextField fileTextField;
    private javax.swing.JPanel goupsMutexInfoPanel;
    private javax.swing.JButton importMutexButton;
    private javax.swing.JPanel importMutexPanel;
    private javax.swing.JPanel importMutexParametersPanel;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mappingLabel;
    private javax.swing.JTextField mappingTextField;
    private javax.swing.JComboBox<Type> mutationComboBox;
    private javax.swing.JLabel mutationLabel;
    private javax.swing.JLabel tabLabel;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
