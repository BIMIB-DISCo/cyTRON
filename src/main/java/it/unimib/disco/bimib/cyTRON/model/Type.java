package it.unimib.disco.bimib.cyTRON.model;

public class Type {

	private String name;

	public Type(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    @Override
    public String toString() {
        return name;
    }
	
}
