package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class PenDown extends Command {

	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		System.out.println("Pen is down");
		return 1;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 0;
	}

}
