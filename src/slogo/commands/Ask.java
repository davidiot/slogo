package slogo.commands;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import slogo.interpreter.ControlInterface;
import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class Ask extends Command {
	private final int CHILDREN_REQUIRED = 2;


	@Override
	public double doCommand(List<NodeObject> params, ControlInterface controller) {
		List<Integer> IDs =  getIDs(params.get(0), controller);
		Set<Integer> storedIDs = new HashSet<>(controller.getTurtleController().getActiveIndices());
		controller.getTurtleController().setActiveIDs(IDs);
		double result = params.get(1).traverseAndExecute(controller);
		controller.getTurtleController().setActiveIDs(storedIDs);
		return result;
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}
	
	private ArrayList<Integer> getIDs(NodeObject nodeObject, ControlInterface controller) {
		ArrayList<Integer> idList = new ArrayList<Integer>();
		for (int i = 0; i < nodeObject.getAllChildren().size() - 1; i ++) {
			idList.add(new Integer((int) nodeObject.getAllChildren().get(i).traverseAndExecute(controller)));
		}
		return idList;
	}

}
