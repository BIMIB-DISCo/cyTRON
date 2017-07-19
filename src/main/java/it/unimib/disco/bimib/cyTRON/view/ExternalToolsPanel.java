package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.controller.ExternalToolsController;
import it.unimib.disco.bimib.cyTRON.model.Dataset;
import it.unimib.disco.bimib.cyTRON.model.Gene;
import it.unimib.disco.bimib.cyTRON.model.Type;
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
        genesScrollPane = new javax.swing.JScrollPane();
        genesList = new javax.swing.JList<>();
        genesLabel = new javax.swing.JLabel();
        ctrlLabel3 = new javax.swing.JLabel();
        importMutexPanel = new javax.swing.JPanel();

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
        tabLabel.setText("tab-separated values file containing the mapping from Hugo symbols to Entrez gene ids");

        exportNbsButton.setText("Export");
        exportNbsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportNbsButtonActionPerformed(evt);
            }
        });

        genesList.setModel(datasetController.getGenesListModel());
        genesScrollPane.setViewportView(genesList);

        genesLabel.setText("Genes:");

        ctrlLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        ctrlLabel3.setText("ctrl/cmd-click to select multiple types");

        javax.swing.GroupLayout exportNbsPanelLayout = new javax.swing.GroupLayout(exportNbsPanel);
        exportNbsPanel.setLayout(exportNbsPanelLayout);
        exportNbsPanelLayout.setHorizontalGroup(
            exportNbsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportNbsPanelLayout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(exportNbsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exportNbsPanelLayout.createSequentialGroup()
                        .addComponent(exportNbsButton)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exportNbsPanelLayout.createSequentialGroup()
                        .addGroup(exportNbsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filePathLabel2)
                            .addComponent(fileNameLabel2)
                            .addComponent(mappingLabel)
                            .addComponent(genesLabel))
                        .addGap(43, 43, 43)
                        .addGroup(exportNbsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ctrlLabel3)
                            .addGroup(exportNbsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(genesScrollPane)
                                .addComponent(tabLabel)
                                .addComponent(filePathTextField2)
                                .addComponent(fileNameTextField2)
                                .addComponent(mappingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(113, 113, 113))))
        );
        exportNbsPanelLayout.setVerticalGroup(
            exportNbsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportNbsPanelLayout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addGroup(exportNbsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctrlLabel3)
                .addGap(137, 137, 137)
                .addComponent(exportNbsButton)
                .addContainerGap())
        );

        tabbedPane.addTab("Export NBS", exportNbsPanel);

        javax.swing.GroupLayout importMutexPanelLayout = new javax.swing.GroupLayout(importMutexPanel);
        importMutexPanel.setLayout(importMutexPanelLayout);
        importMutexPanelLayout.setHorizontalGroup(
            importMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 907, Short.MAX_VALUE)
        );
        importMutexPanelLayout.setVerticalGroup(
            importMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
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
        
        // export the mutex file
        externalToolsController.exportMutex(dataset, fileName, filePath, mutation, amplification, deletion);
        
        // show confirmation message
        JOptionPane.showConfirmDialog(mainFrame, "Mutex file exported.", "", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_exportMutexButtonActionPerformed

    private void exportNbsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportNbsButtonActionPerformed
        // get the parameters 
    	Dataset dataset = mainFrame.getSelectedDataset();
        String file = filePathTextField2.getText() + "/" + fileNameTextField2.getText();
        String mapping = mappingTextField.getText();
        List<Gene> genes = genesList.getSelectedValuesList();
        
        // export the nbs file
        externalToolsController.exportNbs(dataset, file, mapping, genes);
        
        // show confirmation message
        JOptionPane.showConfirmDialog(mainFrame, "NBS file exported.", "", JOptionPane.INFORMATION_MESSAGE);
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

    public void updateSelectedDataset() {
        DefaultComboBoxModel<Type> defaultComboBoxModel = new DefaultComboBoxModel();
        defaultComboBoxModel.addElement(null);
        for (Type type : (Type[]) datasetController.getTypesListModel().toArray()) {
            defaultComboBoxModel.addElement(type);
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
    private javax.swing.JLabel ctrlLabel3;
    private javax.swing.JLabel deletionLabel;
    private javax.swing.JList<Type> deletionList;
    private javax.swing.JScrollPane deletionScrollPane;
    private javax.swing.JButton exportMutexButton;
    private javax.swing.JPanel exportMutexPanel;
    private javax.swing.JButton exportNbsButton;
    private javax.swing.JPanel exportNbsPanel;
    private javax.swing.JLabel fileNameLabel1;
    private javax.swing.JLabel fileNameLabel2;
    private javax.swing.JTextField fileNameTextField1;
    private javax.swing.JTextField fileNameTextField2;
    private javax.swing.JLabel filePathLabel1;
    private javax.swing.JLabel filePathLabel2;
    private javax.swing.JTextField filePathTextField1;
    private javax.swing.JTextField filePathTextField2;
    private javax.swing.JLabel genesLabel;
    private javax.swing.JList<Gene> genesList;
    private javax.swing.JScrollPane genesScrollPane;
    private javax.swing.JPanel importMutexPanel;
    private javax.swing.JLabel mappingLabel;
    private javax.swing.JTextField mappingTextField;
    private javax.swing.JComboBox<Type> mutationComboBox;
    private javax.swing.JLabel mutationLabel;
    private javax.swing.JLabel tabLabel;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
