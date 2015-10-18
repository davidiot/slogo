package slogo.interpreter;

import java.util.List;

import slogo.nodes.NodeObject;
import slogo.nodes.RootNode;


public class TreeBuilder {
	private NodeObject myRootNode;
	private CommandLibrary myCommands;
	private TemporaryCommandLibrary tempCommands;
	private VariableLibrary myVariables;
	private NodeFactory	myFactory;
	private List<InputObject> myInput;


	public TreeBuilder(CommandLibrary commandLibrary, VariableLibrary variables, TemporaryCommandLibrary temp, List<InputObject> parsedInput) {
		myCommands = commandLibrary;
		myVariables = variables;
		myInput = parsedInput;
		tempCommands = temp;
		myFactory = new NodeFactory(commandLibrary, variables, temp);
		myRootNode = new RootNode(null);
	}

	public NodeObject buildTreeFromInput() {
		System.out.println(myInput);
		buildTreeNodes(0, myRootNode);
		return myRootNode;
	}

	private void buildTreeNodes(int index, NodeObject root) {
		NodeObject current = root;
		if (index >= myInput.size()){
			// TODO check complete?
			return;
		}
		if(current.canAdd()) {
			// TODO throw exception if action doesn't exist
			NodeObject node = myFactory.create(myInput.get(index), current);
			current.addChild(node);
			buildTreeNodes(index+1, node);
		} else {
			if (current.getParent() != null) {
				buildTreeNodes(index, current.getParent());
			} else {
				// TODO throw an exception here if there is nowhere to add the next node
			}
		}
		// now check whether each function has enough parameters
	}
	
//	private void findCustomCommands() {
//		int currentIndex = 0;
//		InputObject toNode = new InputObject("Command", "MakeUserInstruction"); 
//		for (InputObject in: myInput) {
//			if (in.equals(toNode)) addCustomCommand(currentIndex);
//		}	
//	}
//
//	private void addCustomCommand(int index) {
//		int currentIndex = index + 1;
//		int paramCount = 0;
//		String name = myInput.get(currentIndex).getValue();
//		currentIndex += 1;
//		if (! myInput.get(currentIndex).getType().equals("ListStart")) {
//			// TODO maybe throw error
//			System.out.println("missing open bracket");
//		}
//		currentIndex += 1;
//		// TODO check for out of bounds
//		while (! myInput.get(currentIndex).getType().equals("ListEnd")) {
//			paramCount += 1;
//			currentIndex += 1;
//		}
//		tempCommands.addCommand(name, new UserInstruction(paramCount));
//	}
}
