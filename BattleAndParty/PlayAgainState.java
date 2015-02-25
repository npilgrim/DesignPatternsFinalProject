import java.util.Scanner;

public class PlayAgainState implements GameState
{
	private Game game;
	
	public PlayAgainState(Game game)
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
		Scanner kb = new Scanner(System.in);		
		String input = "";
		System.out.println("Would you like to play again? (yes/no)");
		try
		{
			input = kb.nextLine();
			if(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"))
				throw new Exception();
		}
		catch (Exception e)
		{
			System.out.println("Invalid choice. Try again.");
		}
		kb.close();
		if(input.equalsIgnoreCase("yes"))
			game.setState(game.getBattleState());
		else
			game.setState(game.getEndState());
	}
	
	@Override
	public void confirmExit()
	{
		System.out.println("You have to decide whether you would like to play again or not first.");
	}

	@Override
	public void endGame()
	{
		System.out.println("You have to confirm before you quit.");
	}
}