import java.util.*;

public class ItemTester
{
	public static void main(String[] args)
	{
		//TEST WEAPONS
		System.out.println("***WEAPONS***");
		Weapon w = new Sword();
		w = new PoorWeapon(w);
		System.out.println(w.getDescription());
		
		Weapon a = new Phaser();
		a = new SuperiorWeapon(a);
		System.out.println(a.getDescription());
		
		Weapon b = new Staff();
		b = new SuperiorWeapon(b);
		System.out.println(b.getDescription());
		
		Weapon c = new Stick();
		c = new EliteWeapon(c);
		System.out.println(c.getDescription());
		
		System.out.println("\n");
		
		//TEST ARMOR
		System.out.println("***ARMOR***");
		Armor d = new Shield();
		d = new SuperiorArmor(d);
		System.out.println(d.getDescription());
		
		Armor e = new PaperHat();
		e = new EliteArmor(e);
		System.out.println(e.getDescription());
		
		Armor f = new PlateSuit();
		f = new SuperiorArmor(f);
		System.out.println(f.getDescription());
		
		Armor g = new ForceField();
		g = new PoorArmor(g);
		System.out.println(g.getDescription());
		
		Item gg = g;
		System.out.println(gg.getDescription());
		
		
		ItemCreator testtt = ItemCreator.getCreator();
		
		System.out.println(testtt.makeRandomWeapon().getDescription());
		System.out.println(testtt.makeRandomArmor().getDescription());
	}
}









		/*
		Item gg = g;
		HashMap<String, Item> bag = new HashMap<String,Item>();
		
		bag.put(gg.getName(), g);
		
		Item getItem = bag.get(g.getName());
		System.out.println( getItem.getDescription() );
		*/
