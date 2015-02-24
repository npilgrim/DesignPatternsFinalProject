public class StartGameState implements GameState 
{
	private Game game;

	public StartGameState(Game game)
	{
		this.game = game;
	}
	
	@Override
	public void startGame() 
	{
		System.out.println("Game already started. Patience, young padawan.");
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
	public void endGame()
	{
		System.out.println("Game still loading. Patience, young padawan.");
	}

}
