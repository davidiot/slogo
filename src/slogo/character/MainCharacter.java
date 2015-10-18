package slogo.character;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.LinkedList;
import java.util.ResourceBundle;

public class MainCharacter {
	protected final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	protected ResourceBundle slogoResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "slogo");
	private final double XADJUST = Double.parseDouble(slogoResources.getString("characterCenterX"));
	private final double YADJUST = Double.parseDouble(slogoResources.getString("characterCenterY"));
	private double WIDTH = Double.parseDouble(slogoResources.getString("mapWidth"));
	private double HEIGHT = Double.parseDouble(slogoResources.getString("mapHeight"));
	private double xCenter = WIDTH / 2;
	private double yCenter = HEIGHT / 2;
	private static final double ANGLE = 90.0;
	private boolean penDown = true;
	private boolean hidden = false;
	private double preX;
	private double preY;
	private double curX;
	private double curY;
	private double direction;
	private double finalX;
	private double finalY;
	private double finalDirection;
	private Image image;
	private ImageView imageView;
	private Color penColor;
	private double penWidth = 1;
	private double speed = 1;
	private double maxSpeed = Double.parseDouble(slogoResources.getString("maxSpeed"));
	private Pane myPane;
	private LinkedList<Movement> myQueue;

	public MainCharacter(Pane pane) {
		myPane = pane;
		curX = xCenter;
		preX = xCenter;
		curY = yCenter;
		preY = yCenter;
		direction = 0;
		finalX = curX;
		finalY = curY;
		finalDirection = direction;
		if (!hidden) {
			image = new Image(getClass().getClassLoader().getResourceAsStream("Images/SlogoTurtle.png"));
		} else {
			image = new Image("Images/blank.png");
		}
		imageView = new ImageView();
		imageView.setImage(image);
		imageView.setX(curX);
		imageView.setY(curY);
		penColor = Color.BLACK;
		myQueue = new LinkedList<Movement>();
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
			currentPenDown = penDown;
			currentPenColor = penColor;
			currentPenWidth = penWidth;
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
		myPane.getChildren().remove(imageView);
		myPane.getChildren().add(imageView);
	}

	public void update() {
		if (!myQueue.isEmpty()) {
			Movement nextMove = myQueue.peek();
			if (nextMove.getType().equals("angle")) {
				double angle = nextMove.getValue()[0];
				if (angle - direction > 0) {
					direction += Math.min(speed, angle - direction);
				} else {
					direction -= Math.min(speed, direction - angle);
				}
				imageView.setRotate(direction);
				if (direction == angle) {
					direction = wrap(direction, 360);
					myQueue.poll();
				}
			} else {
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
				newX = curX + speed * Math.cos(Math.toRadians(ANGLE - adjustedDirection));
				newY = curY - speed * Math.sin(Math.toRadians(ANGLE - adjustedDirection));

				if (speed == Double.MAX_VALUE || ((Math.pow((newX - curX), 2)
						+ Math.pow((newY - curY), 2)) > (Math.pow((x - curX), 2) + Math.pow((y - curY), 2)))) {
					curX = wrap(x, WIDTH);
					curY = wrap(y, HEIGHT);
					myQueue.poll();
				} else {
					curX = newX;
					curY = newY;
				}

				boolean teleport = false;

				if (curX - preX < wrap(curX, WIDTH) - wrap(preX, WIDTH)) {
					//curX = 0;
					//curY = preY - (WIDTH - preX) * Math.tan(Math.toRadians(ANGLE - adjustedDirection));
					teleport = true;
				} else if (curX - preX > wrap(curX, WIDTH) - wrap(preX, WIDTH)) {
					//curX = WIDTH;
					//curY = preY - (0 - preX) * Math.tan(Math.toRadians(ANGLE - adjustedDirection));
					teleport = true;
				}

				if (curY - preY < wrap(curY, HEIGHT) - wrap(preY, HEIGHT)) {
					//curY = 0;
					//curX = preX + (HEIGHT - preY) / Math.tan(Math.toRadians(ANGLE - adjustedDirection));
					teleport = true;
				} else if (curY - preY > wrap(curY, HEIGHT) - wrap(preY, HEIGHT)) {
					//curY = HEIGHT;
					//curX = preX + (0 - preY) / Math.tan(Math.toRadians(ANGLE - adjustedDirection));
					teleport = true;
				}

				imageView.setX(wrap(curX, WIDTH));
				imageView.setY(wrap(curY, HEIGHT));
				if (nextMove.isCurrentPenDown() & !teleport) {
					Line line;
					line = new Line(wrap(preX, WIDTH) + XADJUST, wrap(preY, HEIGHT) + YADJUST,
							wrap(curX, WIDTH) + XADJUST, wrap(curY, HEIGHT) + YADJUST);
					line.setStroke(nextMove.getCurrentPenColor());
					line.setStrokeWidth(nextMove.getCurrentPenWidth());
					myPane.getChildren().add(line);
				}
			}
			refreshImage();
		}
	}

	public ImageView getImageView() {
		return imageView;
	}

	public Image getImage() {
		return image;
	}

	public void move(double distance, boolean forward) {
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
	}

	public void changeSpeed(Double value) {
		if (value >= maxSpeed) {
			speed = Double.MAX_VALUE;
		} else {
			speed = value;
		}
	}

	public void setVisible(boolean input) {
		hidden = input;
	}

	public void setPenDown(boolean input) {
		penDown = input;
	}

	public void rotateCharacter(double degree) {
		finalDirection += degree;
		myQueue.add(new Movement("angle", new double[] { finalDirection }));
		finalDirection = wrap(finalDirection, 360);
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
		towards(xCenter, yCenter);
		double distance = goTo(xCenter, yCenter);
		setHeading(0);
		return distance;
	}

	public void changePenColor(String input) {
		penColor = Color.valueOf(input);
	}

	public void changePenWidth(Double input) {
		penWidth = input;
	}

	public double getX() {
		return finalX - xCenter;
	}

	public double getY() {
		return yCenter - finalY;
	}

	public double getDirection() {
		return finalDirection;
	}

	public boolean isPenDown() {
		return penDown;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setImage(Image image) {
		this.image = image;
		imageView.setImage(image);
		imageView.setFitHeight(XADJUST * 2);
		imageView.setFitWidth(YADJUST * 2);
		imageView.setSmooth(true);
		imageView.setCache(true);
		refreshImage();
	}
}
