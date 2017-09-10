package it.unimib.disco.bimib.cyTRON.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Properties;

import it.unimib.disco.bimib.cyTRON.R.RConnectionManager;

public class WizardController {
	
	public static final String VERSION = "201708";
	public static final String INSTALLATION_LINK = "www.google.com";
	private static final String CYTOSCAPE_DIRECTORY = "CytoscapeConfiguration";
	private static final String CYTRON = "cyTRON";
	
	public static final String CYTRON_VERSION = "cyTRON.version";
	public static final String CYTRON_JRI_FROM = "cyTRON.jriFrom";
	public static final String CYTRON_JRI_TO = "cyTRON.jriTo";
	public static final String CYTRON_RLIBRARY_FROM = "cyTRON.rLibraryFrom";
	public static final String CYTRON_RLIBRARY_TO = "cyTRON.rLibraryTo";
	
	private boolean jdkInstalled;
	private boolean jriCopied;
	private boolean rLibraryCopied;
	private boolean rHomeSet;
	private boolean rLibsSet;
	private boolean rConnectionOn;
	private boolean troncoInstalled;
	
	private Properties properties;
	private String propertiesFilePath;
	
	public WizardController() {
		// set all the controls to false
		jdkInstalled = false;
		jriCopied = false;
		rLibraryCopied = false;
		rHomeSet = false;
		rLibsSet = false;
		rConnectionOn = false; 
		troncoInstalled = false;
		
		// load the properties
		loadProperties();
	}
	
	private void loadProperties() {
		// instantiate the properties object
		properties = new Properties();
		
		// get the user directory path
		String userDirectoryPath = System.getProperty("user.home");
		
		// get the cyTRON file path
		propertiesFilePath = userDirectoryPath + File.separator + CYTOSCAPE_DIRECTORY + File.separator + CYTRON + File.separator + CYTRON + ".txt";
		
		try {
			// read the properties
			InputStream input = new FileInputStream(propertiesFilePath);
			properties.load(input);
		} catch (IOException e) {
			// add the properties manually in case of exceptions
			properties.setProperty(CYTRON_VERSION, "");
			properties.setProperty(CYTRON_JRI_FROM, "");
			properties.setProperty(CYTRON_JRI_TO, "");
			properties.setProperty(CYTRON_RLIBRARY_FROM, "");
			properties.setProperty(CYTRON_RLIBRARY_TO, "");
		}
	}
	
	public boolean showWizard() {
		if (properties.get(CYTRON_VERSION).equals(VERSION)) {
			return false;
		}
		
		return true;
	}
	
	public boolean isJdkInstalled() {
		if (System.getProperty("os.name").toLowerCase().contains("win")) {
			jdkInstalled = true;
		} else {
			try {
				// run javac -version in terminal
				ProcessBuilder processBuilder = new ProcessBuilder("javac","-version");
				processBuilder.redirectErrorStream(true);
				Process process = processBuilder.start();
				
				// if the output has javac in
				BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line = output.readLine();
				if (line != null && line.contains("javac")) {
					jdkInstalled = true;
				}
			} catch (IOException e) {}
		}
		
		return jdkInstalled;
	}
	
	public boolean isJriCopied() {
		try {
			System.loadLibrary("jri");
			jriCopied = true;
		} catch (UnsatisfiedLinkError e) {
			if (!e.getMessage().contains("no jri")) {
				jriCopied = true;
			}
		}
		
		return jriCopied;
	}
	
	public boolean isRLibraryCopied() {
		// if the OS is windows
    	if (System.getProperty("os.name").toLowerCase().contains("win")) {
    		try {
    			System.loadLibrary("jri");
    			rLibraryCopied = true;
    		} catch (UnsatisfiedLinkError e) {
    			if (!e.getMessage().contains("dependent libraries")) {
    				rLibraryCopied = true;
    			}
    		}
    	} else {
    		rLibraryCopied = true;
    	}
    	
    	return rLibraryCopied;
	}
	
	public boolean isRHomeSet() {
		String rHome = System.getenv("R_HOME"); 
		
		if (rHome != null && rHome.length() > 0) {
			rHomeSet = true;
		}
		
		return rHomeSet;
	}
	
	public boolean isRLibsSet() {
		// if the OS is windows
    	if (System.getProperty("os.name").toLowerCase().contains("win")) {
    		String rLibs = System.getenv("R_LIBS_USER"); 
    		
    		if (rLibs != null && rLibs.length() > 0) {
    			rLibsSet = true;
    		}
    	} else {
    		rLibsSet = true;
    	}
    	
    	return rLibsSet;
	}
	
	public boolean isRConnectionOn() {
		try {
			RConnectionManager.instantiateConnection();
			rConnectionOn = true;
		} catch (RuntimeException e) {}
		
		return rConnectionOn;
	}
	
	public boolean isTroncoInstalled() {
		try {
			RConnectionManager.loadTronco();
			troncoInstalled = true;
		} catch (RuntimeException e) {}
		
		return troncoInstalled;
	}
	
	public void copyJriFile(String from, String to) throws RuntimeException, IOException {
		// get the right file
		File jriFile = new File(from + File.separator + "jri.dll");
		if (!jriFile.exists()) {
			jriFile = new File(from + File.separator + "libjri.so");
			if (!jriFile.exists()) {
				jriFile = new File(from + File.separator + "libjri.jnilib");
				if (!jriFile.exists()) {
					throw new RuntimeException("Con't find JRI library.");
				}
			}
		}
		
		// copy the file
		File destinationFile = new File(to + File.separator + jriFile.getName());
		destinationFile.getParentFile().mkdirs();
		Files.copy(jriFile.toPath(), destinationFile.toPath());
		
		// save the paths into the properties
		properties.setProperty(CYTRON_JRI_FROM, from);
		properties.setProperty(CYTRON_JRI_TO, to);
		writePropertiesToFile();
	}
	
	public void copyRLibraryFiles(String from, String to) throws IOException {
		// if this code is not running on Windows
		if (!System.getProperty("os.name").toLowerCase().contains("win")) {
			// return
			return;
		}
		
		// for each .dll file
		String[] dllNames = new String[]{"R.dll", "Rblas.dll", "Rgraphapp.dll", "Riconv.dll", "Rlapack.dll"};
		for (int i = 0; i < dllNames.length; i++) {
			// get the file and its destination
			File dllFile = new File(from + File.separator + dllNames[i]);
			File destinationFile = new File(to + File.separator + dllFile.getName());
			
			// copy the file
			destinationFile.getParentFile().mkdirs();
			Files.copy(dllFile.toPath(), destinationFile.toPath());
		}
		
		// save the paths into the properties
		properties.setProperty(CYTRON_RLIBRARY_FROM, from);
		properties.setProperty(CYTRON_RLIBRARY_TO, to);
		writePropertiesToFile();
	}
	
	public void completeWizard() {
		// set the version property
		properties.setProperty(CYTRON_VERSION, VERSION);
		
		// write the properties
		writePropertiesToFile();
	}
	
	private void writePropertiesToFile() {
		try {
			File propertiesFile = new File(propertiesFilePath);
			propertiesFile.getParentFile().mkdirs();
			
			// write the properties to file
			OutputStream output = new FileOutputStream(propertiesFilePath);
			properties.store(output, null);
		} catch (IOException e) {}
	}
	
	public String getProperty(String property) {
		return properties.getProperty(property);
	}

}
