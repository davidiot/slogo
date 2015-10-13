package slogo.turtleactions;

import java.util.List;

import slogo.character.MainCharacter;
import slogo.commands.Command;

public class SetTowards extends Command {

	public SetTowards(MainCharacter character) {
		super(character);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double doCommand(List<Double> params) {
		// needs to return the number of degrees that the turtle has turned.
		// therefore needs front end to have done that part of their project.
		System.out.println("Setting towards " + params.get(0) + " " + params.get(1));
		return 100;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 2;
	}

}
