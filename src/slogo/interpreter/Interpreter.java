package slogo.interpreter;

import java.util.List;

import slogo.nodes.Node;
import slogo.screen.SlogoScreen;

public class Interpreter {
	private String myLanguage;
	//private SlogoScreen myView;
	private CommandLibrary myCommandLibrary;
	private VariableLibrary myVariables;
	private Parser myParser;

	public Interpreter(String language, CommandLibrary commandLibrary, VariableLibrary variableLibrary) {
		myLanguage = language;
		//myView = view;
		myVariables = variableLibrary;
		myCommandLibrary = commandLibrary;
		myParser = new Parser(language);
	}
	
	public void interpret(String input) {
		//String[] translated = myParser.parseCommands(input);
		TreeBuilder tree = new TreeBuilder(myLanguage, myCommandLibrary, myVariables);
		List<String> parsedInput = myParser.parse(input);
		tree.build(parsedInput);
		tree.run();
		
	}

}
