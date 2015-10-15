package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;

public class Right extends Command {

	@Override
	public double doCommand(List<Double> params) {
		double degreesTurned = params.get(0);
		System.out.println("Turned right " + params.get(0) + " degrees.");
		return degreesTurned;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 1;
	}

}
