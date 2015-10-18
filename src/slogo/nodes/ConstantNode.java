package slogo.nodes;

import slogo.interpreter.EngineController;

public class ConstantNode extends NodeObject {
	private double myValue;
	

	public ConstantNode(String value, NodeObject parent) {
		super(value, parent);
		myValue = Double.parseDouble(value);
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
		return myValue;
	}

}
