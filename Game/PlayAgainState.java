public class PlayAgainState implements GameState
{
	private Game game;
	
	public PlayAgainState(Game game)
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
	public void playAgain()
	{		
		String input = "";
		System.out.println("Would you like to play again? (yes/no)");
		
		try
		{
			input = Game.kb.nextLine();
			while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"))
			{
				System.out.println("Invalid choice. Try again.");
				input = Game.kb.nextLine();
			}
		}
		catch (Exception e)
		{
			System.out.println("Exception during playAgain: " + e);
		}
		
		if(input.equalsIgnoreCase("yes"))
		{
			game.setState(game.getStartState());
		}
		else
			game.setState(game.getEndState());
	}
	
	@Override
	public void manageInventory()
	{
		System.out.println("Now is not the time for that, Ash!");
	}

	@Override
	public void endGame()
	{
		System.out.println("You have to confirm before you quit.");
	}
}