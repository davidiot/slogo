package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;

public class SetHeading extends Command {
	
	@Override
	public double doCommand(MainCharacter character, List<Double> params) {
		double currentHeading = character.getImageView().getRotate();
		double destinationHeading = params.get(0);
		System.out.println("Set the heading to " + params.get(0));
		return destinationHeading - currentHeading;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 1;
	}

}
