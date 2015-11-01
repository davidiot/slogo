package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.interpreter.ControlInterface;
import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class Backward extends TurtleCommand {
	//private List<NodeObject> myParams;
	private final int CHILDREN_REQUIRED = 1;
	
//	@Override
//	public double doCommand(List<NodeObject> params, EngineController controller) {
//		myParams = params;
////		List<Double> parameters = recurseToGetParameters(params, controller);
////		distance = parameters.get(0);
//		//controller.getMainCharacter().move(distance, false);
//		return controller.getTurtleController().commandTurtles(this);
//	}

	
	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

	@Override
	public double doTurtling(MainCharacter turtle) {
		List<Double> parameters = recurseToGetParameters(myParams, myController);
		double distance = parameters.get(0);
		turtle.move(distance, false);
		return distance;
	}

}
