package slogo.interpreter;

import java.util.LinkedList;
import java.util.List;

public abstract class Node {
	protected Node myParent;
	protected List<Node> myChildren;
	
	public Node() {
		myChildren = new LinkedList<Node>();
	}
	
	
	abstract boolean hasCompleteChildren();
	
	
	public List<Node> getAllChildren() {
		return myChildren;
	}

}
