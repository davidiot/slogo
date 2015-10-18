package slogo.nodes;

import slogo.character.CharacterInterface;

public class ListEndNode extends NodeObject {

	public ListEndNode(String value, NodeObject parent) {
		super(value, parent);
	}

	@Override
	public boolean hasCompleteChildren() {
		return true;
	}

	@Override
	public void addChild(NodeObject node) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canAdd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double traverseAndExecute(CharacterInterface character) {
		// TODO Auto-generated method stub
		return 0;
	}

}
