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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gene == null) ? 0 : gene.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Event other = (Event) obj;
		if (gene == null) {
			if (other.gene != null) {
				return false;
			}
		} else if (!gene.equals(other.gene)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}
    
}
