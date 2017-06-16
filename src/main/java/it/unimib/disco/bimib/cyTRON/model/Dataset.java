package it.unimib.disco.bimib.cyTRON.model;

import org.rosuda.JRI.REXP;

import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.model.R.RConnectionManager;
import java.util.HashSet;
import java.util.Set;

public class Dataset {
    
    private String name;
    private String path;
    
    private Set<Gene> genes;
    private Set<Type> types;
    private Set<Sample> samples;
    
    public Dataset(String name, String path, String type) {
        this.name = name;
        this.path = path;
    	
    	switch (type) {
            case DatasetController.GENOTYPES:
                importGenotypes(name, path);
                break;
            case DatasetController.GISTIC:
                importGistic(name, path);
                break;
            case DatasetController.MAF:
                importMaf(name, path);
                break;
            default:
                break;
        }
    	
    	retrieveGenes();
    	retrieveTypes();
    	retrieveSamples();
    }
    
    public void deleteDataset() {
        // create and execute the command
        String command = "rm(" + name + ")";
        RConnectionManager.eval(command);
    }
    
    private void importGenotypes(String name, String path) {
        // create and execute the command
        String command = name + " = import.genotypes('" + path + "')";
        RConnectionManager.eval(command);
    }
    
    private void importGistic(String name, String path) {
        // create and execute the command
        String command = name + " = import.GISTIC('" + path + "')";
        RConnectionManager.eval(command);
    }
    
    private void importMaf(String name, String path) {
        // create and execute the command
        String command = name + " = import.MAF('" + path + "', sep = ';')";
        
        RConnectionManager.eval(command);
    }
    
    // ************ GENES ************ \\
    private void retrieveGenes() {
    	// initialize the structure
    	genes = new HashSet();
    	
    	// create and execute the command
        String command = "as.genes(" + name + ")";
        REXP rexp = RConnectionManager.eval(command);
        
        // get the names of the genes
        String[] names = rexp.asStringArray();
        
        // instantiate the genes and add them to the map
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            genes.add(new Gene(name));
        }
    }
    
    public void renameGene(Gene gene, String newName) {
    	// create and execute the command
        String command = name + " = rename.gene(" + name + ", '" + gene.getName() + "', '" + newName + "')";
        RConnectionManager.eval(command);
        
        // rename the gene
        gene.setName(newName);
        // TODO: update other variables
    }
    
    public void deleteGene(Gene gene) {
    	// create and execute the command
        String command = this.name + " = delete.gene(" + name + ", '" + gene.getName() + "')";
        RConnectionManager.eval(command);
        
        // delete the gene from the set
        genes.remove(gene);
        // TODO: update other variables
    }
    
    public Set<Gene> getGenes() {
        return genes;
    }
    
    // ************ TYPES ************ \\
    private void retrieveTypes() {
    	// initialize the structure
    	types = new HashSet();
    	
    	// create and execute the command
        String command = "as.types(" + name + ")";
        REXP rexp = RConnectionManager.eval(command);
        
        // get the names of the genes
        String[] names = rexp.asStringArray();
        
        // instantiate the genes and add them to the map
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            types.add(new Type(name));
        }
    }
    
    public void renameType(Type type, String newName) {
    	// create and execute the command
        String command = name + " = rename.type(" + name + ", '" + type.getName() + "', '" + newName + "')";
        RConnectionManager.eval(command);
        
        // rename the type
        type.setName(newName);
        // TODO: update other variables
    }
    
    public void deleteType(Type type) {
    	// create and execute the command
        String command = this.name + " = delete.type(" + name + ", '" + type.getName() + "')";
        RConnectionManager.eval(command);
        
        // delete the type from the set
        types.remove(type);
        // TODO: update other variables
    }
    
    public void joinTypes(Type type1, Type type2, String newName) {
    	// create and execute the command
        String command = "join.types(" + name + ", '" + type1.getName() + "', '" + type2.getName() + "', new.type='" + newName + "')";
        RConnectionManager.eval(command);
    	
        // rename the first type
        type1.setName(newName);
        // remove the second type
        types.remove(type2);
        // TODO: update other variables
    }
    
    public Set<Type> getTypes() {
        return types;
    } 
    
    // ************ SAMPLES ************ \\
    private void retrieveSamples() {
    	// initialize the structure
    	samples = new HashSet();
    	
    	// create and execute the command
        String command = "as.samples(" + name + ")";
        REXP rexp = RConnectionManager.eval(command);
        
        // get the names of the genes
        String[] names = rexp.asStringArray();
        
        // instantiate the genes and add them to the map
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            samples.add(new Sample(name));
        }
    }
    
    public void deleteSample(Sample sample) {
    	// create and execute the command
        String command = this.name + " = delete.samples(" + name + ", c('" + sample.getName() + "'))";
        RConnectionManager.eval(command);
        
        // delete the type from the set
        samples.remove(sample);
        // TODO: update other variables
    }
    
    public Set<Sample> getSamples() {
        return samples;
    } 
    
    @Override
    public String toString() {
        return name;
    }
    
}
