import java.util.Random;

public class Game 
{
	GameState startState;
	GameState moveState;
	GameState battleState;
	GameState confirmState;
	GameState playAgainState;
	GameState endState;
	
	GameState current;
	Party party;
	
	// strictly for testing purposes
	Party enemies;
	
	public Game(Party party, Party enemies)
	{
		startState = new StartGameState(this);
		moveState = new MovePartyState(this);
		battleState = new GameBattleState(this);
		confirmState = new ConfirmExitState(this);
		playAgainState = new PlayAgainState(this);
		endState = new EndGameState(this);
		
		setState(startState);
		
		this.party = party;
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
		current.playAgain();
	}
	public void endGame()
	{
		current.endGame();
	}
}
