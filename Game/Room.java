public abstract class Room
{
	private String name;
	private String description;
	private Door[] doors;
	private Inventory inventory;
	private Party monsters;
	
	public Room(String name, String description)
	{
		this.name = name;
		this.description = description;
		this.inventory = new Inventory("room");
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setMonsterParty(Party party)
	{
		this.monsters = party;
	}
	
	public String getDescription()
	{	
		String ret = name + "\n" + description + "\n";
		ret += getDoorNames() + "\n";
		ret += inventory.getDescription();
		
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
	
	public Item getItem(int i)
	{
		return inventory.getItem(i);
	}
	
	public void putItem(Item i, boolean silent)
	{
		inventory.putItem(i, silent);
	}
}
