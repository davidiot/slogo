package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.element.Display;
import slogo.interpreter.ControlInterface;
import slogo.interpreter.EngineController;

public class GetPenColor extends TurtleCommand {
	private final int CHILDREN_REQUIRED = 1;
	
	public double doTurtling(MainCharacter turtle, ControlInterface controller) {
		return 0;
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

}
