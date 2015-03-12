public abstract class RoomCreator
{ 
	public Room createRoom(String name)
	{
		return makeRoom(name);
	}
	
	public abstract Room makeRoom(String name);
}
