
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
		String input = "";
		
		System.out.println(game.map().getCurrentRoomDescription());
		System.out.println("To enter inventory type \"i\" then enter.\nTo move press {e, w, n, s, u, d} then enter.\n" +
				"If you wish to quit, type \"quit\".");
		input = Game.kb.nextLine();
		
		System.out.println();
		
		if(input.equalsIgnoreCase("i"))
			game.setState(game.getInventoryState());
		else if(input.equalsIgnoreCase("quit"))
			game.setState(game.getPlayAgainState());
		else
			game.map().moveRoom(input);
			
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
