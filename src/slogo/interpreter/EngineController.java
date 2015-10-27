package slogo.interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import slogo.character.CharacterInterface;
import slogo.commands.TurtleCommandInterface;
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
		//myTurtles = view.getDisplay().getCharacters();
		//activeIndices = view.getDisplay().getActiveIndices();
	}

	public void runCommands(String input) {
		NodeObject compiledCommandsTree = myInterpreter.interpret(input);
		compiledCommandsTree.traverseAndExecute(this);
		updateVariablesListInGUI();
	}

	public void updateVariablesListInGUI() {
		HashMap<String, Double> variableMap = (HashMap<String, Double>) myVariableLibrary.getVariableMap();
		myView.getVariablesObject().clear();
		for (String s : variableMap.keySet()) {
			String variableMapping = s.substring(1) + " = " + variableMap.get(s);
			myView.getVariablesObject().add(variableMapping);
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


	public double commandTurtles(TurtleCommandInterface command) {
		double returnVal = 0;
		HashSet<Integer> activeIndicesSet = myView.getDisplay().getActiveIndices();
		for (int i = 0; i < myView.getDisplay().getCharacters().size(); i++) {
			if (activeIndicesSet.contains(i)){
				HashSet<Integer> storedSet = new HashSet<Integer>(activeIndicesSet);
				activeIndicesSet= new HashSet<Integer>();
				activeIndicesSet.add(i);
				System.out.println("iiiii " + i);
				returnVal = command.doTurtling(myView.getDisplay().getCharacters().get(i), this);
				activeIndicesSet = storedSet;
			}
		}
		return returnVal;
	}

	public double getActiveID() {
		HashSet<Integer> activeSet = myView.getDisplay().getActiveIndices();
		return new ArrayList<Integer>(activeSet).get(0) + 1;
	}
	

}
