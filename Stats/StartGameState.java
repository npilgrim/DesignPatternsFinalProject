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
	public void confirmExit()
	{
		System.out.println("You just started the game and haven't chosen to quit yet.");
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
