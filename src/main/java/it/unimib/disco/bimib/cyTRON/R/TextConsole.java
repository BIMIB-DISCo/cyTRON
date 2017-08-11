package it.unimib.disco.bimib.cyTRON.R;

import org.rosuda.JRI.RMainLoopCallbacks;
import org.rosuda.JRI.Rengine;

public class TextConsole implements RMainLoopCallbacks {
	
	private String lastConsoleMessage;
	private int lastConsoleMessageType;
	
	public TextConsole() {
		lastConsoleMessage = "";
		lastConsoleMessageType = 0;
	}
	
	@Override
	public void rWriteConsole(Rengine rEngine, String text, int oType) {
		lastConsoleMessage = text;
		lastConsoleMessageType = oType;
		System.out.print(text);
	}

	@Override
	public void rBusy(Rengine rEngine, int which) {
		System.out.println("rBusy(" + which + ")");
	}

	@Override
	public String rReadConsole(Rengine rEngine, String prompt, int addToHistory) {
		return null;
	}

	@Override
	public void rShowMessage(Rengine rEngine, String message) {
		System.out.println("rShowMessage \"" + message + "\"");
	}

	@Override
	public String rChooseFile(Rengine arg0, int arg1) {
		return null;
	}

	@Override
	public void rFlushConsole(Rengine arg0) {}

	@Override
	public void rLoadHistory(Rengine arg0, String arg1) {}

	@Override
	public void rSaveHistory(Rengine arg0, String arg1) {}
	
	public String getLastConsoleMessage() {
		String tempLastConsoleMessage = lastConsoleMessage.substring(0);
		lastConsoleMessage = "";
		lastConsoleMessageType = 0;
		return tempLastConsoleMessage;
	}
	
	public boolean isLastMessageRegular() {
		return lastConsoleMessageType == 0;
	}
}