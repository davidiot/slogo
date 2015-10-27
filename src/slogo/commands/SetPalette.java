package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class SetPalette extends Command {
	private final int CHILDREN_REQUIRED = 4;
	
	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		List<Double> parameters = this.recurseToGetParameters(params, controller);
		double index = parameters.get(0);
		double r = parameters.get(1);
		double g = parameters.get(2);
		double b = parameters.get(3);
		int indexInt = (int) index; 
		int rInt = (int) r;
		int gInt = (int) g; 
		int bInt = (int) b;
		controller.getDisplay().setPaletteIndex(indexInt, rInt, gInt, bInt);
		return index;
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

}
