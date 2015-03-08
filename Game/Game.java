import java.util.Scanner;

public class Game 
{
	static Scanner kb = new Scanner(System.in);
	
	private GameState startState;
	private GameState moveState;
	private GameState battleState;
	private GameState inventoryState;
	private GameState playAgainState;
	private GameState endState;
	
	private GameState current;
	private Party party;
	private Party.PartyMemento savedParty;
	private Party enemies;
	
	private Map map;
	
	public Game()
	{
		startState = new StartGameState(this);
		moveState = new MovePartyState(this);
		battleState = new GameBattleState(this);
		inventoryState = new InventoryState(this);
		playAgainState = new PlayAgainState(this);
		endState = new EndGameState(this);
		
		setState(startState);
		
		printBanner();
	}
	
	public Party party()
	{
		return this.party;
	}
	
	public void setParty(Party party)
	{
		this.party = party;
		this.savedParty = party.saveParty();
	}
	
	public Party.PartyMemento getSavedParty()
	{
		return this.savedParty;
	}
	
	public Party enemy()
	{
		return this.enemies;
	}
	
	public void setEnemy(Party enemies)
	{
		this.enemies = enemies;
	}
	
	public GameState getState() {
		return current;
	}

	public void setState(GameState current) {
		this.current = current;
	}

	public GameState getStartState() {
		return startState;
	}

	public GameState getMoveState() {
		return moveState;
	}

	public GameState getBattleState() {
		return battleState;
	}
	
	public GameState getPlayAgainState()
	{
		return playAgainState;
	}
	
	public GameState getInventoryState()
	{
		return inventoryState;
	}

	public GameState getEndState() {
		return endState;
	}
	
	public void startGame()
	{
		current.startGame();
	}
	public void moveParty()
	{
		setEnemy(map.getMonsterParty());
		current.moveParty();
	}
	public void engageBattle()
	{
		current.engageBattle();
		party.restoreParty(savedParty);
	}
	public void playAgain()
	{
		current.playAgain();
	}
	public void manageInventory()
	{
		current.manageInventory();
		this.savedParty = this.party.saveParty();
	}
	public void endGame()
	{
		current.endGame();
	}
	
	public void printBanner()
	{
		String[] array = new String[9];
		
		array[0] = "\t\t __  __           _       _    _       _ \n";
		array[1] = "\t\t|  \\/  |         | |     | |  | |     | |\n";
		array[2] = "\t\t| \\  / | __ _ ___| |__   | |  | |_ __ | |\n";
		array[3] = "\t\t| |\\/| |/ _` / __| '_ \\  | |  | | '_ \\| |\n";
		array[4] = "\t\t| |  | | (_| \\__ \\ | | | | |__| | |_) |_|\n";
		array[5] = "\t\t|_|  |_|\\__,_|___/_| |_|  \\____/| .__/(_)\n";
		array[6] = "\t\t                                | |      \n";
		array[7] = "\t\t                                |_|      \n";
		array[8] = "\tGame developed by: Nathan Pilgrim, Corbin Staaben, Brady Clapp\n";
		
		
		for (int i = 0; i < array.length; i++)
			System.out.println(array[i]);
	}

	public Map map() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
}
