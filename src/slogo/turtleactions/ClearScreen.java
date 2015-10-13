package slogo.turtleactions;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.commands.Command;

public class ClearScreen extends Command {

	public ClearScreen(MainCharacter character) {
		super(character);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double doCommand(List<Double> params) {
		double currentX = myCharacter.getImageView().getX();
		double currentY = myCharacter.getImageView().getY();
		double destinationX = 0;
		double destinationY = 0;
		double distance = Math.sqrt((destinationX - currentX)*(destinationX - currentX)
				+ (destinationY - currentY)*(destinationY - currentY));
		System.out.println("Cleared screen. Distance moved: " + distance);
		return distance;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 0;
	}

}
