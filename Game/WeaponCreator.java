import java.util.Random;

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
	
	public static Weapon makeRandom()
	{
		Weapon w = null;
		Random r = new Random();
		double y, z;
		
		y = r.nextDouble();
		if(y < 0.1)
		{
			z = r.nextDouble();
			if(z < 0.5)
				w = makeItem("phaser", Enums.Quality.POOR.ordinal());
			else if(z >= 0.5 && z < 0.9)
				w = makeItem("phaser", Enums.Quality.SUPERIOR.ordinal());
			else
				w = makeItem("phaser", Enums.Quality.ELITE.ordinal());
		}
		else if(y >= 0.1 && y < 0.3)
		{
			z = r.nextDouble();
			if(z < 0.5)
				w = makeItem("sword", Enums.Quality.POOR.ordinal());
			else if(z >= 0.5 && z < 0.9)
				w = makeItem("sword", Enums.Quality.SUPERIOR.ordinal());
			else
				w = makeItem("sword", Enums.Quality.ELITE.ordinal());
		}
		else if(y >= 0.3 && y < 0.6)
		{
			z = r.nextDouble();
			if(z < 0.5)
				w = makeItem("staff", Enums.Quality.POOR.ordinal());
			else if(z >= 0.5 && z < 0.9)
				w = makeItem("staff", Enums.Quality.SUPERIOR.ordinal());
			else
				w = makeItem("staff", Enums.Quality.ELITE.ordinal());
		}
		else
		{
			z = r.nextDouble();
			if(z < 0.5)
				w = makeItem("stick", Enums.Quality.POOR.ordinal());
			else if(z >= 0.5 && z < 0.9)
				w = makeItem("stick", Enums.Quality.SUPERIOR.ordinal());
			else
				w = makeItem("stick", Enums.Quality.ELITE.ordinal());
		}
		
		return w;
	}
}
