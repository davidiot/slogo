package slogo.interpreter;

import java.util.LinkedList;
import java.util.List;

public abstract class Node {
	protected Node myParent;
	protected List<Node> myChildren;
	
	public Node() {
		myChildren = new LinkedList<Node>();
	}
	
	public abstract boolean hasCompleteChildren();
	
	public List<Node> getAllChildren() {
		return myChildren;
	}


	public abstract void addChild(Node node);
	
	public abstract void setParent(Node current);

	public abstract boolean canAdd();

	public abstract double traverseAndExecute();

}
