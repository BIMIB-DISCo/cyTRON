package it.unimib.disco.bimib.cyTRON.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import it.unimib.disco.bimib.cyTRON.model.Dataset;
import it.unimib.disco.bimib.cyTRON.model.Gene;
import it.unimib.disco.bimib.cyTRON.model.Type;

public class ExternalToolsController {

	public void exportMutex(Dataset dataset, String fileName, String filePath, Type mutation, List<Type> amplification, List<Type> deletion) {
		// export the mutex file for the dataset
		dataset.exportMutex(fileName, filePath, mutation, amplification, deletion);
	}
	
	public void exportNbs(Dataset dataset, String file, String mapping, List<Gene> genes) {
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
		
		// export the nbs file for the dataset
		dataset.exportNbs(file, genes, entrezIds);
	}
	
	public void importMutex() {
		
	}
	
}
