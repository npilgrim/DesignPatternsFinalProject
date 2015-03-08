import java.util.Random;

public class ArmorCreator
{
	public static Armor makeItem(String item, int decorator)
	{
		Armor w = null;
		
		if ( item.equals("shield") )
			w = new Shield();
		else if ( item.equals("paperhat") )
			w = new PaperHat();
		else if ( item.equals("platesuit") )
			w = new PlateSuit();
		else if ( item.equals("forcefield") )
			w = new ForceField();
		else
			w = new NullArmor();
		
		if (decorator == 0)
			w = new PoorArmor(w);
		else if (decorator == 1)
			w = new SuperiorArmor(w);
		else if (decorator == 2)
			w = new EliteArmor(w);
		
		return w;
	}
	
	public static Armor makeRandom()
	{
		Armor a = null;
		Random r = new Random();
		double y, z;
		
		y = r.nextDouble();
		if(y < 0.1)
		{
			z = r.nextDouble();
			if(z < 0.5)
				a = makeItem("forcefield", Enums.Quality.POOR.ordinal());
			else if(z >= 0.5 && z < 0.9)
				a = makeItem("forcefield", Enums.Quality.SUPERIOR.ordinal());
			else
				a = makeItem("forcefield", Enums.Quality.ELITE.ordinal());
		}
		else if(y >= 0.1 && y < 0.3)
		{
			z = r.nextDouble();
			if(z < 0.5)
				a = makeItem("platesuit", Enums.Quality.POOR.ordinal());
			else if(z >= 0.5 && z < 0.9)
				a = makeItem("platesuit", Enums.Quality.SUPERIOR.ordinal());
			else
				a = makeItem("platesuit", Enums.Quality.ELITE.ordinal());
		}
		else if(y >= 0.3 && y < 0.6)
		{
			z = r.nextDouble();
			if(z < 0.5)
				a = makeItem("shield", Enums.Quality.POOR.ordinal());
			else if(z >= 0.5 && z < 0.9)
				a = makeItem("shield", Enums.Quality.SUPERIOR.ordinal());
			else
				a = makeItem("shield", Enums.Quality.ELITE.ordinal());
		}
		else
		{
			z = r.nextDouble();
			if(z < 0.5)
				a = makeItem("paperhat", Enums.Quality.POOR.ordinal());
			else if(z >= 0.5 && z < 0.9)
				a = makeItem("paperhat", Enums.Quality.SUPERIOR.ordinal());
			else
				a = makeItem("paperhat", Enums.Quality.ELITE.ordinal());
		}
		
		return a;
	}
}
