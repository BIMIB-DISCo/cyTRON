package it.unimib.disco.bimib.cyTRON.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.unimib.disco.bimib.cyTRON.controller.ToStringComparator;

public class Pattern {

	private String label;
	private Set<Hypothesis> hypotheses;
	
	public Pattern(String label) {
		this.label = label;
		hypotheses = new HashSet<>();
	}
	
	public void addHypothesis(Hypothesis hypothesis) {
		hypotheses.add(hypothesis);
	}
	
	public void deleteHypothesis(Hypothesis hypothesis) {
		hypotheses.remove(hypothesis);
	}
	
	public Collection<Hypothesis> getHypotheses() {
		// order and return the list
    	List<Hypothesis> hypothesesList = new ArrayList<>(hypotheses);
    	Collections.sort(hypothesesList, new ToStringComparator());
    	return hypothesesList;
	}
	
	public String getLabel() {
		return label;
	}
	
	@Override
	public String toString() {
		return label;
	}
	
}
