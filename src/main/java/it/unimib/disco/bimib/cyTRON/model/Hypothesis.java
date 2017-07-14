package it.unimib.disco.bimib.cyTRON.model;

public class Hypothesis {
	
	private Type causeType;
	private Object causeEvent;
	private Type effectType;
	private Object effectEvent;
	
	public Hypothesis(Type causeType, Object causeEvent, Type effectType, Object effectEvent) {
		this.causeType = causeType;
		this.causeEvent = causeEvent;
		this.effectType = effectType;
		this.effectEvent = effectEvent;
	}
	
	public Object getCauseEvent() {
		return causeEvent;
	}

	public Object getEffectEvent() {
		return effectEvent;
	}
	
	@Override
	public String toString() {
		return "(" + causeType + ", " + causeEvent + ") --> (" + effectType + ", " + effectEvent + ")";
	}
	
}
