package it.unimib.disco.bimib.cyTRON;

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

import org.cytoscape.app.swing.CySwingAppAdapter;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.work.FinishStatus;
import org.cytoscape.work.ObservableTask;
import org.cytoscape.work.TaskObserver;

import it.unimib.disco.bimib.cyTRON.OptionPanel.FieldTitle;

/**
 * Creates a new menu item under Apps menu section.
 *
 */
public class MenuAction extends AbstractCyAction {

    private final CySwingAppAdapter adapter;
    private final CommandExecutor commandExecutor;
    private OptionPanel panel;
    private String outputPath;
    private String modelPath;

    public MenuAction(CyApplicationManager cyApplicationManager,
            CySwingAppAdapter adapter,
            CommandExecutor commandExecutor,
            final String menuTitle) {
        super("cyTRON");
        setPreferredMenu("Apps");
        this.adapter = adapter;
        this.commandExecutor = commandExecutor;
        this.panel = null;
        this.outputPath = "";
        this.modelPath = "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Construction of the UI to set the R Script parameters
        JFrame frame = new JFrame();
        panel = new OptionPanel(commandExecutor, frame);

        int result = JOptionPane.showConfirmDialog(null,
                panel,
                "cyTRON",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            
            // cyTRON import command execution
            TaskObserver observer = new TaskObserver() {
                @Override
                public void taskFinished(ObservableTask arg0) {
                    System.out.println("TaskFinished");
                }

                @Override
                public void allFinished(FinishStatus arg0) {
                    System.out.println("TaskAllFinished");

                }
            };

            File script = generateScript();
            HashMap<String, Object> mappa = new HashMap<>();
            mappa.put("inputFile", script.getAbsolutePath());
            mappa.put("outputFile", outputPath);
            commandExecutor.executeCommand("cytron", "import", mappa, observer);
        }
    }

    // Method that constructs the R script to create the graphml
    private File generateScript() {
        StringBuilder scriptBuilder = new StringBuilder();
        File outputFile = null;
        Map<FieldTitle, String> parameters = panel.getParameters();

        modelPath = parameters.remove(FieldTitle.MODEL);
        outputPath = "";

        if (parameters.containsKey(FieldTitle.GRAPHML)) {
            outputPath = parameters.remove(FieldTitle.GRAPHML);
        } else {
            File tmpGraphml = null;
            try {
                tmpGraphml = File.createTempFile("graph", ".graphml");
                Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmpGraphml)));
                writer.write(scriptBuilder.toString());
                writer.close();
                outputPath = tmpGraphml.getAbsolutePath();
            } catch (IOException e) {
                // TODO: decidere come segnalare l'errore

            }
        }
        
        String pdfPath = "";
        if (parameters.containsKey(FieldTitle.PDF)) {
            pdfPath = parameters.remove(FieldTitle.PDF);
        }

        modelPath = modelPath.replace('\\', '/');
        outputPath = outputPath.replace('\\', '/');
        pdfPath = pdfPath.replace('\\', '/');
        
        // TODO: estrarre un metodo
        // Model name retrieval from path
        String modelName = "";
        int lastDot = modelPath.lastIndexOf('.');
        if (modelPath.contains("\\")) {
            int lastBackslash = modelPath.lastIndexOf('\\');

            if (lastBackslash < lastDot) {
                modelName = modelPath.substring(lastBackslash + 1, lastDot);
            } else {
                modelName = modelPath.substring(lastBackslash + 1);
            }
        } else {
            int lastSlash = modelPath.lastIndexOf('/');

            if (lastSlash == -1) {
                modelName = modelPath;
            } else if (lastSlash < lastDot) {
                modelName = modelPath.substring(lastSlash + 1, lastDot);
            } else {
                modelName = modelName.substring(lastSlash + 1);
            }
        }
        
        String hg = parameters.remove(FieldTitle.HG);
        String tp = parameters.remove(FieldTitle.TP);
        String pr = parameters.remove(FieldTitle.PR);

        scriptBuilder.append("library('TRONCO')\n")
                .append("load('").append(modelPath).append("')\n")
                .append("export.graphml(")
                .append(modelName)
                .append(", '").append(outputPath).append("'")
                .append(pdfPath.isEmpty() ? "" : ", file = '" + pdfPath + "'");

        scriptBuilder.append(", confidence = c(");
        if (hg != null) {
            scriptBuilder.append(hg);
        }
        if (tp != null && hg != null) {
            scriptBuilder.append(", ").append(tp);
        } else if (tp != null) {
            scriptBuilder.append(tp);
        }
        if ((tp != null || hg != null) && pr != null) {
            scriptBuilder.append(", ").append(pr);
        } else if (pr != null) {
            scriptBuilder.append(pr);
        }
        scriptBuilder.append(")");

        for (FieldTitle field : parameters.keySet()) {
            scriptBuilder.append(", ")
                    .append(field.getTitle())
                    .append(" = ")
                    .append(parameters.get(field));
        }
        
        scriptBuilder.append(")");

        // TODO: debug line
        System.out.println("-----------------------------\n\n");
        System.out.println(scriptBuilder.toString());
        System.out.println("-----------------------------\n\n");

        try {
            outputFile = File.createTempFile("cytron_script", ".R");
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
            writer.write(scriptBuilder.toString());
            writer.close();
        } catch (IOException e) {
            // TODO: scegliere come segnalare l'errore 
        }

        return outputFile;
    }
}
