package slogo.commands;

import java.util.List;
import slogo.character.MainCharacter;
import slogo.nodes.*;


public class Right extends Command {

	@Override
	public double doCommand(List<Node> params) {
		return 0;
		//double degreesTurned = params.get(0);
		//System.out.println("Turned right " + params.get(0) + " degrees.");
		//return degreesTurned;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 1;
	}

}
