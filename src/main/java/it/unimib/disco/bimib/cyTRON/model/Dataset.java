package it.unimib.disco.bimib.cyTRON.model;

import org.rosuda.JRI.REXP;

import it.unimib.disco.bimib.cyTRON.R.RConnectionManager;
import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.controller.StatisticsController;
import it.unimib.disco.bimib.cyTRON.controller.ToStringComparator;
import it.unimib.disco.bimib.cyTRON.view.DeleteHypothesesFrame;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Dataset {
	
	public static final String PATTERN = "Pattern"; 
    
    private String name;

	private Map<String, Gene> genes;
    private Map<String, Type> types;
    private Map<String, Sample> samples;
    private Map<String, Event> events;
    private Map<String, Pattern> patterns;
    private String description;
    private boolean hasStagesAnnotation;
    private Inference inference;
    
    public Dataset(String name, String path, String type) {
        this.name = name;
        genes = new HashMap<>();
        types = new HashMap<>();
        samples = new HashMap<>();
        events = new HashMap<>();
        patterns = new HashMap<>();
        description = "";
        hasStagesAnnotation = false;
        inference = new Inference();
    	
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
            case DatasetController.LOAD:
                load(name, path);
                break;
            default:
                break;
        }
    	
    	// if the last console message is regular
    	if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
    		retrieveSamples();
        	retrieveEvents();
        	if (type.equals(DatasetController.LOAD)) {
    			retrievePatterns();
    			retrieveInference();
    			retrieveStatistics();
    		}
    	}
    }
    
    public void deleteDataset() {
        // create and execute the command
        String command = "rm(" + name + ")";
        RConnectionManager.eval(command);
    }
    
    public void save(String path) {
    	// create and execute the command
        String command = "saveRDS(" + name + ", '" + path + "')";
        RConnectionManager.eval(command);
    }
    
    private void load(String name, String path){
    	// create and execute the command
        String command = name + " = readRDS('" + path + "')";
        RConnectionManager.eval(command);
    }
    
    private void importGenotypes(String name, String path){
        // create and execute the command
        String command = name + " = import.genotypes('" + path + "')";
        RConnectionManager.eval(command);
    }
    
    private void importGistic(String name, String path){
        // create and execute the command
        String command = name + " = import.GISTIC('" + path + "', silent=TRUE)";
        RConnectionManager.eval(command);
    }
    
    private void importMaf(String name, String path){
        // create and execute the command
        String command = name + " = import.MAF('" + path + "', sep = ';', silent=TRUE)";
        RConnectionManager.eval(command);
    }
    
    public void bindSamples(Dataset dataset, String newName) {
    	// create and execute the command
        String command = newName + " = sbind(c(" + name + ", " + dataset.getName() + "))";
        RConnectionManager.eval(command);
        
    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
        	// delete the old R object
        	command = "rm(" + name + ")";
            RConnectionManager.eval(command);
            
            // update the name
            name = newName;
            
            // update the samples and the events
            retrieveSamples();
            retrieveEvents();
        }
    }
    
    public void bindEvents(Dataset dataset, String newName) {
    	// create and execute the command
        String command = newName + " = ebind(c(" + name + ", " + dataset.getName() + "), silent=TRUE)";
        RConnectionManager.eval(command);
        
        // if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
        	// delete the old R object
	        command = "rm(" + name + ")";
	        RConnectionManager.eval(command);
	        
	        // update the name
	        name = newName;
	        
	        // update the samples and the events
	        retrieveSamples();
	        retrieveEvents();
        }
    }
    
    public void intersect(Dataset dataset, String newName) {
    	// create and execute the command
        String command = newName + " = intersect.datasets(" + name + ", " + dataset.getName() + ")";
        RConnectionManager.eval(command);
        
        // if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
        	// delete the old R object
	        command = "rm(" + name + ")";
	        RConnectionManager.eval(command);
	        
	        // update the name
	        name = newName;
	        
	        // update the samples and the events
	        retrieveSamples();
	        retrieveEvents();
        }
    }
    
    // ************ SAMPLES ************ \\
    private void retrieveSamples() {
    	// initialize the structure
    	samples = new HashMap<>();
    	
    	// create and execute the command
        String command = "as.samples(" + name + ")";
        REXP rexp = RConnectionManager.eval(command);
        
    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
        	// get the names of the genes
            String[] names = rexp.asStringArray();
            
            // if the output of R is null
            if (names == null) {
            	// return
    			return;
    		}
            
        	// instantiate the genes and add them to the map
        	for (int i = 0; i < names.length; i++) {
                String name = names[i];
                samples.put(name, new Sample(name));
        	}
        } else {
        	// clean the console
        	RConnectionManager.getTextConsole().getLastConsoleMessage();
        }
    }
    
    public void deleteSample(Sample sample) {
    	// create and execute the command
        String command = name + " = delete.samples(" + name + ", c('" + sample.getName() + "'))";
        RConnectionManager.eval(command);
        
    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
        	// delete the sample from the map
            samples.remove(sample.getName());
        }
    }
    
    public void samplesSelection(Sample[] samples) {
    	// create and execute the command
        String command = name + " = samples.selection(" + name + ", c(";
        for (int i = 0; i < samples.length; i++) {
        	command += "'" + samples[i].getName() + "'";
        	if (i < samples.length - 1) {
        		command += ", ";
        	}
		}
        command += "))";
        RConnectionManager.eval(command);
        
    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
        	// reload the samples
            retrieveSamples();
        }
    }
    
    public Collection<Sample> getSamples() {
    	// order and return the list
    	List<Sample> samplesList = new ArrayList<>(samples.values());
    	Collections.sort(samplesList, new ToStringComparator());
    	return samplesList;
    }
    
    // ************ TCGA ************ \\
    public List<Sample> getMultipleSamples() {
    	// create and execute the command
        String command = "TCGA.multiple.samples(" + name + ")";
        REXP rexp = RConnectionManager.eval(command);
        
        // get the multiple samples
        String[] multipleSamplesNames = rexp.asStringArray();
        List<Sample> multipleSamples = new ArrayList<>();
        if (multipleSamplesNames != null && multipleSamplesNames.length > 1) {
        	for (int i = 0; i < multipleSamplesNames.length; i++) {
        		multipleSamples.add(samples.get(multipleSamplesNames[i]));
			}
		}
        
        // return the result list
        return multipleSamples;
    }
    
    public void removeMultipleSamples() {
    	// create and execute the command
        String command = name + " = TCGA.remove.multiple.samples(" + name + ")";
        RConnectionManager.eval(command);
        
    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
        	// reload the samples
            retrieveSamples();
        }
    }
    
    public void shortenBarcodes() {
    	// create and execute the command
        String command = name + " = TCGA.shorten.barcodes(" + name + ")";
        RConnectionManager.eval(command);
        
    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
            // reload the samples
            retrieveSamples();
        }
    }
    
    // ************ GENES ************ \\    
    public void renameGene(Gene gene, String newName) {
    	// create and execute the command
        String command = name + " = rename.gene(" + name + ", '" + gene.getName() + "', '" + newName + "')";
        RConnectionManager.eval(command);
        
    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
            // rename the gene
            gene.setName(newName);
        }
    }
    
    public void deleteGene(Gene gene) {
    	// create and execute the command
        String command = name + " = delete.gene(" + name + ", '" + gene.getName() + "')";
        RConnectionManager.eval(command);
        
    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
        	// delete the gene from the map
            genes.remove(gene.getName());
        	
            // reload the events
            retrieveEvents();
        }
    }
    
    public Collection<Gene> getGenes() {
    	// order and return the list
    	List<Gene> genesList = new ArrayList<>(genes.values());
    	Collections.sort(genesList, new ToStringComparator());
    	return genesList;
    }
    
    // ************ TYPES ************ \\    
    public void renameType(Type type, String newName) {
    	// create and execute the command
        String command = name + " = rename.type(" + name + ", '" + type.getName() + "', '" + newName + "')";
        RConnectionManager.eval(command);
        
    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
            // rename the type
            type.setName(newName);
        }
    }
    
    public void deleteType(Type type) {
    	// create and execute the command
        String command = name + " = delete.type(" + name + ", '" + type.getName() + "')";
        RConnectionManager.eval(command);
        
        // delete the type from the map
        types.remove(type.getName());
        
    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
            // reload the events
            retrieveEvents();
        }
    }
    
    public void joinTypes(Type type1, Type type2, String newName) {
    	// create and execute the command
        String command = name + " = join.types(" + name + ", '" + type1.getName() + "', '" + type2.getName() + "', new.type='" + newName + "', silent=TRUE)";
        RConnectionManager.eval(command);
        
    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
            // reload the events
            retrieveEvents();
        }
    }
    
    public Collection<Type> getTypes() {
    	// order and return the list
    	List<Type> typesList = new ArrayList<>(types.values());
    	Collections.sort(typesList, new ToStringComparator());
    	return typesList;
    }
    
    // ************ EVENTS ************ \\
    private void retrieveEvents() {
    	// initialize the structures
    	events = new HashMap<>();
    	types = new HashMap<>();
    	genes = new HashMap<>();
    	
    	// create and execute the commands
    	String command = "row.names(as.events(" + name + "))";
        REXP rexp = RConnectionManager.eval(command);
        String commandAttributes = "as.events(" + name + ")";
        REXP rexpAttributes = RConnectionManager.eval(commandAttributes);
        
    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
        	// get the events and its attributes
            String[] names = rexp.asStringArray();
            String[] attributes = rexpAttributes.asStringArray();
            
            // if the output of R is null
            if (names == null || attributes == null) {
            	// return
    			return;
    		}
            
            // instantiate the events and add them to the map
            for (int i = 0; i < names.length; i++) {
            	// get the name, the type and the gene
            	String name = names[i];
            	String typeName = attributes[i];
            	String geneName = attributes[i + names.length];
            	
            	// get the type
            	Type type;
            	if (types.containsKey(typeName)) {
    				type = types.get(typeName);
    			} else {
    				type = new Type(typeName);
    				types.put(typeName, type);
    			}
            	
            	// get the gene
            	Gene gene;
            	if (genes.containsKey(geneName)) {
            		gene = genes.get(geneName);
    			} else {
    				gene = new Gene(geneName);
    				if (!typeName.equals(PATTERN)) {
    					genes.put(geneName, gene);
    				}
    			}
            	
            	// add the event
            	events.put(name, new Event(name, type, gene));
            }
        } else {
        	// clean the console
        	RConnectionManager.getTextConsole().getLastConsoleMessage();
        }
    }
    
    public void deleteEvent(Event event) {
    	// create and execute the command
        String command = name + " = delete.event(" + name + ", '" + event.getGene().getName() + "', '" + event.getType().getName() + "')";
        RConnectionManager.eval(command);
        
    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
        	// reload the events
            retrieveEvents();
        }
    }
    
    public void joinEvents(Event event1, Event event2, String geneName, String typeName, String colorName) {
    	// create and execute the command
    	String command = name + " = join.events(" + name + ", '" + event1.getName() + "', '" + event2.getName() +
    			"', new.event='" + geneName + "', new.type='" + typeName + "', event.color='" + colorName + "')";
    	RConnectionManager.eval(command);
    	
    	// if the last console message is regular
    	if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
    		// reload the events
            retrieveEvents();
    	}
    }
    
    public void eventsSelection(Float frequence, Event[] selectedEvents, Event[] filteredEvents) {
    	// create and execute the command
        String command = name + " = events.selection(" + name;
        if (frequence >= 0) {
			command += ", filter.freq=" + frequence.toString().replace(",", ".");
		}
        if (selectedEvents.length > 0) {
        	command += ", filter.in.names=c(";
        	for (int i = 0; i < selectedEvents.length; i++) {
        		command += "'" + selectedEvents[i].getGene().getName() + "'";
        		if (i < selectedEvents.length - 1) {
            		command += ", ";
            	}
			}
        	command += ")";
		}
        if (filteredEvents.length > 0) {
        	command += ", filter.out.names=c(";
        	for (int i = 0; i < filteredEvents.length; i++) {
        		command += "'" + filteredEvents[i].getGene().getName() + "'";
        		if (i < filteredEvents.length - 1) {
            		command += ", ";
            	}
			}
        	command += ")";
		}
        command += ", silent=TRUE)";
        RConnectionManager.eval(command);
        
    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
            // reload the events
            retrieveEvents();
        }
    }
    
    public void trim() {
    	// create and execute the command
        String command = name + " = trim(" + name + ")";
        RConnectionManager.eval(command);
        
    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
        	// reload the events
            retrieveEvents();
        }
    }
    
    public Collection<Event> getEvents() {
    	// order and return the list
    	List<Event> eventsList = new ArrayList<>(events.values());
    	Collections.sort(eventsList, new Comparator<Event>() {
			@Override
			public int compare(Event e1, Event e2) {
				Integer index1 = null;
				Integer index2 = null;
				try {
					index1 = Integer.parseInt(e1.getName().substring(1));
				} catch (Exception e) {
					index1 = Integer.MAX_VALUE;
				}
				try {
					index2 = Integer.parseInt(e2.getName().substring(1));
				} catch (Exception e) {
					index2 = Integer.MAX_VALUE;
				}
				return index1.compareTo(index2);
			}
		});
    	return eventsList;
    }
    
    // ************ PATTERNS AND HYPOTHESES ************ \\
    private void retrievePatterns() {
    	// initialize the structures
    	patterns = new HashMap<>();
    	
    	// create and execute the commands
    	String command = "as.hypotheses(" + name + ")";
        REXP rexp = RConnectionManager.eval(command);
        
        // get the hypotheses info
    	String[] hypothesesStrings = rexp.asStringArray();
    	
    	// if the last console message is regular
    	if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
        	// if the output of R is null
        	if (hypothesesStrings == null) {
        		// return
        		return;
        	}
        	
            // instantiate and split the hypotheses by patterns
        	int numberOfHypotheses = hypothesesStrings.length / 4;
        	for (int j = 0; j < numberOfHypotheses ; j++) {
        		// get the names of the elements
    			String causeTypeName = hypothesesStrings[j];
    			String causeEventName = hypothesesStrings[j + numberOfHypotheses];
    			String effectTypeName = hypothesesStrings[j + numberOfHypotheses * 2];
    			String effectEventName = hypothesesStrings[j + numberOfHypotheses * 3];
    			
    			// get the types
    			Type causeType = types.get(causeTypeName);
    			Type effectType = types.get(effectTypeName);
    			
    			// get the events and the pattern
    			Pattern pattern = null;
    			Object causeEvent = null;
    			Object effectEvent = null;
    			
    			if (causeTypeName.equals("Pattern")) {
    				if (patterns.containsKey(causeEventName)) {
    					pattern = patterns.get(causeEventName);
    				} else {
    					pattern = new Pattern(causeEventName);
    					patterns.put(causeEventName, pattern);
    				}
    				causeEvent = pattern;
    			} else {
    				causeEvent = genes.get(causeEventName);
    			}
    			
    			if (effectTypeName.equals("Pattern")) {
    				if (patterns.containsKey(effectEventName)) {
    					pattern = patterns.get(effectEventName);
    				} else {
    					pattern = new Pattern(effectEventName);
    					patterns.put(effectEventName, pattern);
    				}
    				effectEvent = pattern;
    			} else {
    				effectEvent = genes.get(effectEventName);
    			}
    			
    			// add the hypothesis to the pattern
    			pattern.addHypothesis(new Hypothesis(causeType, causeEvent, effectType, effectEvent));
    		}
    	} else {
    		// clean the console
    		RConnectionManager.getTextConsole().getLastConsoleMessage();
    	}
    }
    
    public void addHypothesis(String pattern, String label, List<Event> effect, List<Event> cause) {
    	// create and execute the command
        String command = name + " = hypothesis.add(" + name + ", '" + label + "', " + pattern + "";
        if (effect.size() > 0) {
        	command += ", pattern.effect=list(" + getStringOfEvents(effect) + ")";
		}
        if (cause.size() > 0) {
        	command += ", pattern.cause=list(" + getStringOfEvents(cause) + ")";
		}		
        command += ")";
        RConnectionManager.eval(command);
        
        // if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
        	// get the pattern type
            Type type;
            if (!types.containsKey(PATTERN)) {
            	types.put(PATTERN, new Type(PATTERN));
            }
            type = types.get(PATTERN);
            
            // add the sample
            events.put(label, new Event(label, type, new Gene(label)));
            
            // update the patterns
            retrievePatterns();
		}
    }
    
    public void addGroupHypothesis(String operation, List<Gene> genes, List<Event> effect, List<Event> cause, Integer minimumCardinality, Integer maximumCardinality, Float minimumProbability) {
    	// create and execute the command
        String command = name + " = hypothesis.add.group(" + name + ", " + operation + ", list(" + getStringOfGenes(genes) + ")";
        if (effect.size() > 0) {
        	command += ", pattern.effect=list(" + getStringOfEvents(effect) + ")";
		}
        if (cause.size() > 0) {
        	command += ", pattern.cause=list(" + getStringOfEvents(cause) + ")";
		}
        command += ", dim.min=" + minimumCardinality.toString()
        	+ ", dim.max=" + maximumCardinality.toString();
        if (minimumProbability > 0) {
        	command += ", min.prob=" + minimumProbability.toString().replaceAll(",", ".");
		}
        command += ", silent=TRUE)";
        RConnectionManager.eval(command);
        
        // if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
	        // update the patterns and the events 
	        retrieveEvents();
	        retrievePatterns();
        }
    }
    
    public void addHomologousHypothesis(List<Event> effect, List<Event> cause, List<Gene> genes, String operation) {
    	// create and execute the command
        String command = name + " = hypothesis.add.homologous(" + name;
        if (effect.size() > 0) {
        	command += ", pattern.effect=list(" + getStringOfEvents(effect) + ")";
		}
        if (cause.size() > 0) {
        	command += ", pattern.cause=list(" + getStringOfEvents(cause) + ")";
		}
        if (genes.size() > 0) {
        	command += ", genes=list(" + getStringOfGenes(genes) + ")";
		}
        command += ", FUN=" + operation + ", silent=TRUE)";
        RConnectionManager.eval(command);
        
        // if the last console message is regular
    	if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
    		// update the patterns and the events 
            retrieveEvents();
            retrievePatterns();
    	}
    }
    
    public void deletePattern(Pattern pattern) {
    	// create and execute the command
    	String command = name + " = delete.pattern(" + name + ", '" + pattern.getLabel() + "')";
        RConnectionManager.eval(command);
        
    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
        	// delete the pattern from the map
            patterns.remove(pattern.getLabel());
            
            // remove the event
            events.remove(pattern.getLabel());
            
            // remove the type if there are no more events
            if (patterns.size() == 0) {
    			types.remove(PATTERN);
    		}
        }
    }
    
    public void deleteHypothesis(String deletion, Object event) {
    	// get the name of the event
    	String eventName;
    	if (event instanceof Gene) {
			eventName = ((Gene) event).getName();
		} else {
			eventName = ((Pattern) event).getLabel();
		}
    	
    	// create and execute the command
    	String command = name + " = delete.hypothesis(" + name + ", " + deletion.toLowerCase() + "='" + eventName + "')";
        RConnectionManager.eval(command);
    	
    	// if the last console message is regular
        if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
        	// update the list of hypothesis    
        	for (Pattern pattern : patterns.values()) {
        		for (Hypothesis hypothesis : pattern.getHypotheses()) {
        			// if one of the three condition holds (depending on the type of deletion)
        			if ((deletion.equals(DeleteHypothesesFrame.CAUSE) && event.equals(hypothesis.getCauseEvent())) ||
        					(deletion.equals(DeleteHypothesesFrame.EFFECT) && event.equals(hypothesis.getEffectEvent())) ||
        					(deletion.equals(DeleteHypothesesFrame.EVENT) && (event.equals(hypothesis.getCauseEvent()) || event.equals(hypothesis.getEffectEvent())))) {
        				// delete the hypothesis
        				pattern.deleteHypothesis(hypothesis);
        			}
    			}
    		}
        }
    }
    
    public Collection<Pattern> getPatterns() {
    	// order and return the list
    	List<Pattern> patternsList = new ArrayList<>(patterns.values());
    	Collections.sort(patternsList, new ToStringComparator());
    	return patternsList;
    }
    
    // ************ EXTERNAL TOOLS ************ \\
    public void exportMutex(String fileName, String filePath, Type mutation, List<Type> amplification, List<Type> deletion) {
    	// create and execute the command
    	String command = "export.mutex(" + name;
    	if (fileName.length() > 0) {
    		command += ", filename='" + fileName + "'";
		}
    	if (filePath.length() > 0) {
    		command += ", filepath='" + filePath + "'";
		}
    	if (mutation != null) {
			command += ", label.mutation='" + mutation.getName() + "'";
		}
    	if (amplification.size() > 0) {
			command += ", label.amplification=list(" + getStringOfTypes(amplification) + ")";
		}
    	if (deletion.size() > 0) {
    		command += ", label.deletion=list(" + getStringOfTypes(deletion) + ")";
		}
    	command += ")";
    	RConnectionManager.eval(command);
    }
    
    public String[] exportNbs(String file, HashMap<String, String> entrezIds) {
    	// create and execute the command
    	String command = "mapping = matrix(c(";
    	for (Iterator<String> iterator = entrezIds.keySet().iterator(); iterator.hasNext();) {
    		String hugoSymbol = (String) iterator.next();
    		command += "'" + hugoSymbol + "', ";
    	}
    	for (Iterator<String> iterator = entrezIds.keySet().iterator(); iterator.hasNext();) {
    		String hugoSymbol = (String) iterator.next();
    		command += "'" + entrezIds.get(hugoSymbol) + "'";
    		if (iterator.hasNext()) {
				command += ", ";
			}
    	}
    	command += "), ncol=2)";
    	RConnectionManager.eval(command);
    	
    	command= "colnames(mapping) = c('Hugo_Symbol', 'Entrez_Gene_Id')";
    	RConnectionManager.eval(command);
    			
    	command= "capture.output(export.nbs.input(" + name + ", mapping";
    	if (file.length() > 0) {
			command += ", file='" + file + "'";
		}
    	command += "))";
    	REXP rexp = RConnectionManager.eval(command);
    	
    	return rexp.asStringArray();
    }
    
    // ************ ANNOTATIONS ************ \\
    public void annotateDescription(String description) {
    	// create and execute the command
    	String command = name + " = annotate.description(" + name + ", '" + description + "')";
    	RConnectionManager.eval(command);
    	
    	// if the last console message is regular
    	if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
    		// set the description
        	this.description = description;
    	}
    }
    
    public void annotateStages(HashMap<String, String> stages) {
    	// create and execute the command
    	String command = "stages = matrix(c(";
    	for (Iterator<String> iterator = stages.keySet().iterator(); iterator.hasNext();) {
    		String sample = (String) iterator.next();
    		command += "'" + stages.get(sample) + "'";
    		if (iterator.hasNext()) {
				command += ", ";
			}
    	}
    	command += "))";
    	RConnectionManager.eval(command);
    	
    	command = "colnames(stages) = c('Stage')";
    	RConnectionManager.eval(command);
    	
    	command = "rownames(stages) = c(";
    	for (Iterator<String> iterator = stages.keySet().iterator(); iterator.hasNext();) {
    		String sample = (String) iterator.next();
    		command += "'" + sample + "'";
    		if (iterator.hasNext()) {
				command += ", ";
			}
    	}
    	command += ")";
    	RConnectionManager.eval(command);
    	
    	command = name + " = annotate.stages(" + name + ", stages)";
    	RConnectionManager.eval(command);
    	
    	// if the last console message is regular
    	if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
    		hasStagesAnnotation = true;
    	}
    }
    
    // ************ VISUALIZATION ************ \\
    public void oncoprint(String path, Boolean exclusivitySort, Boolean labelSort, Boolean stageSort, Boolean clusterSamples,
    		Boolean clusterGenes, Boolean annotateStage, Boolean annotateHits, Float fontSize, Boolean samplesName, Boolean legend,
    		Float legendSize, HashMap<String, String> groups, Boolean pattern) {    	
    	// create the command
    	String command = "oncoprint(" + name + ", file='" + path
    			+ "', excl.sort=" + exclusivitySort.toString().toUpperCase()
    			+ ", group.by.label=" + labelSort.toString().toUpperCase()
    			+ ", group.by.stage=" + stageSort.toString().toUpperCase()
    			+ ", samples.cluster=" + clusterSamples.toString().toUpperCase()
    			+ ", genes.cluster=" + clusterGenes.toString().toUpperCase()
    			+ ", ann.stage=" + annotateStage.toString().toUpperCase()
    			+ ", ann.hits=" + annotateHits.toString().toUpperCase()
    			+ ", text.cex=" + fontSize.toString().replace(",", ".")
    			+ ", sample.id=" + samplesName.toString().toUpperCase()
    			+ ", legend=" + legend.toString().toUpperCase()
    			+ ", legend.cex=" + legendSize.toString().replace(",", ".")
    			+ ", show.patterns=" + pattern.toString().toUpperCase();
    
    	// create the groups if provided
    	if (groups.size() > 0) {
    		String groupsCommand = "groups = matrix(c(";
        	for (Iterator<String> iterator = groups.keySet().iterator(); iterator.hasNext();) {
        		String sample = (String) iterator.next();
        		groupsCommand += "'" + groups.get(sample) + "'";
        		if (iterator.hasNext()) {
    				groupsCommand += ", ";
    			}
        	}
        	groupsCommand += "))";
        	RConnectionManager.eval(groupsCommand);
        	
        	groupsCommand = "colnames(groups) = c('Group')";
        	RConnectionManager.eval(groupsCommand);
        	
        	groupsCommand = "rownames(groups) = c(";
        	for (Iterator<String> iterator = groups.keySet().iterator(); iterator.hasNext();) {
        		String sample = (String) iterator.next();
        		groupsCommand += "'" + sample + "'";
        		if (iterator.hasNext()) {
    				groupsCommand += ", ";
    			}
        	}
        	groupsCommand += ")";
        	RConnectionManager.eval(groupsCommand);
        	
        	command += ", group.samples=groups";
		}
    	
    	// close the command
    	command += ")";
    	
    	// if the OS is windows
    	if (System.getProperty("os.name").toLowerCase().contains("win")) {
			// execute the command
    		RConnectionManager.eval(command);
    		
    		// close the graphics
    		command = "dev.off()";
        	RConnectionManager.eval(command);
		} else {
			String rdataPath;
			try {
				// create the temporary Rdata file
				File rdataFile = File.createTempFile("oncoprint_" + name + "_", ".Rdata");
				
				// get the path and delete the file
				rdataPath = rdataFile.getAbsolutePath();
				rdataFile.delete();
				
				// save the dataset to the Rdata file
				String saveCommand = "save(" + name + ", file='" + rdataPath + "')";
				RConnectionManager.eval(saveCommand);
			} catch (IOException e) {
			 	e.printStackTrace();
			 	return;
			}
			
			File rFile = null;
			try {
				// create the temporary R file
				rFile = File.createTempFile("oncoprint_" + name + "_", ".R");
				
				// get the path
				Path rPath = rFile.toPath();
				
				// prepare the content of the file
				List<String> rFileContent = Arrays.asList(
						"library(TRONCO)",
						"load(file='" + rdataPath + "')",
						command);
				
				// write the content to the file
				Files.write(rPath, rFileContent, Charset.forName("UTF-8"));
			} catch (IOException e) {
			 	e.printStackTrace();
			 	return;
			}
			
			try {
				// create the temporary bash file
				File shFile = File.createTempFile("oncoprint_" + name + "_", ".bash");
				
				// get the path
				Path shPath = shFile.toPath();
				
				// prepare the content of the file
				List<String> shFileContent = Arrays.asList(
						"#!/bin/bash",
						"Rscript " + rFile.getPath());
				
				// write the content to the file
				Files.write(shPath, shFileContent, Charset.forName("UTF-8"));
				
				// instantiate the process
				ProcessBuilder processBuilder = new ProcessBuilder("bash", shFile.toString());
		        processBuilder.inheritIO();
		        
		        // start and wait for the process
		        Process process = processBuilder.start();
		        process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    }
    
    public void plot(String path, List<Model> models, Boolean primaFacie, Boolean disconnectedNodes, Boolean scaleNodes,
			List<Statistics> confidence, Float pvalueCutoff, Boolean expandHypotheses) {
    	// create and execute the command
    	String command = "export.graphml(" + name + ", file='" + path + "'";
    	if (models.size() > 0) {
			command += ", models=c(";
			for (Iterator<Model> iterator = models.iterator(); iterator.hasNext();) {
				Model model = (Model) iterator.next();
				command += "'" + model.getName() + "'";
				if (iterator.hasNext()) {
					command += ", ";
				}
			}
			command += ")";
		}
    	command += ", pf=" + primaFacie.toString().toUpperCase()
    			+ ", disconnected=" + disconnectedNodes.toString().toUpperCase();
    	if (scaleNodes) {
    		command += ", scale.nodes=TRUE";
    	} 
    	if (confidence.size() > 0) {
    		command += ", confidence=c(";
    		for (Iterator<Statistics> iterator = confidence.iterator(); iterator.hasNext();) {
				Statistics statistics = (Statistics) iterator.next();
				command += "'" + statistics.getCode() + "'";
				if (iterator.hasNext()) {
					command += ", ";
				}
			}
    		command += ")";
		}
    	command += ", p.min=" + pvalueCutoff.toString().replace(",", ".")
    			+ ", expand=" + expandHypotheses.toString().toUpperCase()
    			+ ")";
    	System.out.println(command);
    	RConnectionManager.eval(command);
    }
    
    public String getDescription() {
    	return description;
    }
    
    public boolean hasStagesAnnotation() {
    	return hasStagesAnnotation;
    }
    
    // ************ INFERENCE ************ \\
    private void retrieveInference() {
    	// create and execute the command for getting the inference algorithm
    	String command = "as.parameters(" + name + ")$algorithm";
    	REXP rexp = RConnectionManager.eval(command);
    	
    	// if last message is regular
    	if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
    		// get the inference algorithm
    		String algorithm = rexp.asString().toLowerCase();
    		
    		// create and execute the command for getting the models
    		command = "names(as.models(" + name + "))";
        	rexp = RConnectionManager.eval(command);
        	String[] modelNames = rexp.asStringArray();
    		
        	// instantiate the models
    		List<Model> models = new ArrayList<>();
    		for (int i = 0; i < modelNames.length; i++) {
				String modelName = modelNames[i];
				models.add(new Model(modelName));
			}
    		
    		// instantiate the model
    		inference = new Inference(algorithm, models);
    	} else {
	    	// clean the console
	    	RConnectionManager.getTextConsole().getLastConsoleMessage();
    	}
    }
    
    public void caprese(Float lambda, Float falsePositive, Float falseNegative) {
    	// create and execute the command
    	String command = name + " = tronco.caprese(" + name
    			+ ", lambda=" + lambda.toString().replace(",", ".")
    			+ ", epos=" + falsePositive.toString().replace(",", ".")
    			+ ", eneg=" + falseNegative.toString().replace(",", ".")
    			+ ", silent=TRUE)";
    	RConnectionManager.eval(command);
    	
    	// if last message is regular
    	if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
    		// retrieve the inference
    		retrieveInference();
    		// remove the old statistics
    		removeStatistics();
    	}
    }
    
	public void capri(String command, List<String> regularization, Boolean estimateErrorRates, Integer bootstrapSamplings,
			Float pValue, Integer initialBootstrapSeeds, Integer restarts, Float falsePositive, Float falseNegative) {
		// create and execute the command
		String rCommand = name + " = tronco.capri(" + name
    			+ ", command='" + command
    			+ "', regularization=c(";
		for (Iterator<String> iterator = regularization.iterator(); iterator.hasNext();) {
			String rule = (String) iterator.next();
			rCommand += "'" + rule + "'";
			if (iterator.hasNext()) {
				rCommand += ", ";
			}
		}
		rCommand += ")"
				+ ", do.boot=" + estimateErrorRates.toString().toUpperCase()
				+ ", nboot=" + bootstrapSamplings.toString()
				+ ", pvalue=" + pValue.toString().replace(",", ".");
		if (initialBootstrapSeeds == 0) {
			rCommand += ", boot.seed=NULL";
		} else {
			rCommand += ", boot.seed=" + initialBootstrapSeeds.toString();
		}
		rCommand += ", epos=" + falsePositive.toString().replace(",", ".")
    			+ ", eneg=" + falseNegative.toString().replace(",", ".")
    			+ ", restart=" + restarts.toString()
    			+ ", silent=TRUE)";
		RConnectionManager.eval(rCommand);
		
		// if last message is regular
    	if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
    		// retrieve the inference
    		retrieveInference();
    		// remove the old statistics
    		removeStatistics();
    	}
	}
	
	public void chowliu(List<String> regularization, Boolean estimateErrorRates, Integer bootstrapSamplings,
			Float pValue, Integer initialBootstrapSeeds, Float falsePositive, Float falseNegative) {
		// create and execute the command
		String rCommand = name + " = tronco.chowliu(" + name
    			+ ", regularization=c(";
		for (Iterator<String> iterator = regularization.iterator(); iterator.hasNext();) {
			String rule = (String) iterator.next();
			rCommand += "'" + rule + "'";
			if (iterator.hasNext()) {
				rCommand += ", ";
			}
		}
		rCommand += ")"
				+ ", do.boot=" + estimateErrorRates.toString().toUpperCase()
				+ ", nboot=" + bootstrapSamplings.toString()
				+ ", pvalue=" + pValue.toString().replace(",", ".");
		if (initialBootstrapSeeds == 0) {
			rCommand += ", boot.seed=NULL";
		} else {
			rCommand += ", boot.seed=" + initialBootstrapSeeds.toString();
		}
		rCommand += ", epos=" + falsePositive.toString().replace(",", ".")
    			+ ", eneg=" + falseNegative.toString().replace(",", ".")
    			+ ", silent=TRUE)";
		RConnectionManager.eval(rCommand);
		
		// if last message is regular
    	if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
    		// retrieve the inference
    		retrieveInference();
    		// remove the old statistics
    		removeStatistics();
    	}
	}
	
	public void edmonds(List<String> regularization, String score, Boolean estimateErrorRates, Integer bootstrapSamplings,
			Float pValue, Integer initialBootstrapSeeds, Float falsePositive, Float falseNegative) {
		// create and execute the command
		String rCommand = name + " = tronco.edmonds(" + name
    			+ ", regularization=c(";
		for (Iterator<String> iterator = regularization.iterator(); iterator.hasNext();) {
			String rule = (String) iterator.next();
			rCommand += "'" + rule + "'";
			if (iterator.hasNext()) {
				rCommand += ", ";
			}
		}
		rCommand += ")"
				+ ", score='" + score
				+ "', do.boot=" + estimateErrorRates.toString().toUpperCase()
				+ ", nboot=" + bootstrapSamplings.toString()
				+ ", pvalue=" + pValue.toString().replace(",", ".");
		if (initialBootstrapSeeds == 0) {
			rCommand += ", boot.seed=NULL";
		} else {
			rCommand += ", boot.seed=" + initialBootstrapSeeds.toString();
		}
		rCommand += ", epos=" + falsePositive.toString().replace(",", ".")
    			+ ", eneg=" + falseNegative.toString().replace(",", ".")
    			+ ", silent=TRUE)";
		RConnectionManager.eval(rCommand);
		
		// if last message is regular
    	if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
    		// retrieve the inference
    		retrieveInference();
    		// remove the old statistics
    		removeStatistics();
    	}
	}
	
	public void gabow(List<String> regularization, String score, Boolean estimateErrorRates, Integer bootstrapSamplings, 
			Float pValue, Integer initialBootstrapSeeds, Float falsePositive, Float falseNegative,
			Boolean raisingCondition) {
		// create and execute the command
		String rCommand = name + " = tronco.gabow(" + name
    			+ ", regularization=c(";
		for (Iterator<String> iterator = regularization.iterator(); iterator.hasNext();) {
			String rule = (String) iterator.next();
			rCommand += "'" + rule + "'";
			if (iterator.hasNext()) {
				rCommand += ", ";
			}
		}
		rCommand += ")"
				+ ", score='" + score
				+ "', do.boot=" + estimateErrorRates.toString().toUpperCase()
				+ ", nboot=" + bootstrapSamplings.toString()
				+ ", pvalue=" + pValue.toString().replace(",", ".");
		if (initialBootstrapSeeds == 0) {
			rCommand += ", boot.seed=NULL";
		} else {
			rCommand += ", boot.seed=" + initialBootstrapSeeds.toString();
		}
		rCommand += ", epos=" + falsePositive.toString().replace(",", ".")
    			+ ", eneg=" + falseNegative.toString().replace(",", ".")
    			+ ", do.raising=" + raisingCondition.toString().toUpperCase()
    			+ ", silent=TRUE)";
		RConnectionManager.eval(rCommand);
		
		// if last message is regular
    	if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
    		// retrieve the inference
    		retrieveInference();
    		// remove the old statistics
    		removeStatistics();
    	}
	}
	
	public void prim(List<String> regularization, Boolean estimateErrorRates, Integer bootstrapSamplings,
			Float pValue, Integer initialBootstrapSeeds, Float falsePositive, Float falseNegative) {
		// create and execute the command
		String rCommand = name + " = tronco.prim(" + name
    			+ ", regularization=c(";
		for (Iterator<String> iterator = regularization.iterator(); iterator.hasNext();) {
			String rule = (String) iterator.next();
			rCommand += "'" + rule + "'";
			if (iterator.hasNext()) {
				rCommand += ", ";
			}
		}
		rCommand += ")"
				+ ", do.boot=" + estimateErrorRates.toString().toUpperCase()
				+ ", nboot=" + bootstrapSamplings.toString()
				+ ", pvalue=" + pValue.toString().replace(",", ".");
		if (initialBootstrapSeeds == 0) {
			rCommand += ", boot.seed=NULL";
		} else {
			rCommand += ", boot.seed=" + initialBootstrapSeeds.toString();
		}
		rCommand += ", epos=" + falsePositive.toString().replace(",", ".")
    			+ ", eneg=" + falseNegative.toString().replace(",", ".")
    			+ ", silent=TRUE)";
		RConnectionManager.eval(rCommand);
		
		// if last message is regular
    	if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
    		// retrieve the inference
    		retrieveInference();
    		// remove the old statistics
    		removeStatistics();
    	}
	}
	
	public Inference getInference() {
		return inference;
	}
	
    // ************ STATISTICS ************ \\
	private void retrieveStatistics() {
		// create and execute the command for bootstrap npb
		String command = name + "$bootstrap$npb";
		REXP rexp = RConnectionManager.eval(command);
		String rexpString = rexp.toString();
		
		// if the result is not null
		if (!rexpString.equals("[NULL ]")) {
			// add the statistics
			inference.addStatistics(new Statistics(StatisticsController.BOOTSTRAP + "-npb", "npb"));
		}
		
		// create and execute the command for bootstrap sb
		command = name + "$bootstrap$sb";
		rexp = RConnectionManager.eval(command);
		rexpString = rexp.toString();
		
		// if the result is not null
		if (!rexpString.equals("[NULL ]")) {
			// add the statistics
			inference.addStatistics(new Statistics(StatisticsController.BOOTSTRAP + "-sb", "sb"));
		}
		
		// create and execute the command for eloss
		command = "as.kfold.eloss(" + name + ")";
		RConnectionManager.eval(command);
		
		// if last message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// add the statistics
			inference.addStatistics(new Statistics(StatisticsController.ELOSS, StatisticsController.ELOSS.substring(6)));
		} else {
			// clean the console
			RConnectionManager.getTextConsole().getLastConsoleMessage();
		}
		
		// create and execute the command for posterr
		command = "as.kfold.posterr(" + name + ")";
		RConnectionManager.eval(command);
		
		// if last message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// add the statistics
			inference.addStatistics(new Statistics(StatisticsController.POSTERR, StatisticsController.POSTERR.substring(6)));
		} else {
			// clean the console
			RConnectionManager.getTextConsole().getLastConsoleMessage();
		}
		
		// create and execute the command for prederr
		command = "as.kfold.prederr(" + name + ")";
		RConnectionManager.eval(command);
		
		// if last message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// add the statistics
			inference.addStatistics(new Statistics(StatisticsController.PREDERR, StatisticsController.PREDERR.substring(6)));
		} else {
			// clean the console
			RConnectionManager.getTextConsole().getLastConsoleMessage();
		}
	}
	
	private void removeStatistics() {
		// create and execute the command for removing bootstrap
		String command = name + "$bootstrap = NULL";
		RConnectionManager.eval(command);
		
		// create and execute the command for removing kfold
		command = name + "$kfold = NULL";
		RConnectionManager.eval(command);
	}
	
	public void bootstrap(String type, Integer bootstrapSamplings, Float coresRatio) {
		// create and execute the command
		String command = name + " = tronco.bootstrap(" + name
				+ ", type='" + type
				+ "', nboot=" + bootstrapSamplings.toString()
				+ ", cores.ratio=" + coresRatio.toString().replace(",", ".")
				+ ", silent=TRUE)";
		RConnectionManager.eval(command);
		
		// if last message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// add the statistics
			if (type.equals(StatisticsController.NON_PARAMETRIC)) {
				inference.addStatistics(new Statistics(StatisticsController.BOOTSTRAP + "-npb", "npb"));
			} else if (type.equals(StatisticsController.STATISTICAL)) {
				inference.addStatistics(new Statistics(StatisticsController.BOOTSTRAP + "-sb", "sb"));
			}
		}
	}
	
	public void eloss(Integer runs, Integer groups) {
		// create and execute the command
		String command = name + " = tronco.kfold.eloss(" + name
				+ ", runs=" + runs.toString()
				+ ", k=" + groups.toString()
				+ ", silent=TRUE)";
		RConnectionManager.eval(command);
		
		// if last message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// add the statistics
			inference.addStatistics(new Statistics(StatisticsController.ELOSS, StatisticsController.ELOSS.substring(6)));
		}
	}
	
	public void posterr(Integer runs, Integer groups, Float coresRatio) {
		// create and execute the command
		String command = name + " = tronco.kfold.posterr(" + name
				+ ", runs=" + runs.toString()
				+ ", k=" + groups.toString()
				+ ", cores.ratio=" + coresRatio.toString().replace(",", ".")
				+ ", silent=TRUE)";
		RConnectionManager.eval(command);
		
		// if last message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// add the statistics
			inference.addStatistics(new Statistics(StatisticsController.POSTERR, StatisticsController.POSTERR.substring(6)));
		}
	}
	
	public void prederr(Integer runs, Integer groups, Float coresRatio) {
		// create and execute the command
		String command = name + " = tronco.kfold.posterr(" + name
				+ ", runs=" + runs.toString()
				+ ", k=" + groups.toString()
				+ ", cores.ratio=" + coresRatio.toString().replace(",", ".")
				+ ", silent=TRUE)";
		RConnectionManager.eval(command);
		
		// if last message is regular
		if (RConnectionManager.getTextConsole().isLastMessageRegular()) {
			// add the statistics
			inference.addStatistics(new Statistics(StatisticsController.PREDERR, StatisticsController.PREDERR.substring(6)));
		}
	}
    
    // ************ UTILITIES ************ \\
    private String getStringOfEvents(List<Event> events) {
    	String string = "";
    	for (Iterator<Event> iterator = events.iterator(); iterator.hasNext();) {
			Event event = (Event) iterator.next();
			string += "c('" + event.getGene().getName() + "', '" + event.getType().getName() + "')";
			if (iterator.hasNext()) {
				string += ", ";
        	}
		}
    	return string;
    }
    
    private String getStringOfGenes(List<Gene> genes) {
    	String string = "";
    	for (Iterator<Gene> iterator = genes.iterator(); iterator.hasNext();) {
			Gene gene = (Gene) iterator.next();
			string += "'" + gene.getName() + "'"; 
			if (iterator.hasNext()) {
				string += ", ";
		    }
		}
    	return string;
    }
    
    private String getStringOfTypes(List<Type> types) {
    	String string = "";
    	for (Iterator<Type> iterator = types.iterator(); iterator.hasNext();) {
			Type type = (Type) iterator.next();
			string += "'" + type.getName() + "'"; 
			if (iterator.hasNext()) {
				string += ", ";
		    }
		}
    	return string;
    }
    
    // ************ OTHERS ************ \\
    public String getName() {
		return name;
	}
    
    @Override
    public String toString() {
        return name;
    }
}
