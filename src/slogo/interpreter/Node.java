package slogo.interpreter;

import java.util.LinkedList;
import java.util.List;

import slogo.commands.Command;

public class Node {
	
	private Node myParent;
	private List<Node> myChildren;
	private Command myAction;
	
	public Node(Command action) {
		myChildren = new LinkedList<Node>();
		myAction = action;
	}
	
	public void addChild(Node child) {
		myChildren.add(child);
	}

	public double traverseAndExecute() {
		return 0;
		// TODO Auto-generated method stub
		
	}

	public boolean hasCompleteChildren() {
		// first check this node
		if (myAction != null) {
			if (myAction.getNumChildrenRequired() != myChildren.size()) return false;
		}
		// recursively check children
		boolean complete = true;
		for (Node child: myChildren) {
			complete = complete && child.hasCompleteChildren();
		}
		return complete;
	}

	public boolean canAdd() {
		if (myAction == null) return true;
		if (myChildren.size() >= myAction.getNumChildrenRequired()) return false;
		return true;
	}

	public void setParent(Node parent) {
		myParent = parent;
		
	}

	public List<Node> getAllChildren() {
		return myChildren;
	}

	public String getAction() {
		return myAction.toString();
	}

}
