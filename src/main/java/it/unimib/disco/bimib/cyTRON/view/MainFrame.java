package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.model.Dataset;
import it.unimib.disco.bimib.cyTRON.model.Gene;

public class MainFrame extends javax.swing.JFrame {

    private final DatasetController datasetController;
    
    public MainFrame() {
        // instantiate the controllers
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
        visualizationPanel = new javax.swing.JPanel();
        inferencePanel = new javax.swing.JPanel();
        datasetsPanelList = new javax.swing.JPanel();
        datasetsListScrollPane = new javax.swing.JScrollPane();
        datasetsList = new javax.swing.JList<>();
        importDatasetButton = new javax.swing.JButton();
        deleteDatasetButton = new javax.swing.JButton();
        bindEventsButton = new javax.swing.JButton();
        bindSamplesButton = new javax.swing.JButton();
        intersectButton = new javax.swing.JButton();

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

        javax.swing.GroupLayout samplesPanelListLayout = new javax.swing.GroupLayout(samplesPanelList);
        samplesPanelList.setLayout(samplesPanelListLayout);
        samplesPanelListLayout.setHorizontalGroup(
            samplesPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(samplesPanelListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(samplesPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(samplesScrollPane)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, samplesPanelListLayout.createSequentialGroup()
                        .addComponent(samplesSelectionButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deteleSampleButton)))
                .addContainerGap())
        );
        samplesPanelListLayout.setVerticalGroup(
            samplesPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(samplesPanelListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(samplesScrollPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(samplesPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deteleSampleButton)
                    .addComponent(samplesSelectionButton))
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

        javax.swing.GroupLayout visualizationPanelLayout = new javax.swing.GroupLayout(visualizationPanel);
        visualizationPanel.setLayout(visualizationPanelLayout);
        visualizationPanelLayout.setHorizontalGroup(
            visualizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 941, Short.MAX_VALUE)
        );
        visualizationPanelLayout.setVerticalGroup(
            visualizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Visualization", visualizationPanel);

        javax.swing.GroupLayout inferencePanelLayout = new javax.swing.GroupLayout(inferencePanel);
        inferencePanel.setLayout(inferencePanelLayout);
        inferencePanelLayout.setHorizontalGroup(
            inferencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 941, Short.MAX_VALUE)
        );
        inferencePanelLayout.setVerticalGroup(
            inferencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Inference", inferencePanel);

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

        javax.swing.GroupLayout datasetsPanelListLayout = new javax.swing.GroupLayout(datasetsPanelList);
        datasetsPanelList.setLayout(datasetsPanelListLayout);
        datasetsPanelListLayout.setHorizontalGroup(
            datasetsPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datasetsPanelListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datasetsPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datasetsListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addGroup(datasetsPanelListLayout.createSequentialGroup()
                        .addComponent(importDatasetButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteDatasetButton))
                    .addGroup(datasetsPanelListLayout.createSequentialGroup()
                        .addComponent(intersectButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(datasetsPanelListLayout.createSequentialGroup()
                        .addComponent(bindEventsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bindSamplesButton)))
                .addContainerGap())
        );
        datasetsPanelListLayout.setVerticalGroup(
            datasetsPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datasetsPanelListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datasetsPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importDatasetButton)
                    .addComponent(deleteDatasetButton))
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
    	
    	tabbedPane.addTab("Hypotheses", hypothesesPanel);
    	tabbedPane.addTab("External Tools", externalToolsPanel);
    }
    
    // ************ DATASETS ************ \\
    private void importDatasetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importDatasetButtonActionPerformed
        ImportDatasetFrame importDatasetFrame = new ImportDatasetFrame(datasetController);
        importDatasetFrame.setLocationRelativeTo(null);
	importDatasetFrame.setVisible(true);
    }//GEN-LAST:event_importDatasetButtonActionPerformed

    private void deleteDatasetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDatasetButtonActionPerformed
        // execute the action
        datasetController.deleteDataset(datasetsList.getSelectedIndex());
        
        // clear the number labels
        clearNumberLabels();
    }//GEN-LAST:event_deleteDatasetButtonActionPerformed

    // ************ SAMPLES ************ \\
    private void deteleSampleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deteleSampleButtonActionPerformed
        // excute the action
        datasetController.deleteSample(samplesList.getSelectedIndex(), datasetsList.getSelectedIndex());
        
        // update the number labels
        updateNumberLabels();
    }//GEN-LAST:event_deteleSampleButtonActionPerformed
    
    // ************ GENES ************ \\
    private void renameGeneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameGeneButtonActionPerformed
        RenameGeneFrame renameGeneFrame = new RenameGeneFrame(datasetController, genesList.getSelectedIndex(), datasetsList.getSelectedIndex());
        renameGeneFrame.setLocationRelativeTo(null);
	renameGeneFrame.setVisible(true);
    }//GEN-LAST:event_renameGeneButtonActionPerformed

    private void deleteGeneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteGeneButtonActionPerformed
        // execute the actioin
        datasetController.deleteGene(genesList.getSelectedIndex(), datasetsList.getSelectedIndex());
        
        // update the number labels
        updateNumberLabels();
    }//GEN-LAST:event_deleteGeneButtonActionPerformed

    // ************ TYPES ************ \\
    private void deleteTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTypeButtonActionPerformed
        // execute the action
        datasetController.deleteType(typesList.getSelectedIndex(), datasetsList.getSelectedIndex());
        
        // update the number labels
        updateNumberLabels();
    }//GEN-LAST:event_deleteTypeButtonActionPerformed

    private void renameTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameTypeButtonActionPerformed
        RenameTypeFrame renameTypeFrame = new RenameTypeFrame(datasetController, typesList.getSelectedIndex(), datasetsList.getSelectedIndex());
        renameTypeFrame.setLocationRelativeTo(null);
	renameTypeFrame.setVisible(true);
    }//GEN-LAST:event_renameTypeButtonActionPerformed

    private void joinTypesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinTypesButtonActionPerformed
        JoinTypesFrame joinTypesFrame = new JoinTypesFrame(this, datasetController, typesList.getSelectedIndex(), datasetsList.getSelectedIndex());
        joinTypesFrame.setLocationRelativeTo(null);
	joinTypesFrame.setVisible(true);
    }//GEN-LAST:event_joinTypesButtonActionPerformed

    // ************ EVENTS ************ \\
    private void deleteEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEventButtonActionPerformed
        // execute the action
        datasetController.deleteEvent(eventsList.getSelectedIndex(), datasetsList.getSelectedIndex());
        
        // update the number labels
        updateNumberLabels();
    }//GEN-LAST:event_deleteEventButtonActionPerformed

    private void joinEventsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinEventsButtonActionPerformed
        JoinEventsFrame joinEventsFrame = new JoinEventsFrame(this, datasetController, eventsList.getSelectedIndex(), datasetsList.getSelectedIndex());
        joinEventsFrame.setLocationRelativeTo(null);
	joinEventsFrame.setVisible(true);
    }//GEN-LAST:event_joinEventsButtonActionPerformed
    
    // ************ BINDS ************ \\
    private void bindEventsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bindEventsButtonActionPerformed
        BindDatasetsFrame bindDatasetsFrame = new BindDatasetsFrame(this, datasetController, datasetsList.getSelectedIndex(), DatasetController.EVENTS);
        bindDatasetsFrame.setLocationRelativeTo(null);
	bindDatasetsFrame.setVisible(true);
    }//GEN-LAST:event_bindEventsButtonActionPerformed

    private void bindSamplesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bindSamplesButtonActionPerformed
        BindDatasetsFrame bindDatasetsFrame = new BindDatasetsFrame(this, datasetController, datasetsList.getSelectedIndex(), DatasetController.SAMPLES);
        bindDatasetsFrame.setLocationRelativeTo(null);
	bindDatasetsFrame.setVisible(true);
    }//GEN-LAST:event_bindSamplesButtonActionPerformed

    private void intersectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intersectButtonActionPerformed
        IntersectDatasetsFrame intersectDatasetsFrame = new IntersectDatasetsFrame(this, datasetController, datasetsList.getSelectedIndex(), DatasetController.SAMPLES);
        intersectDatasetsFrame.setLocationRelativeTo(null);
	intersectDatasetsFrame.setVisible(true);
    }//GEN-LAST:event_intersectButtonActionPerformed

    private void datasetsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_datasetsListValueChanged
        // update the lists
        datasetController.updateLists(datasetsList.getSelectedIndex());
        
        // update the number labels
        updateNumberLabels();
        
        // update the other panels
        hypothesesPanel.updateSelectedDataset(datasetsList.getSelectedIndex());
        externalToolsPanel.updateSelectedDataset();
        
    }//GEN-LAST:event_datasetsListValueChanged

    private void samplesSelectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_samplesSelectionButtonActionPerformed
        SamplesSelectionFrame samplesSelectionFrame = new SamplesSelectionFrame(this, datasetController, datasetsList.getSelectedIndex());
        samplesSelectionFrame.setLocationRelativeTo(null);
	samplesSelectionFrame.setVisible(true);
    }//GEN-LAST:event_samplesSelectionButtonActionPerformed

    private void eventsSelectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventsSelectionButtonActionPerformed
        EventsSelectionFrame eventsSelectionFrame = new EventsSelectionFrame(this, datasetController, datasetsList.getSelectedIndex());
        eventsSelectionFrame.setLocationRelativeTo(null);
	eventsSelectionFrame.setVisible(true);
    }//GEN-LAST:event_eventsSelectionButtonActionPerformed

    private void trimButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trimButtonActionPerformed
        datasetController.trim(datasetsList.getSelectedIndex());
    }//GEN-LAST:event_trimButtonActionPerformed

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
    	return (Dataset) datasetController.getDatasetsListModel().get(datasetsList.getSelectedIndex());
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
    private javax.swing.JPanel inferencePanel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JButton intersectButton;
    private javax.swing.JButton joinEventsButton;
    private javax.swing.JButton joinTypesButton;
    private javax.swing.JButton renameGeneButton;
    private javax.swing.JButton renameTypeButton;
    private javax.swing.JLabel samplesLabel;
    private javax.swing.JList<String> samplesList;
    private javax.swing.JLabel samplesNumberLabel;
    private javax.swing.JPanel samplesPanelList;
    private javax.swing.JScrollPane samplesScrollPane;
    private javax.swing.JButton samplesSelectionButton;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JButton trimButton;
    private javax.swing.JLabel typesLabel;
    private javax.swing.JList<it.unimib.disco.bimib.cyTRON.model.Type> typesList;
    private javax.swing.JLabel typesNumberLabel;
    private javax.swing.JPanel typesPanelList;
    private javax.swing.JScrollPane typesScrollPane;
    private javax.swing.JPanel visualizationPanel;
    // End of variables declaration//GEN-END:variables
    private HypothesesPanel hypothesesPanel;
    private ExternalToolsPanel externalToolsPanel;
}
