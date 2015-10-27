package slogo.commands;

import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;


public class Home extends TurtleCommand {
	
//	@Override
//	public double doCommand(List<NodeObject> params, EngineController controller) {
//		return controller.getMainCharacter().goHome();
//	}

	@Override
	public int getNumChildrenRequired() {
		return 0;
	}

	@Override
	public double doTurtling(MainCharacter turtle, EngineController controller) {
		return turtle.goHome();
	}

}
