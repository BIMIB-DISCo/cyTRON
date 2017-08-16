package it.unimib.disco.bimib.cyTRON.R;

import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

public class RConnectionManager {
	
	public static final String CHECK_INPUT = " failed!\nPlease check input parameters.";
	public static final String ERROR = "Error!";

	// singleton objects
	private static Rengine rEngine;
	private static TextConsole textConsole;
	
	// instantiate the objects
	public static void instantiateConnection() throws RuntimeException {
		// check libraries consistency
    	if (!versionCheck()) {
    		System.out.println("Version check failed.");
			throw new RuntimeException("Version mismatch - Java files don't match library version.");
		}
		
    	// instantiate the objects 
		String[] args = new String[]{"--quiet", "--vanilla"};
		rEngine = Rengine.getMainEngine();
		if (rEngine == null) {
			textConsole = new TextConsole();
			rEngine = new Rengine(args, false, textConsole);
		}
		
		// check R
        if (!waitForR()) {
        	System.out.println("Wait for R failed.");
        	throw new RuntimeException("R cannot be loaded.");
		}
	}
	
	// load TRONCO
	public static void loadTronco() throws RuntimeException {
		// load the TRONCO library in R
		eval("library('TRONCO')");
		
		// check TRONCO
		if (!textConsole.isLastMessageRegular()) {
			throw new RuntimeException(textConsole.getLastConsoleMessage());
		}
	}
	
	// get the singleton objects
	public static Rengine getConnection() {
		return rEngine;
	}
	
	// get the text console
	public static TextConsole getTextConsole() {
		return textConsole;
	}
        
    // execute a command
    public static REXP eval(String command) {
    	// clear last console message
    	RConnectionManager.getTextConsole().getLastConsoleMessage();
    	
    	// print and run the command
    	System.out.println("R command:\t" + command);
    	return getConnection().eval(command);
	}
	
	// check libraries consistency
	public static Boolean versionCheck() {
		if (!Rengine.versionCheck()) {
            System.err.println("Version mismatch - Java files don't match library version.");
            return false;
        }
		
		return true;
	}
	
	// check R
	public static Boolean waitForR() {
		if (!getConnection().waitForR()) {
	        System.err.println("R cannot be loaded.");
	        return false;
	    }
		
		return true;
	}
}
