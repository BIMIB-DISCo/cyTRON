package it.unimib.disco.bimib.cyTRON;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.JLabel;

import org.cytoscape.app.swing.CySwingAppAdapter;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.work.FinishStatus;
import org.cytoscape.work.ObservableTask;
import org.cytoscape.work.TaskObserver;

import it.unimib.disco.bimib.cyTRON.OptionPanel2.FieldTitle;


/**
 * Creates a new menu item under Apps menu section.
 *
 */
public class MenuAction extends AbstractCyAction {
	private CySwingAppAdapter adapter;
	private CommandExecutor commandExecutor;
	private OptionPanel2 panel;
	private String outputPath;
	private String modelPath;
	
	public MenuAction(CyApplicationManager cyApplicationManager, 
			CySwingAppAdapter adapter, 
			CommandExecutor commandExecutor,
			final String menuTitle) {
		super("cyTRON-2");
		//super(menuTitle, cyApplicationManager, null, null);
		setPreferredMenu("Apps");
		this.adapter = adapter;
		this.commandExecutor = commandExecutor;
		this.panel = null;
		this.outputPath = "";
		this.modelPath = "";
	}

	public void actionPerformed(ActionEvent e) {
		
		JFrame frame = new JFrame();
		panel = new OptionPanel2(commandExecutor, frame);
		System.out.println("ActionPerformed MenuAction");
		
		int result = JOptionPane.showConfirmDialog(null, panel,
                "cyTRON", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			
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
            HashMap<String, Object> mappa = new HashMap<String, Object>();
            mappa.put("inputFile", script.getAbsolutePath());
            mappa.put("outputFile", outputPath);
            commandExecutor.executeCommand("cytron", "import", mappa, observer);
            
         }
		
		//frame.getContentPane().add(panel);
		//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frame.pack();
                
		//a = panel.script;
                //taskFactory.createTaskIterator(a)
		//final JFrame desktop = adapter.getCySwingApplication().getJFrame();
		//frame.setLocationRelativeTo(desktop);
		//frame.setVisible(true);
	}
	
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
    			tmpGraphml = File.createTempFile("graph", "graphml");
    			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmpGraphml)));
    			writer.write(scriptBuilder.toString());
    			writer.close();	
    			outputPath = tmpGraphml.getAbsolutePath();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
        }
        
        
        String pdfPath = "";
        if (parameters.containsKey(FieldTitle.PDF)) {
        	pdfPath = parameters.remove(FieldTitle.PDF);
        }
             
        
        
        
        modelPath = modelPath.replace('\\', '/');
        outputPath = outputPath.replace('\\', '/');
        pdfPath = pdfPath.replace('\\', '/');

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
        
        scriptBuilder.append("library('TRONCO')\n");
        scriptBuilder.append("load('" + modelPath + "')\n");
        scriptBuilder.append("export.graphml(" + modelName + ", '" + outputPath + "'");
        scriptBuilder.append(pdfPath.isEmpty() ? "" : ", file = '" + pdfPath + "'");
        
        scriptBuilder.append(", confidence = (");
        if(hg != null) {
        	scriptBuilder.append(hg);
        }
        if (tp != null && hg != null) {
            scriptBuilder.append(", " + tp);
        } else if (tp != null) {
            scriptBuilder.append(tp);
        }
        if ((tp != null || hg != null) && pr != null) {
            scriptBuilder.append(", " + pr);
        } else if (pr != null) {
            scriptBuilder.append(pr);
        }
        scriptBuilder.append(")");
        
        
        parameters.forEach((key, value) -> { 
        	scriptBuilder.append(", " + key.name() + " = " + value);
        });
        
 
        scriptBuilder.append(")");

        System.out.println("-----------------------------\n\n");
        System.out.println(scriptBuilder.toString());
        System.out.println("-----------------------------\n\n");

        
        try {
            outputFile = File.createTempFile("cytron_script", "R");
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
            writer.write(scriptBuilder.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputFile;
    }

}
