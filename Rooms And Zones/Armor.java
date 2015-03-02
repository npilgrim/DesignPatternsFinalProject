public abstract class Armor implements Item
{
	public String name;
	private int health;
	
	public abstract int getHealth();
	
	public String getName()
	{ return name;}	
	
	//all items must implement this
	public String getDescription()
	{
		String ret;
		
		ret = "A " + getName() + " gives " + getHealth() + " health.";
		
		return ret;
	}
	
	public String getType()
	{
		return "armor";
	}
	
}
