package slogo.interpreter;

import slogo.screen.SlogoScreen;

public class Interpreter {
	private String language;
	private SlogoScreen view;
	private CommandParser parser; 

	public Interpreter(String language, SlogoScreen view) {
		this.language = language;
		this.view = view;
		this.parser = new CommandParser();
	}

	public void interpret(String input) {
		CommandTree tree = parser.build(input);
		tree.run();
		
	}

}
