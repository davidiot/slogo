package slogo.commands;

import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;


public class Left extends Command {
	
	@Override
	public double doCommand(List<NodeObject> params, EngineController character) {
		return 0;
		//double degreesTurned = params.get(0);
		//System.out.println("Turned " + params.get(0) + " left.");
		//return degreesTurned;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 1;
	}

}
