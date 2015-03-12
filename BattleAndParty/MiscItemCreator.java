public class MiscItemCreator
{
	public static MiscItems makeItem(String item)
	{
		MiscItems w = null;
		
		if ( item.equals("candle") )
			w = new Candle();
		else if ( item.equals("flower") )
			w = new Flower();
		else if ( item.equals("stone") )
			w = new Stone();
		else if ( item.equals("skull") )
			w = new Skull();
		else
			w = null;
		
		return w;
	}
}
