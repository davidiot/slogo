package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.interpreter.VariableLibrary;
import slogo.nodes.NodeObject;
import slogo.nodes.VariableNode;

public class MakeVariable extends Command {
	
	private VariableLibrary myVariables;
	private final int CHILDREN_REQUIRED = 2;
	
	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		// first param is variable
		// second is expression
		// TODO if parameter types are wrong throw exception
		myVariables = controller.getVariableLibrary();
		double value = params.get(1).traverseAndExecute(controller);
		String name = ((VariableNode)params.get(0)).getName();
		System.out.println("making " + name + " " + value);
		myVariables.addVariable(name, value);
		return value;
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

}
