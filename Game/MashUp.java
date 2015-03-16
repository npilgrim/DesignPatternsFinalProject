public class MashUp
{

	public static void main(String[] args)
	{
		Game mashup = new Game();

		while(!mashup.getState().equals(mashup.getEndState()))
		{
			if(mashup.getState().equals(mashup.getStartState()))
			{
				mashup.startGame();
			}
			else if(mashup.getState().equals(mashup.getMoveState()))
			{
				mashup.moveParty();
			}
			else if(mashup.getState().equals(mashup.getInventoryState()))
			{
				mashup.manageInventory();
			}
			else if(mashup.getState().equals(mashup.getBattleState()))
			{
				mashup.engageBattle();
			}
			else if(mashup.getState().equals(mashup.getPlayAgainState()))
			{
				mashup.playAgain();
			}
		}

		mashup.endGame();
	}
}
