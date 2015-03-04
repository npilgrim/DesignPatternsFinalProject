public class PoorArmor extends ArmorDecorator
{
	private Armor armor;
	
	public PoorArmor(Armor armor)
	{
		this.armor = armor;
	}
	
	public String getName()
	{
		return "cotton-made " + armor.getName();
	}
	
	public int getHealth()
	{
		return -3 + armor.getHealth();
	}
}
