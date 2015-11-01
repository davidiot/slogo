package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.interpreter.ControlInterface;
import slogo.nodes.NodeObject;

public abstract class TurtleCommand extends Command implements TurtleCommandInterface{

	protected List<NodeObject> myParams;
	protected ControlInterface myController;

	@Override
	public double doCommand(List<NodeObject> params, ControlInterface controller) {
		myParams = params;
		myController = controller;
		return controller.getTurtleController().commandTurtles(this);
	}

	@Override
	public abstract int getNumChildrenRequired();

	@Override
	public abstract double doTurtling(MainCharacter turtle);

}
