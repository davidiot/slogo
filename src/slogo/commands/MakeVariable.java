package slogo.commands;

import java.util.List;

import slogo.interpreter.VariableLibrary;
import slogo.nodes.Node;
import slogo.nodes.VariableNode;

public class MakeVariable extends Command {
	private VariableLibrary myVariables;
	
	public MakeVariable(VariableLibrary variables) {
		myVariables = variables;
	}
	
	@Override
	public double doCommand(List<Node> params) {
		// first param is variable
		// second is expression
		// TODO if parameter types are wrong throw exception
		double value = params.get(1).traverseAndExecute();
		String name = ((VariableNode)params.get(0)).getName();
		System.out.println("making " + name + " " + value);
		myVariables.addVariable(name, value);
		return value;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 2;
	}

}
