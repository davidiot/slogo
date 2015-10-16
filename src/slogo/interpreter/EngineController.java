package slogo.interpreter;

import slogo.screen.SlogoScreen;

public class EngineController {

	private Interpreter myInterpreter;
	private SlogoScreen myView;
	private CommandLibrary myCommandLibrary;
	private VariableLibrary myVariables;
	
	public EngineController(String language, SlogoScreen view) {
		myView = view;
		myVariables = new VariableLibrary();
		myCommandLibrary = new CommandLibrary(myVariables);
		myInterpreter = new Interpreter(language, myCommandLibrary, myVariables);
	}

	public void sendToInterpreter(String input){
		myInterpreter.interpret(input);
	}
}
