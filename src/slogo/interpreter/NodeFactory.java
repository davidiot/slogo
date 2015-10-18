package slogo.interpreter;

import slogo.nodes.CommandDeclarationNode;
import slogo.nodes.CommandNode;
import slogo.nodes.ConstantNode;
import slogo.nodes.ListEndNode;
import slogo.nodes.ListStartNode;
import slogo.nodes.NodeObject;
import slogo.nodes.UserCommandNode;
import slogo.nodes.VariableNode;

public class NodeFactory{

	private CommandLibrary myCommandLibrary;
	private VariableLibrary myVariables;
	private TemporaryCommandLibrary tempActions;

	public NodeFactory(CommandLibrary actions, VariableLibrary variables, TemporaryCommandLibrary temps) {
		myCommandLibrary = actions;
		myVariables = variables;
		tempActions = temps;
	}
	
	public NodeObject create(InputObject input, NodeObject parent) {
		NodeObject new_node = null;
		String type = input.getType();
		String value = input.getValue();
//		System.out.println("adding node  " + type + " " + value);
		switch(type){
		case "Command":
			if (myCommandLibrary.getCommand(value) != null) {
			new_node = new CommandNode(myCommandLibrary.getCommand(value), parent);
			} else {
				new_node = new UserCommandNode(parent, value, tempActions.getNumParameters(value));
			}
			break;
		case "CommandDeclaration":
//			System.out.println("making dec node " + value);
			new_node = new CommandDeclarationNode(value, parent);
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
			new_node = new VariableNode(parent, value);
			break;
		}
		return new_node;		
	}

}
