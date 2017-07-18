package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.model.Type;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;

public class ExternalToolsPanel extends javax.swing.JPanel {
    
    private DatasetController datasetController;
    private MainFrame mainFrame;
    
    private DefaultComboBoxModel<Type> defaultComboBoxModel;
    
    public ExternalToolsPanel() {
    	// instantiate empty variables
    	datasetController = new DatasetController();
    	mainFrame = new MainFrame();
        defaultComboBoxModel = new DefaultComboBoxModel();
    	
    	// draw the interface
        initComponents();
    }

    public ExternalToolsPanel(DatasetController datasetController, MainFrame mainFrame) {
        // get the main frame and the controllers
        this.datasetController = datasetController;
        this.mainFrame = mainFrame;
        
        // build the combo box model
        defaultComboBoxModel = new DefaultComboBoxModel(datasetController.getTypesListModel().toArray());        
        
        // draw the interface
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        exportMutexPanel = new javax.swing.JPanel();
        filePathLabel = new javax.swing.JLabel();
        filePathTextField = new javax.swing.JTextField();
        fileNameLabel = new javax.swing.JLabel();
        fileNameTextField = new javax.swing.JTextField();
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
        exportNbsPanel = new javax.swing.JPanel();
        importMutexPanel = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(940, 660));

        filePathLabel.setText("File path:");

        filePathTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filePathTextFieldMouseClicked(evt);
            }
        });

        fileNameLabel.setText("File name:");

        mutationLabel.setText("Mutation:");

        amplificationLabel.setText("Amplification:");

        deletionLabel.setText("Deletion:");

        mutationComboBox.setModel(defaultComboBoxModel);

        amplificationList.setModel(datasetController.getTypesListModel());
        amplificationScrollPane.setViewportView(amplificationList);

        deletionList.setModel(datasetController.getTypesListModel());
        deletionScrollPane.setViewportView(deletionList);

        ctrlLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        ctrlLabel1.setText("ctrl/cmd-click to select multiple types (do not select for default)");

        ctrlLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        ctrlLabel2.setText("ctrl/cmd-click to select multiple types (do not select for default)");

        exportMutexButton.setText("Export");

        javax.swing.GroupLayout exportMutexPanelLayout = new javax.swing.GroupLayout(exportMutexPanel);
        exportMutexPanel.setLayout(exportMutexPanelLayout);
        exportMutexPanelLayout.setHorizontalGroup(
            exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportMutexPanelLayout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exportMutexPanelLayout.createSequentialGroup()
                        .addGroup(exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(amplificationLabel)
                            .addComponent(deletionLabel)
                            .addComponent(mutationLabel)
                            .addComponent(filePathLabel)
                            .addComponent(fileNameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ctrlLabel2)
                            .addComponent(amplificationScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                            .addComponent(ctrlLabel1)
                            .addComponent(deletionScrollPane)
                            .addComponent(mutationComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(filePathTextField)
                            .addComponent(fileNameTextField))
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exportMutexPanelLayout.createSequentialGroup()
                        .addComponent(exportMutexButton)
                        .addContainerGap())))
        );
        exportMutexPanelLayout.setVerticalGroup(
            exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exportMutexPanelLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileNameLabel))
                .addGap(18, 18, 18)
                .addGroup(exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filePathLabel))
                .addGap(18, 18, 18)
                .addGroup(exportMutexPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mutationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mutationLabel))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(exportMutexButton)
                .addContainerGap())
        );

        tabbedPane.addTab("Export Mutex", exportMutexPanel);

        javax.swing.GroupLayout exportNbsPanelLayout = new javax.swing.GroupLayout(exportNbsPanel);
        exportNbsPanel.setLayout(exportNbsPanelLayout);
        exportNbsPanelLayout.setHorizontalGroup(
            exportNbsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 907, Short.MAX_VALUE)
        );
        exportNbsPanelLayout.setVerticalGroup(
            exportNbsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
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

    private void filePathTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filePathTextFieldMouseClicked
        // create the file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        // check the return option
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                // update the text field
                filePathTextField.setText(fileChooser.getSelectedFile().getCanonicalPath());
            } catch (IOException ex) {
                Logger.getLogger(ImportDatasetFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_filePathTextFieldMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amplificationLabel;
    private javax.swing.JList<Type> amplificationList;
    private javax.swing.JScrollPane amplificationScrollPane;
    private javax.swing.JLabel ctrlLabel1;
    private javax.swing.JLabel ctrlLabel2;
    private javax.swing.JLabel deletionLabel;
    private javax.swing.JList<Type> deletionList;
    private javax.swing.JScrollPane deletionScrollPane;
    private javax.swing.JButton exportMutexButton;
    private javax.swing.JPanel exportMutexPanel;
    private javax.swing.JPanel exportNbsPanel;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JLabel filePathLabel;
    private javax.swing.JTextField filePathTextField;
    private javax.swing.JPanel importMutexPanel;
    private javax.swing.JComboBox<Type> mutationComboBox;
    private javax.swing.JLabel mutationLabel;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
