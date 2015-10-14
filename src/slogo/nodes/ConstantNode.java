package slogo.nodes;


public class ConstantNode extends Node {
	private double myValue;

	public ConstantNode(double value, Node parent) {
		super(parent);
		myValue = value;
	}

	@Override
	public boolean hasCompleteChildren() {
		return true;
	}

	@Override
	public void addChild(Node node) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canAdd() {
		return false;
	}

	@Override
	public double traverseAndExecute() {
		return myValue;
	}

}
