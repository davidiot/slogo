package slogo.commands;

import java.util.List;
import slogo.character.MainCharacter;
import slogo.nodes.*;


public class Home extends Command {
	
	@Override
	public double doCommand(List<NodeObject> params, MainCharacter character) {
		/*double currentX = character.getImageView().getX();
		double currentY = character.getImageView().getY();
		double destinationX = 0;
		double destinationY = 0;
		double distance = Math.sqrt((destinationX - currentX)*(destinationX - currentX)
				+ (destinationY - currentY)*(destinationY - currentY));*/
		System.out.println("Went home. Distance moved: ");
		return 0;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 0;
	}

}
