package slogo.commands;

import java.util.List;

import slogo.nodes.Node;

public class If extends Command {

	@Override
	public double doCommand(List<Node> params) {
		// TODO Auto-generated method stub
		double expression = params.get(0).traverseAndExecute();
		if (expression != 0) {
			params.get(1).traverseAndExecute();
		}
		return 0;
	}

	@Override
	public int getNumChildrenRequired() {
		// TODO Auto-generated method stub
		return 2;
	}

}
