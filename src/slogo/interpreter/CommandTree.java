package slogo.interpreter;

import java.util.LinkedList;
import java.util.List;

public class CommandTree {
	Node root;

	public CommandTree() {
		root = new Node(null);	// root has no action
	}
	
	private boolean treeComplete() {
		return root.hasCompleteChildren();
	}

	public void run() {
		for (Node node: root) {
			node.execute();
		}
	}

}
