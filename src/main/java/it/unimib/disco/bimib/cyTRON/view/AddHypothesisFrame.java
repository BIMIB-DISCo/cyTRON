package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.R.RConnectionManager;
import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.controller.HypothesesController;
import it.unimib.disco.bimib.cyTRON.model.Event;
import it.unimib.disco.bimib.cyTRON.model.Gene;

import java.awt.Color;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class AddHypothesisFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = -8553686634181134563L;
	
	private final HypothesesController hypothesesController;
    private final DatasetController datasetController;
    private final MainFrame mainFrame;
    private final HypothesesPanel hypothesesPanel;
    
    private final DefaultTreeCellRenderer defaultTreeCellRenderer;
    private final DefaultComboBoxModel<String> operationsDefaultComboBoxModel;
    private final DefaultComboBoxModel<Gene> genesDefaultComboBoxModel;
    private final DefaultComboBoxModel<Event> eventsDefaultComboBoxModel;
    
    public AddHypothesisFrame(HypothesesController hypothesesController, DatasetController datasetController, MainFrame mainFrame, HypothesesPanel hypothesesPanel) {
        // instantiate the controllers
        this.hypothesesController = hypothesesController;
        this.datasetController = datasetController;
        this.mainFrame = mainFrame;
        this.hypothesesPanel = hypothesesPanel;
        
        // modify the render of the tree
        defaultTreeCellRenderer = new DefaultTreeCellRenderer();
        defaultTreeCellRenderer.setLeafIcon(null);
        defaultTreeCellRenderer.setOpenIcon(null);
        defaultTreeCellRenderer.setClosedIcon(null);
        
        // create the default combo box models
        operationsDefaultComboBoxModel = new DefaultComboBoxModel<>(HypothesesController.OPERATIONS);
        genesDefaultComboBoxModel = new DefaultComboBoxModel<>((Gene[]) datasetController.getGenesListModel().toArray());
        eventsDefaultComboBoxModel = new DefaultComboBoxModel<>((Event[]) datasetController.getEventsListModel().toArray());
        
        // draw the interface
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nodeButtonGroup = new javax.swing.ButtonGroup();
        paternPanel = new javax.swing.JPanel();
        patternScrollPane = new javax.swing.JScrollPane();
        patternTree = new javax.swing.JTree();
        addNodeButton = new javax.swing.JButton();
        operationRadioButton = new javax.swing.JRadioButton();
        geneRadioButton = new javax.swing.JRadioButton();
        eventRadioButton = new javax.swing.JRadioButton();
        operationComboBox = new javax.swing.JComboBox<>();
        geneComboBox = new javax.swing.JComboBox<>();
        eventComboBox = new javax.swing.JComboBox<>();
        removeNodeButton = new javax.swing.JButton();
        infoButton = new javax.swing.JButton();
        parametersPanel = new javax.swing.JPanel();
        labelLabel = new javax.swing.JLabel();
        labelTextField = new javax.swing.JTextField();
        effectScrollPane = new javax.swing.JScrollPane();
        effectList = new javax.swing.JList<>();
        causeScrollPane = new javax.swing.JScrollPane();
        causeList = new javax.swing.JList<>();
        effectLabel = new javax.swing.JLabel();
        causeLabel = new javax.swing.JLabel();
        ctrlLabel1 = new javax.swing.JLabel();
        ctrlLabel2 = new javax.swing.JLabel();
        addHypothesisButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Hypothesis");
        setMaximumSize(new java.awt.Dimension(960, 540));
        setMinimumSize(new java.awt.Dimension(960, 540));
        setSize(new java.awt.Dimension(960, 540));

        paternPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Pattern"));

        patternTree.setModel(hypothesesController.getPatternTreeModel());
        patternTree.setCellRenderer(defaultTreeCellRenderer);
        patternTree.setShowsRootHandles(true);
        patternScrollPane.setViewportView(patternTree);

        addNodeButton.setText("Add");
        addNodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNodeButtonActionPerformed(evt);
            }
        });

        nodeButtonGroup.add(operationRadioButton);
        operationRadioButton.setSelected(true);

        nodeButtonGroup.add(geneRadioButton);

        nodeButtonGroup.add(eventRadioButton);

        operationComboBox.setModel(operationsDefaultComboBoxModel);

        geneComboBox.setModel(genesDefaultComboBoxModel);

        eventComboBox.setModel(eventsDefaultComboBoxModel);

        removeNodeButton.setText("Remove");
        removeNodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeNodeButtonActionPerformed(evt);
            }
        });

        infoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info.png"))); // NOI18N
        infoButton.setPreferredSize(new java.awt.Dimension(29, 29));
        infoButton.setSize(new java.awt.Dimension(29, 29));
        infoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paternPanelLayout = new javax.swing.GroupLayout(paternPanel);
        paternPanel.setLayout(paternPanelLayout);
        paternPanelLayout.setHorizontalGroup(
            paternPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paternPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paternPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patternScrollPane)
                    .addGroup(paternPanelLayout.createSequentialGroup()
                        .addGroup(paternPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paternPanelLayout.createSequentialGroup()
                                .addComponent(operationRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(operationComboBox, 0, 342, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paternPanelLayout.createSequentialGroup()
                                .addComponent(geneRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(geneComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paternPanelLayout.createSequentialGroup()
                                .addComponent(eventRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(eventComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paternPanelLayout.createSequentialGroup()
                        .addComponent(infoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(removeNodeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addNodeButton)))
                .addContainerGap())
        );
        paternPanelLayout.setVerticalGroup(
            paternPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paternPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(patternScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paternPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(operationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(operationRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paternPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(geneRadioButton)
                    .addComponent(geneComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paternPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eventComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paternPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paternPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addNodeButton)
                        .addComponent(removeNodeButton))
                    .addComponent(infoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        parametersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Parameters"));

        labelLabel.setText("Label:");

        effectList.setModel(datasetController.getEventsListModel());
        effectList.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        effectScrollPane.setViewportView(effectList);

        causeList.setModel(datasetController.getEventsListModel());
        causeList.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        causeScrollPane.setViewportView(causeList);

        effectLabel.setText("Effect:");

        causeLabel.setText("Cause:");

        ctrlLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        ctrlLabel1.setText("ctrl/cmd-click to select multiple events (do not select for all)");

        ctrlLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        ctrlLabel2.setText("ctrl/cmd-click to select multiple events (do not select for all)");

        javax.swing.GroupLayout parametersPanelLayout = new javax.swing.GroupLayout(parametersPanel);
        parametersPanel.setLayout(parametersPanelLayout);
        parametersPanelLayout.setHorizontalGroup(
            parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parametersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(parametersPanelLayout.createSequentialGroup()
                        .addComponent(labelLabel)
                        .addGap(18, 18, 18)
                        .addComponent(labelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(parametersPanelLayout.createSequentialGroup()
                        .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(effectLabel)
                            .addComponent(causeLabel))
                        .addGap(18, 18, 18)
                        .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(causeScrollPane)
                            .addGroup(parametersPanelLayout.createSequentialGroup()
                                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ctrlLabel1)
                                    .addComponent(ctrlLabel2))
                                .addGap(0, 135, Short.MAX_VALUE))
                            .addComponent(effectScrollPane))))
                .addGap(6, 6, 6))
        );
        parametersPanelLayout.setVerticalGroup(
            parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parametersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLabel)
                    .addComponent(labelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(parametersPanelLayout.createSequentialGroup()
                        .addComponent(effectLabel)
                        .addGap(0, 161, Short.MAX_VALUE))
                    .addComponent(effectScrollPane))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctrlLabel1)
                .addGap(18, 18, 18)
                .addGroup(parametersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(causeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(causeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctrlLabel2)
                .addContainerGap())
        );

        addHypothesisButton.setText("Add");
        addHypothesisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHypothesisButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(paternPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parametersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addHypothesisButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paternPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(parametersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addHypothesisButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addNodeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNodeButtonActionPerformed
        // if nothing is selected
    	if (patternTree.isSelectionEmpty()) {
			// return
    		return;
		}
    	
    	// get the selected node
        DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) patternTree.getSelectionPath().getLastPathComponent();

        // get the child object
        Object childObject = null;
        if (operationRadioButton.isSelected()) {
            childObject = operationComboBox.getSelectedItem();
        } else if (geneRadioButton.isSelected()) {
            childObject = geneComboBox.getSelectedItem();
        } else if (eventRadioButton.isSelected()) {
            childObject = eventComboBox.getSelectedItem();
        }

        // add the object to the tree
        hypothesesController.addNode(parentNode, childObject);
        
        // expand the parent
        patternTree.expandPath(patternTree.getSelectionPath());
    }//GEN-LAST:event_addNodeButtonActionPerformed
    
    private void removeNodeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeNodeButtonActionPerformed
    	// if nothing is selected
    	if (patternTree.isSelectionEmpty()) {
			// return
    		return;
		}
    	
    	// get the selected node
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) patternTree.getSelectionPath().getLastPathComponent();
        
        // remove the node
        hypothesesController.removeNode(node);
    }//GEN-LAST:event_removeNodeButtonActionPerformed

    private void addHypothesisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHypothesisButtonActionPerformed
        // get the parameters
        String label = labelTextField.getText();
        List<Event> effect = effectList.getSelectedValuesList();
        List<Event> cause = causeList.getSelectedValuesList();
        
        // validate input
        if (label.length() == 0) {
			labelTextField.setBackground(Color.RED);
		} else {
			labelTextField.setBackground(Color.WHITE);
        }
        if (hypothesesController.isPatternTreeEmpty()) {
			patternTree.setBackground(Color.RED);
		} else {
			patternTree.setBackground(Color.WHITE);
        }
        
        if (label.length() > 0 && !hypothesesController.isPatternTreeEmpty()) {
        	// add the hypothesis
            hypothesesController.addHypothesis(mainFrame.getSelectedDataset(), label, effect, cause, datasetController);
            
            // if the last console message is regular
        	if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
        		// update the number labels
                mainFrame.updateNumberLabels();
                hypothesesPanel.updatePatternsNumberLabel();
                
                // clear the pattern tree model
                hypothesesController.clearPatternTreeModel();
                
                // close the frame
                dispose();
        	} else {
        		JOptionPane.showConfirmDialog(this, RConnectionManager.getTextConsole().getLastConsoleMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
        	}
        }
    }//GEN-LAST:event_addHypothesisButtonActionPerformed

    private void infoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoButtonActionPerformed
        JOptionPane.showConfirmDialog(this, 
        		"INSTRUCTIONS:"
        		+ "\nTo start click on \"Pattern\" (it represents the root of any pattern) in the text box."
        		+ "\nThen select an item using the radio buttons below the text box and click \"Add\". This will add the item to the pattern."
        		+ "\nContinue iteratively to create the desired pattern.",
        		"Add Hipothesis Instructions", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_infoButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addHypothesisButton;
    private javax.swing.JButton addNodeButton;
    private javax.swing.JLabel causeLabel;
    private javax.swing.JList<Event> causeList;
    private javax.swing.JScrollPane causeScrollPane;
    private javax.swing.JLabel ctrlLabel1;
    private javax.swing.JLabel ctrlLabel2;
    private javax.swing.JLabel effectLabel;
    private javax.swing.JList<Event> effectList;
    private javax.swing.JScrollPane effectScrollPane;
    private javax.swing.JComboBox<Event> eventComboBox;
    private javax.swing.JRadioButton eventRadioButton;
    private javax.swing.JComboBox<Gene> geneComboBox;
    private javax.swing.JRadioButton geneRadioButton;
    private javax.swing.JButton infoButton;
    private javax.swing.JLabel labelLabel;
    private javax.swing.JTextField labelTextField;
    private javax.swing.ButtonGroup nodeButtonGroup;
    private javax.swing.JComboBox<String> operationComboBox;
    private javax.swing.JRadioButton operationRadioButton;
    private javax.swing.JPanel parametersPanel;
    private javax.swing.JPanel paternPanel;
    private javax.swing.JScrollPane patternScrollPane;
    private javax.swing.JTree patternTree;
    private javax.swing.JButton removeNodeButton;
    // End of variables declaration//GEN-END:variables
}
