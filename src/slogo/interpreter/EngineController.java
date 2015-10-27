package slogo.interpreter;

import java.util.HashMap;

import slogo.character.CharacterInterface;
import slogo.element.History;
import slogo.nodes.NodeObject;
import slogo.screen.SlogoScreenInterface;

public class EngineController {

	private Interpreter myInterpreter;
	private SlogoScreenInterface myView;
	private CommandLibrary myCommandLibrary;
	private VariableLibrary myVariableLibrary;
	
	private final int DEFAULT_CHARACTER = 0;
	
	public EngineController(String language, SlogoScreenInterface view) {
		myView = view;
		myVariableLibrary = new VariableLibrary();
		myCommandLibrary = new CommandLibrary(myVariableLibrary);
		myInterpreter = new Interpreter(language, myCommandLibrary, myVariableLibrary);
	}

	public void runCommands(String input){
		NodeObject compiledCommandsTree = myInterpreter.interpret(input);
		compiledCommandsTree.traverseAndExecute(this);
		updateVariablesListInGUI();
		updateCommandsListInGUI();
	}
	
	private void updateVariablesListInGUI(){
		HashMap<String, Double> variableMap = (HashMap<String, Double>) myVariableLibrary.getVariableMap();
		myView.getVariablesObject().clear();
		for (String s: variableMap.keySet()){
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

	public SlogoScreenInterface getScreen(){
		return myView;
	}
	
	public CommandLibrary getCommandLibrary(){
		return myCommandLibrary;
	}
	
	public VariableLibrary getVariableLibrary(){
		return myVariableLibrary;
	}
	
	public CharacterInterface getMainCharacter(){
		return myView.getDisplay().getCharacter();
	}
	
}
