// This entire file is part of my masterpiece.
// Daniel McKee

package slogo.commands;

import java.util.List;

import slogo.character.CharacterInterface;

public class Forward extends TurtleCommand{
	private final int CHILDREN_REQUIRED = 1;


	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}

	@Override
	public double doTurtling(CharacterInterface turtle ) {
		List<Double> parameters = recurseToGetParameters(myParams, myController);
		double distance = parameters.get(0);
		turtle.move(distance, true);
		return distance;
	}


}
