package slogo.interpreter;

import slogo.screen.SlogoScreen;

public class Interpreter {
	private String myLanguage;
	private SlogoScreen myView;
	private CommandTree myTree;
	private Parser myParser;
	
	public Interpreter(String language, SlogoScreen view) {
		myLanguage = language;
		myView = view;
		myParser = new Parser(language);
	}

	public void interpret(String input) {
		String[] parsedInput = myParser.parseCommands(input);
		
		CommandTree tree = new CommandTree();
		tree.build(parsedInput);
		tree.run();
		
	}

}
