package it.unimib.disco.bimib.cyTRON.controller;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.work.FinishStatus;
import org.cytoscape.work.ObservableTask;
import org.cytoscape.work.TaskObserver;

import it.unimib.disco.bimib.cyTRON.view.OptionPanel;
import it.unimib.disco.bimib.cyTRON.view.OptionPanel.FieldTitle;

public class MenuAction extends AbstractCyAction {

	private static final long serialVersionUID = -8729200562605831296L;
	
    private final CommandExecutor commandExecutor;
    private OptionPanel optionPanel;
    private String outputPath;
    private String modelPath;

    public MenuAction(CyApplicationManager cyApplicationManager, CommandExecutor commandExecutor, final String menuTitle) {
        super("cyTRON");
        setPreferredMenu("Apps");
        
        this.commandExecutor = commandExecutor;
        this.optionPanel = null;
        this.outputPath = "";
        this.modelPath = "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Show the UI
        JFrame frame = new JFrame();
        this.optionPanel = new OptionPanel(this.commandExecutor, frame);
        
        // Execute command
        int result = JOptionPane.showConfirmDialog(null, optionPanel, "cyTRON", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            TaskObserver taskObserver = new TaskObserver() {
                @Override
                public void taskFinished(ObservableTask arg0) {
                    System.out.println("TaskFinished");
                }

                @Override
                public void allFinished(FinishStatus arg0) {
                    System.out.println("AllFinished");
                }
            };

            File script = generateScript();
            HashMap<String, Object> map = new HashMap<>();
            map.put("inputFile", script.getAbsolutePath());
            map.put("outputFile", this.outputPath);
            this.commandExecutor.executeCommand("cytron", "import", map, taskObserver);
        }
    }

    // Generates the R script to get the graphml file
    private File generateScript() {
        StringBuilder stringBuilder = new StringBuilder();
        
        Map<FieldTitle, String> parameters = this.optionPanel.getParameters();
        this.modelPath = parameters.remove(FieldTitle.MODEL);
        this.outputPath = "";

        if (parameters.containsKey(FieldTitle.GRAPHML)) {
            this.outputPath = parameters.remove(FieldTitle.GRAPHML);
        } else {
            File graphmlTemp = null;
            try {
                graphmlTemp = File.createTempFile("graph", ".graphml");
                Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(graphmlTemp)));
                writer.write(stringBuilder.toString());
                writer.close();
                this.outputPath = graphmlTemp.getAbsolutePath();
            } catch (IOException e) {
            	// TODO: visualizzare l'errore nell'interfaccia
            }
        }
        
        String pdfPath = "";
        if (parameters.containsKey(FieldTitle.PDF)) {
            pdfPath = parameters.remove(FieldTitle.PDF);
        }

        this.modelPath = modelPath.replace('\\', '/');
        this.outputPath = outputPath.replace('\\', '/');
        pdfPath = pdfPath.replace('\\', '/');
        
        // Get model name
        String modelName = "";
        int lastDot = this.modelPath.lastIndexOf('.');
        if (this.modelPath.contains("\\")) {
            int lastBackslash = this.modelPath.lastIndexOf('\\');

            if (lastBackslash < lastDot) {
                modelName = this.modelPath.substring(lastBackslash + 1, lastDot);
            } else {
                modelName = this.modelPath.substring(lastBackslash + 1);
            }
        } else {
            int lastSlash = this.modelPath.lastIndexOf('/');

            if (lastSlash == -1) {
                modelName = this.modelPath;
            } else if (lastSlash < lastDot) {
                modelName = this.modelPath.substring(lastSlash + 1, lastDot);
            } else {
                modelName = modelName.substring(lastSlash + 1);
            }
        }
        
        String hg = parameters.remove(FieldTitle.HG);
        String tp = parameters.remove(FieldTitle.TP);
        String pr = parameters.remove(FieldTitle.PR);

        // Creates the script
        stringBuilder.append("library('TRONCO')\n")
			        .append("load('")
			        .append(this.modelPath)
			        .append("')\n");
        
        boolean statisticalBoot = parameters.remove(FieldTitle.STATISTICAL_BOOTSTRAP) != null;
        boolean nonParametricBoot = parameters.remove(FieldTitle.NON_PARAMETRIC_BOOTSTRAP) != null;
        if (statisticalBoot || nonParametricBoot) {
            stringBuilder.append(modelName + "=tronco.bootstrap(" + modelName)
                        .append(", nboot=" + parameters.remove(FieldTitle.N_BOOT))
                        .append(", cores.ratio=" + parameters.remove(FieldTitle.CORES_RATIO));
            if (statisticalBoot){
                stringBuilder.append(", type = 'statistical'");
            } else {
                stringBuilder.append(", type = 'non-parametric'");
            } 
            stringBuilder.append(")\n");
        }
        
        stringBuilder.append("export.graphml(")
                .append(modelName)
                .append(", '").append(this.outputPath).append("'")
                .append(pdfPath.isEmpty() ? "" : ", file = '" + pdfPath + "'");

        stringBuilder.append(", confidence = c(");
        if (hg != null) {
            stringBuilder.append(hg);
        }
        if (tp != null && hg != null) {
            stringBuilder.append(", ").append(tp);
        } else if (tp != null) {
            stringBuilder.append(tp);
        }
        if ((tp != null || hg != null) && pr != null) {
            stringBuilder.append(", ").append(pr);
        } else if (pr != null) {
            stringBuilder.append(pr);
        }
        if (statisticalBoot || nonParametricBoot) {
           if (tp != null || hg != null || pr != null) {
               stringBuilder.append(", ");
            }
           if (statisticalBoot) {
               stringBuilder.append("'sb'");
           } else {
               stringBuilder.append("'npb'");
           }
               
        }
        stringBuilder.append(")");

        for (FieldTitle field : parameters.keySet()) {
            stringBuilder.append(", ")
                    .append(field.getTitle())
                    .append(" = ")
                    .append(parameters.get(field));
        }
        
        stringBuilder.append(")");

        System.out.println("-----------------------------\n");
        System.out.println(stringBuilder.toString());
        System.out.println("-----------------------------\n");

        File outputFile = null;
        try {
            outputFile = File.createTempFile("cytron_script", ".R");
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
            writer.write(stringBuilder.toString());
            writer.close();
        } catch (IOException e) {
        	// TODO: visualizzare l'errore nell'interfaccia
        }

        return outputFile;
    }
}
