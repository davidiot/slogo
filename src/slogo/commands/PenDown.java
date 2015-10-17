package slogo.commands;

import java.util.List;
import slogo.character.MainCharacter;
import slogo.nodes.*;

public class PenDown extends Command {

	@Override
	public double doCommand(List<NodeObject> params, MainCharacter character) {
		System.out.println("Pen is down");
		return 1;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 0;
	}

}
