package it.unimib.disco.bimib.cyTRON.controller;

import it.unimib.disco.bimib.cyTRON.R.RConnectionManager;
import it.unimib.disco.bimib.cyTRON.model.Dataset;
import it.unimib.disco.bimib.cyTRON.model.Event;
import it.unimib.disco.bimib.cyTRON.model.Gene;
import it.unimib.disco.bimib.cyTRON.model.Sample;
import it.unimib.disco.bimib.cyTRON.model.Type;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.swing.DefaultListModel;

public class DatasetController {

	public static final String GENOTYPES = "genotypes";
	public static final String GISTIC = "GISTIC";
	public static final String MAF = "MAF";
	public static final String LOAD = "load";

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
	public void importDataset(String name, String path, String type) throws FileNotFoundException {
		// validate name input
		name = name.trim();
		name = name.replace(" ", "_");

		// check if the corresponding file exists
		File datasetFile = new File(path);
		if (!datasetFile.exists()) {
			throw new FileNotFoundException();
		}

		try {
			// create the new dataset
			Dataset dataset = new Dataset(name, datasetFile.getCanonicalPath().replace("\\", "\\\\"), type);

			// if the last console message is regular
			if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
				// add it to the list
				datasetsListModel.addElement(dataset);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteDataset(int datasetIndex) {
		// get the dataset from the model
		Dataset dataset = datasetsListModel.get(datasetIndex);

		// delete the R object
		dataset.deleteDataset();

		// if the last console message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// get the dataset from the model
			datasetsListModel.remove(datasetIndex);

			// clear the lists
			samplesListModel.clear();
			genesListModel.clear();
			typesListModel.clear();
			eventsListModel.clear();
		}
	}

	public void bind(int datasetIndex1, int datasetIndex2, String newName, String bind) {
		// get the datasets
		Dataset dataset1 = datasetsListModel.get(datasetIndex1);
		Dataset dataset2 = datasetsListModel.get(datasetIndex2);

		// validate name input
		newName = newName.trim();
		newName = newName.replace(" ", "_");

		// execute the bind
		if (bind.equals(SAMPLES)) {
			dataset1.bindSamples(dataset2, newName);
		} else if (bind.equals(EVENTS)) {
			dataset1.bindEvents(dataset2, newName);
		}

		// if the last console message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// get the dataset from R
			Dataset dataset3 = new Dataset(newName);
			
			// if the last console message is regular
			if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
				// add the new dataset to the list
				datasetsListModel.addElement(dataset3);
			}
		}
	}

	public void intersect(int datasetIndex1, int datasetIndex2, String newName) {
		// get the datasets
		Dataset dataset1 = datasetsListModel.get(datasetIndex1);
		Dataset dataset2 = datasetsListModel.get(datasetIndex2);

		// validate name input
		newName = newName.trim();
		newName = newName.replace(" ", "_");

		// execute the intersection
		dataset1.intersect(dataset2, newName);

		// if the last console message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// get the dataset from R
			Dataset dataset3 = new Dataset(newName);
			
			// if the last console message is regular
			if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
				// add the new dataset to the list
				datasetsListModel.addElement(dataset3);
			}
		}
	}

	public boolean save(Dataset dataset, String name, String path, boolean force) {
		// validate the path
		path = path.replace("\\", "\\\\") + File.separator + name + ".rds";
		
		// return if the file already exists
		File file = new File(path);
		if (file.exists() && !force) {
			return false;
		}

		// save the dataset
		dataset.save(path);
		return true;
	}
	
	public void renameDataset(int datasetIndex, String newName) {
		// get the dataset
		Dataset dataset = datasetsListModel.get(datasetIndex);
		
		// validate name input
		newName = newName.trim();
		newName = newName.replace(" ", "_");
		
		// execute the rename
		dataset.rename(newName);
	}
	
	public void duplicateDataset(int datasetIndex, String newName) {
		// get the dataset
		Dataset dataset = datasetsListModel.get(datasetIndex);
		
		// validate name input
		newName = newName.trim();
		newName = newName.replace(" ", "_");
		
		// execute the duplication
		dataset.duplicate(newName);
		
		// if the last console message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// add the new dataset to the list
			Dataset newDataset = new Dataset(newName);
			datasetsListModel.addElement(newDataset);
		}
	}

	// ************ SAMPLES ************ \\
	public void deleteSample(int sampleIndex, int datasetIndex) {
		// get the sample and the dataset
		Sample sample = samplesListModel.get(sampleIndex);
		Dataset dataset = datasetsListModel.get(datasetIndex);

		// remove the sample in the dataset
		dataset.deleteSample(sample);

		// if the last console message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// remove the sample from the list model
			samplesListModel.remove(sampleIndex);
		}
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

		// if the last console message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// update the sample list
			updateSamplesList(dataset);
		}
	}
	
	public void filterSamples(int datasetIndex, String filter) {
		// get the dataset
		Dataset dataset = datasetsListModel.get(datasetIndex);
		
		// execute the filtering
		for (Sample sample : dataset.getSamples()) {
			if (!sample.getName().toLowerCase().startsWith(filter)) {
				if (samplesListModel.contains(sample)) {
					samplesListModel.removeElement(sample);
				}
			} else {
				if (!samplesListModel.contains(sample)) {
					samplesListModel.addElement(sample);
				}
			}
		}
	}

	// ************ TCGA ************ \\
	public int[] selectMultipleSamples(int datasetIndex) {
		// get the dataset
		Dataset dataset = datasetsListModel.get(datasetIndex);

		// get the multiple samples
		List<Sample> multipleSamples = dataset.getMultipleSamples();

		// get the indexes of the multiple samples
		int[] multipleSamplesIndexes = new int[multipleSamples.size()];
		for (int i = 0; i < multipleSamples.size(); i++) {
			multipleSamplesIndexes[i] = samplesListModel.indexOf(multipleSamples.get(i));
		}

		return multipleSamplesIndexes;
	}

	public void removeMultipleSamples(int datasetIndex) {
		// get the dataset
		Dataset dataset = datasetsListModel.get(datasetIndex);

		// remove the multiple samples
		dataset.removeMultipleSamples();

		// if the last console message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// update the sample list
			updateSamplesList(dataset);
		}
	}

	public void shortenBarcodes(int datasetIndex) {
		// get the dataset
		Dataset dataset = datasetsListModel.get(datasetIndex);

		// shorten the barcodes of the dataset
		dataset.shortenBarcodes();

		// if the last console message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// update the sample list
			updateSamplesList(dataset);
		}
	}

	// ************ GENES ************ \\
	public void renameGene(int geneIndex, int datasetIndex, String newName) {
		// get the gene and the dataset
		Gene gene = genesListModel.get(geneIndex);
		Dataset dataset = datasetsListModel.get(datasetIndex);

		// validate name input
		newName = newName.trim();
		newName = newName.replace(" ", "_");

		// if the last console message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// rename the gene
			dataset.renameGene(gene, newName);
		}
	}

	public void deleteGene(int geneIndex, int datasetIndex) {
		// get the gene and the dataset
		Gene gene = genesListModel.get(geneIndex);
		Dataset dataset = datasetsListModel.get(datasetIndex);

		// remove the gene in the dataset
		dataset.deleteGene(gene);

		// if the last console message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// update lists
			updateGenesList(dataset);
			updateTypesList(dataset);
			updateEventsList(dataset);
		}
	}
	
	public void filterGenes(int datasetIndex, String filter) {
		// get the dataset
		Dataset dataset = datasetsListModel.get(datasetIndex);
		
		// execute the filtering
		for (Gene gene : dataset.getGenes()) {
			if (!gene.getName().toLowerCase().startsWith(filter)) {
				if (genesListModel.contains(gene)) {
					genesListModel.removeElement(gene);
				}
			} else {
				if (!genesListModel.contains(gene)) {
					genesListModel.addElement(gene);
				}
			}
		}
	}

	// ************ TYPES ************ \\
	public void renameType(int typeIndex, int datasetIndex, String newName) {
		// get the gene and the dataset
		Type type = typesListModel.get(typeIndex);
		Dataset dataset = datasetsListModel.get(datasetIndex);

		// validate name input
		newName = newName.trim();
		newName = newName.replace(" ", "_");

		// rename the gene
		dataset.renameType(type, newName);
	}

	public void deleteType(int typeIndex, int datasetIndex) {
		// get the type and the dataset
		Type type = typesListModel.get(typeIndex);
		Dataset dataset = datasetsListModel.get(datasetIndex);

		// remove the type in the dataset
		dataset.deleteType(type);

		// if the last console message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// update lists
			updateGenesList(dataset);
			updateTypesList(dataset);
			updateEventsList(dataset);
		}
	}

	public void joinTypes(int typeIndex1, int typeIndex2, int datasetIndex, String newName) {
		// get the typed and the dataset
		Type type1 = typesListModel.get(typeIndex1);
		Type type2 = typesListModel.get(typeIndex2);
		Dataset dataset = datasetsListModel.get(datasetIndex);

		// validate name input
		newName = newName.trim();
		newName = newName.replace(" ", "_");

		// join the types in the dataset
		dataset.joinTypes(type1, type2, newName);

		// if the last console message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// update lists
			updateGenesList(dataset);
			updateTypesList(dataset);
			updateEventsList(dataset);
		}
	}

	// ************ EVENTS ************ \\
	public void deleteEvent(int eventIndex, int datasetIndex) {
		// get the event and the dataset
		Event event = eventsListModel.get(eventIndex);
		Dataset dataset = datasetsListModel.get(datasetIndex);

		// remove the event in the dataset
		dataset.deleteEvent(event);

		// if the last console message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// update lists
			updateGenesList(dataset);
			updateTypesList(dataset);
			updateEventsList(dataset);
		}
	}

	public void joinEvents(int eventIndex1, int eventIndex2, int datasetIndex, String geneName, String typeName,
			String colorName) {
		// get the event and the dataset
		Event event1 = eventsListModel.get(eventIndex1);
		Event event2 = eventsListModel.get(eventIndex2);
		Dataset dataset = datasetsListModel.get(datasetIndex);

		// validate input
		geneName = geneName.trim();
		geneName = geneName.replace(" ", "_");
		typeName = typeName.trim();
		typeName = typeName.replace(" ", "_");
		colorName = colorName.trim();
		colorName = colorName.replace(" ", "_");

		// join the events in the dataset
		dataset.joinEvents(event1, event2, geneName, typeName, colorName);

		// if the last console message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// update lists
			updateGenesList(dataset);
			updateTypesList(dataset);
			updateEventsList(dataset);
		}
	}

	public void selectEvents(Float frequence, int[] selectedEventsIndex, int[] filteredEventsIndex, int datasetIndex) {
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

		// if the last console message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// update lists
			updateGenesList(dataset);
			updateTypesList(dataset);
			updateEventsList(dataset);
		}
	}

	public void trim(int datasetIndex) {
		// get the dataset
		Dataset dataset = datasetsListModel.get(datasetIndex);

		// trim the events
		dataset.trim();

		// if the last console message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// update lists
			updateGenesList(dataset);
			updateTypesList(dataset);
			updateEventsList(dataset);
		}
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

	public void updateLists(Dataset dataset) {
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

	public DefaultListModel<Gene> getGenesListModel() {
		return genesListModel;
	}

	public DefaultListModel<Type> getTypesListModel() {
		return typesListModel;
	}

	public DefaultListModel<Sample> getSamplesListModel() {
		return samplesListModel;
	}

	@SuppressWarnings("rawtypes")
	public DefaultListModel getEventsListModel() {
		return eventsListModel;
	}
}
