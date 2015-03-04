import java.util.Scanner;

public class Game 
{
	static Scanner kb = new Scanner(System.in);
	
	private GameState startState;
	private GameState moveState;
	private GameState battleState;
	private GameState confirmState;
	private GameState playAgainState;
	private GameState endState;
	
	private GameState current;
	private Party party;
	private Party.PartyMemento savedParty;
	private Party enemies;
	
	// strictly for testing purposes
	static Party.PartyMemento enemySave;
	
	public Game(Party party)
	{
		startState = new StartGameState(this);
		moveState = new MovePartyState(this);
		battleState = new GameBattleState(this);
		confirmState = new InventoryState(this);
		playAgainState = new PlayAgainState(this);
		endState = new EndGameState(this);
		
		setState(startState);
		
		this.party = party;
		this.savedParty = party.saveParty();
	}
	
	public Party getParty()
	{
		return this.party;
	}
	
	public Party.PartyMemento getSavedParty()
	{
		return this.savedParty;
	}
	
	public Party getEnemy()
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
	
	public GameState getConfirmState()
	{
		return confirmState;
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
		current.moveParty();
	}
	public void engageBattle()
	{
		current.engageBattle();
	}
	public void playAgain()
	{
		party.restoreParty(savedParty);
		enemies.restoreParty(enemySave); // TODO remove this line after testign
		current.playAgain();
	}
	public void manageInventory()
	{
		current.manageInventory();
	}
	public void endGame()
	{
		current.endGame();
	}
}
