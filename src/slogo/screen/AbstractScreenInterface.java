package slogo.screen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public interface AbstractScreenInterface {

	abstract public void run();

	public Scene getScene();

	public AbstractScreen getNextScreen();

	public String getTitle();

	public void makeWindow(Stage stage, AbstractWindowScreen screen);
	
}