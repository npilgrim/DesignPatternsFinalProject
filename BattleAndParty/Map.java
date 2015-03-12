public class Map
{
	private Zone forest;
	private Zone grounds;
	private Zone castle;
	private Zone dungeon;
	private Room currentRoom;
	
	public Map()
	{
		ZoneCreator z = new ForestZoneCreator();
		forest = z.createZone();
		
		z = new CastleGroundsZoneCreator();
		grounds = z.createZone();
		
		z = new CastleZoneCreator();
		castle = z.createZone();
		
		z = new DungeonZoneCreator();
		dungeon = z.createZone();
		
		linkZones();
		
		currentRoom = getStartingRoom();
	}
	
	private void linkZones()
	{
		Room from, to;
		
		//link forest to grounds
		from = forest.getEndingRoom();
		to = grounds.getStartingRoom();
		
		from.setDoor(5, new Door("DOWN", to, true));
		to.setDoor(4, new Door("UP" , from, true));
		
		//link grounds to castle
		from = grounds.getEndingRoom();
		to = castle.getStartingRoom();
		
		from.setDoor(5, new Door("DOWN", to, true));
		to.setDoor(4, new Door("UP" , from, true));
		
		//link castle to dungeon
		
		from = castle.getEndingRoom();
		to = dungeon.getStartingRoom();
		
		from.setDoor(5, new Door("DOWN", to, true));
		to.setDoor(4, new Door("UP" , from, true));
	}
	
	public Party getMonsterParty()
	{
		return this.currentRoom.getMonsterParty();
	}
	
	public Room getStartingRoom()
	{
		return forest.getStartingRoom();
	}
	
	public Room getCurrentRoom()
	{
		return currentRoom;
	}
	
	public String getCurrentRoomDescription()
	{
		return currentRoom.getDescription();
	}
	
	
	public void moveRoom(String room)
	{
		String input = room;
		Room newRoom = null;
		
			if (input.equals("e") )
				newRoom = currentRoom.getDoor(0).enter();
			else if (input.equals("w") )
				newRoom = currentRoom.getDoor(1).enter();
			else if (input.equals("n") )
				newRoom = currentRoom.getDoor(2).enter();
			else if (input.equals("s") )
				newRoom = currentRoom.getDoor(3).enter();
			else if (input.equals("u") )
				newRoom = currentRoom.getDoor(4).enter();
			else if (input.equals("d") )
				newRoom = currentRoom.getDoor(5).enter();
			else
			{
				System.out.println("Not a valid command");
				//continue;
			}
			
			if (newRoom != null)
				currentRoom = newRoom;
			else
				System.out.println("You can't go that way!\n");
	}
}
