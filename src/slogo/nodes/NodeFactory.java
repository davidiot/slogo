package slogo.nodes;

import slogo.interpreter.CommandLibrary;
import slogo.interpreter.InputObject;
import slogo.interpreter.TemporaryCommandLibrary;
import slogo.interpreter.VariableLibrary;

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
		System.out.println("adding node  " + type + " " + value);
		switch(type){
		case "Command":
			if (myCommandLibrary.getCommand(value) != null) {
			new_node = new CommandNode(myCommandLibrary.getCommand(value), parent);
			} else {
//				System.out.println("making user command node " + value);
//				System.out.println("params " +  tempActions.getNumParameters(value));
				new_node = new UserCommandNode(parent, value, tempActions.getNumParameters(value), myCommandLibrary);
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
			new_node = new VariableNode(myVariables, parent, value);
			break;
		}
		return new_node;		
	}

}
