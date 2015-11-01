package slogo.nodes;

import slogo.interpreter.ControlInterface;

public class ConstantNode extends NodeObject {
	private double myValue;
	

	public ConstantNode(String value, String rawString, NodeObject parent) {
		super(value, rawString, parent);
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
	public double traverseAndExecute(ControlInterface controller) {
		return myValue;
	}

}
