package slogo.nodes;

import slogo.interpreter.ControlInterface;
import slogo.interpreter.InterpreterException;

public class ListStartNode extends NodeObject {

	public ListStartNode(String value, String rawString, NodeObject parent) {
		super(value, rawString, parent);
	}

	@Override
	public boolean hasCompleteChildren() {
		return ! canAdd();
	}

	@Override
	public void addChild(NodeObject node) {
		myChildren.add(node);
	}

	@Override
	public boolean canAdd() {
		if (myChildren.size() < 1) return true;
		return !(myChildren.get(myChildren.size()-1) instanceof ListEndNode);
	}

	@Override
	public double traverseAndExecute(ControlInterface controller) {
		double returnVal = 0;
		if (myChildren.size() < 1) {
			throw new InterpreterException("Missing closing bracket ]");
		}
		if (! (myChildren.get(myChildren.size() -1 ) instanceof ListEndNode)) {
			throw new InterpreterException("Missing closing bracket ]");
		}
		for (NodeObject child: myChildren) {
			returnVal = child.traverseAndExecute(controller);
		}
		return returnVal;
	}

}
