package slogo.commands;

import java.util.List;
import slogo.nodes.*;
import slogo.character.CharacterInterface;
import slogo.character.MainCharacter;

public class ShowTurtle extends Command {

	@Override
	public double doCommand(List<NodeObject> params, CharacterInterface character) {
		System.out.println("Showing turtle.");
		return 1;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 0;
	}

}
