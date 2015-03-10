import java.util.*;

public class MonsterMaker 
{
	private Random rand;
	
	public MonsterMaker()
	{
		rand = new Random();
	}
	
	public Monster makeMonster()
	{
		Monster m;
		
		m = new Monster();
		m.setSpeed(rand.nextInt(11));
		m.setName("Monster " + rand.nextInt(1001));
		
		return m;
	}
}
