
public class Balrog extends Monster {

	private static Balrog boss = null;
	
	private Balrog()
	{
		super();
		setName("Balrog of Morgoth");
		setHealth(500);
		setAccuracy(0.45);
		setMinDmg(60);
		setMaxDmg(100);
		setSpeed(3);
	}
	
	public static Balrog getBalrog()
	{
		if(boss == null)
			boss = new Balrog();
		
		return boss;
	}
	
}
