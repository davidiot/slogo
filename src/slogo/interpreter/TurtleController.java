// This entire file is part of my masterpiece.
// Daniel McKee

package slogo.interpreter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import slogo.character.CharacterInterface;
import slogo.commands.TurtleCommandInterface;
import slogo.element.DisplayInterface;
import slogo.screen.SlogoScreenInterface;

public class TurtleController {
	
	private SlogoScreenInterface myScreen;
	private DisplayInterface myDisplay;

	public TurtleController(SlogoScreenInterface screen) {
		myScreen = screen;
	}

	public double commandTurtles(TurtleCommandInterface command) {
		myDisplay = myScreen.getDisplay();
		Set<Integer> activeIndicesSet = myDisplay.getActiveIndices();
		List<CharacterInterface> characters = myDisplay.getCharacters();
		
		List<Double> returnVals = characters
			.stream()
			.filter(c -> activeIndicesSet.contains(characters.indexOf(c)) )
			.map(c -> {
				Set<Integer> storedSet = new HashSet<Integer>(activeIndicesSet);
				setOneActive(c);
				double val = command.doTurtling(c);
				setActiveIDs(storedSet);
				return val;
			})
			.collect(Collectors.toList());
		
		return returnVals.get(returnVals.size()-1);
		
	}

	private void setOneActive(CharacterInterface c) {
		int index = myDisplay.getCharacters().indexOf(c);
		List<Integer> list = new ArrayList<>();
		list.add(index);
		myDisplay.setActiveIDs(list);
		
	}

	public double getActiveID() {
		List<Integer> activeSet = new ArrayList<>(myDisplay.getActiveIndices());
		return activeSet.get(0) + 1;
	}

	public void setActiveIDs(Collection<Integer> IDs) {		
		for (int id: IDs){
			if (id > numTurtles()) {
				createMoreCharacters(id);
			}
		}
		myDisplay.setActiveIDs(IDs);
	}

	private void createMoreCharacters(int id) {
		while (numTurtles() < id) {
			myDisplay.addCharacter();
		}	
	}

	public double numTurtles() {
		return myDisplay.getCharacters().size();
	}

	public Collection<Integer> getActiveIndices() {
		return myDisplay.getActiveIndices();
	}
}
