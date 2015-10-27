package slogo.saving;

import slogo.interpreter.EngineController;

public class WorkspaceSaver {
	
	private EngineController myController;
	private ParsedWorkspace myParsedWorkspace;
	private FileMaker myFileMaker;

	public WorkspaceSaver(EngineController controller) {
		myController = controller;
		createParsedWorkspace();
		myFileMaker = new FileMaker(myParsedWorkspace);
		
	}
	
	private void createParsedWorkspace(){
		myParsedWorkspace = new ParsedWorkspace(myController.getCommandLibrary(), 
				myController.getVariableLibrary());
	}
	
	public void saveWorkspaceToFile(String name){
		myFileMaker.writeFile(name + ".txt");
	}

}
