import java.util.*;

public class DungeonZoneCreator extends ZoneCreator
{
	private RoomCreator roomCreator;
	
	public Zone makeZone()
	{
		roomCreator = new DungeonRoomCreator();
		int num1, num2;
		Random rand = new Random();
		Room[][] rooms = new Room[3][3];
		Zone ret = new DungeonZone();
		int start_r, start_c;
		int end_r, end_c;
		//randomize start
		num1 = 1;
		num2 = 1;
		
		while (num1 == 1 && num2 == 1)
		{
			num1 = (rand.nextInt() % 2 - 0 + 1) + 0;
			num2 = (rand.nextInt() % 2 - 0 + 1) + 0;
		}
		
		rooms[num1][num2] = roomCreator.createRoom("dungeontocastle");
		rooms[num1][num2].setZone(ret);
		start_r = num1;
		start_c = num2;
		
		//randomize end
		num1 = 1;
		num2 = 1;
		
		while ((num1 == 1 && num2 == 1) || (num1 == start_r && num2 == start_c))
		{
			num1 = (rand.nextInt() % 2 - 0 + 1) + 0;
			num2 = (rand.nextInt() % 2 - 0 + 1) + 0;
		}
		rooms[num1][num2] = roomCreator.createRoom("tortureroom");
		rooms[num1][num2].setZone(ret);
		end_r = num1;
		end_c = num2;
		//fill in the rest
		
		int i, j;
		for (i = 0; i < 3; i++)
			for (j = 0; j < 3; j++)
				if (rooms[i][j] == null)
				{
					rooms[i][j] = makeRandomRoom();
					rooms[i][j].setZone(ret);
				}
		
		ret.setRooms(rooms);
		ret.setStartingRoom(rooms[start_r][start_c]);
		ret.setEndingRoom(rooms[end_r][end_c]);
		
		//adding skulls to this specific zone
		for (int num = 0; num < 4; num++)	
			rooms[end_r][end_c].putItem( itemCreator.makeMisc(3), true);
		
		return ret;
	}

	public Room makeRandomRoom()
	{
		//Random r = new Random();
		
		return roomCreator.createRoom("dungeonhall");
		
		/*
		int num = (r.nextInt() % 2 - 0) + 1;
		
		if ( num == 0 )
			return roomCreator.createRoom("thelordsroom");
		else if ( num == 1 )
			return roomCreator.createRoom("hallway");
		else if ( num == 2 )
			return roomCreator.createRoom("chamberroom");
		else
			return roomCreator.createRoom("");
			*/
			
	}
	
	public int getID()
	{
		return 3;
	}
}
