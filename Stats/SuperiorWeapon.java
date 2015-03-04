public class SuperiorWeapon extends WeaponDecorator
{
	private Weapon weapon;
	
	public SuperiorWeapon(Weapon weapon)
	{
		this.weapon = weapon;
	}
	
	public String getName()
	{
		return "dang nice " + weapon.getName();
	}
	
	public int getDamage()
	{
		return 3 + weapon.getDamage();
	}
}
