// This entire file is part of my masterpiece.
// MICHAEL DAOU

package slogo.interpreter;

import java.util.HashMap;

import slogo.character.CharacterInterface;
import slogo.element.Display;
import slogo.element.DisplayInterface;
import slogo.nodes.NodeObject;
import slogo.saving.FileParser;
import slogo.saving.WorkspaceSaver;
import slogo.screen.SlogoScreenInterface;

public class EngineController {

	private Interpreter myInterpreter;
	private SlogoScreenInterface myView;
	private CommandLibrary myCommandLibrary;
	private VariableLibrary myVariableLibrary;
	private TurtleController myTurtleController;
	private WorkspaceSaver myWorkspaceSaver;
	private FileParser myFileParser;
	

	public EngineController(String language, SlogoScreenInterface view) {
		myView = view;
		myVariableLibrary = new VariableLibrary();
		myCommandLibrary = new CommandLibrary(myVariableLibrary);
		myInterpreter = new Interpreter(language, myCommandLibrary, myVariableLibrary);
		myTurtleController = new TurtleController(this, view);
		//myTurtles = view.getDisplay().getCharacters();
		//activeIndices = view.getDisplay().getActiveIndices();
		myWorkspaceSaver = new WorkspaceSaver(this);
		myFileParser = new FileParser(this);
	}

	public void runCommands(String input) {
		NodeObject compiledCommandsTree = myInterpreter.interpret(input);
		compiledCommandsTree.traverseAndExecute(this);
		updateVariablesListInGUI();
		updateCommandsListInGUI();
		myWorkspaceSaver.saveWorkspaceToFile("newFile");
	}
	
	public void saveDatabaseToFile(String fileName){
		myWorkspaceSaver.saveWorkspaceToFile(fileName);
	}

	public void updateVariablesListInGUI() {
		HashMap<String, Double> variableMap = (HashMap<String, Double>) myVariableLibrary.getVariableMap();
		myView.getVariablesObject().clear();
		for (String s : variableMap.keySet()) {
			String variableMapping = s.substring(1) + " = " + variableMap.get(s);
			myView.getVariablesObject().add(variableMapping);
		}
	}
	
	private void updateCommandsListInGUI(){
		HashMap<String, String> commandMap = (HashMap<String, String>) myCommandLibrary.getCustomCommandMap();
		myView.getCommandsObject().clear();
		for (String s: commandMap.keySet()){
			String commandMapping = commandMap.get(s);
			myView.getCommandsObject().add(commandMapping);
		}
	}

	public SlogoScreenInterface getScreen() {
		return myView;
	}

	public DisplayInterface getDisplay(){
		return myView.getDisplay();
	}
	
	public CommandLibrary getCommandLibrary() {
		return myCommandLibrary;
	}

	public VariableLibrary getVariableLibrary() {
		return myVariableLibrary;
	}

	public CharacterInterface getMainCharacter() {
		return myView.getDisplay().getCharacters().get(0);
	}

	public TurtleController getTurtleController() {
		return myTurtleController;
	}
	

}
