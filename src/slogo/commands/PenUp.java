package slogo.commands;

import java.util.List;
import slogo.character.MainCharacter;
import slogo.nodes.*;


public class PenUp extends Command {
	
	@Override
	public double doCommand(List<NodeObject> params, MainCharacter character) {
		System.out.println("Pen is up.");
		return 0;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 0;
	}

}
