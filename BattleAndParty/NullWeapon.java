public class NullWeapon extends Weapon
{
	private int damage;
	
	public NullWeapon()
	{
		damage = 0;
		name = "null";
	}
	
	public int getDamage()
	{
		return damage;
	}
}
