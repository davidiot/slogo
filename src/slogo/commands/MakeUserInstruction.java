package slogo.commands;

import java.util.ArrayList;
import java.util.List;

import slogo.character.CharacterInterface;
import slogo.character.MainCharacter;
import slogo.interpreter.CommandLibrary;
import slogo.interpreter.VariableLibrary;
import slogo.nodes.CommandDeclarationNode;
import slogo.nodes.NodeObject;
import slogo.nodes.VariableNode;

public class MakeUserInstruction extends Command {

	private CommandLibrary myCommands;
	
	public MakeUserInstruction(CommandLibrary commands) {
		myCommands = commands;
	}
	
	@Override
	public double doCommand(List<NodeObject> params, CharacterInterface character) {
		// TODO throw exceptions
		String name = ((CommandDeclarationNode) params.get(0)).getName();
		List<String> parameters = getParameterList(params.get(1));
		NodeObject tree = params.get(2);
		UserInstruction newCommand = new UserInstruction(name, parameters, tree); 
		System.out.println("made " + name + " with params " + parameters);
		
		return 0;
	}

	private List<String> getParameterList(NodeObject nodeObject) {
		List<String> parameters = new ArrayList<>();
		List<NodeObject> children = nodeObject.getAllChildren();
		for (NodeObject child: children) {
			if (child instanceof VariableNode) {
				parameters.add(((VariableNode) child).getName());
			}
		}
		return parameters;
	}

	@Override
	public int getNumChildrenRequired() {
		// 3 children: command node with name, start list of params, start list of fuction body
		return 3;
	}

}
