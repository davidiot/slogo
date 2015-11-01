package slogo.element;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import slogo.character.MainCharacter;

public interface DisplayInterface {

	List<MainCharacter> getCharacters();

	Set<Integer> getActiveIndices();

	void setActiveIDs(Collection<Integer> list);

	void addCharacter();
	
	

}
