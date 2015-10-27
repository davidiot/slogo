package slogo.interpreter;

import java.util.HashMap;

import slogo.character.CharacterInterface;
import slogo.commands.TurtleCommandInterface;
import slogo.nodes.NodeObject;
import slogo.saving.FileParser;
import slogo.saving.WorkspaceSaver;
import slogo.screen.SlogoScreenInterface;

public class EngineController {

	private Interpreter myInterpreter;
	private SlogoScreenInterface myView;
	private CommandLibrary myCommandLibrary;
	private VariableLibrary myVariableLibrary;
	private WorkspaceSaver myWorkspaceSaver;
	private FileParser myFileParser;
	
	private final int DEFAULT_CHARACTER = 0;


	public EngineController(String language, SlogoScreenInterface view) {
		myView = view;
		myVariableLibrary = new VariableLibrary();
		myCommandLibrary = new CommandLibrary(myVariableLibrary);
		myInterpreter = new Interpreter(language, myCommandLibrary, myVariableLibrary);
		myWorkspaceSaver = new WorkspaceSaver(this);
		myFileParser = new FileParser();
	}

	public void runCommands(String input) {
		NodeObject compiledCommandsTree = myInterpreter.interpret(input);
		compiledCommandsTree.traverseAndExecute(this);
		updateVariablesListInGUI();
		updateCommandsListInGUI();
		//myWorkspaceSaver.saveWorkspaceToFile("newFile");
	}
	
	public void saveDatabaseToFile(String fileName){
		myWorkspaceSaver.saveWorkspaceToFile(fileName);
	}
	
	public void loadDatabaseFromFile(String fileName){
		
	}

	private void updateVariablesListInGUI() {
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

	public CommandLibrary getCommandLibrary() {
		return myCommandLibrary;
	}

	public VariableLibrary getVariableLibrary() {
		return myVariableLibrary;
	}

	public CharacterInterface getMainCharacter() {
		return myView.getDisplay().getCharacters().get(0);
	}


	public void commandTurtles(TurtleCommandInterface command) {
		for (int i = 0; i < myView.getDisplay().getCharacters().size(); i++) {
			if (myView.getDisplay().getActiveIndices().contains(i)){
				command.doTurtling(myView.getDisplay().getCharacters().get(i));
			}
		}
		
	}
	

}
