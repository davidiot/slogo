package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class If extends Command {

	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		// TODO Auto-generated method stub
		double expression = params.get(0).traverseAndExecute(controller);
		if (expression != 0) {
			params.get(1).traverseAndExecute(controller);
		}
		return 0;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 2;
	}

}
