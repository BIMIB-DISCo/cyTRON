package it.unimib.disco.bimib.cyTRON.view;

import it.unimib.disco.bimib.cyTRON.controller.WizardController;
import it.unimib.disco.bimib.cyTRON.cytoscape.CommandExecutor;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class WizardFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = -5083643351838860038L;

	private WizardController wizardController;
    private CommandExecutor commandExecutor;
	
    public WizardFrame(WizardController wizardController, CommandExecutor commandExecutor) {
        // get the controller and the command executor
        this.wizardController = wizardController;
    	this.commandExecutor = commandExecutor;
    	
    	// draw the interface
    	initComponents();
        
        // validate the statuses
        validateStatuses();
    }
    
    private void validateStatuses() {
    	// step 1: JDK
        if (wizardController.isJdkInstalled()) {
            javaStatusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick.png")));
        } else {
        	return;
        }
        
        // step 2: JRI
        if (wizardController.isJriCopied()) {
            jriStatusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick.png")));
            jriFromTextField.setEnabled(false);
            jriToTextField.setEnabled(false);
            jriCopyButton.setEnabled(false);
        } else {
        	return;
        }
        
        // step 3 (for Windows only): R files
        if (wizardController.isRLibraryCopied()) {
			rLibraryStatusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick.png")));
			rLibraryFromTextField.setEnabled(false);
			rLibraryToTextField.setEnabled(false);
			rLibraryCopyButton.setEnabled(false);
		} else {
			return;
		}
        
        // step 4: R_HOME
        if (wizardController.isRHomeSet()) {
        	rHomeStatusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick.png")));
		} else {
			return;
		}
        
        // step 5 (for Windows only): R_LIBS_USER
        if (wizardController.isRLibsSet()) {
        	rLibsStatusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick.png")));
		} else {
			return;
		}
        
        // step 6: R
        if (wizardController.isRConnectionOn()) {
        	rConnectionStatusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick.png")));
        } else {
			return;
		}
        
        // step 7: TRONCO
        if (wizardController.isTroncoInstalled()) {
        	troncoStatusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick.png")));
        } else {
			return;
		}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeLabel = new javax.swing.JLabel();
        jriPanel = new javax.swing.JPanel();
        jriLabel = new javax.swing.JLabel();
        jriStatusLabel = new javax.swing.JLabel();
        fromLabel1 = new javax.swing.JLabel();
        toLabel1 = new javax.swing.JLabel();
        jriToTextField = new javax.swing.JTextField();
        jriFromTextField = new javax.swing.JTextField();
        jriCopyButton = new javax.swing.JButton();
        rLibraryPanel = new javax.swing.JPanel();
        rLibraryLabel = new javax.swing.JLabel();
        rLibraryFromTextField = new javax.swing.JTextField();
        rLibraryToTextField = new javax.swing.JTextField();
        rLibraryCopyButton = new javax.swing.JButton();
        fromLabel2 = new javax.swing.JLabel();
        toLabel2 = new javax.swing.JLabel();
        rLibraryStatusLabel = new javax.swing.JLabel();
        javaPanel = new javax.swing.JPanel();
        javaLabel = new javax.swing.JLabel();
        javaStatusLabel = new javax.swing.JLabel();
        rConnectionPanel = new javax.swing.JPanel();
        rConnectionLabel = new javax.swing.JLabel();
        rConnectionStatusLabel = new javax.swing.JLabel();
        rLibsPanel = new javax.swing.JPanel();
        rLibsLabel1 = new javax.swing.JLabel();
        rLibsStatusLabel = new javax.swing.JLabel();
        rHomePanel = new javax.swing.JPanel();
        rHomeLabel = new javax.swing.JLabel();
        rHomeStatusLabel = new javax.swing.JLabel();
        troncoPanel = new javax.swing.JPanel();
        troncoLabel = new javax.swing.JLabel();
        troncoStatusLabel = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        versionLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("cyTRON");
        setMaximumSize(new java.awt.Dimension(640, 720));
        setMinimumSize(new java.awt.Dimension(640, 720));
        setSize(new java.awt.Dimension(640, 720));

        welcomeLabel.setFont(new java.awt.Font("Lucida Grande", 1, 17)); // NOI18N
        welcomeLabel.setText("Welcome to cyTRON!");

        jriPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jriPanel.setMaximumSize(new java.awt.Dimension(540, 120));
        jriPanel.setSize(new java.awt.Dimension(540, 120));

        jriLabel.setText("JRI library file");

        jriStatusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/x.png"))); // NOI18N
        jriStatusLabel.setSize(new java.awt.Dimension(40, 40));

        fromLabel1.setText("From:");

        toLabel1.setText("To:");

        jriToTextField.setText(wizardController.getProperty(WizardController.CYTRON_JRI_TO));
        jriToTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jriToTextFieldMouseClicked(evt);
            }
        });

        jriFromTextField.setText(wizardController.getProperty(WizardController.CYTRON_JRI_FROM));
        jriFromTextField.setToolTipText("");
        jriFromTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jriFromTextFieldMouseClicked(evt);
            }
        });

        jriCopyButton.setText("Copy");
        jriCopyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jriCopyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jriPanelLayout = new javax.swing.GroupLayout(jriPanel);
        jriPanel.setLayout(jriPanelLayout);
        jriPanelLayout.setHorizontalGroup(
            jriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jriPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jriPanelLayout.createSequentialGroup()
                        .addComponent(jriLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jriStatusLabel))
                    .addGroup(jriPanelLayout.createSequentialGroup()
                        .addGroup(jriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fromLabel1)
                            .addComponent(toLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jriToTextField)
                            .addComponent(jriFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jriCopyButton)))
                .addContainerGap())
        );
        jriPanelLayout.setVerticalGroup(
            jriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jriPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jriStatusLabel)
                    .addComponent(jriLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jriPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jriCopyButton))
                    .addGroup(jriPanelLayout.createSequentialGroup()
                        .addGroup(jriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jriFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fromLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jriToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(toLabel1))))
                .addContainerGap())
        );

        rLibraryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        rLibraryLabel.setText("R library files (Windows users only)");

        rLibraryFromTextField.setText(wizardController.getProperty(WizardController.CYTRON_RLIBRARY_FROM));
        rLibraryFromTextField.setToolTipText("");
        rLibraryFromTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rLibraryFromTextFieldMouseClicked(evt);
            }
        });

        rLibraryToTextField.setText(wizardController.getProperty(WizardController.CYTRON_RLIBRARY_TO));
        rLibraryToTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rLibraryToTextFieldMouseClicked(evt);
            }
        });

        rLibraryCopyButton.setText("Copy");
        rLibraryCopyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rLibraryCopyButtonActionPerformed(evt);
            }
        });

        fromLabel2.setText("From:");

        toLabel2.setText("To:");

        rLibraryStatusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/x.png"))); // NOI18N
        rLibraryStatusLabel.setSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout rLibraryPanelLayout = new javax.swing.GroupLayout(rLibraryPanel);
        rLibraryPanel.setLayout(rLibraryPanelLayout);
        rLibraryPanelLayout.setHorizontalGroup(
            rLibraryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rLibraryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rLibraryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rLibraryPanelLayout.createSequentialGroup()
                        .addComponent(rLibraryLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rLibraryStatusLabel))
                    .addGroup(rLibraryPanelLayout.createSequentialGroup()
                        .addGroup(rLibraryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fromLabel2)
                            .addComponent(toLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rLibraryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rLibraryToTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(rLibraryFromTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rLibraryCopyButton)))
                .addContainerGap())
        );
        rLibraryPanelLayout.setVerticalGroup(
            rLibraryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rLibraryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rLibraryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rLibraryPanelLayout.createSequentialGroup()
                        .addComponent(rLibraryStatusLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rLibraryCopyButton))
                    .addGroup(rLibraryPanelLayout.createSequentialGroup()
                        .addComponent(rLibraryLabel)
                        .addGap(30, 30, 30)
                        .addGroup(rLibraryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rLibraryFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fromLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rLibraryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rLibraryToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(toLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javaLabel.setText("Java SE Development Kit");

        javaStatusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/x.png"))); // NOI18N
        javaStatusLabel.setSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout javaPanelLayout = new javax.swing.GroupLayout(javaPanel);
        javaPanel.setLayout(javaPanelLayout);
        javaPanelLayout.setHorizontalGroup(
            javaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(javaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(javaStatusLabel)
                .addContainerGap())
        );
        javaPanelLayout.setVerticalGroup(
            javaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(javaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(javaStatusLabel)
                    .addComponent(javaLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rConnectionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        rConnectionLabel.setText("R connection");

        rConnectionStatusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/x.png"))); // NOI18N
        rConnectionStatusLabel.setSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout rConnectionPanelLayout = new javax.swing.GroupLayout(rConnectionPanel);
        rConnectionPanel.setLayout(rConnectionPanelLayout);
        rConnectionPanelLayout.setHorizontalGroup(
            rConnectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rConnectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rConnectionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rConnectionStatusLabel)
                .addContainerGap())
        );
        rConnectionPanelLayout.setVerticalGroup(
            rConnectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rConnectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rConnectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rConnectionStatusLabel)
                    .addComponent(rConnectionLabel))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        rLibsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        rLibsLabel1.setText("R_LIBS_USER environment variable (Windows users only)");

        rLibsStatusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/x.png"))); // NOI18N
        rLibsStatusLabel.setSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout rLibsPanelLayout = new javax.swing.GroupLayout(rLibsPanel);
        rLibsPanel.setLayout(rLibsPanelLayout);
        rLibsPanelLayout.setHorizontalGroup(
            rLibsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rLibsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rLibsLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rLibsStatusLabel)
                .addContainerGap())
        );
        rLibsPanelLayout.setVerticalGroup(
            rLibsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rLibsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rLibsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rLibsStatusLabel)
                    .addComponent(rLibsLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rHomePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        rHomeLabel.setText("R_HOME environment variable");

        rHomeStatusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/x.png"))); // NOI18N
        rHomeStatusLabel.setSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout rHomePanelLayout = new javax.swing.GroupLayout(rHomePanel);
        rHomePanel.setLayout(rHomePanelLayout);
        rHomePanelLayout.setHorizontalGroup(
            rHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rHomePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rHomeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rHomeStatusLabel)
                .addContainerGap())
        );
        rHomePanelLayout.setVerticalGroup(
            rHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rHomePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rHomeStatusLabel)
                    .addComponent(rHomeLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        troncoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        troncoLabel.setText("TRONCO R library");

        troncoStatusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/x.png"))); // NOI18N
        troncoStatusLabel.setSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout troncoPanelLayout = new javax.swing.GroupLayout(troncoPanel);
        troncoPanel.setLayout(troncoPanelLayout);
        troncoPanelLayout.setHorizontalGroup(
            troncoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(troncoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(troncoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 382, Short.MAX_VALUE)
                .addComponent(troncoStatusLabel)
                .addContainerGap())
        );
        troncoPanelLayout.setVerticalGroup(
            troncoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(troncoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(troncoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(troncoStatusLabel)
                    .addComponent(troncoLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        startButton.setText("Start!");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Remember to reboot Cytoscape every time you make a change for updating this wizard.");

        versionLabel.setText(WizardController.VERSION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(welcomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(versionLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(startButton)
                                .addGap(235, 235, 235))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(rLibraryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(javaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jriPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rHomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rLibsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rConnectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(troncoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(welcomeLabel)
                    .addComponent(versionLabel))
                .addGap(18, 18, 18)
                .addComponent(javaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jriPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rLibraryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rHomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rLibsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rConnectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(troncoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(startButton)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // create the main frame and show it
        MainFrame mainFrame = new MainFrame(commandExecutor, false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        
        // update cyTRON file
        wizardController.completeWizard();
        
        // close this frame
        dispose();
    }//GEN-LAST:event_startButtonActionPerformed

    private void jriFromTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jriFromTextFieldMouseClicked
        // if the text field is not active
    	if (!jriFromTextField.isEnabled()) {
			// return
    		return;
		}
    	
    	// create the file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        // check the return option
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                // update the text field
                jriFromTextField.setText(fileChooser.getSelectedFile().getCanonicalPath());
            } catch (IOException e) {
            	e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jriFromTextFieldMouseClicked

    private void jriToTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jriToTextFieldMouseClicked
    	// if the text field is not active
    	if (!jriToTextField.isEnabled()) {
			// return
    		return;
		}
    	
    	// create the file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        // check the return option
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                // update the text field
                jriToTextField.setText(fileChooser.getSelectedFile().getCanonicalPath());
            } catch (IOException e) {
            	e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jriToTextFieldMouseClicked

    private void rLibraryFromTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rLibraryFromTextFieldMouseClicked
    	// if the text field is not active
    	if (!rLibraryFromTextField.isEnabled()) {
			// return
    		return;
		}
    	
    	// create the file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        // check the return option
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                // update the text field
                rLibraryFromTextField.setText(fileChooser.getSelectedFile().getCanonicalPath());
            } catch (IOException e) {
            	e.printStackTrace();
            }
        }
    }//GEN-LAST:event_rLibraryFromTextFieldMouseClicked

    private void rLibraryToTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rLibraryToTextFieldMouseClicked
    	// if the text field is not active
    	if (!rLibraryToTextField.isEnabled()) {
			// return
    		return;
		}
    	
    	// create the file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        // check the return option
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                // update the text field
                rLibraryToTextField.setText(fileChooser.getSelectedFile().getCanonicalPath());
            } catch (IOException e) {
            	e.printStackTrace();
            }
        }
    }//GEN-LAST:event_rLibraryToTextFieldMouseClicked

    private void jriCopyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jriCopyButtonActionPerformed
        // get the paths
        String from = jriFromTextField.getText();
        String to = jriToTextField.getText();

        try {            
        	// copy the jri file
			wizardController.copyJriFile(from, to);
			JOptionPane.showConfirmDialog(this, "JRI library copied!\nReboot Cytoscape.", "", JOptionPane.PLAIN_MESSAGE);
		} catch (RuntimeException e) {
			JOptionPane.showConfirmDialog(this, e.getMessage(), "", JOptionPane.PLAIN_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showConfirmDialog(this, e.getMessage() + " is not an accesible path!", "", JOptionPane.PLAIN_MESSAGE);
		}
    }//GEN-LAST:event_jriCopyButtonActionPerformed

    private void rLibraryCopyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rLibraryCopyButtonActionPerformed
        // get the paths
        String from = rLibraryFromTextField.getText();
        String to = rLibraryToTextField.getText();
        
        // copy the R library files
        try {
			wizardController.copyRLibraryFiles(from, to);
			JOptionPane.showConfirmDialog(this, "R library copied!\nReboot Cytoscape.", "", JOptionPane.PLAIN_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showConfirmDialog(this, e.getMessage() + " is not an accesible path!", "", JOptionPane.PLAIN_MESSAGE);
		}
    }//GEN-LAST:event_rLibraryCopyButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fromLabel1;
    private javax.swing.JLabel fromLabel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel javaLabel;
    private javax.swing.JPanel javaPanel;
    private javax.swing.JLabel javaStatusLabel;
    private javax.swing.JButton jriCopyButton;
    private javax.swing.JTextField jriFromTextField;
    private javax.swing.JLabel jriLabel;
    private javax.swing.JPanel jriPanel;
    private javax.swing.JLabel jriStatusLabel;
    private javax.swing.JTextField jriToTextField;
    private javax.swing.JLabel rConnectionLabel;
    private javax.swing.JPanel rConnectionPanel;
    private javax.swing.JLabel rConnectionStatusLabel;
    private javax.swing.JLabel rHomeLabel;
    private javax.swing.JPanel rHomePanel;
    private javax.swing.JLabel rHomeStatusLabel;
    private javax.swing.JButton rLibraryCopyButton;
    private javax.swing.JTextField rLibraryFromTextField;
    private javax.swing.JLabel rLibraryLabel;
    private javax.swing.JPanel rLibraryPanel;
    private javax.swing.JLabel rLibraryStatusLabel;
    private javax.swing.JTextField rLibraryToTextField;
    private javax.swing.JLabel rLibsLabel1;
    private javax.swing.JPanel rLibsPanel;
    private javax.swing.JLabel rLibsStatusLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel toLabel1;
    private javax.swing.JLabel toLabel2;
    private javax.swing.JLabel troncoLabel;
    private javax.swing.JPanel troncoPanel;
    private javax.swing.JLabel troncoStatusLabel;
    private javax.swing.JLabel versionLabel;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
