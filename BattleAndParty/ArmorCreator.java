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
}
