package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;


public class Home extends Command {
	
	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		return controller.getMainCharacter().goHome();
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 0;
	}

}
