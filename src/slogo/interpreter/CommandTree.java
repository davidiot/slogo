package slogo.interpreter;

import java.util.List;


public class CommandTree {
	private Node root;
	private String myLanguage;
	private CommandLibrary myActions;
	private VariableLibrary myVariables;
	private Parser myTranslator;
	private NodeFactory	myFactory;


	public CommandTree(String language, CommandLibrary actions, VariableLibrary variables) {
		myTranslator = new Parser(language);
		myFactory = new NodeFactory(myActions, myVariables);
		// Change to something besides command node
		root = new CommandNode(null, null);
		myLanguage = language;
		myActions = actions;
		myVariables = variables;	
	}

	public void build(String input) {
		List<String> parsed = myTranslator.parse(input);
		System.out.println(parsed);
		Node current = root;
		while(parsed.size() > 0){
			if(current.canAdd()) {
				// TODO throw exception if action doesn't exist
//				Node node = myFactory.create(parsed, current);
//				current.addChild(node);
//				current = node;
			}
		}
		// need to modify this so that it checks that nodes above
		// have complete children as well
		if (! current.hasCompleteChildren()) {
			// TODO throw incorrect formatting exception
			// functions do not have enough parameters
		}	
	}
	
	public void run() {
		root.traverseAndExecute();
	}	

}
