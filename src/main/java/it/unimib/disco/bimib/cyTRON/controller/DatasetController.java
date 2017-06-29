package it.unimib.disco.bimib.cyTRON.controller;

import it.unimib.disco.bimib.cyTRON.model.Dataset;
import it.unimib.disco.bimib.cyTRON.model.Event;
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
    private final DefaultListModel<Sample> samplesListModel;
    private final DefaultListModel<Event> eventsListModel;
    
    public DatasetController() {
        datasetsListModel = new DefaultListModel<>();
        genesListModel = new DefaultListModel<>();
        typesListModel = new DefaultListModel<>();
        samplesListModel = new DefaultListModel<>();
        eventsListModel = new DefaultListModel<>();
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
        
        // clear the lists
        samplesListModel.clear();
        genesListModel.clear();
        typesListModel.clear();
        eventsListModel.clear();
    }
    
    public void bind(int datasetIndex1, int datasetIndex2, String newName, String bind) {
    	// get the datasets
        Dataset dataset1 = datasetsListModel.get(datasetIndex1);
        Dataset dataset2 = datasetsListModel.get(datasetIndex2);
        
        // execute the bind
        if (bind.equals(SAMPLES)) {
			dataset1.bindSamples(dataset2, newName);
		} else if (bind.equals(EVENTS)) {
			dataset1.bindEvents(dataset2, newName);
		}
        
        // remove the second dataset form the list model and from R
        datasetsListModel.remove(datasetIndex2);
        dataset2.deleteDataset();
        
        // update the lists
        updateLists(datasetIndex1);
    }
    
    public void intersect(int datasetIndex1, int datasetIndex2, String newName) {
    	// get the datasets
        Dataset dataset1 = datasetsListModel.get(datasetIndex1);
        Dataset dataset2 = datasetsListModel.get(datasetIndex2);
        
        // execute the intersection
        dataset1.intersect(dataset2, newName);
        
        // remove the second dataset form the list model and from R
        datasetsListModel.remove(datasetIndex2);
        dataset2.deleteDataset();
        
        // update the lists
        updateLists(datasetIndex1);
    }
    
    // ************ SAMPLES ************ \\
    public void deleteSample(int sampleIndex, int datasetIndex) {
        // get the sample and the dataset
        Sample sample = samplesListModel.get(sampleIndex);
        Dataset dataset = datasetsListModel.get(datasetIndex);
        
        // remove the sample in the dataset
        dataset.deleteSample(sample);
        
        // remove the sample from the list model
        samplesListModel.remove(sampleIndex);
    }
    
    public void selectSamples(int[] samplesIndex, int datasetIndex) {
    	// get the samples and the dataset
    	Sample[] samples = new Sample[samplesIndex.length];
    	for (int i = 0; i < samplesIndex.length; i++) {
    		samples[i] = samplesListModel.get(samplesIndex[i]);
		}
    	Dataset dataset = datasetsListModel.get(datasetIndex);
    	
    	// select the samples
    	dataset.samplesSelection(samples);
    	
    	// update the sample list
    	updateSamplesList(dataset);
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
        
        // update lists
        updateGenesList(dataset);
        updateTypesList(dataset);
        updateEventsList(dataset);
    }
    
    // ************ TYPES ************ \\
    public void renameType(int typeIndex, int datasetIndex, String newName) {
        // get the gene and the dataset
        Type type = typesListModel.get(typeIndex);
        Dataset dataset = datasetsListModel.get(datasetIndex);
        
        // rename the gene
        dataset.renameType(type, newName);
    }
    
    public void deleteType(int typeIndex, int datasetIndex) {
        // get the type and the dataset
        Type type = typesListModel.get(typeIndex);
        Dataset dataset = datasetsListModel.get(datasetIndex);
        
        // remove the type in the dataset
        dataset.deleteType(type);
        
        // update lists
        updateGenesList(dataset);
        updateTypesList(dataset);
        updateEventsList(dataset);
    }
    
    public void joinTypes(int typeIndex1, int typeIndex2, int datasetIndex, String newName) {
    	// get the typed and the dataset
        Type type1 = typesListModel.get(typeIndex1);
        Type type2 = typesListModel.get(typeIndex2);
        Dataset dataset = datasetsListModel.get(datasetIndex);
        
        // join the types in the dataset
        dataset.joinTypes(type1, type2, newName);
        
        // update lists
        updateGenesList(dataset);
        updateTypesList(dataset);
        updateEventsList(dataset);
    }
    
    // ************ EVENTS ************ \\
    public void deleteEvent(int eventIndex, int datasetIndex) {
        // get the event and the dataset
        Event event = eventsListModel.get(eventIndex);
        Dataset dataset = datasetsListModel.get(datasetIndex);
        
        // remove the event in the dataset
        dataset.deleteEvent(event);
        
        // update lists
        updateGenesList(dataset);
        updateTypesList(dataset);
        updateEventsList(dataset);
    }
    
    public void joinEvents(int eventIndex1, int eventIndex2, int datasetIndex, String geneName, String typeName, String colorName) {
    	// get the event and the dataset
        Event event1 = eventsListModel.get(eventIndex1);
        Event event2 = eventsListModel.get(eventIndex2);
        Dataset dataset = datasetsListModel.get(datasetIndex);
        
        // join the events in the dataset
        dataset.joinEvents(event1, event2, geneName, typeName, colorName);
        
        // update lists
        updateGenesList(dataset);
        updateTypesList(dataset);
        updateEventsList(dataset);
    }
    
    public void selectEvents(String frequence, int[] selectedEventsIndex, int[] filteredEventsIndex, int datasetIndex) {
    	// get the events and the dataset
    	Event[] selectedEvents = new Event[selectedEventsIndex.length];
    	for (int i = 0; i < selectedEventsIndex.length; i++) {
    		selectedEvents[i] = eventsListModel.get(selectedEventsIndex[i]);
		}
    	Event[] filteredEvents = new Event[filteredEventsIndex.length];
    	for (int i = 0; i < filteredEventsIndex.length; i++) {
    		filteredEvents[i] = eventsListModel.get(filteredEventsIndex[i]);
		}
    	Dataset dataset = datasetsListModel.get(datasetIndex);
    	
    	// select the samples
    	dataset.eventsSelection(frequence, selectedEvents, filteredEvents);
    	
    	// update lists
        updateGenesList(dataset);
        updateTypesList(dataset);
        updateEventsList(dataset);
    }
    
    public void trim(int datasetIndex) {
    	// get the dataset
    	Dataset dataset = datasetsListModel.get(datasetIndex);
    	
    	// trim the events
    	dataset.trim();
    	
    	// update lists
        updateGenesList(dataset);
        updateTypesList(dataset);
        updateEventsList(dataset);
    }
    
    // ************ LIST UPDATES ************ \\
    public void updateLists(int datasetIndex) {
        // get the dataset
        Dataset dataset = datasetsListModel.get(datasetIndex);
        
        // update samples list
        updateSamplesList(dataset);
        
        // update genes list
        updateGenesList(dataset);
        
        // update types list
        updateTypesList(dataset);
        
        // update samples list
        updateEventsList(dataset);
    }
 
    private void updateSamplesList(Dataset dataset) {
    	samplesListModel.clear();
        for (Sample sample : dataset.getSamples()) {
            samplesListModel.addElement(sample);
        }
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
    
    private void updateEventsList(Dataset dataset) {
    	eventsListModel.clear();
        for (Event event : dataset.getEvents()) {
        	eventsListModel.addElement(event);
        }
    }
    
    // ************ LIST GETTERS ************ \\
	@SuppressWarnings("rawtypes")
	public DefaultListModel getDatasetsListModel() {
        return datasetsListModel;
    }
    
    @SuppressWarnings("rawtypes")
	public DefaultListModel getGenesListModel() {
        return genesListModel;
    }
    
    @SuppressWarnings("rawtypes")
	public DefaultListModel getTypesListModel() {
        return typesListModel;
    }
    
    @SuppressWarnings("rawtypes")
	public DefaultListModel getSamplesListModel() {
        return samplesListModel;
    }
    
    @SuppressWarnings("rawtypes")
	public DefaultListModel getEventsListModel() {
        return eventsListModel;
    }
}
