public class ConfirmExitState implements GameState
{
	private Game game;
	
	public ConfirmExitState(Game game)
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
		System.out.println("You haven't finished the current game!");
	}
	
	@Override
	public void confirmExit()
	{
		String answer = "";
		System.out.println("Are you sure you want to exit? (yes/no)");
		
		try
		{
			answer = Game.kb.nextLine();
			while(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"))
			{
				System.out.println("Invalid choice. Try again.");
				answer = Game.kb.nextLine();
			}
		}
		catch (Exception e)
		{
			System.out.println("Exception during confirmExit: " + e);
		}
		
		
		if(answer.equalsIgnoreCase("yes"))
		{
			game.setState(game.getEndState());
		}
		else
		{
			game.setState(game.getBattleState());
		}
	}

	@Override
	public void endGame()
	{
		System.out.println("You have to confirm before you quit.");
	}
	@Override
	public void manageInventory() {
		// TODO Auto-generated method stub
		
	}
}