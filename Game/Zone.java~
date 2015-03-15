public abstract class Zone
{
	private String name;
	private String description;
	private Room[][] rooms;
	private Room startingRoom;
	private Room endingRoom;
	
	public Zone(String name, String desc)
	{
		this.name = name;
		this.description = desc;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	
	}
	
	public Room[][] getRooms()
	{
		return rooms;
	}
	
	public void setRooms(Room[][] rooms)
	{
		this.rooms = rooms;
	}
	
	//getStartRoom
	public void setStartingRoom(Room r)
	{
		startingRoom = r;
	}
	
	public Room getStartingRoom()
	{
		return startingRoom;
	}
	
	//getEndRoom
	public void setEndingRoom(Room r)
	{
		endingRoom = r;
	}
	
	public Room getEndingRoom()
	{
		return endingRoom;
	}
	
	//test
	
	public void printAllRooms()
	{
		int i, j;
		
		for (i = 0; i < 3; i++)
			for (j = 0; j < 3; j++)
			{
				System.out.println("\nroom["+i+"]["+j+"]");
				System.out.println(rooms[i][j].getDescription());
			}
	}
}
