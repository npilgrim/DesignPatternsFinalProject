public class DungeonRoomCreator extends RoomCreator
{	
	public Room makeRoom(String name)
	{
		if (name.equals("dungeonhall") )
			return new DungeonHall();
		else if (name.equals("tortureroom") )
			return new TortureRoom();
		else if (name.equals("dungeontocastle") )
			return new DungeonToCastle();
		else
			return new NullRoom();
	}
}
