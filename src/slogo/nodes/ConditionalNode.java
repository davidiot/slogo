package slogo.nodes;

import slogo.character.MainCharacter;

public class ConditionalNode extends NodeObject {

	public ConditionalNode(NodeObject parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasCompleteChildren() {
		// TODO Auto-generated method stub
		return false;
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
	public double traverseAndExecute(MainCharacter character) {
		// TODO Auto-generated method stub
		return 0;
	}

}
