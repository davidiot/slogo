package slogo.nodes;

import slogo.character.CharacterInterface;
import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;

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
	public double traverseAndExecute(EngineController controller) {
		// TODO Auto-generated method stub
		return 0;
	}

}
