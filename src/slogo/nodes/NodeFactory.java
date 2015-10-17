package slogo.nodes;

import slogo.interpreter.CommandLibrary;
import slogo.interpreter.VariableLibrary;

public class NodeFactory{

	private CommandLibrary myActions;
	private VariableLibrary myVariables;

	public NodeFactory(CommandLibrary actions, VariableLibrary variables) {
		myActions = actions;
		myVariables = variables;
	}

//	public Node create(List<String> parsed, Node parent) {
//		System.out.println(parsed);
//		Node new_node = null;
//		String[] entry = parsed.remove(0).split("\\s+");
//		String type = entry[0];
//		String value = entry[1];
//		switch(type){
//		case "Command": 
//			switch(value) {
//			case "MakeVariable":
//				// TODO
//				break;
//			case "If":
//				// TODO
//				break;
//			case "IfElse":
//				// TODO
//			break;
//			}
//			new_node = makeCommandNode(value, parent);
//			break;
//		case "Constant": 
//			new_node = makeConstantNode(value, parent);
//			break;
//		}
//		return new_node;
//	}
	
	
	public Node create(String parse, Node parent) {
		System.out.println(parse);
		Node new_node = null;
		String[] entry = parse.split("\\s+");
		String type = entry[0];
		String value = entry[1];
		switch(type){
		case "Command": 
			new_node = new CommandNode(myActions.getCommand(value), parent);
			break;
		case "Constant": 
			new_node = new ConstantNode(Integer.parseInt(value), parent);
			break;
		case "ListStart":
			new_node = new ListStartNode(parent);
			break;
		case "ListEnd":
			new_node = new ListEndNode(parent);
			break;
		case "Variable":
			new_node = new VariableNode(myVariables, parent, value);
			break;
		}
		return new_node;		
	}

}
