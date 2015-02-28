public class CastleRoomCreator extends RoomCreator
{	
	public Room makeRoom(String name)
	{
		if (name.equals("hallway") )
			return new Hallway();
		else if (name.equals("thelordsroom") )
			return new TheLordsRoom();
		else if (name.equals("chamberroom") )
			return new ChamberRoom();
		else if (name.equals("castletodungeon") )
			return new CastleToDungeon();
		else if (name.equals("castletogrounds") )
			return new CastleToGrounds();
		else
			return new NullRoom();
	}
}
