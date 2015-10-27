package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class Forward extends Command implements TurtleCommandInterface {
	
	private final int CHILDREN_REQUIRED = 1;


	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		List<Double> parameters = recurseToGetParameters(params, controller);
		double distance = parameters.get(0);
		return controller.getMainCharacter().move(distance, true);
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

	@Override
	public void doTurtling(MainCharacter turtle) {
		// TODO Auto-generated method stub
		
	}


}
