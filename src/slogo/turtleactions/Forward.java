package slogo.turtleactions;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.commands.Command;

public class Forward extends Command {

	public Forward(MainCharacter character) {
		super(character);
	}

	@Override
	public double doCommand(List<Double> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 0;
	}

}
