package slogo.interpreter;

import java.util.List;

import slogo.nodes.CommandNode;
import slogo.nodes.Node;
import slogo.nodes.NodeFactory;
import slogo.nodes.RootNode;


public class CommandTree {
	private Node root;
	private String myLanguage;
	private CommandLibrary myActions;
	private VariableLibrary myVariables;
	//private Parser myTranslator;
	private NodeFactory	myFactory;


	public CommandTree(String language, CommandLibrary actions, VariableLibrary variables) {
		//myTranslator = new Parser(language);
		// Change to something besides command node
		myFactory = new NodeFactory(actions, variables);
		root = new RootNode(null);
		myLanguage = language;
		myActions = actions;
		myVariables = variables;
	}

	public void build(List<String> input) {
		//List<String> parsed = myTranslator.parse(input);
		//System.out.println(parsed);
		Node current = root;
		while(input.size() > 0){
			if(current.canAdd()) {
				// TODO throw exception if action doesn't exist
				Node node = myFactory.create(input, current);
				current.addChild(node);
				current = node;
			} else {
				current = current.getParent();
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
