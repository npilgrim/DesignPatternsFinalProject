import java.util.*;

public class CastleGroundsZoneCreator extends ZoneCreator
{
	private RoomCreator roomCreator;
	
	public Zone makeZone()
	{
		roomCreator = new CastleGroundsCreator();
		int num1, num2;
		Random rand = new Random();
		Room[][] rooms = new Room[3][3];
		Zone ret = new CastleGroundsZone();
		int start_r, start_c;
		int end_r, end_c;
		//randomize start
		num1 = 1;
		num2 = 1;
		
		while (num1 == 1 && num2 == 1)
		{
			num1 = (rand.nextInt() % 2 - 0) + 1;
			num2 = (rand.nextInt() % 2 - 0) + 1;
		}
		
		rooms[num1][num2] = roomCreator.createRoom("groundstoforest");
		start_r = num1;
		start_c = num2;
		
		//randomize end
		num1 = 1;
		num2 = 1;
		
		while (num1 == 1 && num2 == 1 && (num1 != start_r && num2 != start_c))
		{
			num1 = (rand.nextInt() % 2 - 0) + 1;
			num2 = (rand.nextInt() % 2 - 0) + 1;
		}
		rooms[num1][num2] = roomCreator.createRoom("groundstocastle");
		end_r = num1;
		end_c = num2;
		//fill in the rest
		
		int i, j;
		for (i = 0; i < 3; i++)
			for (j = 0; j < 3; j++)
				if (rooms[i][j] == null)
					rooms[i][j] = makeRandomRoom();		
		
		ret.setRooms(rooms);
		ret.setStartingRoom(rooms[start_r][start_c]);
		ret.setEndingRoom(rooms[end_r][end_c]);
		
		return ret;
	}

	public Room makeRandomRoom()
	{
		Random r = new Random();
		
		int num = (r.nextInt() % 1 - 0) + 1;
		
		if ( num == 0 )
			return roomCreator.createRoom("garden");
		if ( num == 1 )
			return roomCreator.createRoom("courtyard");
		else
			return roomCreator.createRoom("");
			
	}
	
	public int getID()
	{
		return 1;
	}
}
