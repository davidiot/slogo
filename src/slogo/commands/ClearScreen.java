package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;


public class ClearScreen extends Command {
	

	public double doCommand(List<NodeObject> params, EngineController engine) {
		/*double currentX = engine.getMainCharacter().getX();
		double currentY = engine.getMainCharacter().getY();
		double destinationX = 0;
		double destinationY = 0;
		double distance = Math.sqrt((destinationX - currentX)*(destinationX - currentX)
				+ (destinationY - currentY)*(destinationY - currentY)); */
		System.out.println("Cleared screen. Distance moved: ");
		engine.getScreen().clearMap();
		return engine.getMainCharacter().goHome();
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 0;
	}

}
