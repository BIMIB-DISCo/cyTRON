package it.unimib.disco.bimib.cyTRON.model;

import org.rosuda.JRI.REXP;

import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.controller.ToStringComparator;
import it.unimib.disco.bimib.cyTRON.model.R.RConnectionManager;
import it.unimib.disco.bimib.cyTRON.view.DeleteHypothesesFrame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Dataset {
	
	public static final String PATTERN = "Pattern"; 
    
    private String name;

	private Map<String, Gene> genes;
    private Map<String, Type> types;
    private Map<String, Sample> samples;
    private Map<String, Event> events;
    private Map<String, Pattern> patterns;
    
    public Dataset(String name, String path, String type) {
        this.name = name;
        genes = new HashMap<>();
        types = new HashMap<>();
        samples = new HashMap<>();
        events = new HashMap<>();
        patterns = new HashMap<>();
    	
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
    	
    	retrieveSamples();
    	retrieveEvents();
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
    
    public void bindSamples(Dataset dataset, String newName) {
    	// create and execute the command
        String command = newName + " = sbind(c(" + name + ", " + dataset.getName() + "))";
        RConnectionManager.eval(command);
        command = "rm(" + name + ")";
        RConnectionManager.eval(command);
        
        // update the name
        name = newName;
        
        // update the samples and the events
        retrieveSamples();
        retrieveEvents();
    }
    
    public void bindEvents(Dataset dataset, String newName) {
    	// create and execute the command
        String command = newName + " = ebind(c(" + name + ", " + dataset.getName() + "))";
        RConnectionManager.eval(command);
        command = "rm(" + name + ")";
        RConnectionManager.eval(command);
        
        // update the name
        name = newName;
        
        // update the samples and the events
        retrieveSamples();
        retrieveEvents();
    }
    
    public void intersect(Dataset dataset, String newName) {
    	// create and execute the command
        String command = newName + " = intersect.datasets(" + name + ", " + dataset.getName() + ")";
        RConnectionManager.eval(command);
        command = "rm(" + name + ")";
        RConnectionManager.eval(command);
        
        // update the name
        name = newName;
        
        // update the samples and the events
        retrieveSamples();
        retrieveEvents();
    }
    
    // ************ SAMPLES ************ \\
    private void retrieveSamples() {
    	// initialize the structure
    	samples = new HashMap<>();
    	
    	// create and execute the command
        String command = "as.samples(" + name + ")";
        REXP rexp = RConnectionManager.eval(command);
        
        // get the names of the genes
        String[] names = rexp.asStringArray();
        
        // instantiate the genes and add them to the map
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            samples.put(name, new Sample(name));
        }
    }
    
    public void deleteSample(Sample sample) {
    	// create and execute the command
        String command = name + " = delete.samples(" + name + ", c('" + sample.getName() + "'))";
        RConnectionManager.eval(command);
        
        // delete the sample from the map
        samples.remove(sample.getName());
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
        
        // reload the samples
        retrieveSamples();
    }
    
    public Collection<Sample> getSamples() {
    	// order and return the list
    	List<Sample> samplesList = new ArrayList<>(samples.values());
    	Collections.sort(samplesList, new ToStringComparator());
    	return samplesList;
    }
    
    // ************ GENES ************ \\    
    public void renameGene(Gene gene, String newName) {
    	// create and execute the command
        String command = name + " = rename.gene(" + name + ", '" + gene.getName() + "', '" + newName + "')";
        RConnectionManager.eval(command);
        
        // rename the gene
        gene.setName(newName);
    }
    
    public void deleteGene(Gene gene) {
    	// create and execute the command
        String command = name + " = delete.gene(" + name + ", '" + gene.getName() + "')";
        RConnectionManager.eval(command);
        
        // delete the gene from the map
        genes.remove(gene.getName());
        
        // reload the events
        retrieveEvents();
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
        
        // rename the type
        type.setName(newName);
    }
    
    public void deleteType(Type type) {
    	// create and execute the command
        String command = name + " = delete.type(" + name + ", '" + type.getName() + "')";
        RConnectionManager.eval(command);
        
        // delete the type from the map
        types.remove(type.getName());
        
        // reload the events
        retrieveEvents();
    }
    
    public void joinTypes(Type type1, Type type2, String newName) {
    	// create and execute the command
        String command = name + " = join.types(" + name + ", '" + type1.getName() + "', '" + type2.getName() + "', new.type='" + newName + "')";
        RConnectionManager.eval(command);
        
        // reload the events
        retrieveEvents();
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
    }
    
    public void deleteEvent(Event event) {
    	// create and execute the command
        String command = name + " = delete.event(" + name + ", '" + event.getGene().getName() + "', '" + event.getType().getName() + "')";
        RConnectionManager.eval(command);
        
        // reload the events
        retrieveEvents();
    }
    
    public void joinEvents(Event event1, Event event2, String geneName, String typeName, String colorName) {
    	// create and execute the command
    	String command = name + " = join.events(" + name + ", '" + event1.getName() + "', '" + event2.getName() +
    			"', new.event='" + geneName + "', new.type='" + typeName + "', event.color='" + colorName + "')";
    	RConnectionManager.eval(command);
    	
    	// reload the events
        retrieveEvents();
    }
    
    public void eventsSelection(String frequence, Event[] selectedEvents, Event[] filteredEvents) {
    	// create and execute the command
        String command = name + " = events.selection(" + name;
        if (frequence.length() > 0) {
			command += ", filter.freq=" + frequence;
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
        command += ")";
        RConnectionManager.eval(command);
        
        // reload the events
        retrieveEvents();
    }
    
    public void trim() {
    	// create and execute the command
        String command = name + " = trim(" + name + ")";
        RConnectionManager.eval(command);
        
        // reload the events
        retrieveEvents();
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
    
    public void addGroupHypothesis(String operation, List<Gene> genes, List<Event> effect, List<Event> cause, String minimumCardinality, String maximumCardinality, String minimumProbability) {
    	// create and execute the command
        String command = name + " = hypothesis.add.group(" + name + ", " + operation + ", list(" + getStringOfGenes(genes) + ")";
        if (effect.size() > 0) {
        	command += ", pattern.effect=list(" + getStringOfEvents(effect) + ")";
		}
        if (cause.size() > 0) {
        	command += ", pattern.cause=list(" + getStringOfEvents(cause) + ")";
		}
        if (minimumCardinality.length() > 0) {
        	command += ", dim.min=" + minimumCardinality;
		}
        if (maximumCardinality.length() > 0) {
        	command += ", dim.max=" + maximumCardinality;
		}
        if (minimumProbability.length() > 0) {
        	command += ", min.prob=" + minimumProbability;
		}
        command += ", silent=TRUE)";
        RConnectionManager.eval(command);
        
        // update the patterns and the events 
        retrieveEvents();
        retrievePatterns();
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
        
        // update the patterns and the events 
        retrieveEvents();
        retrievePatterns();
    }
    
    public void deletePattern(Pattern pattern) {
    	// create and execute the command
    	String command = name + " = delete.pattern(" + name + ", '" + pattern.getLabel() + "')";
        RConnectionManager.eval(command);
        
        // delete the pattern from the map
        patterns.remove(pattern.getLabel());
        
        // remove the event
        events.remove(pattern.getLabel());
        
        // remove the type if there are no more events
        if (patterns.size() == 0) {
			types.remove(PATTERN);
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
