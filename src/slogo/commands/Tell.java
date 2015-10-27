package slogo.commands;

import java.util.ArrayList;
import java.util.List;

import slogo.interpreter.EngineController;
import slogo.nodes.NodeObject;

public class Tell extends Command {
	private final int CHILDREN_REQUIRED = 1;
	@Override
	public double doCommand(List<NodeObject> params, EngineController controller) {
		List<Integer> IDs =  getIDs(params.get(0), controller);
		controller.getTurtleController().setActiveIDs(IDs);
		return IDs.get(IDs.size()-1);
	}

	@Override
	public int getNumChildrenRequired() {
		return CHILDREN_REQUIRED;
	}
	
	private ArrayList<Integer> getIDs(NodeObject nodeObject, EngineController controller) {
		ArrayList<Integer> idList = new ArrayList<Integer>();
		for (int i = 0; i < nodeObject.getAllChildren().size() - 1; i ++) {
			idList.add(new Integer((int) nodeObject.getAllChildren().get(i).traverseAndExecute(controller)));
		}
		return idList;
	}

}
