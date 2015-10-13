package slogo.interpreter;

public class VariableNode extends Node {
	private double myName;

	public VariableNode(Node parent, double name) {
		super(parent);
		myName = name;
	}

	@Override
	public boolean hasCompleteChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addChild(Node node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canAdd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double traverseAndExecute() {
		// TODO Auto-generated method stub
		return 0;
	}

}
