
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
	public void endGame() 
	{
		System.out.println("You're in the middle of the map. You cannot quit now.");
	}

}
