package it.unimib.disco.bimib.cyTRON.model;

public class Event {
    
	private String name;
	private Type type;
	private Gene gene;
	
	public Event(String name, Type type, Gene gene) {
		this.name = name;
		this.type = type;
		this.gene = gene;
	}
	
	public String getName() {
		return name;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public Gene getGene() {
		return gene;
	}
	
    @Override
    public String toString() {
        return name + " (" + type + ", " + gene + ")";
    }
}
