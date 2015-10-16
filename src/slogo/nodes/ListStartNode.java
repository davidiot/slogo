package slogo.nodes;

public class ListStartNode extends Node {

	public ListStartNode(Node parent) {
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
		myChildren.add(node);
	}

	@Override
	public boolean canAdd() {
		// TODO Auto-generated method stub
		if (myChildren.size() < 1) return true;
		return !(myChildren.get(myChildren.size()-1) instanceof ListEndNode);
	}

	@Override
	public double traverseAndExecute() {
		// TODO Auto-generated method stub
		double returnVal = 0;
		for (Node child: myChildren) {
			returnVal = child.traverseAndExecute();
		}
		return returnVal;
	}

}
