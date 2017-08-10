package it.unimib.disco.bimib.cyTRON.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultListModel;

import org.rosuda.JRI.REXP;
import org.rosuda.JRI.RList;

import it.unimib.disco.bimib.cyTRON.R.RConnectionManager;
import it.unimib.disco.bimib.cyTRON.model.Dataset;
import it.unimib.disco.bimib.cyTRON.model.Gene;
import it.unimib.disco.bimib.cyTRON.model.Type;

public class ExternalToolsController {
	
	private final DefaultListModel<String> groupsListModel;
	
	public ExternalToolsController() {
		groupsListModel = new DefaultListModel<>();
	}

	public void exportMutex(Dataset dataset, String fileName, String filePath, Type mutation, List<Type> amplification, List<Type> deletion) {
		// validate the path
		filePath = filePath.replace("\\", "\\\\");
		
		// export the mutex file for the dataset
		dataset.exportMutex(fileName, filePath, mutation, amplification, deletion);
	}
	
	public String exportNbs(Dataset dataset, String file, String mapping) {
		// validate the paths
		file.replace("\\", "\\\\");
		mapping.replace("\\", "\\\\");
		
		// read the mapping
		HashMap<String, String> entrezIds = new HashMap<>();
		try {
			for (String line : Files.readAllLines(Paths.get(mapping))) {
				String[] splitLine = line.split("\t");
				entrezIds.put(splitLine[0], splitLine[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// check that every gene is in the mapping
		for (Gene gene : dataset.getGenes()) {
			if (!entrezIds.containsKey(gene.getName())) {
				return "Please check the mapping!\nGene " + gene.getName() + " not found.";
			}
		}
		
		// export the nbs file for the dataset
		String[] output = dataset.exportNbs(file, entrezIds);
		
		// return the output
		if (output[output.length - 1].contains("DONE")) {
			return "NBS file exported.";
		} else {
			String outputString = "";
			for (int i = 0; i < output.length; i++) {
				outputString += output[i];
				if (i < output.length - 1) {
					outputString += "\n";
				}
			}
			return outputString;
		}
	}
	
	public void importMutex(String file, Float fdr) {
		// validate the path
		file = file.replace("\\", "\\\\");
		
		// create and execute the command
        String command = "import.mutex.groups('" + file + "'"
        	+ ", fdr=" + fdr.toString().replace(",", ".")
        	+ ", display=FALSE)";
        REXP rexp = RConnectionManager.eval(command);
        
        // read the output and populate the model
        groupsListModel.clear();
        try {
			RList groupsList = rexp.asList();
			for (int i = 0; i < groupsList.keys().length; i++) {
				String group = groupsList.keys()[i] + " - ";
				
				String[] genes = groupsList.at(i).asStringArray();
				for (int j = 0; j < genes.length; j++) {
					group += genes[j];
					if (j < genes.length - 1) {
						group += ", ";
					}
				}
				
				groupsListModel.addElement(group);
			}
		} catch (NullPointerException e) {}
	}
	
	public DefaultListModel<String> getGroupsListModel() {
		return groupsListModel;
	}
	
}
