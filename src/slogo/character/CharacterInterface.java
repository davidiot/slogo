package slogo.character;



public interface CharacterInterface {

	public void update();
	
	public double move(double distance, boolean forward);
	
	public void changeSpeed(Double value);

	public double setHidden(boolean input);
	
	public double setPenDown(boolean input);

	public double rotateCharacter(double degree);

	public double setHeading(double degree);

	public double towards(double x, double y);

	public double goTo(double x, double y);
	
	public double goHome();
	
	public void changePenColor(String input);
	
	public void changePenWidth(Double input);
	
	public double getXLocation();
	
	public double getYLocation();

	public double getDirection();

	public boolean isPenDown();

	public boolean isHidden();
		
	}
