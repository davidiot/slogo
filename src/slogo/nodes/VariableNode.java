package slogo.nodes;


public class VariableNode extends Node {
	private String myName;

	public VariableNode(Node parent, String name) {
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
	
	public String getName() {
		return myName;
	}

}
