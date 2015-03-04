
public class MovePartyState implements GameState 
{
	private Game game;
	
	public MovePartyState(Game game)
	{
		this.game = game;
	}

	@Override
	public void startGame() 
	{
		System.out.println("Game already started. You cannot restart it from here.");
	}

	@Override
	public void moveParty() 
	{
		System.out.println("You moved the party!");
	}

	@Override
	public void engageBattle()
	{
		System.out.println("There's nobody to attack here.");
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
		System.out.println("You're in the middle of the map. You cannot quit now.");
	}

}
