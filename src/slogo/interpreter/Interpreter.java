package slogo.interpreter;

import java.util.List;

import slogo.nodes.NodeObject;
import slogo.nodes.RootNode;
import slogo.screen.SlogoScreen;

public class Interpreter {
	private String myLanguage;
	private CommandLibrary myCommandLibrary;
	private VariableLibrary myVariables;
	private Parser myParser;

	public Interpreter(String language, CommandLibrary commandLibrary, VariableLibrary variableLibrary) {
		myLanguage = language;
		myVariables = variableLibrary;
		myCommandLibrary = commandLibrary;
		myParser = new Parser(language);
	}
	
	public NodeObject interpret(String input) {
		TreeBuilder treeBuilder = new TreeBuilder(myCommandLibrary, myVariables);
		List<String> parsedInput = myParser.parse(input);
		NodeObject commandTree = treeBuilder.buildTreeFromInput(parsedInput);
		return commandTree;		
	}

}
