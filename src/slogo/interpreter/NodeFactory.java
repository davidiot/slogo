package slogo.interpreter;

import java.util.List;

public class NodeFactory{

	private CommandLibrary myActions;
	private VariableLibrary myVariables;

	public NodeFactory(CommandLibrary actions, VariableLibrary variables) {
		myActions = actions;
		myVariables = variables;
	}

	public Node create(List<String> translated, List<String> types, Node parent) {
		Node new_node = null;
		String start = translated.remove(0);
		switch(translated.remove(0)){
		case "Command": new_node = makeCommandNode(start, parent);
		}
		return new_node;
	}

	private Node makeCommandNode(String name, Node parent) {
		return new CommandNode(myActions.getAction(name), parent);
	}

}
