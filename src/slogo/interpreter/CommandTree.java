package slogo.interpreter;

import java.util.Iterator;
import java.util.List;

import slogo.commands.Command;


public class CommandTree {
	private Node root;
	private String myLanguage;
	private CommandLibrary myActions;
	private VariableLibrary myVariables;
	private SyntaxTranslator myTranslator;


	public CommandTree(String language, CommandLibrary actions, VariableLibrary variables) {
		myTranslator = new SyntaxTranslator(language);
		root = new Node(null);	// root has no action
		myLanguage = language;
		myActions = actions;
		myVariables = variables;	
	}

	public void build(String input) {
		List<String> translated = myTranslator.parse(input);
		Node current = root;
		Iterator<String> iter = translated.iterator();
		while(iter.hasNext()){
			if(current.canAdd()) {
				// TODO throw exception if action doesn't exist
				Command command = CommandLibrary.getAction(iter.next());
				Node node = new Node(command);
				current.addChild(node);
				node.setParent(current);
				current = node;
			}
		}
		if (! current.hasCompleteChildren()) {
			// TODO throw incorrect formatting exception
			// functions do not have enough parameters
		}
		
	}

	// Probably don't need this
	//	private boolean treeComplete() {
	//		return root.hasCompleteChildren();
	//	}
	
	public void run() {
		root.traverseAndExecute();
	}

	

}
