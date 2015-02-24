import java.util.Random;

public class GameTest
{

	public static void main(String[] args)
	{
		Random r = new Random();
		
		Party goodGuys = new Party();
		Party badGuys = new Party();
		
		for(int i = 0; i < 4; i++)
		{
			goodGuys.addCharacter(new Hero());
		}
		for(int i = 0; i < 4; i++)
		{
			badGuys.addCharacter(new Monster());
		}
		
		int i = 1;
		for(Character c : goodGuys)
		{
			c.setName("Member " + i);
			i++;
			
			c.setSpeed(r.nextInt(11));
		}
		for(Character c : badGuys)
		{
			c.setName("Monster " + r.nextInt(1001));
			c.setSpeed(r.nextInt(11));
		}
		
		for(Character c : goodGuys)
		{
			System.out.println(c.getName() + ": " + c.getSpeed());
		}
		for(Character c : badGuys)
		{
			System.out.println(c.getName() + ": " + c.getSpeed());
		}
		
		System.out.println();
		
		Game tester = new Game(goodGuys, badGuys);
		tester.setState(tester.getBattleState());
		while(tester.getState().equals(tester.getBattleState()))
		{
			tester.engageBattle(); 
			if(tester.getState().equals(tester.getPlayAgainState()))
				tester.playAgain();
		}
		tester.endGame();
	}
}
