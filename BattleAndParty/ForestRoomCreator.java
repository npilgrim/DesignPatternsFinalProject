public class ForestRoomCreator extends RoomCreator
{	
	public Room makeRoom(String name)
	{
		if (name.equals("heavilyWooded") )
			return new HeavilyWooded();
		else if (name.equals("startingRoom") )
			return new StartingRoom();
		else if (name.equals("clearedWood") )
			return new ClearedWood();
		else if (name.equals("woodedPath") )
			return new WoodedPath();
		else if (name.equals("forestToGrounds") )
			return new ForestToGrounds();
		else
			return new NullRoom();
	}
}
