public class Map
{
	private Zone forest;
	private Zone grounds;
	private Zone castle;
	private Zone dungeon;
	
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
	
	public Room getStartingRoom()
	{
		return forest.getStartingRoom();
	}
}
