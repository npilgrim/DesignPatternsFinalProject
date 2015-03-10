
public class WitchKingBoss extends Monster {

	private static WitchKingBoss boss = null;
	
	private WitchKingBoss()
	{
		super();
		setName("Witch-King of Angmar");
		setHealth(400);
		setSpeed(7);
		setAccuracy(0.75);
		setMinDmg(40);
		setMaxDmg(75);
	}
	
	public static WitchKingBoss getWitchKing()
	{
		if(boss == null)
			boss = new WitchKingBoss();
		
		return boss;
	}
	
	
}
