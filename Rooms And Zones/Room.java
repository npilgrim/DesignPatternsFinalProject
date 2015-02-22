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
		/*
		if (doors == null)
		{
			System.out.println("name : " + name);
			System.out.println("p1");
		}
		
		if (doors[0] == null)
			System.out.println("p2");
			*/
		
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
	
	public void setDoors(Door[] doors)
	{
		this.doors = doors;
		//System.out.println("Doors made");
	}
	
	public String getDoorNames()
	{
		String ret; 
		
		ret = "Doors available: ";
		try
		{
			for (int i = 0; i < 6; i++)
			{
				if ( doors[i].getEnterable() )
				{
					{ ret += "[" + doors[i].getName() + "] "; }
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Door not created correctly. Exiting.");
			System.exit(0);
		}
		
		return ret;
	}
}
