package slogo.commands;

import java.util.List;


import slogo.character.CharacterInterface;
import slogo.interpreter.EngineController;
import slogo.nodes.*;

public class Backward extends Command {
	
	private final int CHILDREN_REQUIRED = 1;
	
	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		List<Double> parameters = recurseToGetParameters(params, controller);
		Double distance = parameters.get(0);
		controller.getMainCharacter().move(distance*(-1));
		return distance;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return CHILDREN_REQUIRED;
	}

}
