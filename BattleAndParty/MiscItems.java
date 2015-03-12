public abstract class MiscItems implements Item
{
	public String name;
	
	public String getName()
	{ return name;}	
	
	//all items must implement this
	public abstract String getDescription();
	
	public String getType()
	{
		return "misc";
	}
	
	public boolean equipable()
	{
		return false;
	}
	
}
