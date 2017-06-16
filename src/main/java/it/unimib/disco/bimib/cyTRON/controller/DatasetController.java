package it.unimib.disco.bimib.cyTRON.controller;

import it.unimib.disco.bimib.cyTRON.model.Dataset;
import it.unimib.disco.bimib.cyTRON.model.Gene;
import it.unimib.disco.bimib.cyTRON.model.Sample;
import it.unimib.disco.bimib.cyTRON.model.Type;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class DatasetController {
        
    public static final String GENOTYPES = "genotypes";
    public static final String GISTIC = "GISTIC";
    public static final String MAF = "MAF";
    
    public static final String EVENTS = "Events";
    public static final String SAMPLES = "Samples";
    
    private final DefaultListModel<Dataset> datasetsListModel;
    private final DefaultListModel<Gene> genesListModel;
    private final DefaultListModel<Type> typesListModel;
    private final DefaultListModel<Sample> sampleListModel;
    
    public DatasetController() {
        datasetsListModel = new DefaultListModel();
        genesListModel = new DefaultListModel();
        typesListModel = new DefaultListModel();
        sampleListModel = new DefaultListModel();
    }
    
    // ************ DATASETS ************ \\
    public void importDataset(String name, String path, String type) {
        // check name input
        name = name.trim();
        name = name.replace(" ", "_");
        if (name.isEmpty()) {
            return;
        }
        
        // check path input
        if (path.isEmpty()) {
            return;
        }
        
        // check if the corresponding file exists
        File datasetFile = new File(path);
        if (!datasetFile.exists()) {
            return;
        }
        
        try {
            // create the new dataset
            Dataset dataset = new Dataset(name, datasetFile.getCanonicalPath(), type);
            
            // add it to the list
            datasetsListModel.addElement(dataset);
        } catch (IOException ex) {
            Logger.getLogger(DatasetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteDataset(int datasetIndex) {
        // remove the dataset from the model
        Dataset dataset = datasetsListModel.remove(datasetIndex);
        
        // delete the R object
        dataset.deleteDataset();
    }
    
    public void bind(int datasetIndex1, int datasetIndex2, String newName, String bind) {
    	
    }
    
    // ************ GENES ************ \\
    public void renameGene(int geneIndex, int datasetIndex, String newName) {
        // get the gene and the dataset
        Gene gene = genesListModel.get(geneIndex);
        Dataset dataset = datasetsListModel.get(datasetIndex);
        
        // rename the gene
        dataset.renameGene(gene, newName);
        // TODO: update other variables
    }
    
    public void deleteGene(int geneIndex, int datasetIndex) {
        // get the gene and the dataset
        Gene gene = genesListModel.get(geneIndex);
        Dataset dataset = datasetsListModel.get(datasetIndex);
        
        // remove the gene in the dataset
        dataset.deleteGene(gene);
        
        // remove the gene from the list model
        genesListModel.remove(geneIndex);
        // TODO: update other variables
    }
    
    // ************ TYPES ************ \\
    public void renameType(int typeIndex, int datasetIndex, String newName) {
        // get the gene and the dataset
        Type type = typesListModel.get(typeIndex);
        Dataset dataset = datasetsListModel.get(datasetIndex);
        
        // rename the gene
        dataset.renameType(type, newName);
        // TODO: update other variables
    }
    
    public void deleteType(int typeIndex, int datasetIndex) {
        // get the type and the dataset
        Type type = typesListModel.get(typeIndex);
        Dataset dataset = datasetsListModel.get(datasetIndex);
        
        // remove the type in the dataset
        dataset.deleteType(type);
        
        // remove the type from the list model
        typesListModel.remove(typeIndex);
        // TODO: update other variables
    }
    
    public void joinTypes(int typeIndex1, int typeIndex2, int datasetIndex, String newName) {
    	// get the typed and the dataset
        Type type1 = typesListModel.get(typeIndex1);
        Type type2 = typesListModel.get(typeIndex2);
        Dataset dataset = datasetsListModel.get(datasetIndex);
        
        // join the types in the dataset
        dataset.joinTypes(type1, type2, newName);
        
        // remove the second type from the list
        typesListModel.remove(typeIndex2);
        // TODO: update other variables
    }
    
    // ************ SAMPLES ************ \\
    public void deleteSample(int sampleIndex, int datasetIndex) {
        // get the type and the dataset
        Sample sample = sampleListModel.get(sampleIndex);
        Dataset dataset = datasetsListModel.get(datasetIndex);
        
        // remove the type in the dataset
        dataset.deleteSample(sample);
        
        // remove the type from the list model
        sampleListModel.remove(sampleIndex);
        // TODO: update other variables
    }
    
    // ************ LIST UPDATES ************ \\
    public void updateLists(int index) {
        // get the dataset
        Dataset dataset = datasetsListModel.get(index);
        
        // update genes list
        updateGenesList(dataset);
        
        // update types list
        updateTypesList(dataset);
        
        // update samples list
        updateSamplesList(dataset);
    }
 
    private void updateGenesList(Dataset dataset) {
    	genesListModel.clear();
        for (Gene gene : dataset.getGenes()) {
            genesListModel.addElement(gene);
        }
    }
    
    private void updateTypesList(Dataset dataset) {
    	typesListModel.clear();
        for (Type type : dataset.getTypes()) {
            typesListModel.addElement(type);
        }
    }
    
    private void updateSamplesList(Dataset dataset) {
    	sampleListModel.clear();
        for (Sample sample : dataset.getSamples()) {
            sampleListModel.addElement(sample);
        }
    }
    
    // ************ LIST GETTERS ************ \\
    public DefaultListModel getDatasetsListModel() {
        return datasetsListModel;
    }
    
    public DefaultListModel getGenesListModel() {
        return genesListModel;
    }
    
    public DefaultListModel getTypesListModel() {
        return typesListModel;
    }
    
    public DefaultListModel getSampltListModel() {
        return sampleListModel;
    }
    
}
