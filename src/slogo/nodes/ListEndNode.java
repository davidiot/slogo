package slogo.nodes;

import slogo.character.CharacterInterface;
import slogo.character.MainCharacter;

public class ListEndNode extends NodeObject {

	public ListEndNode(NodeObject parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasCompleteChildren() {
		// TODO Auto-generated method stub
		// has no children
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
