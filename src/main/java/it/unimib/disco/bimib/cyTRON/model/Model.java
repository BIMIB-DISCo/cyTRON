package it.unimib.disco.bimib.cyTRON.model;

public class Model {

	private String name;
	
	public Model(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
