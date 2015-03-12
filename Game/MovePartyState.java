
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
		
		if(game.map().getMonsterParty().size() == 0)
		{
			System.out.println(game.map().getCurrentRoomDescription());
			System.out.println("Inventory: i\nPickup item: pickup item_number\nDisplay map: m\n" +
					"Move: {e, w, n, s, u, d}\nQuit: quit");
			input = Game.kb.nextLine();
			
			System.out.println();
			
			if(input.equalsIgnoreCase("i"))
				game.setState(game.getInventoryState());
			else if(input.equalsIgnoreCase("quit"))
				game.setState(game.getPlayAgainState());
			else if(input.equalsIgnoreCase("map"))
				game.map().displayMap();
			else if(input.contains("pickup"))
			{
				int itemNum = Integer.parseInt(input.charAt(input.length()-1) + "");
				Item pickup = game.map().getCurrentRoom().getItem(itemNum);
				game.party().inventory().putItem(pickup, false);
			}
			else
				game.map().moveRoom(input);
		}
		else
		{
			game.setState(game.getBattleState());
		}
			
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
