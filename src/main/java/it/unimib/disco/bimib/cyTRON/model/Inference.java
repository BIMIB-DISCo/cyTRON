package it.unimib.disco.bimib.cyTRON.model;

import java.util.ArrayList;
import java.util.List;

public class Inference {

	private String algorithm;
	private List<Model> models;
	private List<Statistics> statistics;
	
	public Inference() {
		algorithm = "";
		models = new ArrayList<>();
		statistics = new ArrayList<>();
	}
	
	public Inference(String algorithm, List<Model> models) {
		this.algorithm = algorithm;
		this.models = models;
		statistics = new ArrayList<>();
	}
	
	public void addStatistics(Statistics statistics) {
		this.statistics.add(statistics);
	}
	
	public String getAlgorithm() {
		return algorithm;
	}

	public List<Model> getModels() {
		return models;
	}

	public List<Statistics> getStatistics() {
		return statistics;
	}
	
	@Override
	public String toString() {
		return algorithm;
	}
}
