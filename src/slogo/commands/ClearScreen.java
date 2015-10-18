package slogo.commands;

import java.util.List;

import slogo.character.CharacterInterface;
import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;
import slogo.nodes.*;


public class ClearScreen extends Command {
	

	public double doCommand(List<NodeObject> params, EngineController engine) {
		double currentX = engine.getMainCharacter().getImageView().getX();
		double currentY = engine.getMainCharacter().getImageView().getY();
		double destinationX = 0;
		double destinationY = 0;
		double distance = Math.sqrt((destinationX - currentX)*(destinationX - currentX)
				+ (destinationY - currentY)*(destinationY - currentY));
		System.out.println("Cleared screen. Distance moved: ");
		engine.getScreen().clearMap();
		return distance;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 0;
	}

}
