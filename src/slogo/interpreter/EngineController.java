package slogo.interpreter;

import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

import slogo.nodes.NodeObject;
import slogo.screen.SlogoScreen;

public class EngineController {

	private Interpreter myInterpreter;
	private SlogoScreen myView;
	private CommandLibrary myCommandLibrary;
	private VariableLibrary myVariableLibrary;
	
	private final int DEFAULT_CHARACTER = 0;
	
	public EngineController(String language, SlogoScreen view) {
		myView = view;
		myVariableLibrary = new VariableLibrary();
		myCommandLibrary = new CommandLibrary(myVariableLibrary);
		myInterpreter = new Interpreter(language, myCommandLibrary, myVariableLibrary);
	}

	public void runCommands(String input){
		NodeObject compiledCommandsTree = myInterpreter.interpret(input);
		compiledCommandsTree.traverseAndExecute(myView.getDisplay().getCharacter(DEFAULT_CHARACTER));
		updateVariablesListInGUI();
	}
	
	public void updateVariablesListInGUI(){
		HashMap<String, Double> variableMap = (HashMap<String, Double>) myVariableLibrary.getVariableMap();
		myView.getVariablesObject().clear();
		for (String s: variableMap.keySet()){
			System.out.println("variable is" + s);
			String variableMapping = s.substring(1) + " = " + variableMap.get(s);
			myView.getVariablesObject().add(variableMapping);
		}
		//String newestVariableName = myVariableLibrary.getNewestVariableString();
		//myView.getVariableList().add(myVariableLibrary.getNewestVariableString());
	}
	
	
}
