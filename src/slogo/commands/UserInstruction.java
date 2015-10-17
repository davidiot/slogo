package slogo.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import slogo.character.CharacterInterface;
import slogo.character.MainCharacter;
import slogo.nodes.NodeObject;
import slogo.nodes.RootNode;

public class UserInstruction extends Command {
	private String myName; 
	private NodeObject myRoot;
	private List<String> myParameters;
	
	public UserInstruction(String name, List<String> parameters, NodeObject tree) {
		myName = name;
		myParameters = parameters;
		myRoot = tree;
	}

	@Override
	public double doCommand(List<NodeObject> params, CharacterInterface character) {
		Map<String, Double> parameters = new HashMap<String,Double>();
		int currentIdx = 0;
		for (String param: myParameters) {
			parameters.put(param, params.get(currentIdx).traverseAndExecute(character));
			currentIdx += 1;
		}
		myRoot.setLocalVariables(parameters);
		return myRoot.traverseAndExecute(character);
	}

	@Override
	public int getNumChildrenRequired() {
		return myParameters.size();
	}
	
	public void setCommands(NodeObject root) {
		myRoot = root;
	}

}
