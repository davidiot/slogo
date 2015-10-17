package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.interpreter.VariableLibrary;
import slogo.nodes.NodeObject;

public class LookupVariable extends Command {
	
	private VariableLibrary myVariables;
	
	public LookupVariable (VariableLibrary variables) {
		myVariables = variables;
	}

	@Override
	public double doCommand(List<NodeObject> params, MainCharacter character) {
		return 0;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 0;
	}

}
