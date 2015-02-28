public abstract class Room
{
	private String name;
	private String description;
	private Door[] doors;
	
	public Room(String name, String description)
	{
		this.name = name;
		this.description = description;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{	
		String ret = name + "\n" + description + "\n";
		ret += getDoorNames();
		
		
		return ret;
	}
	
	public Door getDoor(int i)
	{
		if ( i >= 0 && i <6)
			return doors[i];
		
		else
			return null;
	}
	
	public void setDoor(int i, Door door)
	{
		doors[i] = door;
	}
	
	public void setDoors(Door[] doors)
	{
		this.doors = doors;
	}
	
	public String getDoorNames()
	{
		String ret; 
		int i = 0;
	
		
		ret = "Exits available: ";
		try
		{
			for (i = 0; i < 6; i++)
			{
				if ( doors[i].getEnterable() )
				{
					{ ret += "[" + doors[i].getName() + "] "; }
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Door: " + i + " not created correctly. Exiting.");
			System.exit(0);
		}
		
		return ret;
	}
}
