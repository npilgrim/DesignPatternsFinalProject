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
	
	public Party makeParty(String roomName)
	{
		Party p = null;
		
		if(roomName.contains("torture"))
		{
			p = getBossParty();
		}
		else
			p = makeMonsterParty();
		
		return p;
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
	
	public Party getBossParty()
	{
		Party boss = new Party();
		
		Random r = new Random();
		int x = r.nextInt(2);
		
		switch(x)
		{
			case 0:
				boss.addCharacter(new WitchKingBoss());
				break;
			case 1:
				boss.addCharacter(new Balrog());
				break;
		}
		
		return boss;
	}
}
