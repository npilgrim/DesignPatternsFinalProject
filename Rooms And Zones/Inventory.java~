import java.util.*;

public class Inventory
{
	private ArrayList<Item> bag;
	private String name;
	
	public Inventory(String name)
	{
		this.name = name;
		bag = new ArrayList<Item>();
	}
	
	public String getDescription()
	{
		String ret = "";
		Item item = null;
		int i;
		
		if ( bag.size() == 0 )
			ret += "No items found!";
		
		else
		{
			ret += "Items found in " + name + ":\n";
			
			for (i = 0; i < bag.size(); i++)
			{
				item = bag.get(i);
				ret += "   " + i + ") " + item.getName() + "\n";
			}
		}
			
		return ret;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Item getItem(int i)
	{
		if (i < 0 || i > bag.size() - 1)
		{
			System.out.println("That is not a valid item!");
			return null;
		}
		Item item = bag.remove(i);
		System.out.println("You remove a " + item.getName() + " from the " + name);
		return item;
	}
	
	public void putItem(Item i)
	{
		if (i == null)
			return;
		
		System.out.println("You placed " + i.getName() + " into the " + name);
		bag.add(i);
	}
}
