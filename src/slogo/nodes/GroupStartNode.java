package slogo.nodes;

import slogo.interpreter.EngineController;
import slogo.interpreter.InterpreterException;

public class GroupStartNode extends NodeObject {

	public GroupStartNode(String name, NodeObject parent) {
		super(name, parent);
	}

	@Override
	public boolean hasCompleteChildren() {
		return ! canAdd() ;
	}

	@Override
	public void addChild(NodeObject node) {
		myChildren.add(node);
	}

	@Override
	public boolean canAdd() {
		if (myChildren.size() < 1) return true;
		return !(myChildren.get(myChildren.size()-1) instanceof GroupEndNode);
	}

	@Override
	public double traverseAndExecute(EngineController controller) {
		if (myChildren.size() < 1) {
			throw new InterpreterException("Missing ) to close group");
		}
		if (! (myChildren.get(myChildren.size() -1 ) instanceof GroupEndNode)) {
			throw new InterpreterException("Missing ) to close group");
		}
		if (!(myChildren.get(0) instanceof CommandNode)) {
			throw new InterpreterException("Expected default command after (");
		}
		if (! ((CommandNode) myChildren.get(0)).canGroup()) {
			throw new InterpreterException("Command %s does not support grouping", myChildren.get(0).getName());
		}
		NodeObject groupedCommand = myChildren.get(0);
		// first child is command last child is group end node
		for (int i = 1; i < myChildren.size() - 1; i ++ ) {
			groupedCommand.addChild(myChildren.get(i));
		}
		return groupedCommand.traverseAndExecute(controller);
	}

}
