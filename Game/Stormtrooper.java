
public class Stormtrooper extends Monster {

	private static int trooperCount = 0;
	
	public Stormtrooper()
	{
		super(false);
		setSpeed(180);
		setMinDmg(10);
		setMaxDmg(30);
		setHealth(70);
		setAccuracy(0.85);
		setName("Trooper " + ++trooperCount);
	}
}
