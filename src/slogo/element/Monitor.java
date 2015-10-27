package slogo.element;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
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
				box.getChildren().add(makeImage(settings));
				setGraphic(box);
			}
		}

		public Text makeLabel(LocalParameters settings) {
			Text label = new Text(Integer.toString(settings.getIndex() + 1));
			label.setFont(font);
			return label;
		}

		public ImageView makeImage(LocalParameters settings) {
			ImageView output = new ImageView(settings.getImage());
			if (!parameters.getActiveIndices().contains(settings.getIndex())) {
				output.setOpacity(0.5);
			}
			output.setOnMouseClicked(e -> toggleActive(settings.getIndex()));
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
	}
}
