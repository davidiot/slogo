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
		//System.out.println(parsed);
		Node current = root;
		while(parsed.size() > 0){
			if(current.canAdd()) {
				// TODO throw exception if action doesn't exist
				Node node = myFactory.create(parsed, current);
				current.addChild(node);
				current = node;
			}
		}
		// now check whether each function has enough parameters
		if(! treeComplete(current)) {
			// TODO throw an exception
		}
	}
	
	private boolean treeComplete(Node current) {
		// move up the tree from the current node checking whether each parent
		// has enough parameters
		while (current != null) {
			if (! current.hasCompleteChildren()) return false;
			current = current.getParent();
		}
		return true;

	}

	public void run() {
		root.traverseAndExecute();
	}	

}
