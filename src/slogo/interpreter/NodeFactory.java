package slogo.interpreter;

import java.util.List;

public class NodeFactory{

	private CommandLibrary myActions;
	private VariableLibrary myVariables;

	public NodeFactory(CommandLibrary actions, VariableLibrary variables) {
		myActions = actions;
		myVariables = variables;
	}

	public Node create(List<String> parsed, Node parent) {
		Node new_node = null;
		String start = parsed.get(0).split("\\s+")[0];
		switch(start){
		case "Command": new_node = makeCommandNode(start, parent);
		case "Constant": new_node = makeConstantNode(start, parent);
		}
		return new_node;
	}

	private Node makeConstantNode(String start, Node parent) {
		return null;
	}

	private Node makeCommandNode(String name, Node parent) {
		return new CommandNode(myActions.getAction(name), parent);
	}

}
