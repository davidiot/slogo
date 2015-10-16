package slogo.interpreter;

import java.util.List;

import slogo.nodes.Node;
import slogo.screen.SlogoScreen;

public class Interpreter {
	private String myLanguage;
	private SlogoScreen myView;
	//private CommandTree myTree;
	private CommandLibrary actions;
	private VariableLibrary variables;
	private Parser myParser;
	private CommandLibrary myCommandLibrary;

	public Interpreter(String language, SlogoScreen view) {
		myLanguage = language;
		myView = view;
		variables = new VariableLibrary();
		actions = new CommandLibrary(variables);
		myParser = new Parser(language);
		//myCommandLibrary = new CommandLibrary();
	}
	
	public void interpret(String input) {
		//String[] translated = myParser.parseCommands(input);
		TreeBuilder tree = new TreeBuilder(myLanguage, actions, variables);
		List<String> parsedInput = myParser.parse(input);
		tree.build(parsedInput);
		tree.run();
		
	}
	
	
	


//	public void interpret(String input) {
//		String[] parsedInput = myParser.parseCommands(input);
//		CommandTree tree = new CommandTree();
//		tree.build(parsedInput);
//		tree.run();	
//	}
	
	
	/**
	 * FOR TESTING
	 */
	
//	
//	public static void main (String[] args) {
//		Interpreter i = new Interpreter("English", null);
//		i.interpret("repeat fd  [ fd 9 ]");
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
