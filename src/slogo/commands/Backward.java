package slogo.commands;

import java.util.List;


import slogo.character.CharacterInterface;
import slogo.nodes.*;

public class Backward extends Command {
	
	private final int CHILDREN_REQUIRED = 1;
	
	@Override
	public double doCommand(List<NodeObject> params, CharacterInterface character) {
		List<Double> parameters = recurseToGetParameters(params, character);
		Double distance = parameters.get(0);
		character.move(distance*(-1));
		return distance;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return CHILDREN_REQUIRED;
	}

}
