package it.unimib.disco.bimib.cyTRON.controller;

import it.unimib.disco.bimib.cyTRON.model.Dataset;
import it.unimib.disco.bimib.cyTRON.model.Gene;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class DatasetController {
        
    public static final String GENOTYPES = "genotypes";
    public static final String GISTIC = "GISTIC";
    public static final String MAF = "MAF";
    
    private final DefaultListModel<Dataset> datasetsListModel;
    private final DefaultListModel<Gene> genesListModel;
    
    public DatasetController() {
        datasetsListModel = new DefaultListModel();
        genesListModel = new DefaultListModel();
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
    
    // ************ GENES ************ \\
    public void renameGene(int geneIndex, int datasetIndex, String newName) {
        // get the gene and the dataset
        Gene gene = genesListModel.get(geneIndex);
        Dataset dataset = datasetsListModel.get(datasetIndex);
        
        // rename the gene
        dataset.renameGene(gene, newName);
    }
    
    public void deleteGene(int geneIndex, int datasetIndex) {
        // get the gene and the dataset
        Gene gene = genesListModel.get(geneIndex);
        Dataset dataset = datasetsListModel.get(datasetIndex);
        
        // remove the gene in the dataset
        dataset.deleteGene(gene);
        
        // remove the gene from the list model
        genesListModel.remove(geneIndex);
    }
    
    // ************ OTHERS ************ \\
    public void updateLists(int index) {
        // get the dataset
        Dataset dataset = datasetsListModel.get(index);
        
        // update genes list
        genesListModel.clear();
        for (Gene gene : dataset.getGenes()) {
            genesListModel.addElement(gene);
        }
    }
    
    public DefaultListModel getDatasetsListModel() {
        return datasetsListModel;
    }
    
    public DefaultListModel getGenesListModel() {
        return genesListModel;
    }
    
}
