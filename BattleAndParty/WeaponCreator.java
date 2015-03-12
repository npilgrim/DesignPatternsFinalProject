public class WeaponCreator
{
	public static Weapon makeItem(String item, int decorator)
	{
		Weapon w = null;
		
		if ( item.equals("sword") )
			w = new Sword();
		else if ( item.equals("staff") )
			w = new Staff();
		else if ( item.equals("stick") )
			w = new Stick();
		else if ( item.equals("phaser") )
			w = new Phaser();
		else
			w = new NullWeapon();
		
		if (decorator == 0)
			w = new PoorWeapon(w);
		else if (decorator == 1)
			w = new SuperiorWeapon(w);
		else if (decorator == 2)
			w = new EliteWeapon(w);
		
		return w;
	}
}
