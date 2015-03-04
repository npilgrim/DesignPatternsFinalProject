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
		Party p = new Party();
		Monster m;
		
		for(int i = 0; i < 4; i++)
		{
			m = mm.makeMonster();
			p.addCharacter(m);
		}
		
		return p;
	}
}
