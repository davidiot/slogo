package slogo.element;

import java.io.File;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Callback;
import slogo.character.MainCharacter;
import slogo.parameters.LocalParameters;

public class Monitor extends AbstractElement {
	private String title;
	private Text text;
	private boolean open;
	private ListView<MainCharacter> list;

	public Monitor(GridPane pane) {
		super(pane);
		makePane();
	}

	@Override
	protected void makePane() {
		title = slogoResources.getString(this.getClass().getName());
		open = true;
		text = new Text(title);
		text.setFont(font);
		pane.add(text, 0, 0);
		list = new ListView<MainCharacter>(parameters.getCharacters());
		list.setOnMouseClicked(e -> clear());
		list.setCellFactory(new Callback<ListView<MainCharacter>, ListCell<MainCharacter>>() {
			@Override
			public ListCell<MainCharacter> call(ListView<MainCharacter> list) {
				return new SettingsCell();
			}
		});
		pane.add(list, 0, 1);
	}

	private void clear() {
		list.getSelectionModel().clearSelection();
	}

	private class SettingsCell extends ListCell<MainCharacter> {
		@Override
		public void updateItem(MainCharacter item, boolean empty) {
			super.updateItem(item, empty);
			HBox box = new HBox(5);
			if (empty) {
				setText(null);
				setGraphic(null);
			} else if (item != null) {
				LocalParameters settings = item.getSettings();
				box.getChildren().add(makeLabel(settings));
				box.getChildren().add(makeImage(item));
				box.getChildren().add(makePen(settings));
				box.getChildren().add(makeEye(settings));
				box.getChildren().add(makeArrow(settings));
				box.getChildren().add(makeCoordinates(item));
				box.setAlignment(Pos.CENTER_LEFT);
				setGraphic(box);
			}
		}

		private Text makeLabel(LocalParameters settings) {
			Text label = new Text(Integer.toString(settings.getIndex() + 1));
			label.setFont(font);
			return label;
		}

		private VBox makeCoordinates(MainCharacter item) {
			VBox output = new VBox();
			Text coord = new Text("(" + item.getXLocation() + ", " + item.getYLocation() + ")");
			Text deg = new Text(Double.toString(item.getDirection()) + " deg");
			output.getChildren().add(coord);
			output.getChildren().add(deg);
			output.setAlignment(Pos.CENTER);
			return output;
		}

		private ImageView makeImage(MainCharacter item) {
			ImageView output = new ImageView(item.getSettings().getImage());
			if (!parameters.getActiveIndices().contains(item.getSettings().getIndex())) {
				output.setOpacity(0.5);
			}
			output.setFitHeight(item.getXADJUST() * 2);
			output.setFitWidth(item.getYADJUST() * 2);
			output.setSmooth(true);
			output.setCache(true);
			output.setOnMouseClicked(e -> toggleActive(item.getSettings().getIndex()));
			return output;
		}

		private void toggleActive(int i) {
			if (parameters.getActiveIndices().contains(i)) {
				parameters.getActiveIndices().remove(i);
			} else {
				parameters.getActiveIndices().add(i);
			}
			list.refresh();
		}

		private ImageView makePen(LocalParameters settings) {
			Image image;
			if (settings.isPenDown()) {
				image = new Image(getClass().getClassLoader().getResourceAsStream("Images/pendown.png"));
			} else {
				image = new Image(getClass().getClassLoader().getResourceAsStream("Images/penup.png"));
			}
			ImageView output = new ImageView(image);
			output.setOnMouseClicked(e -> togglePen(settings));
			return output;
		}

		private ImageView makeEye(LocalParameters settings) {
			Image image = new Image(getClass().getClassLoader().getResourceAsStream("Images/eye.png"));
			ImageView output = new ImageView(image);
			if (settings.isHidden()) {
				output.setOpacity(0.5);
			} else {
				output.setOpacity(1);
			}
			output.setOnMouseClicked(e -> toggleHidden(settings));
			return output;
		}

		private ImageView makeArrow(LocalParameters settings) {
			Image image = new Image(getClass().getClassLoader().getResourceAsStream("Images/upload.png"));
			ImageView output = new ImageView(image);
			output.setOnMouseClicked(e -> showSelector(settings));
			return output;
		}

		private void showSelector(LocalParameters settings) {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle(slogoResources.getString("selectorTitle"));
			fileChooser.getExtensionFilters()
					.addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));
			File selectedFile = fileChooser.showOpenDialog(new Stage());
			if (selectedFile != null) {
				settings.setImage(new Image(selectedFile.toURI().toString()));
				list.refresh();
			}
		}

		private void togglePen(LocalParameters settings) {
			settings.setPenDown(!settings.isPenDown());
			list.refresh();
		}

		private void toggleHidden(LocalParameters settings) {
			settings.setHidden(!settings.isHidden());
			list.refresh();
		}
	}

	public void refresh() {
		list.refresh();
	}
}
