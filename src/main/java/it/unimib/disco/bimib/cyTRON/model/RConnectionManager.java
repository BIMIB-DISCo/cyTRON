package it.unimib.disco.bimib.cyTRON.model;

import org.rosuda.JRI.Rengine;

public class RConnectionManager {

	// Singleton object
	private static Rengine rEngine;
	
	// Get the singleton object
	public static Rengine getConnection() {
		if (rEngine == null) {
			rEngine = Rengine.getMainEngine();
			if (rEngine == null) {
				String[] args = new String[]{"--quiet", "--vanilla", "--no-save"};
				rEngine = new Rengine(args, false, new TextConsole());
			}
		}
		
		return rEngine;
	}
	
	// Check libraries consistency
	public static Boolean versionCheck() {
		if (!Rengine.versionCheck()) {
			// TODO: visualizzare l'errore nell'interfaccia
            System.err.println("Version mismatch - Java files don't match library version.");
            return false;
        }
		
		return true;
	}
	
	// Check R
	public static Boolean waitForR() {
		if (!getConnection().waitForR()) {
			// TODO: visualizzare l'errore nell'interfaccia
	        System.err.println("R cannot be loaded.");
	        return false;
	    }
		
		return true;
	}
	
}
