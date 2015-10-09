package slogo.interpreter;

import slogo.screen.SlogoScreen;

public class Interpreter {
	private String language;
	private SlogoScreen view;

	public Interpreter(String language, SlogoScreen view) {
		this.language = language;
		this.view = view;
	}

	public void interpret(String input) {
		CommandTree tree = new CommandTree();
		tree.build(input);
		tree.run();
		
	}

}
