package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.interpreter.InterpreterException;
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
		if (! ( params.get(0) instanceof VariableNode)) {
			throw new InterpreterException("Expected variable name to make variable, not %s", params.get(0).getName());
		}
			String name = ((VariableNode)params.get(0)).getName();
		double value = params.get(1).traverseAndExecute(controller);
		System.out.println("making " + name + " " + value);
		myVariables.addVariable(name, value);
		return value;
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

}
