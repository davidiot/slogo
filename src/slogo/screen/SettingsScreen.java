package slogo.screen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import slogo.parameters.Parameters;

public class SettingsScreen extends AbstractWindowScreen {

	private int i;

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void makeScene() {
		i = 0;
		add(makeTitle());
		makeControls();
	}

	protected void add(Node node) {
		root.add(node, 0, i);
		i++;
	}

	protected void makeControls() {
		Scanner s;
		boolean isNew = (parameters == null);
		if (isNew) {
			parameters = new Parameters();
		}
		try {
			s = new Scanner(new File("src/resources/settings.txt"));
			while (s.hasNext()) {
				String next = s.nextLine();
				if (next.equals("0")) {
					break;
				}
				String[] vals = s.nextLine().split(" ");
				double x;
				if (isNew) {
					x = Double.parseDouble(vals[0]);
				} else {
					x = parameters.getValue(next);
				}
				double y = Double.parseDouble(vals[1]);
				double z = Double.parseDouble(vals[2]);
				Toggle toggle = new Toggle(next, x, y, z);
				add(toggle);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		setAlignment(root);
	}

	private GridPane makeTitle() {
		GridPane title = new GridPane();
		Text temp = createText(myResources.getString("settingsTitle"),
				Integer.parseInt(myResources.getString("smallTitle")));
		title.add(temp, 0, 0);
		return title;
	}

	public class Toggle extends GridPane {
		private String name;
		private Label nameLabel;
		private Slider slider;
		private TextField valueField;

		private Toggle(String n, Double x, Double y, Double z) {
			name = n;
			slider = new Slider();
			slider.setValue(x);
			slider.setMin(y);
			slider.setMax(z);
			slider.setShowTickMarks(true);
			slider.setShowTickLabels(true);
			slider.setMajorTickUnit((slider.getMax() - slider.getMin()));
			nameLabel = new Label(name + ":");
			nameLabel.setFont(font);
			valueField = new TextField(String.format("%.2f", slider.getValue()));
			valueField.setPrefColumnCount(valueField.getText().length());
			valueField.setAlignment(Pos.CENTER);
			valueField.textProperty()
					.addListener((ObservableValue<? extends String> ob, String oldVal, String newVal) -> {
						valueField.setPrefColumnCount(valueField.getText().length());
					});
			valueField.setOnAction(e -> setValue());
			valueField.setFont(font);
			HBox lowerBox = new HBox();
			lowerBox.getChildren().addAll(slider, valueField);
			this.add(nameLabel, 0, 0);
			this.add(lowerBox, 0, 1);
			slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number oldVal, Number newVal) -> {
				parameters.setValue(name, (Double) newVal);
				valueField.setText(String.format("%.2f", newVal));
			});
			parameters.setValue(name, slider.getValue());
		}

		private void setValue() {
			{
				try {
					String current = this.valueField.getCharacters().toString();
					double val = Double.parseDouble(current);
					if (val >= slider.getMin() && val <= slider.getMax()) {
						this.slider.setValue(val);
						parameters.setValue(name, val);
					} else {
						valueField.setText(String.format("%.2f", this.slider.getValue()));
					}
				} catch (NumberFormatException d) {
					valueField.setText(String.format("%.2f", this.slider.getValue()));
				}
			}
		}
	}

}
