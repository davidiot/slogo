package slogo.nodes;

public class RootNode extends Node {

	public RootNode(Node parent) {
		super(parent);
	}

	@Override
	public boolean hasCompleteChildren() {
		return true;
	}

	@Override
	public void addChild(Node node) {
		myChildren.add(node);
	}

	@Override
	public boolean canAdd() {
		return true;
	}

	@Override
	public double traverseAndExecute() {
		System.out.println(myChildren);
		for (Node child: myChildren){
			child.traverseAndExecute();
		}
		return 0;
	}

}
