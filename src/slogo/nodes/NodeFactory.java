package slogo.nodes;

import java.util.List;

import slogo.interpreter.CommandLibrary;
import slogo.interpreter.VariableLibrary;

public class NodeFactory{

	private CommandLibrary myActions;
	private VariableLibrary myVariables;

	public NodeFactory(CommandLibrary actions, VariableLibrary variables) {
		myActions = actions;
		myVariables = variables;
	}

	public Node create(List<String> parsed, Node parent) {
		System.out.println(parsed);
		Node new_node = null;
		String[] entry = parsed.remove(0).split("\\s+");
		String type = entry[0];
		String value = entry[1];
		switch(type){
		case "Command": 
			switch(value) {
			case "MakeVariable":
				// TODO
				break;
			case "If":
				// TODO
				break;
			case "IfElse":
				// TODO
			break;
			}
			new_node = makeCommandNode(value, parent);
			break;
		case "Constant": 
			new_node = makeConstantNode(value, parent);
			break;
		}
		return new_node;
	}

	private Node makeConstantNode(String value, Node parent) {
		return new ConstantNode(Integer.parseInt(value), parent);
	}

	private Node makeCommandNode(String name, Node parent) {
		return new CommandNode(myActions.getAction(name), parent);
	}

}
