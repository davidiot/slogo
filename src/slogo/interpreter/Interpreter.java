package slogo.interpreter;

import java.util.List;

import slogo.nodes.NodeObject;

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
		List<InputObject> parsedInput = myParser.parse(input);
		NewCommandFinder newCommands = new NewCommandFinder(parsedInput);
		TemporaryCommandLibrary temp = newCommands.findCustomCommands();
		TreeBuilder treeBuilder = new TreeBuilder(myCommandLibrary, myVariables, temp, parsedInput);
		NodeObject commandTree = treeBuilder.buildTreeFromInput();
		return commandTree;		
	}

}
