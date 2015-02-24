import java.util.Scanner;
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

	@Override
	public void engageBattle() 
	{
		Scanner kb = new Scanner(System.in);
		String answer = "";
		boolean quit = false;
		Random random = new Random();
		Character[] characterOrder = setTurnOrder(game.party, game.enemies);
		Character target = null;
		int option = 0, targetChoice = 0, i;
		int damage = 0;
		
		while (game.enemies.size() > 0 && game.party.size() > 0 && !quit) 
		{
			for (i = 0; i < characterOrder.length && game.enemies.size() > 0; i++)
			{
				if (characterOrder[i].playable() && !quit) 
				{
					game.party.printState();
					game.enemies.printState();
					System.out.println(characterOrder[i].getName() + "\n1. Attack\n2. Quit");
					try 
					{
						option = kb.nextInt();
						if (option != 1 && option != 2) 
						{
							throw new Exception();
						}
					}
					catch (Exception e) 
					{
						System.out.println("Invalid input. Try again.");
						kb.nextLine();
					}
					// Use another State within battle?
					switch (option) 
					{
					case 1:
						System.out.println("\nChoose your target: ");
						int j = 1;
						for (Character t : game.enemies) 
						{
							System.out.printf("[%d]: %s\n", j, t.getName());
							j++;
						}

						try 
						{
							targetChoice = kb.nextInt();
							if (targetChoice < 1 || targetChoice > game.enemies.size())
								throw new Exception();
						} 
						catch (Exception e)
						{
							System.out.println("Invalid target choice. Try again.");
							kb.nextLine();
						}

						target = game.enemies.getCharacter(targetChoice-1);
						damage = characterOrder[i].attack();

						if (damage > 0)
						{
							if (damage >= target.getHealth()) 
							{
								System.out.println(target.getName() + " has been defeated!");
								game.enemies.remove(target);
								characterOrder = setTurnOrder(game.party, game.enemies);
							} 
							else
							{
								target.setHealth((target.getHealth() - damage));
								System.out.println(characterOrder[i].getName() + " attacks " + target.getName() + " for " + damage + " points!");
								System.out.println(target.getName() + " has " + target.getHealth() + " health points left.\n");
							}
						}
						else
						{
							System.out.println(characterOrder[i].getName() + "'s attack missed " + target.getName() + ".");
						}
						break;
					
					case 2:
						System.out.println("\nAre you sure you want to quit? (yes/no)");
						try 
						{
							kb.nextLine();
							answer = kb.nextLine();
							if (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"))
								throw new Exception();
						} 
						catch (Exception e)
						{
							System.out.println("Invalid exit option. Try again.");
							kb.nextLine();
						}

						if (answer.equals("yes")) 
						{
							game.setState(game.getEndState());
							quit = true;
						}

						break;
					}// end switch
					
				} // end if playable
				else if(!quit && game.party.size() > 0)
				{
					target = game.party.getCharacter(random.nextInt(game.party.size()));
					damage = characterOrder[i].attack();
					
					
					if (damage > 0) 
					{
						if (damage >= target.getHealth()) 
						{
							System.out.println(target.getName() + " has been defeated!");
							game.party.remove(target);
							characterOrder = setTurnOrder(game.party, game.enemies);
						} 
						else 
						{
							target.setHealth(target.getHealth() - damage);
							System.out.println(characterOrder[i].getName() + " attacks " + target.getName() + " for " + damage + " points!");
							System.out.println(target.getName() + " has " + target.getHealth() + " health points left.");
						}
						System.out.println();
					}
					else
					{
						System.out.println(characterOrder[i].getName() + "'s attack missed " + target.getName() + ".");
					}
				}
				
			}// end for loop
		} //end while loop
		kb.nextLine();
		kb.close();
		game.setState(game.getPlayAgainState());
		if(game.party.size() == 0)
		{
			System.out.println("Your entire has been defeated...");
		}
		else if(game.enemies.size() == 0)
		{
			System.out.println("Victory!");
		}
		else
		{
			System.out.println("No contest.");
		}
	}
   
   @Override
   public void confirmExit()
   {
      System.out.println("You can't quit yet!");
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
	}
}
