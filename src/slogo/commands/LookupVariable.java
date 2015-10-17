package slogo.commands;

import java.util.List;

import slogo.interpreter.VariableLibrary;
import slogo.nodes.Node;

public class LookupVariable extends Command {
	
	private VariableLibrary myVariables;
	
	public LookupVariable (VariableLibrary variables) {
		myVariables = variables;
	}

	@Override
	public double doCommand(List<Node> params) {
		return 0;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 0;
	}

}
