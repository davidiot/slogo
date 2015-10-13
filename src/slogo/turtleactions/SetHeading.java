package slogo.turtleactions;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.commands.Command;

public class SetHeading extends Command {

	public SetHeading(MainCharacter character) {
		super(character);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double doCommand(List<Double> params) {
		double currentHeading = myCharacter.getImageView().getRotate();
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
