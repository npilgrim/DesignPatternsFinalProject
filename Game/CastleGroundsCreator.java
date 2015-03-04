public class CastleGroundsCreator extends RoomCreator
{	
	public Room makeRoom(String name)
	{
		if (name.equals("courtyard") )
			return new Courtyard();
		else if (name.equals("garden") )
			return new Garden();
		else if (name.equals("groundstocastle") )
			return new GroundsToCastle();
		else if (name.equals("groundstoforest") )
			return new GroundsToForest();
		else
			return new NullRoom();
	}
}                                                 
