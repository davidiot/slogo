package slogo.interpreter;

import slogo.nodes.NodeObject;
import slogo.screen.SlogoScreen;

public class EngineController {

	private Interpreter myInterpreter;
	private SlogoScreen myView;
	private CommandLibrary myCommandLibrary;
	private VariableLibrary myVariables;
	
	private final int DEFAULT_CHARACTER = 0;
	
	public EngineController(String language, SlogoScreen view) {
		myView = view;
		myVariables = new VariableLibrary();
		myCommandLibrary = new CommandLibrary(myVariables);
		myInterpreter = new Interpreter(language, myCommandLibrary, myVariables);
	}

	public void runCommands(String input){
		NodeObject compiledCommandsTree = myInterpreter.interpret(input);
		compiledCommandsTree.traverseAndExecute(myView.getDisplay().getCharacter(DEFAULT_CHARACTER));
	}
	
	
}
