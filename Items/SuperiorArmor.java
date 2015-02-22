public class SuperiorArmor extends ArmorDecorator
{
	private Armor armor;
	
	public SuperiorArmor(Armor armor)
	{
		this.armor = armor;
	}
	
	public String getName()
	{
		return "bright and shiny " + armor.getName();
	}
	
	public int getHealth()
	{
		return 3 + armor.getHealth();
	}
}
