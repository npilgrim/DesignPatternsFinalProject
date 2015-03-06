import java.util.Random;

public class MonsterPartyMaker 
{
	private static MonsterPartyMaker monsterPartyMaker = null;
	private MonsterMaker mm;
	
	private MonsterPartyMaker()
	{
		mm = new MonsterMaker();
	}
	
	public static MonsterPartyMaker getMonsterPartyMaker()
	{
		if(monsterPartyMaker == null)
			monsterPartyMaker = new MonsterPartyMaker();
		
		return monsterPartyMaker;
	}
	
	public Party makeMonsterParty()
	{
		Party p;
		Monster m;
		Random r = new Random();
		
		if((r.nextDouble()) <= 0.3)
		{
			p = new Party();
			
			for(int i = 0; i < 4; i++)
			{
				m = mm.makeMonster();
				p.addCharacter(m);
			}
		}
		else
		{
			p = makeEmptyParty();
		}
		
		return p;
	}
	
	public Party makeEmptyParty()
	{
		return new Party();
	}
}
