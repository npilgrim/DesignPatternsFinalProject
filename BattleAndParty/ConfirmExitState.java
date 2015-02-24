import java.util.Scanner;

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
		Scanner kb = new Scanner(System.in);
		String answer = "";
		System.out.println("Are you sure you want to exit? (yes/no)");
		try
		{
			answer = kb.nextLine();
			if(!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"))
				throw new Exception();
		}
		catch (Exception e)
		{
			System.out.println("Invalid. Try again.");
			kb.nextLine();
		}
		
		if(answer.equalsIgnoreCase("yes"))
		{
			game.setState(game.getEndState());
		}
		else
		{
			game.setState(game.getBattleState());
		}
		kb.nextLine();
	}

	@Override
	public void endGame()
	{
		System.out.println("You have to confirm before you quit.");
	}
}