public class InventoryState implements GameState
{
	private final int ACTION = 0;
	private final int ITEM_NUM = 1;
	private final int ARG_LENGTH = 2;
	
	private Game game;
	
	public InventoryState(Game game)
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
	public void manageInventory()
	{
		String input[] = null;
		Item choice = null, unequipped = null;
		Character target = null;
		
		game.party().inventory().getDescription();
		while(!input[ACTION].equalsIgnoreCase("exit"))
		{
			input = inventoryMenu();
			if(input[ACTION].equalsIgnoreCase("equip"))
			{
				choice = game.party().inventory().getItem(Integer.parseInt(input[ITEM_NUM]));
				while(!choice.equipable())
				{
					System.out.println("You can't equip that item!");
					game.party().inventory().putItem(choice, true);
				}
				
				target = chooseTargetCharacter(choice);
				
				unequipped = target.equip(choice);
				if(unequipped != null)
				{
					game.party().inventory().putItem(unequipped, false);
				}
			}
			else if(input[ACTION].equalsIgnoreCase("drop"))
			{
				choice = game.party().inventory().getItem(Integer.parseInt(input[ITEM_NUM]));
				System.out.println("You  dropped " + choice.getDescription() + ".");
			}
		}
		
		game.setState(game.getMoveState());
	}

	@Override
	public void endGame()
	{
		System.out.println("You can't quit from here.");
	}
	
	public String[] inventoryMenu()
	{
		String[] result = null;
		String in = "";
		
		System.out.println("Type either \"equip\" or \"drop\" followed by a space \n"
				+ "and then the item number to perform that action on the specified item.\n" +
				"Type \"exit\" to exit the inventory.");
		
		try
		{
			in = Game.kb.nextLine();
			result = in.split(" ");
			
			while(!result[ACTION].equalsIgnoreCase("exit") && !result[ACTION].equalsIgnoreCase("equip") 
					&& !result[ACTION].equalsIgnoreCase("drop") 
					&& Integer.parseInt(result[ITEM_NUM]) > game.party().inventory().size() 
					&& Integer.parseInt(result[ITEM_NUM]) < 0)
			{
				System.out.println("Invalid command. Try again.");
				in = Game.kb.nextLine();
				result = in.split(" ");
			}
		}
		catch (Exception e)
		{
			System.out.println("Exception during inventory management: " + e);
		}
		
		return result;
	}
	
	public Character chooseTargetCharacter(Item item)
	{
		Character t = null;
		int choice = 0;
		
		System.out.println("Choose the character to equip " + item.getDescription() + " to:");
		game.party().printNames();
		
		choice = Game.kb.nextInt();
		Game.kb.nextLine();
		
		while(choice < 0 || choice > game.party().size())
		{
			System.out.println("Invalid target. Try again.");
			choice = Game.kb.nextInt();
			Game.kb.nextLine();
		}
		
		t = game.party().getCharacter(choice);
		
		return t;
	}
}