package slogo.nodes;

import slogo.character.CharacterInterface;
import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;

public class ListStartNode extends NodeObject {

	public ListStartNode(NodeObject parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasCompleteChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addChild(NodeObject node) {
		myChildren.add(node);
	}

	@Override
	public boolean canAdd() {
		// TODO Auto-generated method stub
		if (myChildren.size() < 1) return true;
		return !(myChildren.get(myChildren.size()-1) instanceof ListEndNode);
	}

	@Override
	public double traverseAndExecute(EngineController controller) {
		// TODO Auto-generated method stub
		double returnVal = 0;
		for (NodeObject child: myChildren) {
			returnVal = child.traverseAndExecute(controller);
		}
		return returnVal;
	}

}
