package it.unimib.disco.bimib.cyTRON.model;

public class Statistics {

	private String algorithm;
	private String code;
	
	public Statistics(String algorithm, String code) {
		this.algorithm = algorithm;
		this.code = code;
	}
	
	public String getAlgorithm() {
		return algorithm;
	}
	
	public String getCode() {
		return code;
	}
	
	@Override
	public String toString() {
		return algorithm;
	}
	
}
