public class Door
{
	private String name;
	private Room room;
	private boolean enterable;
	
	public Door(String name, Room room, boolean enterable)
	{
		this.name = name;
		this.room = room;
		this.enterable = enterable;
	}
	
	public Room enter()
	{
		return room;
	}
	
	public boolean getEnterable()
	{
		return enterable;
	}
	
	public String getName()
	{
		return name;
	}
}
