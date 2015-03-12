import java.util.*;

public class RoomTester
{
	public static void main(String[] args)
	{	
		printBanner();
		
		Map map = new Map();
		
		Scanner in = new Scanner(System.in);
		
		Room current = map.getStartingRoom();
		Room newRoom = null;
		
		String input = "";		
		
		while (true)
		{
			//System.out.println(current.getDescription());
			System.out.println(map.getCurrentRoomDescription());
			System.out.println("To move press {e, w, n, s, u, d} then enter.\n");
			input = in.nextLine();
			
			System.out.println();
			
			
			map.moveRoom(input);		
				
		}
		
		
		
	}
	
	public static void printBanner()
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
}
