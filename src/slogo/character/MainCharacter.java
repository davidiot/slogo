package slogo.character;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import slogo.parameters.GlobalParameters;
import slogo.parameters.LocalParameters;

public class MainCharacter extends ImageView implements CharacterInterface {
	protected final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	protected ResourceBundle slogoResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "slogo");
	private final double XADJUST = Double.parseDouble(slogoResources.getString("characterCenterX"));
	private final double YADJUST = Double.parseDouble(slogoResources.getString("characterCenterY"));
	private double WIDTH = Double.parseDouble(slogoResources.getString("mapWidth"));
	private double HEIGHT = Double.parseDouble(slogoResources.getString("mapHeight"));
	private double xCenter = WIDTH / 2;
	private double yCenter = HEIGHT / 2;
	private static final double ANGLE = 90.0;
	private double preX;
	private double preY;
	private double curX;
	private double curY;
	private double direction;
	private double finalX;
	private double finalY;
	private double finalDirection;
	private Pane myPane;
	private LinkedList<Movement> myQueue;
	private GlobalParameters parameters;
	private LocalParameters settings;
	private ArrayList<Line> lineList;

	public MainCharacter(Pane pane, GlobalParameters parameters, int i) {
		curX = xCenter;
		curY = yCenter;
		init(pane, parameters, i);
	}

	public MainCharacter(Pane pane, GlobalParameters parameters, int i, double x, double y) {
		this.curX = x;
		this.curY = y;
		init(pane, parameters, i);
	}

	private void init(Pane pane, GlobalParameters parameters, int i) {
		myPane = pane;
		this.parameters = parameters;
		settings = new LocalParameters(i);
		preX = curX;
		preY = curY;
		direction = 0;
		finalX = curX;
		finalY = curY;
		finalDirection = direction;
		this.loadImage(settings.getImage());
		this.setX(curX);
		this.setY(curY);
		myQueue = new LinkedList<Movement>();
		lineList = new ArrayList<Line>();
	}

	private class Movement {
		private String type;
		private double[] value;
		private boolean currentPenDown;
		private double currentPenWidth;
		private Color currentPenColor;

		public Movement(String type, double[] value) {
			this.type = type;
			this.value = value;
			currentPenDown = settings.isPenDown();
			currentPenColor = settings.getPenColor();
			currentPenWidth = parameters.getValue("Line Thickness");
		}

		public String getType() {
			return type;
		}

		public double[] getValue() {
			return value;
		}

		public boolean isCurrentPenDown() {
			return currentPenDown;
		}

		public Double getCurrentPenWidth() {
			return currentPenWidth;
		}

		public Color getCurrentPenColor() {
			return currentPenColor;
		}
	}

	private double wrap(double input, double value) {
		while (input >= value) {
			input -= value;
		}
		while (input < 0) {
			input += value;
		}
		return input;
	}

	private void refreshImage() {
		myPane.getChildren().remove(this);
		if (!settings.isHidden()) {
			myPane.getChildren().add(this);
		}
	}

	public void update() {
		if (!myQueue.isEmpty()) {
			Movement nextMove = myQueue.peek();
			if (nextMove.getType().equals("angle")) {
				turn(nextMove);
			} else {
				line(nextMove);
			}
			refreshImage();
		}
	}

	private void line(Movement nextMove) {
		preX = curX;
		preY = curY;
		double x = nextMove.getValue()[0];
		double y = nextMove.getValue()[1];
		double newX = 0;
		double newY = 0;
		double adjustedDirection = direction;
		if (nextMove.getType().equals("bline")) {
			adjustedDirection = wrap(direction + 180, 360);
		}
		newX = curX + parameters.getValue("Speed") * Math.cos(Math.toRadians(ANGLE - adjustedDirection));
		newY = curY - parameters.getValue("Speed") * Math.sin(Math.toRadians(ANGLE - adjustedDirection));

		if ((Math.pow((newX - curX), 2) + Math.pow((newY - curY), 2)) > (Math.pow((x - curX), 2)
				+ Math.pow((y - curY), 2))) {
			curX = wrap(x, WIDTH);
			curY = wrap(y, HEIGHT);
			myQueue.poll();
		} else {
			curX = newX;
			curY = newY;
		}

		this.setX(wrap(curX, WIDTH));
		this.setY(wrap(curY, HEIGHT));
		if (nextMove.isCurrentPenDown() & !checkTeleport()) {
			Line line;
			line = new Line(wrap(preX, WIDTH) + XADJUST, wrap(preY, HEIGHT) + YADJUST, wrap(curX, WIDTH) + XADJUST,
					wrap(curY, HEIGHT) + YADJUST);
			line.setStroke(nextMove.getCurrentPenColor());
			line.setStrokeWidth(nextMove.getCurrentPenWidth());
			myPane.getChildren().add(line);
			// IF INSTANT
			lineList.add(line);
		}
	}

	public boolean checkTeleport() {
		// accounts for double imprecision
		double error = Double.parseDouble(slogoResources.getString("error"));
		boolean teleport = (curX - preX > wrap(curX, WIDTH) - wrap(preX, WIDTH) + error)
				|| (curX - preX < wrap(curX, WIDTH) - wrap(preX, WIDTH) - error)
				|| (curY - preY < wrap(curY, HEIGHT) - wrap(preY, HEIGHT) - error)
				|| (curY - preY > wrap(curY, HEIGHT) - wrap(preY, HEIGHT) + error);
		return teleport;
	}

	public void turn(Movement nextMove) {
		double angle = nextMove.getValue()[0];
		if (angle - direction > 0) {
			direction += Math.min(parameters.getValue("Speed"), angle - direction);
		} else {
			direction -= Math.min(parameters.getValue("Speed"), direction - angle);
		}
		this.setRotate(direction);
		if (direction == angle) {
			direction = wrap(direction, 360);
			myQueue.poll();
		}
	}

	public double move(double distance, boolean forward) {
		double correctedDirection = finalDirection;
		if (!forward) {
			correctedDirection = wrap(finalDirection + 180, 360);
		}
		finalX += distance * Math.cos(Math.toRadians(ANGLE - correctedDirection));
		finalY -= distance * Math.sin(Math.toRadians(ANGLE - correctedDirection));
		if (forward) {
			myQueue.add(new Movement("fline", new double[] { finalX, finalY }));
		} else {
			myQueue.add(new Movement("bline", new double[] { finalX, finalY }));
		}
		finalX = wrap(finalX, WIDTH);
		finalY = wrap(finalY, HEIGHT);
		return distance;
	}

	public void changeSpeed(Double value) {
		parameters.setValue("Speed", value);
	}

	public void changeDashLevel(Double value) {
		parameters.setValue("Dash Level", value);
	}

	public double setHidden(boolean input) {
		double returnVal = 0;
		settings.setHidden(input);
		if (input)
			returnVal = 1;
		refreshImage();
		return returnVal;
	}

	public double setPenDown(boolean input) {
		double returnVal = 0;
		settings.setPenDown(input);
		if (input)
			returnVal = 1;
		return returnVal;
	}

	public double rotateCharacter(double degree) {
		finalDirection += degree;
		myQueue.add(new Movement("angle", new double[] { finalDirection }));
		finalDirection = wrap(finalDirection, 360);
		return degree;
	}

	public double setHeading(double degree) {
		double output = degree - finalDirection;
		finalDirection = wrap(degree, 360);
		myQueue.add(new Movement("angle", new double[] { degree }));
		return output;
	}

	public double towards(double x, double y) {
		x = x + xCenter;
		y = yCenter - y;
		if (x == finalX && y == finalY) {
			return 0;
		} else {
			double degree = 180 - Math.atan2((x - finalX), (y - finalY)) * 180 / Math.PI;
			return setHeading(degree);
		}
	}

	public double goTo(double x, double y) {
		towards(x, y);
		double distance = Math.sqrt(Math.pow(x + xCenter - finalX, 2) + (Math.pow(yCenter - y - finalY, 2)));
		move(distance, true);
		return distance;
	}

	public double goHome() {
		towards(0, 0);
		double distance = goTo(0, 0);
		setHeading(0);
		return distance;
	}

	public void changePenColor(String input) {
		settings.setPenColor(Color.valueOf(input));
	}

	public void changePenColorHex(String input) {
		settings.setPenColor(Color.web(input));
	}

	public void changePenColorRGB(int i, int j, int k) {
		settings.setPenColor(Color.rgb(i, j, k));
	}

	public void changeShape(int index) {
		settings.changeShape(index);
		this.loadImage(settings.getImage());
	}

	public void changePenWidth(Double input) {
		parameters.setValue("Line Thickness", input);
	}

	public double getXLocation() {
		return finalX - xCenter;
	}

	public double getYLocation() {
		return yCenter - finalY;
	}

	public double getDirection() {
		return finalDirection;
	}

	public boolean isPenDown() {
		return settings.isPenDown();
	}

	public boolean isHidden() {
		return settings.isHidden();
	}

	public void loadImage(Image image) {
		this.setImage(image);
		this.setFitHeight(XADJUST * 2);
		this.setFitWidth(YADJUST * 2);
		this.setSmooth(true);
		this.setCache(true);
		refreshImage();
	}

	public LocalParameters getSettings() {
		return settings;
	}
}
