package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public abstract class TurtleCommand extends Command implements TurtleCommandInterface{

	protected List<Double> myParams;

	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		myParams = recurseToGetParameters(params, controller);
		//myParams = params;
		return controller.getTurtleController().commandTurtles(this);
	}

	@Override
	public abstract int getNumChildrenRequired();

	@Override
	public abstract double doTurtling(MainCharacter turtle);

}
