// This entire file is part of my masterpiece.
// MICHAEL DAOU

package slogo.element;

import java.util.Set;

import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import slogo.character.MainCharacter;

public interface DisplayInterface {
		
		public String convertIndexToHex(int index);
		
		public void setPaletteIndex(int index, int r, int g, int b);
		
		public void changeColor(Color input);
		
		public void changeColorIndex(int index);

		public void changeColorHex(String input);

		public void changeColorRGB(int i, int j, int k);
		
		public void addCharacter(double x, double y);
		
		public void addCharacter();

		public void updateCharacters();

		public ObservableList<MainCharacter> getCharacters();

		public Set<Integer> getActiveIndices();

		public double clear();
		
		public GridPane getPalettePane();

	}
