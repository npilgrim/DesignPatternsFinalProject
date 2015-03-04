public abstract class ZoneCreator
{
	private ItemCreator itemCreator;
	
	public Zone createZone()
	{
		itemCreator = ItemCreator.getCreator();
		Zone z = makeZone();
		Room[][] rooms = z.getRooms();
		
		linkDoors(rooms);
		fillInventory(rooms);
		
		return z;
	}
	
	public abstract Zone makeZone();
	public abstract Room makeRandomRoom();
	public abstract int getID();
	
	public void linkDoors(Room[][] rooms)
	{
		int i , j, k;
		Door[] doors = null;
		i = j = k = 0;
				
		for (i = 0; i < 3; i++)
			for (j = 0; j < 3; j++)
			{
				k = 0;
				doors = new Door[6];
				
				//e
				if ( (j + 1) <= 2 )
				{
					doors[k++] = new Door("EAST", rooms[i][j+1], true);
				}
				else
				{
					doors[k++] = new Door("EAST", null, false);
				}
				
				//w
				if ( (j - 1) >= 0 )
				{
					doors[k++] = new Door("WEST", rooms[i][j-1], true);
				}
				else
				{
					doors[k++] = new Door("WEST", null, false);
				}
				
				//n
				if ( (i - 1) >= 0 )
				{
					doors[k++] = new Door("NORTH", rooms[i-1][j], true);
				}
				else
				{
					doors[k++] = new Door("NORTH", null, false);
				}
				//s
				if ( (i + 1) <= 2 )
				{
					doors[k++] = new Door("SOUTH", rooms[i+1][j], true);
				}
				else
				{
					doors[k++] = new Door("SOUTH", null, false);
				}
				
				
				
				//u
				doors[k++] = new Door("UP", null, false);
				//d
				doors[k] = new Door("DOWN", null, false);
				
				rooms[i][j].setDoors(doors);
			}
			
	}
	
	public void fillInventory(Room[][] rooms)
	{
		int i, j, k;
		
		for (i = 0; i < 3; i++)
			for (j = 0; j < 3; j++)
				{
					for (k = 0; k < 5; k++)
						rooms[i][j].putItem( itemCreator.makeRandom(getID()));
				}
	}
}
