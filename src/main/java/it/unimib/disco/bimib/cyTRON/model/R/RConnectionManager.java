package it.unimib.disco.bimib.cyTRON.model.R;

import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

public class RConnectionManager {
	
	public static final String CHECK_INPUT = " failed!\nPlease check input parameters.";
	public static final String ERROR = "Error!";

	// singleton object
	private static Rengine rEngine;
	
	// get the singleton object
	public static Rengine getConnection() {
		if (rEngine == null) {
			String[] args = new String[]{"--quiet", "--vanilla", "--no-save"};
			rEngine = new Rengine(args, false, new TextConsole());
            rEngine.eval("library('TRONCO')");
		}
		
		return rEngine;
	}
        
    // execute a command
    public static REXP eval(String command) {
    	return getConnection().eval(command);
	}
	
	// check libraries consistency
	public static Boolean versionCheck() {
		if (!Rengine.versionCheck()) {
			// TODO: visualizzare l'errore nell'interfaccia
            System.err.println("Version mismatch - Java files don't match library version.");
            return false;
        }
		
		return true;
	}
	
	// check R
	public static Boolean waitForR() {
		if (!getConnection().waitForR()) {
			// TODO: visualizzare l'errore nell'interfaccia
	        System.err.println("R cannot be loaded.");
	        return false;
	    }
		
		return true;
	}
	
}
