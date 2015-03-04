public class Candle extends MiscItems
{	
	public Candle()
	{
		name = "candle";
	}
	
	public String getDescription()
	{
		String ret;
		
		ret = "A " + getName() + " burns gently.";
		
		return ret;
	}
}
