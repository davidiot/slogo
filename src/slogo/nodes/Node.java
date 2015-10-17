package slogo.nodes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class Node {
	protected Node myParent;
	protected List<Node> myChildren;
	protected Map<String, Double> localVariables;
	
	public Node(Node parent) {
		myChildren = new LinkedList<Node>();
		myParent = parent;
		localVariables = new HashMap<>();
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
