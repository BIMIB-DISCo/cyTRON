package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.R.RConnectionManager;
import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.cytoscape.CommandExecutor;
import it.unimib.disco.bimib.cyTRON.model.Dataset;
import it.unimib.disco.bimib.cyTRON.model.Gene;
import it.unimib.disco.bimib.cyTRON.model.Sample;

import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.rosuda.REngine.REngineException;

public class MainFrame extends javax.swing.JFrame {

	private final CommandExecutor commandExecutor;
    private final DatasetController datasetController;
    
    public MainFrame(CommandExecutor commandExecutor) {
    	try {
			// instantiate the connection with R
			RConnectionManager.instantiateConnection();
		} catch (RuntimeException e) {
			JOptionPane.showConfirmDialog(this, e.getMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
		}
    	
    	// get the command executor
    	this.commandExecutor = commandExecutor;
    	
        // instantiate the dataset controller
        datasetController = new DatasetController();
        
        // draws the interface
        initComponents();
        initCustomComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        editPanel = new javax.swing.JPanel();
        currentDatasetPanel = new javax.swing.JPanel();
        genesPanelList = new javax.swing.JPanel();
        renameGeneButton = new javax.swing.JButton();
        deleteGeneButton = new javax.swing.JButton();
        genesScrollPane = new javax.swing.JScrollPane();
        genesList = new javax.swing.JList<>();
        typesPanelList = new javax.swing.JPanel();
        renameTypeButton = new javax.swing.JButton();
        deleteTypeButton = new javax.swing.JButton();
        joinTypesButton = new javax.swing.JButton();
        typesScrollPane = new javax.swing.JScrollPane();
        typesList = new javax.swing.JList<>();
        samplesPanelList = new javax.swing.JPanel();
        samplesScrollPane = new javax.swing.JScrollPane();
        samplesList = new javax.swing.JList<>();
        deteleSampleButton = new javax.swing.JButton();
        samplesSelectionButton = new javax.swing.JButton();
        selectMultipleSamplesButton = new javax.swing.JButton();
        deleteMultipleSamplesButton = new javax.swing.JButton();
        shortenBarcodesButton = new javax.swing.JButton();
        eventsPanelList = new javax.swing.JPanel();
        eventsScrollPane = new javax.swing.JScrollPane();
        eventsList = new javax.swing.JList<>();
        deleteEventButton = new javax.swing.JButton();
        joinEventsButton = new javax.swing.JButton();
        eventsSelectionButton = new javax.swing.JButton();
        trimButton = new javax.swing.JButton();
        infoPanel = new javax.swing.JPanel();
        typesLabel = new javax.swing.JLabel();
        genesLabel = new javax.swing.JLabel();
        eventsLabel = new javax.swing.JLabel();
        samplesLabel = new javax.swing.JLabel();
        typesNumberLabel = new javax.swing.JLabel();
        genesNumberLabel = new javax.swing.JLabel();
        eventsNumberLabel = new javax.swing.JLabel();
        samplesNumberLabel = new javax.swing.JLabel();
        datasetsPanelList = new javax.swing.JPanel();
        datasetsListScrollPane = new javax.swing.JScrollPane();
        datasetsList = new javax.swing.JList<>();
        importDatasetButton = new javax.swing.JButton();
        deleteDatasetButton = new javax.swing.JButton();
        bindEventsButton = new javax.swing.JButton();
        bindSamplesButton = new javax.swing.JButton();
        intersectButton = new javax.swing.JButton();
        saveDatasetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("cyTRON");
        setMinimumSize(new java.awt.Dimension(1280, 720));

        currentDatasetPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        genesPanelList.setBorder(javax.swing.BorderFactory.createTitledBorder("Genes"));
        genesPanelList.setPreferredSize(new java.awt.Dimension(300, 320));

        renameGeneButton.setText("Rename...");
        renameGeneButton.setToolTipText("");
        renameGeneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameGeneButtonActionPerformed(evt);
            }
        });

        deleteGeneButton.setText("Delete");
        deleteGeneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteGeneButtonActionPerformed(evt);
            }
        });

        genesList.setModel(datasetController.getGenesListModel());
        genesScrollPane.setViewportView(genesList);

        javax.swing.GroupLayout genesPanelListLayout = new javax.swing.GroupLayout(genesPanelList);
        genesPanelList.setLayout(genesPanelListLayout);
        genesPanelListLayout.setHorizontalGroup(
            genesPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genesPanelListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(genesPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                    .addGroup(genesPanelListLayout.createSequentialGroup()
                        .addComponent(renameGeneButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteGeneButton)))
                .addContainerGap())
        );
        genesPanelListLayout.setVerticalGroup(
            genesPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, genesPanelListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(genesScrollPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(genesPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(renameGeneButton)
                    .addComponent(deleteGeneButton))
                .addContainerGap())
        );

        typesPanelList.setBorder(javax.swing.BorderFactory.createTitledBorder("Types"));

        renameTypeButton.setText("Rename...");
        renameTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameTypeButtonActionPerformed(evt);
            }
        });

        deleteTypeButton.setText("Delete");
        deleteTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTypeButtonActionPerformed(evt);
            }
        });

        joinTypesButton.setText("Join...");
        joinTypesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinTypesButtonActionPerformed(evt);
            }
        });

        typesList.setModel(datasetController.getTypesListModel());
        typesScrollPane.setViewportView(typesList);

        javax.swing.GroupLayout typesPanelListLayout = new javax.swing.GroupLayout(typesPanelList);
        typesPanelList.setLayout(typesPanelListLayout);
        typesPanelListLayout.setHorizontalGroup(
            typesPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typesPanelListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(typesPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typesScrollPane)
                    .addGroup(typesPanelListLayout.createSequentialGroup()
                        .addComponent(renameTypeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteTypeButton))
                    .addGroup(typesPanelListLayout.createSequentialGroup()
                        .addComponent(joinTypesButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        typesPanelListLayout.setVerticalGroup(
            typesPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, typesPanelListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(typesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joinTypesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(typesPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(renameTypeButton)
                    .addComponent(deleteTypeButton))
                .addContainerGap())
        );

        samplesPanelList.setBorder(javax.swing.BorderFactory.createTitledBorder("Samples"));

        samplesList.setModel(datasetController.getSamplesListModel());
        samplesScrollPane.setViewportView(samplesList);

        deteleSampleButton.setText("Delete");
        deteleSampleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deteleSampleButtonActionPerformed(evt);
            }
        });

        samplesSelectionButton.setText("Selection...");
        samplesSelectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                samplesSelectionButtonActionPerformed(evt);
            }
        });

        selectMultipleSamplesButton.setText("Select multiple");
        selectMultipleSamplesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectMultipleSamplesButtonActionPerformed(evt);
            }
        });

        deleteMultipleSamplesButton.setText("Delete multiple");
        deleteMultipleSamplesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMultipleSamplesButtonActionPerformed(evt);
            }
        });

        shortenBarcodesButton.setText("Shorten barcodes");
        shortenBarcodesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shortenBarcodesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout samplesPanelListLayout = new javax.swing.GroupLayout(samplesPanelList);
        samplesPanelList.setLayout(samplesPanelListLayout);
        samplesPanelListLayout.setHorizontalGroup(
            samplesPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(samplesPanelListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(samplesScrollPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(samplesPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(samplesPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(samplesPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(samplesPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(shortenBarcodesButton)
                                .addComponent(deteleSampleButton, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(samplesSelectionButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(deleteMultipleSamplesButton, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(selectMultipleSamplesButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        samplesPanelListLayout.setVerticalGroup(
            samplesPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(samplesPanelListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(samplesPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(samplesPanelListLayout.createSequentialGroup()
                        .addComponent(selectMultipleSamplesButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteMultipleSamplesButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(shortenBarcodesButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(samplesSelectionButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deteleSampleButton))
                    .addComponent(samplesScrollPane))
                .addContainerGap())
        );

        eventsPanelList.setBorder(javax.swing.BorderFactory.createTitledBorder("Events"));

        eventsList.setModel(datasetController.getEventsListModel());
        eventsScrollPane.setViewportView(eventsList);

        deleteEventButton.setText("Delete");
        deleteEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEventButtonActionPerformed(evt);
            }
        });

        joinEventsButton.setText("Join...");
        joinEventsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinEventsButtonActionPerformed(evt);
            }
        });

        eventsSelectionButton.setText("Selection...");
        eventsSelectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventsSelectionButtonActionPerformed(evt);
            }
        });

        trimButton.setText("Trim");
        trimButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trimButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout eventsPanelListLayout = new javax.swing.GroupLayout(eventsPanelList);
        eventsPanelList.setLayout(eventsPanelListLayout);
        eventsPanelListLayout.setHorizontalGroup(
            eventsPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventsPanelListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eventsPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eventsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eventsPanelListLayout.createSequentialGroup()
                        .addComponent(joinEventsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteEventButton))
                    .addGroup(eventsPanelListLayout.createSequentialGroup()
                        .addComponent(eventsSelectionButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(trimButton)))
                .addContainerGap())
        );
        eventsPanelListLayout.setVerticalGroup(
            eventsPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventsPanelListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eventsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eventsPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventsSelectionButton)
                    .addComponent(trimButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eventsPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteEventButton)
                    .addComponent(joinEventsButton))
                .addContainerGap())
        );

        infoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Info"));
        infoPanel.setToolTipText("");

        typesLabel.setText("Types:");

        genesLabel.setText("Genes:");

        eventsLabel.setText("Events:");

        samplesLabel.setText("Samples:");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(typesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typesNumberLabel)
                .addGap(99, 99, 99)
                .addComponent(genesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(genesNumberLabel)
                .addGap(99, 99, 99)
                .addComponent(eventsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventsNumberLabel)
                .addGap(99, 99, 99)
                .addComponent(samplesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(samplesNumberLabel)
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(typesLabel)
                        .addComponent(genesLabel)
                        .addComponent(eventsLabel)
                        .addComponent(typesNumberLabel)
                        .addComponent(genesNumberLabel)
                        .addComponent(eventsNumberLabel))
                    .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(samplesLabel)
                        .addComponent(samplesNumberLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout currentDatasetPanelLayout = new javax.swing.GroupLayout(currentDatasetPanel);
        currentDatasetPanel.setLayout(currentDatasetPanelLayout);
        currentDatasetPanelLayout.setHorizontalGroup(
            currentDatasetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentDatasetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(currentDatasetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(currentDatasetPanelLayout.createSequentialGroup()
                        .addGroup(currentDatasetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(eventsPanelList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(typesPanelList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(currentDatasetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(samplesPanelList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(genesPanelList, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))))
                .addContainerGap())
        );
        currentDatasetPanelLayout.setVerticalGroup(
            currentDatasetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, currentDatasetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(currentDatasetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(typesPanelList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(genesPanelList, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(currentDatasetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eventsPanelList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(samplesPanelList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout editPanelLayout = new javax.swing.GroupLayout(editPanel);
        editPanel.setLayout(editPanelLayout);
        editPanelLayout.setHorizontalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentDatasetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        editPanelLayout.setVerticalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentDatasetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("Edit", editPanel);

        datasetsPanelList.setBorder(javax.swing.BorderFactory.createTitledBorder("Datasets"));

        datasetsList.setModel(datasetController.getDatasetsListModel());
        datasetsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        datasetsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                datasetsListValueChanged(evt);
            }
        });
        datasetsListScrollPane.setViewportView(datasetsList);

        importDatasetButton.setText("Import...");
        importDatasetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importDatasetButtonActionPerformed(evt);
            }
        });

        deleteDatasetButton.setText("Delete");
        deleteDatasetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDatasetButtonActionPerformed(evt);
            }
        });

        bindEventsButton.setText("Bind events...");
        bindEventsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bindEventsButtonActionPerformed(evt);
            }
        });

        bindSamplesButton.setText("Bind samples...");
        bindSamplesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bindSamplesButtonActionPerformed(evt);
            }
        });

        intersectButton.setText("Intersect...");
        intersectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intersectButtonActionPerformed(evt);
            }
        });

        saveDatasetButton.setText("Save...");
        saveDatasetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveDatasetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout datasetsPanelListLayout = new javax.swing.GroupLayout(datasetsPanelList);
        datasetsPanelList.setLayout(datasetsPanelListLayout);
        datasetsPanelListLayout.setHorizontalGroup(
            datasetsPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datasetsPanelListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datasetsPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datasetsListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addGroup(datasetsPanelListLayout.createSequentialGroup()
                        .addComponent(bindEventsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bindSamplesButton))
                    .addGroup(datasetsPanelListLayout.createSequentialGroup()
                        .addGroup(datasetsPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(importDatasetButton)
                            .addComponent(intersectButton))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(datasetsPanelListLayout.createSequentialGroup()
                        .addComponent(deleteDatasetButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveDatasetButton)))
                .addContainerGap())
        );
        datasetsPanelListLayout.setVerticalGroup(
            datasetsPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datasetsPanelListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(importDatasetButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datasetsPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteDatasetButton)
                    .addComponent(saveDatasetButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datasetsListScrollPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(intersectButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datasetsPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bindEventsButton)
                    .addComponent(bindSamplesButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datasetsPanelList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datasetsPanelList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabbedPane))
                .addContainerGap())
        );

        tabbedPane.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void initCustomComponents() {
    	hypothesesPanel = new HypothesesPanel(datasetController, this);
    	externalToolsPanel = new ExternalToolsPanel(datasetController, this);
    	visualizationPanel = new VisualizationPanel(datasetController, this, commandExecutor);
        statisticsPanel = new StatisticsPanel(datasetController, this, visualizationPanel);
        inferencePanel = new InferencePanel(datasetController, this, statisticsPanel, visualizationPanel);
        
    	tabbedPane.addTab("Hypotheses", hypothesesPanel);
    	tabbedPane.addTab("External Tools", externalToolsPanel);
        tabbedPane.addTab("Inference", inferencePanel);
        tabbedPane.addTab("Statistics", statisticsPanel);
        tabbedPane.addTab("Visualization", visualizationPanel);
    }
    
    // ************ DATASETS ************ \\
    private void importDatasetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importDatasetButtonActionPerformed
        ImportDatasetFrame importDatasetFrame = new ImportDatasetFrame(datasetController, this);
        importDatasetFrame.setLocationRelativeTo(null);
	importDatasetFrame.setVisible(true);
    }//GEN-LAST:event_importDatasetButtonActionPerformed

    private void deleteDatasetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDatasetButtonActionPerformed
        // if there is no selection
        if (datasetsList.getSelectedIndex() == -1) {
            // return
            return;
        }

        // get the confirmation
        int confirmation = JOptionPane.showConfirmDialog(this, "The dataset will be deleted.\nAre you sure?", "", JOptionPane.OK_CANCEL_OPTION);
        
        // if confirmed
        if (confirmation == JOptionPane.OK_OPTION) {
            // execute the action
            datasetController.deleteDataset(datasetsList.getSelectedIndex());

            // if the last console message is regular
            if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
            	// clear the number labels
                clearNumberLabels();
            } else {
            	JOptionPane.showConfirmDialog(this, RConnectionManager.getTextConsole().getLastConsoleMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteDatasetButtonActionPerformed

    // ************ SAMPLES ************ \\
    private void deteleSampleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deteleSampleButtonActionPerformed
        // if there is no selection
        if (samplesList.getSelectedIndex() == -1) {
            // return
            return;
        }

        // get the confirmation
        int confirmation = JOptionPane.showConfirmDialog(this, "The sample will be deleted.\nAre you sure?", "", JOptionPane.OK_CANCEL_OPTION);
        
        // if confirmed
        if (confirmation == JOptionPane.OK_OPTION) {
            // excute the action
            datasetController.deleteSample(samplesList.getSelectedIndex(), datasetsList.getSelectedIndex());
            
        	// if the last console message is regular
            if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
                // update the number labels
                updateNumberLabels();
            } else {
            	JOptionPane.showConfirmDialog(this, RConnectionManager.getTextConsole().getLastConsoleMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
            }
        }


    }//GEN-LAST:event_deteleSampleButtonActionPerformed
    
    // ************ GENES ************ \\
    private void renameGeneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameGeneButtonActionPerformed
        // if there is no selection
        if (genesList.getSelectedIndex() == -1) {
            // return
            return;
        }
        
        RenameGeneFrame renameGeneFrame = new RenameGeneFrame(datasetController, genesList.getSelectedIndex(), datasetsList.getSelectedIndex());
        renameGeneFrame.setLocationRelativeTo(null);
	renameGeneFrame.setVisible(true);
    }//GEN-LAST:event_renameGeneButtonActionPerformed

    private void deleteGeneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteGeneButtonActionPerformed
        // if there is no selection
        if (genesList.getSelectedIndex() == -1) {
            // return
            return;
        }

        // get the confirmation
        int confirmation = JOptionPane.showConfirmDialog(this, "The gene will be deleted.\nAre you sure?", "", JOptionPane.OK_CANCEL_OPTION);
        
        // if confirmed
        if (confirmation == JOptionPane.OK_OPTION) {
            // execute the actioin
            datasetController.deleteGene(genesList.getSelectedIndex(), datasetsList.getSelectedIndex());

        	// if the last console message is regular
            if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
                // update the number labels
                updateNumberLabels();
            } else {
            	JOptionPane.showConfirmDialog(this, RConnectionManager.getTextConsole().getLastConsoleMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteGeneButtonActionPerformed

    // ************ TYPES ************ \\
    private void deleteTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTypeButtonActionPerformed
        // if there is no selection
        if (typesList.getSelectedIndex() == -1) {
            // return
            return;
        }
        
        // get the confirmation
        int confirmation = JOptionPane.showConfirmDialog(this, "The type will be deleted.\nAre you sure?", "", JOptionPane.OK_CANCEL_OPTION);
        
        // if confirmed
        if (confirmation == JOptionPane.OK_OPTION) {
            // execute the action
            datasetController.deleteType(typesList.getSelectedIndex(), datasetsList.getSelectedIndex());

        	// if the last console message is regular
            if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
                // update the number labels
                updateNumberLabels();
            } else {
            	JOptionPane.showConfirmDialog(this, RConnectionManager.getTextConsole().getLastConsoleMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteTypeButtonActionPerformed

    private void renameTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameTypeButtonActionPerformed
        // if there is no selection
        if (typesList.getSelectedIndex() == -1) {
            // return
            return;
        }
        
        RenameTypeFrame renameTypeFrame = new RenameTypeFrame(datasetController, typesList.getSelectedIndex(), datasetsList.getSelectedIndex());
        renameTypeFrame.setLocationRelativeTo(null);
	renameTypeFrame.setVisible(true);
    }//GEN-LAST:event_renameTypeButtonActionPerformed

    private void joinTypesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinTypesButtonActionPerformed
        // if there is no selection
        if (typesList.getSelectedIndex() == -1 || datasetController.getTypesListModel().size() < 2) {
            // return
            return;
        }
        
        JoinTypesFrame joinTypesFrame = new JoinTypesFrame(this, datasetController, typesList.getSelectedIndex(), datasetsList.getSelectedIndex());
        joinTypesFrame.setLocationRelativeTo(null);
	joinTypesFrame.setVisible(true);
    }//GEN-LAST:event_joinTypesButtonActionPerformed

    // ************ EVENTS ************ \\
    private void deleteEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEventButtonActionPerformed
        // if there is no selection
        if (eventsList.getSelectedIndex() == -1) {
            // return
            return;
        }

        // get the confirmation
        int confirmation = JOptionPane.showConfirmDialog(this, "The event will be deleted.\nAre you sure?", "", JOptionPane.OK_CANCEL_OPTION);
        
        // if confirmed
        if (confirmation == JOptionPane.OK_OPTION) {
            // execute the action
            datasetController.deleteEvent(eventsList.getSelectedIndex(), datasetsList.getSelectedIndex());

        	// if the last console message is regular
            if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
            	// update the number labels
                updateNumberLabels();
            } else {
            	JOptionPane.showConfirmDialog(this, RConnectionManager.getTextConsole().getLastConsoleMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteEventButtonActionPerformed

    private void joinEventsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinEventsButtonActionPerformed
        // if there is no selection
        if (eventsList.getSelectedIndex() == -1 || datasetController.getEventsListModel().size() < 2) {
            // return
            return;
        }
        
        JoinEventsFrame joinEventsFrame = new JoinEventsFrame(this, datasetController, eventsList.getSelectedIndex(), datasetsList.getSelectedIndex());
        joinEventsFrame.setLocationRelativeTo(null);
	joinEventsFrame.setVisible(true);
    }//GEN-LAST:event_joinEventsButtonActionPerformed
    
    // ************ BINDS ************ \\
    private void bindEventsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bindEventsButtonActionPerformed
        // if there is no selection
        if (datasetsList.getSelectedIndex() == -1 || datasetController.getDatasetsListModel().size() < 2) {
            // return
            return;
        }
        
        BindDatasetsFrame bindDatasetsFrame = new BindDatasetsFrame(this, datasetController, datasetsList.getSelectedIndex(), DatasetController.EVENTS);
        bindDatasetsFrame.setLocationRelativeTo(null);
	bindDatasetsFrame.setVisible(true);
    }//GEN-LAST:event_bindEventsButtonActionPerformed

    private void bindSamplesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bindSamplesButtonActionPerformed
        // if there is no selection
        if (datasetsList.getSelectedIndex() == -1 || datasetController.getDatasetsListModel().size() < 2) {
            // return
            return;
        }
        
        BindDatasetsFrame bindDatasetsFrame = new BindDatasetsFrame(this, datasetController, datasetsList.getSelectedIndex(), DatasetController.SAMPLES);
        bindDatasetsFrame.setLocationRelativeTo(null);
	bindDatasetsFrame.setVisible(true);
    }//GEN-LAST:event_bindSamplesButtonActionPerformed

    private void intersectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intersectButtonActionPerformed
        // if there is no selection
        if (datasetsList.getSelectedIndex() == -1 || datasetController.getDatasetsListModel().size() < 2) {
            // return
            return;
        }
        
        IntersectDatasetsFrame intersectDatasetsFrame = new IntersectDatasetsFrame(this, datasetController, datasetsList.getSelectedIndex(), DatasetController.SAMPLES);
        intersectDatasetsFrame.setLocationRelativeTo(null);
	intersectDatasetsFrame.setVisible(true);
    }//GEN-LAST:event_intersectButtonActionPerformed

    private void datasetsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_datasetsListValueChanged
        if (datasetsList.getSelectedIndex() != -1) {
	    	// update the lists
	        datasetController.updateLists(datasetsList.getSelectedIndex());
	        
	        // update the number labels
	        updateNumberLabels();
	        
	        // update the other panels
	        hypothesesPanel.updateSelectedDataset(datasetsList.getSelectedIndex());
	        externalToolsPanel.updateSelectedDataset();
	        inferencePanel.updateSelectedDataset();
            statisticsPanel.updateSelectedDataset();
            visualizationPanel.updateSelectedDataset();
        }
    }//GEN-LAST:event_datasetsListValueChanged

    private void samplesSelectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_samplesSelectionButtonActionPerformed
        // if there is no selection
        if (datasetController.getSamplesListModel().size() == 0) {
            // return
            return;
        }
        
        SamplesSelectionFrame samplesSelectionFrame = new SamplesSelectionFrame(this, datasetController, datasetsList.getSelectedIndex());
        samplesSelectionFrame.setLocationRelativeTo(null);
	samplesSelectionFrame.setVisible(true);
    }//GEN-LAST:event_samplesSelectionButtonActionPerformed

    private void eventsSelectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventsSelectionButtonActionPerformed
        // if there is no selection
        if (datasetController.getEventsListModel().size() == 0) {
            // return
            return;
        }
        
        EventsSelectionFrame eventsSelectionFrame = new EventsSelectionFrame(this, datasetController, datasetsList.getSelectedIndex());
        eventsSelectionFrame.setLocationRelativeTo(null);
	eventsSelectionFrame.setVisible(true);
    }//GEN-LAST:event_eventsSelectionButtonActionPerformed

    private void trimButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trimButtonActionPerformed
        // if there is no selection
        if (datasetController.getEventsListModel().size() == 0) {
            // return
            return;
        }

        // get the confirmation
        int confirmation = JOptionPane.showConfirmDialog(this, "Events will be trimmed.\nAre you sure?", "", JOptionPane.OK_CANCEL_OPTION);
        
        // if confirmed
        if (confirmation == JOptionPane.OK_OPTION) {
            // trim the events
            datasetController.trim(datasetsList.getSelectedIndex());
        }
    }//GEN-LAST:event_trimButtonActionPerformed

    private void selectMultipleSamplesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectMultipleSamplesButtonActionPerformed
        // if there is no selection
        if (datasetController.getSamplesListModel().size() < 2) {
            // return
            return;
        }

        // get the indexes of the multiple samples of the dataset
    	int[] multipleSamplesIndexes = datasetController.selectMultipleSamples(datasetsList.getSelectedIndex());
    	
    	// select the multiple samples
    	samplesList.setSelectedIndices(multipleSamplesIndexes);
    }//GEN-LAST:event_selectMultipleSamplesButtonActionPerformed

    private void deleteMultipleSamplesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMultipleSamplesButtonActionPerformed
        // if there is no selection
        if (datasetController.getSamplesListModel().size() < 2) {
            // return
            return;
        }

        // get the confirmation
        int confirmation = JOptionPane.showConfirmDialog(this, "Multiple samples will be deleted.\nAre you sure?", "", JOptionPane.OK_CANCEL_OPTION);
        
        // if confirmed
        if (confirmation == JOptionPane.OK_OPTION) {
            // remove multiple samples from the dataset
            datasetController.removeMultipleSamples(datasetsList.getSelectedIndex());
            
        	// if the last console message is regular
            if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
            	// update the number labels
                updateNumberLabels();
            } else {
            	JOptionPane.showConfirmDialog(this, RConnectionManager.getTextConsole().getLastConsoleMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteMultipleSamplesButtonActionPerformed

    private void shortenBarcodesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shortenBarcodesButtonActionPerformed
        // if there is no selection
        if (datasetController.getSamplesListModel().size() == 0) {
            // return
            return;
        }

        // get the confirmation
        int confirmation = JOptionPane.showConfirmDialog(this, "Samples' names will be shortened.\nAre you sure?", "", JOptionPane.OK_CANCEL_OPTION);
        
        // if confirmed
        if (confirmation == JOptionPane.OK_OPTION) {
            // remove multiple samples from the dataset
            datasetController.shortenBarcodes(datasetsList.getSelectedIndex());
            
        	// if the last console message is regular
            if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
                // update the number labels
                updateNumberLabels();
            } else {
            	JOptionPane.showConfirmDialog(this, RConnectionManager.getTextConsole().getLastConsoleMessage(), RConnectionManager.ERROR, JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_shortenBarcodesButtonActionPerformed

    private void saveDatasetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveDatasetButtonActionPerformed
        // if there is no selection
        if (datasetsList.getSelectedIndex() == -1) {
            // return
            return;
        }
        
        SaveDatasetFrame saveDatasetFrame = new SaveDatasetFrame(datasetController, this);
        saveDatasetFrame.setLocationRelativeTo(null);
	saveDatasetFrame.setVisible(true);
    }//GEN-LAST:event_saveDatasetButtonActionPerformed

    // ************ OTHERS ************ \\
    public void updateNumberLabels() {
        typesNumberLabel.setText(String.valueOf(datasetController.getTypesListModel().size()));
        genesNumberLabel.setText(String.valueOf(datasetController.getGenesListModel().size()));
        eventsNumberLabel.setText(String.valueOf(datasetController.getEventsListModel().size()));
        samplesNumberLabel.setText(String.valueOf(datasetController.getSamplesListModel().size()));
    }
    
    private void clearNumberLabels() {
        typesNumberLabel.setText("");
        genesNumberLabel.setText("");
        eventsNumberLabel.setText("");
        samplesNumberLabel.setText("");
    }
    
    public Dataset getSelectedDataset() {
        int datasetIndex = datasetsList.getSelectedIndex();
        
        if (datasetIndex == -1) {
            return null;
        }
        
    	return (Dataset) datasetController.getDatasetsListModel().get(datasetIndex);
    }
    
    // dispose all option panes
    public static void disposeJOptionPanes() {
    	Window[] windows = Window.getWindows();
		for (Window window : windows) {
		    if (window instanceof JDialog) {
		        JDialog dialog = (JDialog) window;
		        if (dialog.getContentPane().getComponentCount() == 1 && dialog.getContentPane().getComponent(0) instanceof JOptionPane){
		            dialog.dispose();
		        }
		    }
		}
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bindEventsButton;
    private javax.swing.JButton bindSamplesButton;
    private javax.swing.JPanel currentDatasetPanel;
    private javax.swing.JList<String> datasetsList;
    private javax.swing.JScrollPane datasetsListScrollPane;
    private javax.swing.JPanel datasetsPanelList;
    private javax.swing.JButton deleteDatasetButton;
    private javax.swing.JButton deleteEventButton;
    private javax.swing.JButton deleteGeneButton;
    private javax.swing.JButton deleteMultipleSamplesButton;
    private javax.swing.JButton deleteTypeButton;
    private javax.swing.JButton deteleSampleButton;
    private javax.swing.JPanel editPanel;
    private javax.swing.JLabel eventsLabel;
    private javax.swing.JList<String> eventsList;
    private javax.swing.JLabel eventsNumberLabel;
    private javax.swing.JPanel eventsPanelList;
    private javax.swing.JScrollPane eventsScrollPane;
    private javax.swing.JButton eventsSelectionButton;
    private javax.swing.JLabel genesLabel;
    private javax.swing.JList<Gene> genesList;
    private javax.swing.JLabel genesNumberLabel;
    private javax.swing.JPanel genesPanelList;
    private javax.swing.JScrollPane genesScrollPane;
    private javax.swing.JButton importDatasetButton;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JButton intersectButton;
    private javax.swing.JButton joinEventsButton;
    private javax.swing.JButton joinTypesButton;
    private javax.swing.JButton renameGeneButton;
    private javax.swing.JButton renameTypeButton;
    private javax.swing.JLabel samplesLabel;
    private javax.swing.JList<Sample> samplesList;
    private javax.swing.JLabel samplesNumberLabel;
    private javax.swing.JPanel samplesPanelList;
    private javax.swing.JScrollPane samplesScrollPane;
    private javax.swing.JButton samplesSelectionButton;
    private javax.swing.JButton saveDatasetButton;
    private javax.swing.JButton selectMultipleSamplesButton;
    private javax.swing.JButton shortenBarcodesButton;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JButton trimButton;
    private javax.swing.JLabel typesLabel;
    private javax.swing.JList<it.unimib.disco.bimib.cyTRON.model.Type> typesList;
    private javax.swing.JLabel typesNumberLabel;
    private javax.swing.JPanel typesPanelList;
    private javax.swing.JScrollPane typesScrollPane;
    // End of variables declaration//GEN-END:variables
    private HypothesesPanel hypothesesPanel;
    private ExternalToolsPanel externalToolsPanel;
    private InferencePanel inferencePanel;
    private StatisticsPanel statisticsPanel;
    private VisualizationPanel visualizationPanel;
}
