public class GameTest
{

	public static void main(String[] args)
	{
		MonsterPartyMaker enemyMaker = MonsterPartyMaker.getMonsterPartyMaker();
		HeroPartyBuilder builder = HeroPartyBuilder.getBuilder();
		
		Party goodGuys = builder.h1()
								.h2()
								.h3()
								.h4()
								.buildParty();
		
		Party badGuys = enemyMaker.makeMonsterParty();
		
		Game tester = new Game(goodGuys);
		tester.setEnemy(badGuys);
		Game.enemySave = badGuys.saveParty();
		tester.setState(tester.getBattleState());
		while(tester.getState().equals(tester.getBattleState()))
		{
			tester.engageBattle(); 
			if(tester.getState().equals(tester.getPlayAgainState()))
				tester.playAgain();
		}
		tester.endGame();
	}
}
