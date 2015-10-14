package slogo.commands;

import java.util.List;

import slogo.character.MainCharacter;

public class Left extends Command {
	
	@Override
	public double doCommand(List<Double> params) {
		double degreesTurned = params.get(0);
		System.out.println("Turned " + params.get(0) + " left.");
		return degreesTurned;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 1;
	}

}
