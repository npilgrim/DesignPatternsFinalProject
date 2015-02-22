public class EliteWeapon extends WeaponDecorator
{
	private Weapon weapon;
	
	public EliteWeapon(Weapon weapon)
	{
		this.weapon = weapon;
	}
	
	public String getName()
	{
		return "world destroying " + weapon.getName();
	}
	
	public int getDamage()
	{
		return 6 + weapon.getDamage();
	}
}
