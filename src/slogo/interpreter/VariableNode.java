package slogo.interpreter;

public class VariableNode extends Node {

	public VariableNode(Node parent) {
		super(parent);
		// TODO Auto-generated constructor stub
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
