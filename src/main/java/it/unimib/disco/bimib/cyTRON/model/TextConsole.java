package it.unimib.disco.bimib.cyTRON.model;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.rosuda.JRI.RMainLoopCallbacks;
import org.rosuda.JRI.Rengine;

class TextConsole implements RMainLoopCallbacks {
	
	public void rWriteConsole(Rengine rEngine, String text, int oType) {
		System.out.print(text);
	}

	public void rBusy(Rengine rEngine, int which) {
		System.out.println("rBusy(" + which + ")");
	}

	public String rReadConsole(Rengine rEngine, String prompt, int addToHistory) {
		System.out.print(prompt);
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			String string = bufferedReader.readLine();
			return (string == null || string.length() == 0) ? string : string + "\n";
		} catch (Exception e) {
			System.out.println("jriReadConsole exception: " + e.getMessage());
		}
		return null;
	}

	public void rShowMessage(Rengine rEngine, String message) {
		System.out.println("rShowMessage \"" + message + "\"");
	}

	public String rChooseFile(Rengine rEngine, int newFile) {
		FileDialog fileDialog = new FileDialog(new Frame(), (newFile == 0) ? "Select a file" : "Select a new file",(newFile == 0)
				? FileDialog.LOAD : FileDialog.SAVE);
		fileDialog.show();
		String res = null;
		if (fileDialog.getDirectory() != null)
			res = fileDialog.getDirectory();
		if (fileDialog.getFile() != null)
			res = (res == null) ? fileDialog.getFile() : (res + fileDialog.getFile());
		return res;
	}

	public void rFlushConsole(Rengine rEngine) {}

	public void rLoadHistory(Rengine rEngine, String filename) {}

	public void rSaveHistory(Rengine rEngine, String filename) {}
}