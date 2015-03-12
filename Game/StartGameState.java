public class StartGameState implements GameState 
{
	private Game game;
	private HeroPartyBuilder builder = HeroPartyBuilder.getBuilder();

	public StartGameState(Game game)
	{
		this.game = game;
	}
	
	@Override
	public void startGame() 
	{		
		game.setMap(new Map());
		
		System.out.println("Choose your party!");
		try
		{
			Thread.sleep(2000);
		}
		catch (Exception e)
		{
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		Party goodGuys = builder.h1()
				.h2()
				.h3()
				.h4()
				.buildParty();
		
		game.setParty(goodGuys);
		game.setEnemy(game.map().getMonsterParty());
		
		game.setState(game.getMoveState());
	}

	@Override
	public void moveParty() 
	{
		System.out.println("Game still loading. Patience, young padawan.");
	}

	@Override
	public void engageBattle() 
	{
		System.out.println("Game still loading. Patience, young padawan.");
	}
	
	@Override
	public void manageInventory()
	{
		System.out.println("Now is not the time for that, Ash!");
	}
	
	@Override
	public void playAgain()
	{
		System.out.println("You haven't finished the current game!");
	}

	@Override
	public void endGame()
	{
		System.out.println("Game still loading. Patience, young padawan.");
	}

}
