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
		Monster m = null;
		
		int r = rand.nextInt(4);
		switch(r)
		{
			case 0:
				m = new Gremlin();
				break;
			case 1:
				m = new Ogre();
				break;
			case 2: 
				m = new Stormtrooper();
				break;
			case 3:
				m = new UrukHai();
		}
		
		return m;
	}
}
