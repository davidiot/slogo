package slogo.screen;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import slogo.character.MainCharacter;
import slogo.character.Movement;
import slogo.parameters.LocalParameters;

public class DebugScreen extends AbstractWindowScreen {
	private String title;
	private ListView<Movement> list;
	private MainCharacter mc;

	public DebugScreen(MainCharacter mc) {
		super();
		this.mc = mc;
		load();
	}

	public void load() {
		root.add(makeImage(mc), 1, 0);
		list.setItems(FXCollections.observableArrayList(mc.getDebugList()));
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
		return output;
	}

	@Override
	protected void makeScene() {
		title = myResources.getString("debug");
		Text text = new Text(title);
		text.setFont(font);
		root.add(text, 0, 0);
		list = new ListView<Movement>();
		list.setCellFactory(new Callback<ListView<Movement>, ListCell<Movement>>() {
			@Override
			public ListCell<Movement> call(ListView<Movement> list) {
				return new DebugCell();
			}
		});
		root.add(list, 0, 1);
		Button b = makeRevertButton();
		root.add(b, 0, 2);
		GridPane.setColumnSpan(list, 2);
		GridPane.setColumnSpan(b, 2);
		root.setAlignment(Pos.CENTER);
	}

	protected Button makeRevertButton() {
		Button button = new Button(myResources.getString("revert"));
		button.setFont(font);
		button.setOnMouseClicked(e -> revert());
		return button;
	}

	private void revert() {
		if (list.getSelectionModel().getSelectedItem() != null) {
			mc.revert(list.getSelectionModel().getSelectedItem());
		}
	}

	private class DebugCell extends ListCell<Movement> {
		@Override
		public void updateItem(Movement item, boolean empty) {
			super.updateItem(item, empty);
			HBox box = new HBox(5);
			if (empty) {
				setText(null);
				setGraphic(null);
			} else if (item != null) {
				box.getChildren().add(new Label(item.getType() + " to: "));
				double[] values = item.getValue();
				for (double v : values) {
					box.getChildren().add(new Label(v + " "));
				}
				box.getChildren().add(new Label("deg"));
				box.setAlignment(Pos.CENTER_LEFT);
				setGraphic(box);
				// box.setOnContextMenuRequested(e -> debug(item));
			}
		}
	}

}
