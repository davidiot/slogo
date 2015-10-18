package slogo.nodes;

import slogo.character.CharacterInterface;
import slogo.character.MainCharacter;
import slogo.interpreter.EngineController;

public class CommandDeclarationNode extends NodeObject {
	private String commandName; 
	
	public CommandDeclarationNode(String value, NodeObject parent) {
		super(parent);
		commandName = value;
	}

	@Override
	public boolean hasCompleteChildren() {
		return true;
	}

	@Override
	public void addChild(NodeObject node) {
		// TODO Auto-generated method stub
		// does not add children

	}

	@Override
	public boolean canAdd() {
		return false;
	}

	@Override
	public double traverseAndExecute(EngineController controller) {
		return 0;
	}
	
	public String getName() {
		return commandName;
		
	}

}
