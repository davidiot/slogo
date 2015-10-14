package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;

public class ShowTurtle extends Command {

	public ShowTurtle(MainCharacter character) {
		super(character);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double doCommand(List<Double> params) {
		System.out.println("Showing turtle.");
		return 1;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 0;
	}

}
