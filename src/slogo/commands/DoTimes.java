package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.interpreter.InterpreterException;
import slogo.nodes.NodeObject;

public class DoTimes extends Command {

	private final int CHILDREN_REQUIRED = 2;

	@Override
	public double doCommand(List<NodeObject> params, ControlInterface controller) {
		checkFormat(params.get(0));
		double limit = getLimit(params.get(0));
		String variable = getVariable(params.get(0));
		double returnValue = 0;
		for (int i = 1; i<= limit; i++){
			params.get(1).setLocalVariable(variable, i);
			returnValue = params.get(1).traverseAndExecute(controller);
		}
		return returnValue;
	}


	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}
	
	private void checkFormat(NodeObject bracket) {
		if (bracket.getAllChildren().size() < 3) {
			throw new InterpreterException("DoTimes function format is wrong");
		}	
	}


	private String getVariable(NodeObject bracket) {
		return bracket.getAllChildren().get(0).getName();
	}


	private double getLimit(NodeObject bracket) {
		return Integer.parseInt(bracket.getAllChildren().get(1).getName());
	}

	
}
