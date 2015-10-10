package slogo.interpreter;

import slogo.screen.SlogoScreen;

public class Interpreter {
	private String myLanguage;
	private SlogoScreen myView;
	private CommandTree myTree;

	public Interpreter(String language, SlogoScreen view) {
		myLanguage = language;
		myView = view;
	}

	public void interpret(String input) {
		CommandTree tree = new CommandTree(myLanguage);
		tree.build(input);
		tree.run();
		
	}
	
	/**
	 * FOR TESTING
	 */
	public static void main (String[] args) {
		Interpreter i = new Interpreter("English", null);
		i.interpret("fd 90");
	}

}
