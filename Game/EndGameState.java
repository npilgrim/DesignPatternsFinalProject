public class EndGameState implements GameState {

	private Game game;
	
	public EndGameState(Game game)
	{
		this.game = game;
	}
	@Override
	public void startGame() 
	{
		System.out.println("Game already started.");
	}

	@Override
	public void moveParty() 
	{
		System.out.println("Cannot move right now.");
	}

	@Override
	public void engageBattle() 
	{
		System.out.println("There's no one to attack right now.");
	}
	
	@Override
	public void manageInventory()
	{
		System.out.println("Too late! You already quit!");
	}
	
	@Override
	public void playAgain()
	{
		System.out.println("Too late! You already quit!");
	}


	@Override
	public void endGame()
	{
		System.out.println("Thanks for playing! Goodbye.");
	}

}
