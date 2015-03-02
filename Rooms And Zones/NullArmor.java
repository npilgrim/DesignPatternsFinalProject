public class NullArmor extends Armor
{
	private int damage;
	
	public NullArmor()
	{
		damage = 0;
		name = "null";
	}
	
	public int getHealth()
	{
		return damage;
	}
}
