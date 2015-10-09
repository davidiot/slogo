package slogo.interpreter;

import java.util.LinkedList;
import java.util.List;

import slogo.action.Action;

public class Node {
	private Node myParent;
	private List<Node> myChildren;
	private Action myAction;
	
	public Node(Action action) {
		myChildren = new LinkedList<Node>();
		myAction = action;
	}
	
	public void addChild(Node child) {
		myChildren.add(child);
	}

	public void execute() {
		// TODO Auto-generated method stub
		
	}

	public boolean hasCompleteChildren() {
		// first check this node
		if (myAction != null) {
			if (myAction.numParameters() != myChildren.size()) return false;
		}
		// recursively check children
		boolean complete = true;
		for (Node child: myChildren) {
			complete = complete && child.hasCompleteChildren();
		}
		return complete;
	}

}
