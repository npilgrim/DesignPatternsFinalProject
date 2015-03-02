public class Flower extends MiscItems
{	
	public Flower()
	{
		name = "flower";
	}
	
	public String getDescription()
	{
		String ret;
		
		ret = "A " + getName() + " stands tall and pretty.";
		
		return ret;
	}
}
