package it.unimib.disco.bimib.cyTRON.model;

public class Sample {

    private String name;

    public Sample(String name) {
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
