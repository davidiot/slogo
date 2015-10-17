package slogo.nodes;

import slogo.character.CharacterInterface;
import slogo.character.MainCharacter;

public class ConstantNode extends NodeObject {
	private double myValue;

	public ConstantNode(double value, NodeObject parent) {
		super(parent);
		myValue = value;
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
		return false;
	}

	@Override
	public double traverseAndExecute(CharacterInterface character) {
		return myValue;
	}

}
