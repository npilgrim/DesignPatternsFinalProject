import java.util.*;

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
		
		System.out.println("Enemy attack! Engaging!");
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		
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

						target = game.enemy().getCharacter(targetChoice);
						damage = characterOrder[i].attack();

						if (damage > 0)
						{
							if (damage >= target.getHealth()) 
							{
								System.out.println(target.getName() + " has been defeated!");
								characterDefeated(target, game.enemy());
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
						
						try
						{
							Thread.sleep(500);
						}
						catch(InterruptedException e)
						{
							Thread.currentThread().interrupt();
							e.printStackTrace();
						}
						
						break;
					
					case 2:
						System.out.println("You run away in shame...");
						game.setState(game.getPlayAgainState());
						quit = true;

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
							characterDefeated(target, game.party());
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
					
					try
					{
						Thread.sleep(700);
					}
					catch(InterruptedException e)
					{
						Thread.currentThread().interrupt();
						e.printStackTrace();
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
			
			game.setState(game.getMoveState());
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
		int option = -1;
		
		System.out.println(name + "\n1. Attack\n2. Quit");
		while(!(option >= 0))
		{
			try
			{
				option = Integer.parseInt(Game.kb.nextLine());
				if(option < 0 || option > 2)
					throw new InputMismatchException();
			} 
			catch (InputMismatchException i)
			{
				System.out.println("Invalid menu choice. Try again.");
			}
			catch (NumberFormatException n)
			{
				System.out.println("Invalid menu choice. Try again.");
			}
			catch (Exception e) 
			{
				System.out.println("Exception choosing option: " + e);
			}
		}
		
		return option;
	}
	
	public int getTargetChoice()
	{
		int targetChoice = -1;
		
		System.out.println("\nChoose your target: ");
		System.out.println(game.enemy().printNames());
		
		while (targetChoice < 0) {
			try {
				targetChoice = Integer.parseInt(Game.kb.nextLine());
				if (targetChoice < 0 || targetChoice > game.enemy().size()) {
					throw new IndexOutOfBoundsException();
				}
			} catch (InputMismatchException i) {
				System.out.println("Invalid target choice. Please try again.");
			} catch (IndexOutOfBoundsException n) {
				System.out.println("Invalid target choice. Try again.");
			} catch (Exception e) {
				System.out.println("Exception while choosing target: " + e);
			}
		}
		return targetChoice;
	}
	
	public void characterDefeated(Character defeated, Party party)
	{
		Item[] loot;
		
		loot = party.kill(defeated);
		for(int i = 0; i < loot.length; i++)
		{
			if(loot[i] != null)
				game.map().getCurrentRoom().putItem(loot[i], true);
		}
	}
}
