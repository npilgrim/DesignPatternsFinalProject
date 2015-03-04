public class PoorWeapon extends WeaponDecorator
{
	private Weapon weapon;
	
	public PoorWeapon(Weapon weapon)
	{
		this.weapon = weapon;
	}
	
	public String getName()
	{
		return "foamy " + weapon.getName();
	}
	
	public int getDamage()
	{
		return -3 + weapon.getDamage();
	}
}
