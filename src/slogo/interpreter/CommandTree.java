package slogo.interpreter;


public class CommandTree {
	
	Node root;

	public CommandTree() {
		root = new Node(null);	// root has no action
	}

	public void build(String[] input) {
		
		
	}

	private boolean treeComplete() {
		return root.hasCompleteChildren();
	}

	public void run() {
		root.execute();
	}

}
