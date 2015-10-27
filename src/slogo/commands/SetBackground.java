package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class SetBackground extends Command {
	private final int CHILDREN_REQUIRED = 1;
	
	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		List<Double> parameters = this.recurseToGetParameters(params, controller);
		double index = parameters.get(0);
		int indexInteger = (int) index;
		controller.getScreen().getDisplay().changeColorIndex(indexInteger);
		return index;
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

}
