package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;


public class PenUp extends Command {
	
	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		System.out.println("Pen is up.");
		return 0;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 0;
	}

}
