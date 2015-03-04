public abstract class Weapon implements Item
{
	public String name;
	private int damage;
	
	public abstract int getDamage();
	
	public String getName()
	{ return name;}	
	
	//all items must implement this
	public String getDescription()
	{
		String ret;
		
		ret = "A " + getName() + " has a damage of " + getDamage() + ".";
		
		return ret;
	}
	
	public String getType()
	{
		return "weapon";
	}
	
}
