package slogo.commands;

import java.util.ArrayList;
import java.util.List;

import slogo.interpreter.CommandLibrary;
import slogo.interpreter.EngineController;
import slogo.interpreter.InterpreterException;
import slogo.nodes.CommandDeclarationNode;
import slogo.nodes.ListEndNode;
import slogo.nodes.NodeObject;
import slogo.nodes.VariableNode;

public class MakeUserInstruction extends Command {

	private CommandLibrary myCommandLibrary;
	
	/*
	public MakeUserInstruction(CommandLibrary commands) {
		myCommands = commands;
	}
	*/
	
	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		// TODO throw exceptions
		myCommandLibrary = controller.getCommandLibrary();
		if (! (params.get(0) instanceof CommandDeclarationNode)) {
			throw new InterpreterException("Expected command name following declaration not %s", params.get(0).getName());
		}
		String name = params.get(0).getName();
		List<String> parameters = getParameterList(params.get(1));
		NodeObject tree = params.get(2);
		UserInstruction newCommand = new UserInstruction(name, parameters, tree); 
		System.out.println("made " + name + " with params " + parameters);
		myCommandLibrary.addCommand(name, newCommand);
		return 0;
	}

	private List<String> getParameterList(NodeObject nodeObject) {
		List<String> parameters = new ArrayList<>();
		List<NodeObject> children = nodeObject.getAllChildren();
		for (NodeObject child: children) {
			if (child instanceof VariableNode) {
				parameters.add(((VariableNode) child).getName());
			} else if (child instanceof ListEndNode){
				break;
			} else {
				throw new InterpreterException("Expected variable names in parameters list, not %s", child.getName());
			}
		}
		return parameters;
	}

	@Override
	public int getNumChildrenRequired() {
		// 3 children: command node with name, start list of params, start list of function body
		return 3;
	}

}
