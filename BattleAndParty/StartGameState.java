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
