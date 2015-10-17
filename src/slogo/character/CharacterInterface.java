package slogo.character;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import java.util.ResourceBundle;

public interface CharacterInterface {
		
		public ImageView getImageView();
		
		public Image getImage();
		
		public void move(double distance);
		
		public void showCharacter();
		
		public void hideCharacter();
		
		public void rotateCharacter(double degree);
		
		public void refreshImage();
		
		public void changePenColor(String input);
		
		public void changePenWidth(Double input);
		
		public void returnHome();
		
		public double getDistanceMoved();
		
		
	}
