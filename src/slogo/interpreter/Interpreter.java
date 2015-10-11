package slogo.interpreter;

import slogo.screen.SlogoScreen;

public class Interpreter {
	private String myLanguage;
	private SlogoScreen myView;
	private CommandTree myTree;
	private CommandLibrary actions;
	private VariableLibrary variables;
	private Parser myParser;

	public void interpret(String input) {
		//String[] translated = myParser.parseCommands(input);
		CommandTree tree = new CommandTree(myLanguage, actions, variables);
		tree.build(input);
		
	}
	
	public Interpreter(String language, SlogoScreen view) {
		myLanguage = language;
		myView = view;
		//myParser = new Parser(language);
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
	public static void main (String[] args) {
		Interpreter i = new Interpreter("English", null);
		i.interpret("fd 90");
	}
	
	public void print(Node root) {
		for (Node node: root.getAllChildren()) {
			print(node);
		}
		System.out.println(root.getAction());
	}

}
