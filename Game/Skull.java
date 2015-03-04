public class Skull extends MiscItems
{	
	public Skull()
	{
		name = "skull";
	}
	
	public String getDescription()
	{
		String ret;
		
		ret = "A " + getName() + " rests here bodiless.";
		
		return ret;
	}
}
