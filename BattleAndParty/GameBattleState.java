import java.util.Random;

public class GameBattleState implements GameState {

	private Game game;
	
	public GameBattleState(Game game)
	{
		this.game = game;
	}
	
	@Override
	public void startGame() {
		System.out.println("Game already started.");
	}

	@Override
	public void moveParty() {
		System.out.println("Unable to move right now.");
	}

//TODO abstact loop out to use Template
	@Override
	public void engageBattle() 
	{
		boolean quit = false;
		Random random = new Random();
		Character[] characterOrder = setTurnOrder(game.party(), game.enemy());
		Character target = null;
		int option = 0, targetChoice = 0, i;
		int damage = 0;
		
		while (game.enemy().size() > 0 && game.party().size() > 0 && !quit) 
		{
			for (i = 0; i < characterOrder.length && game.enemy().size() > 0 && !quit; i++)
			{
				game.party().printState();
				game.enemy().printState();
				
				if (characterOrder[i].playable() && !quit) 
				{
					option = displayBattleMenu(characterOrder[i].getName());
					 
					switch (option) 
					{
					case 1:
						targetChoice = getTargetChoice();

						target = game.enemy().getCharacter(targetChoice-1);
						damage = characterOrder[i].attack();

						if (damage > 0)
						{
							if (damage >= target.getHealth()) 
							{
								System.out.println(target.getName() + " has been defeated!");
								game.enemy().remove(target);
								characterOrder = setTurnOrder(game.party(), game.enemy());
							} 
							else
							{
								target.setHealth((target.getHealth() - damage));
								System.out.println(characterOrder[i].getName() + " attacks " + target.getName() + " for " + damage + " points!");
							}
						}
						else
						{
							System.out.println(characterOrder[i].getName() + "'s attack missed " + target.getName() + ".");
						}
						break;
					
					case 2:
						System.out.println("You run away in shame...");
						game.setState(game.getPlayAgainState());
						quit = true;
						game.playAgain();

						break;
					}// end switch
					
				} // end if playable
				else if(!quit && game.party().size() > 0)
				{
					target = game.party().getCharacter(random.nextInt(game.party().size()));
					damage = characterOrder[i].attack();
					
					
					if (damage > 0) 
					{
						if (damage >= target.getHealth()) 
						{
							System.out.println(target.getName() + " has been defeated!");
							game.party().remove(target);
							characterOrder = setTurnOrder(game.party(), game.enemy());
						} 
						else 
						{
							target.setHealth(target.getHealth() - damage);
							System.out.println(characterOrder[i].getName() + " attacks " + target.getName() + " for " + damage + " points!");
						}
						System.out.println();
					}
					else
					{
						System.out.println(characterOrder[i].getName() + "'s attack missed " + target.getName() + ".");
					}
				} // end elseif
				
			}// end for loop
		} //end while loop
		
		if(!game.getState().equals(game.getPlayAgainState()) && !quit)
		{	
			if(game.party().size() == 0)
			{
				System.out.println("Your entire has been defeated...");
			}
			else if(game.enemy().size() == 0)
			{
				System.out.println("Victory!");
			}
			
			game.setState(game.getPlayAgainState());
		}
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
		System.out.println("You can't quit in the middle of a battle!");
	}

	public Character[] setTurnOrder(Party party, Party enemies)
	{
		Character[] order = new Character[(party.size() + enemies.size())];
		
		int i = 0;
		while(i < order.length)
		{
			for(Character c : party)
			{
				order[i] = c;
				i++;
			}
			
			for(Character c : enemies)
			{
				order[i] = c;
				i++;
			}
		}
		
		int fastest;
		Character t;
		for(i = 0; i < order.length; i++)
		{
			fastest = i;
			for(int j = i; j < order.length; j++)
			{
				if(order[j].getSpeed() > order[fastest].getSpeed())
				{
					fastest = j;
				}
			}
			
			t = order[i];
			order[i] = order[fastest];
			order[fastest] = t;
		}
		
		return order;
	} // end setTurnOrder
	
	public int displayBattleMenu(String name)
	{
		int option = 0;
		
		System.out.println(name + "\n1. Attack\n2. Quit");
		
		try
		{
			option = Game.kb.nextInt();
			Game.kb.nextLine();
			while(option < 0 || option > 2)
			{
				System.out.println("Invalid menu choice. Try again.");
				option = Game.kb.nextInt();
				Game.kb.nextLine();
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Exception choosing option: " + e);
		}
		
		return option;
	}
	
	public int getTargetChoice()
	{
		int targetChoice = 0;
		
		System.out.println("\nChoose your target: ");
		int j = 1;
		for (Character t : game.enemy()) 
		{
			System.out.printf("[%d]: %s\n", j, t.getName());
			j++;
		}
		
		try
		{
			targetChoice = Game.kb.nextInt();
			Game.kb.nextLine();
			while(targetChoice < 1 || targetChoice > game.enemy().size())
			{
				System.out.println("Invalid target. Try again.");
				targetChoice = Game.kb.nextInt();
				Game.kb.nextLine();
			}
		}
		catch (Exception e)
		{
			System.out.println("Exception while choosing target: " + e);
		}
		
		return targetChoice;
	}
}
