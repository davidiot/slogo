package slogo.nodes;

import slogo.interpreter.EngineController;

public class ListEndNode extends NodeObject {

	public ListEndNode(String value, NodeObject parent) {
		super(value, parent);
	}

	@Override
	public boolean hasCompleteChildren() {
		return true;
	}

	@Override
	public void addChild(NodeObject node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canAdd() {
		return false;
	}

	@Override
	public double traverseAndExecute(EngineController controller) {
		return 0;
	}

}
