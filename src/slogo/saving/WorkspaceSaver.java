package slogo.saving;

import slogo.interpreter.EngineController;

public class WorkspaceSaver {
	
	EngineController myController;
	ParsedWorkspace myParsedWorkspace;

	public WorkspaceSaver(EngineController controller) {
		myController = controller;
	}
	
	public ParsedWorkspace createParsedWorkspace(){
		myParsedWorkspace = new ParsedWorkspace(myController.getCommandLibrary(), 
				myController.getVariableLibrary());
		return myParsedWorkspace;
	}

}
