package slogo.interpreter;

import java.util.List;

import slogo.nodes.Node;
import slogo.nodes.RootNode;
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
		TreeBuilder treeBuilder = new TreeBuilder(myCommandLibrary, myVariables);
		List<String> parsedInput = myParser.parse(input);
		Node commandTree = treeBuilder.buildTreeFromInput(parsedInput);
		commandTree.traverseAndExecute();
		
	}
	
	/**
	 * FOR TESTING
	 */
	
	
//	public static void main (String[] args) {
//		Interpreter i = new Interpreter("English", null);
//		i.interpret("if fd 8 [ fd 9 ]");
//	}
	
	/*
	public void print(Node root) {
		for (Node node: root.getAllChildren()) {
			print(node);
		}
		//System.out.println(root.getAction());
	}
	*/

}
