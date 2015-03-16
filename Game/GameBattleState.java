import java.util.*;

public class GameBattleState implements GameState {

	private static final int THRESHOLD = 1000;
	
	private Game game;
	private boolean bossBattle = false;
	
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
		boolean quit = false;
		Character[] characterOrder = turnOrder(game.party(), game.enemy());
		int i, baseRes = 0;
		
		if(game.map().getMonsterParty().bossParty())
		{
			this.bossBattle = true;
		}
		
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
			baseRes = Character.getBaseRes(characterOrder);
			
			for (i = 0; i < characterOrder.length && game.enemy().size() > 0 && !quit; i++)
			{					
				if (characterOrder[i].getCounter() >= THRESHOLD) {
					
					game.party().printState();
					game.enemy().printState();
					
					Character.setAllReserve(characterOrder, baseRes);
					
					if (characterOrder[i].playable() && !quit)
					{
						quit = processPlayerTurn(characterOrder, i);
					} // end if playable
					else if (!quit && game.party().size() > 0) 
					{
						processEnemyTurn(characterOrder, i);
					} // end elseif
				} // end threshold if
				else
					characterOrder[i].incCounter();
				
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
			
			if(bossBattle)
			{
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("\t\t _   _ _____ _____ _____ _____________   __\n"
						 + "\t\t| | | |_   _/  __ \\_   _|  _  | ___ \\ \\ / /\n"
						 + "\t\t| | | | | | | /  \\/ | | | | | | |_/ /\\ V /\n" 
						 + "\t\t| | | | | | | |     | | | | | |    /  \\ / \n" 
						 + "\t\t\\ \\_/ /_| |_| \\__/\\ | | \\ \\_/ / |\\ \\  | |\n"  
						 + "\t\t \\___/ \\___/ \\____/ \\_/  \\___/\\_| \\_| \\_/");
				
				
				try
				{
					Thread.sleep(2000);
				}
				catch(Exception e)
				{
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
				
				game.setState(game.getPlayAgainState());
			}
			else
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
	
	public Character[] turnOrder(Party heroes, Party enemy)
	{
		Character[] order = new Character[heroes.size() + enemy.size()];		
		
		int i = 0;
		
		for(Character c : heroes)
		{
			order[i] = c;
			i++;
		}
		
		for(Character c : enemy)
		{
			order[i] = c;
			i++;
		}
		
		return order;
	}
	
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
		
		try {
			String s = Game.kb.nextLine();
			targetChoice = Integer.parseInt(s);
			while (targetChoice < 0 || targetChoice >= game.enemy().size()) 
			{
				System.out.println("Invalid target. Try again.");
				s = Game.kb.nextLine();
				targetChoice = Integer.parseInt(s);
			}
		} catch (InputMismatchException i) {
			System.out.println("Invalid target choice. Please try again.");
		} catch (Exception e) {
			System.out.println("Exception while choosing target: " + e);
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
	
	public boolean processPlayerTurn(Character[] characterOrder, int i)
	{
		boolean quit = false;
		
		int option = displayBattleMenu(characterOrder[i].getName());

		switch (option) {
		case 1:
			int targetChoice = getTargetChoice();

			Character target = game.enemy().getCharacter(targetChoice);
			int damage = characterOrder[i].attack();

			if (damage > 0)
			{
				System.out.println(characterOrder[i]
						.getName()
						+ " attacks "
						+ target.getName()
						+ " for "
						+ damage + " points!");
				
				if (damage >= target.getHealth()) {
					System.out.println(target.getName() + " has been defeated!");
					characterDefeated(target, game.enemy());
					characterOrder = setTurnOrder(game.party(), game.enemy());
				} else {
					target.setHealth((target.getHealth() - damage));
					
				}
			} else {
				System.out.println(characterOrder[i].getName()
						+ "'s attack " + "missed "
						+ target.getName() + ".");
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
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
		
		return quit;

	}
	
	public void processEnemyTurn(Character[] characterOrder, int i)
	{
		Random random = new Random();
		
		Character target = game.party().getCharacter(random.nextInt(game.party().size()));
		int damage = characterOrder[i].attack();

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
				System.out.println(characterOrder[i].getName() + " attacks " + target.getName() 
						+ " for " + damage + " points!");
			}
			System.out.println();
		} else {
			System.out.println(characterOrder[i].getName() + "'s attack missed " + target.getName() + ".");
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}
}
