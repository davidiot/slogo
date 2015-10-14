package slogo.nodes;

import java.util.LinkedList;
import java.util.List;

public abstract class Node {
	protected Node myParent;
	protected List<Node> myChildren;
	
	public Node(Node parent) {
		myChildren = new LinkedList<Node>();
		myParent = parent;
	}
	
	public abstract boolean hasCompleteChildren();
	
	public List<Node> getAllChildren() {
		return myChildren;
	}


	public abstract void addChild(Node node);

	public abstract boolean canAdd();

	public abstract double traverseAndExecute();

	public Node getParent() {
		return myParent;
	}

}
