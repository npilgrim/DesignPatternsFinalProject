import java.util.*;

public class RoomTester
{
	public static void main(String[] args)
	{
		Map map = new Map();
		
		Scanner in = new Scanner(System.in);
		
		Room current = map.getStartingRoom();
		Room newRoom = null;
		
		String input = "";		
		
		System.out.println("\n*****Zone movement demo******\n");
		
		while (true)
		{
			System.out.println(current.getDescription());
			System.out.println("To move press {e, w, n, s, u, d} then enter.\n");
			input = in.nextLine();
			
			System.out.println();
			
			if (input.equals("e") )
				newRoom = current.getDoor(0).enter();
			else if (input.equals("w") )
				newRoom = current.getDoor(1).enter();
			else if (input.equals("n") )
				newRoom = current.getDoor(2).enter();
			else if (input.equals("s") )
				newRoom = current.getDoor(3).enter();
			else if (input.equals("u") )
				newRoom = current.getDoor(4).enter();
			else if (input.equals("d") )
				newRoom = current.getDoor(5).enter();
			else
			{
				System.out.println("Not a valid command");
				continue;
			}
			
			if (newRoom != null)
				current = newRoom;
			else
				System.out.println("You can't go that way!\n");
				
				
		}
		
		
		
	}
}
