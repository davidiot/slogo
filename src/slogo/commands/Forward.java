package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;

public class Forward extends Command {

	public Forward(MainCharacter character) {
		super(character);
	}

	@Override
	public double doCommand(List<Double> params) {
		double distanceMoved = params.get(0);
		System.out.println("Moved forward " + distanceMoved);
		return distanceMoved;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 1;
	}

}
