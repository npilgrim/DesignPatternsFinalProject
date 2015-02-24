import java.util.*;

public class ForestZoneCreator extends ZoneCreator
{
	private RoomCreator roomCreator;
	
	public Zone makeZone()
	{
		roomCreator = new ForestRoomCreator();
		int num1, num2;
		Random rand = new Random();
		Room[][] rooms = new Room[3][3];
		Zone ret = new ForestZone();
		
		//randomize start
		num1 = 1;
		num2 = 1;
		
		while (num1 == 1 && num2 == 1)
		{
			num1 = (rand.nextInt() % 2 - 0) + 1;
			num2 = (rand.nextInt() % 2 - 0) + 1;
		}
		
		rooms[num1][num2] = roomCreator.createRoom("startingRoom");
		ret.setStartingRoom(rooms[num1][num2]);
		
		//randomize end
		num1 = 1;
		num2 = 1;
		
		while (num1 == 1 && num2 == 1)
		{
			num1 = (rand.nextInt() % 2 - 0) + 1;
			num2 = (rand.nextInt() % 2 - 0) + 1;
		}
		rooms[num1][num2] = roomCreator.createRoom("forestToGrounds");
		ret.setEndingRoom(rooms[num1][num2]);
		//fill in the rest
		
		int i, j;
		for (i = 0; i < 3; i++)
			for (j = 0; j < 3; j++)
				if (rooms[i][j] == null)
					rooms[i][j] = makeRandomRoom();

		
		ret.setRooms(rooms);
		
		return ret;
	}

	public Room makeRandomRoom()
	{
		Random r = new Random();
		
		int num = (r.nextInt() % 2 - 0) + 1;
		
		if ( num == 0 )
			return roomCreator.createRoom("heavilyWooded");
		if ( num == 1 )
			return roomCreator.createRoom("clearedWood");
		if ( num == 2)
			return roomCreator.createRoom("woodedPath");
		else
			return roomCreator.createRoom("");
			
	}
}
