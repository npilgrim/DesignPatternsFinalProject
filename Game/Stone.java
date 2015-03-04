public class Stone extends MiscItems
{	
	public Stone()
	{
		name = "stone";
	}
	
	public String getDescription()
	{
		String ret;
		
		ret = "A " + getName() + " lies here motionless.";
		
		return ret;
	}
}
