public class EliteArmor extends ArmorDecorator
{
	private Armor armor;
	
	public EliteArmor(Armor armor)
	{
		this.armor = armor;
	}
	
	public String getName()
	{
		return "extremely powerful " + armor.getName();
	}
	
	public int getHealth()
	{
		return 6 + armor.getHealth();
	}
}
