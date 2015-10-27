package slogo.interpreter;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javafx.scene.Node;
import slogo.character.CharacterInterface;
import slogo.character.MainCharacter;
import slogo.commands.TurtleCommandInterface;
import slogo.nodes.NodeObject;
import slogo.screen.SlogoScreenInterface;

public class EngineController {

	private Interpreter myInterpreter;
	private SlogoScreenInterface myView;
	private CommandLibrary myCommandLibrary;
	private VariableLibrary myVariableLibrary;
	private List<MainCharacter> myTurtles;
	private Set<Integer> activeIndices;
	
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

	private void updateVariablesListInGUI() {
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


//	public void commandTurtles(TurtleCommandInterface command) {
//		for (int i = 0; i < myTurtles.size(); i++) {
//			if (activeIndices.contains(i)){
//				command.doTurtling(myTurtles.get(i));
//			}
//		}
//		
//	}
	

}
