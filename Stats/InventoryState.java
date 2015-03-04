public class InventoryState implements GameState
{
	// TODO implement inventory management system
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
		
	}

	@Override
	public void endGame()
	{
		System.out.println("You have to confirm before you quit.");
	}
	@Override
	public void confirmExit() {
		// TODO Auto-generated method stub
		
	}
}