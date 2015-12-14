package slogo.interpreter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import slogo.character.MainCharacter;
import slogo.commands.TurtleCommandInterface;
import slogo.screen.SlogoScreenInterface;

public class TurtleController {
	
	private SlogoScreenInterface myView;
	private EngineController myController;

	public TurtleController(EngineController controller, SlogoScreenInterface view) {
		myController = controller;
		myView = view;
	}

	public double commandTurtles(TurtleCommandInterface command) {
		double returnVal = 0;
		HashSet<Integer> activeIndicesSet = myView.getDisplay().getActiveIndices();
		for (int i = 0; i < myView.getDisplay().getCharacters().size(); i++) {
			if (activeIndicesSet.contains(i)){
				HashSet<Integer> storedSet = new HashSet<Integer>(activeIndicesSet);
				activeIndicesSet.removeAll(activeIndicesSet);
				activeIndicesSet.add(i);
				returnVal = command.doTurtling(myView.getDisplay().getCharacters().get(i), myController);
				activeIndicesSet.addAll(storedSet);
			}
		}
		return returnVal;
	}

	public List<MainCharacter> getTurtles() {
		return myView.getDisplay().getCharacters();
	}
	
	public double getActiveID() {
		HashSet<Integer> activeSet = myView.getDisplay().getActiveIndices();
		return new ArrayList<Integer>(activeSet).get(0) + 1;
	}

	public void setActiveIDs(Collection<Integer> IDs) {
		HashSet<Integer> activeIndicesSet = myView.getDisplay().getActiveIndices();
		activeIndicesSet.removeAll(activeIndicesSet);
		activeIndicesSet.addAll(IDs);
		for (int id: IDs){
			if (id > myView.getDisplay().getCharacters().size()) {
				createMoreCharacters(id);
			}
		}
	}

	private void createMoreCharacters(int id) {
		while (myView.getDisplay().getCharacters().size() < id) {
			myView.getDisplay().addCharacter();
		}
		
	}

	public Set<Integer> getActiveIndices() {
		return myView.getDisplay().getActiveIndices();
	}

	public double numTurtles() {
		return myView.getDisplay().getCharacters().size();
	}
}
