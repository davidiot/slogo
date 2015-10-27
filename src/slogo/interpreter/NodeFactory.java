package slogo.interpreter;

import slogo.nodes.CommandDeclarationNode;
import slogo.nodes.CommandNode;
import slogo.nodes.ConstantNode;
import slogo.nodes.GroupEndNode;
import slogo.nodes.GroupStartNode;
import slogo.nodes.ListEndNode;
import slogo.nodes.ListStartNode;
import slogo.nodes.NodeObject;
import slogo.nodes.UserCommandNode;
import slogo.nodes.VariableNode;

public class NodeFactory {

	private CommandLibrary myCommandLibrary;
	private VariableLibrary myVariables;
	private NewUserCommandLibrary newCommands;

	public NodeFactory(CommandLibrary actions, VariableLibrary variables,
			NewUserCommandLibrary temps) {
		myCommandLibrary = actions;
		myVariables = variables;
		newCommands = temps;
	}

	public NodeObject create(InputObject input, NodeObject parent) {
		NodeObject new_node = null;
		String type = input.getType();
		String value = input.getValue();
		String raw = input.getRawString();
		// System.out.println(type + " " + value);
		switch (type) {
		case "Command":
			if (myCommandLibrary.getCommand(value) != null) {
				new_node = new CommandNode(value, raw,
						myCommandLibrary.getCommand(value), parent);
			} else {
				if (newCommands.getNumParameters(value) == null) {
					throw new InterpreterException(
							"User command %s does not exist", value);
				}
				new_node = new UserCommandNode(parent, value, raw, newCommands.getNumParameters(value));
			}
			break;
			
//		Node c = reflection.getClass(type + "Node").getConstructor(String.class, NodeObject.class, int.class)
//				.newInstance(value, parent, numParams);
//			
		case "CommandDeclaration":
			new_node = new CommandDeclarationNode(value, raw, parent);
			break;
		case "Constant":
			new_node = new ConstantNode(value, raw, parent);
			break;
		case "ListStart":
			new_node = new ListStartNode(value, raw, parent);
			break;
		case "ListEnd":
			new_node = new ListEndNode(value, raw, parent);
			break;
		case "GroupStart":
			new_node = new GroupStartNode(value, raw, parent);
			break;
		case "GroupEnd":
			new_node = new GroupEndNode(value, raw, parent);
			break;
		case "Variable":
			new_node = new VariableNode(value, raw, parent);
			break;
		}
		return new_node;
	}
	


}
