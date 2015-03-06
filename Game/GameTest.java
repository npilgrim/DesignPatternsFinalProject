public class GameTest
{

	public static void main(String[] args)
	{		
		Game tester = new Game();
		
		while(!tester.getState().equals(tester.getEndState()))
		{
			if(tester.getState().equals(tester.getStartState()))
			{
				tester.startGame();
			}
			else if(tester.getState().equals(tester.getMoveState()))
			{
				tester.moveParty();
			}
			else if(tester.getState().equals(tester.getInventoryState()))
			{
				tester.manageInventory();
			}
			else if(tester.getState().equals(tester.getBattleState()))
			{
				tester.engageBattle();
			}
			else if(tester.getState().equals(tester.getPlayAgainState()))
			{
				tester.playAgain();
			}
		}
		
		tester.endGame();
	}
}
