package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;

public class Forward extends Command {

	@Override
	public double doCommand(MainCharacter character, List<Double> params) {
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
