package slogo.commands;

import java.util.List;

import slogo.interpreter.CommandLibrary;
import slogo.interpreter.VariableLibrary;
import slogo.nodes.Node;

public class MakeUserInstruction extends Command {

	private CommandLibrary myCommands;
	
	public MakeUserInstruction(CommandLibrary commands) {
		myCommands = commands;
	}
	
	@Override
	public double doCommand(List<Node> params) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int getNumChildrenRequired() {
		// 3 children: command node with name, start list of params, start list of fuction body
		return 3;
	}

}
