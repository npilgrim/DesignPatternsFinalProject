import java.util.*;

@SuppressWarnings("rawtypes")
public abstract class Character implements Comparable
{
	private Stats stats;
	private String name;
	private boolean playable;
	private Equipment equipment;
	
	public Character(boolean playable)
	{
		stats = new Stats();
		stats.setStats(100, 0, 0.7, 1, 40, 200, 20);
		name = "Character";
		
		this.playable = playable;
		equipment = new Equipment();
	}
	
	public abstract Character cloneCharacter();
	
	public Armor armor()
	{
		return equipment.getArmor();
	}
/*	
	public Item head()
	{
		return equipment.getHead();
	}
*/	
	public Weapon weapon()
	{
		return equipment.getWeapon();
	}
	
	public Item equip(Item i, boolean silent)
	{
		Item r = null;
		
		if(i != null)
		{	
			if(i.getType().equals("weapon"))
				r = equipment.equipWeapon(i);
			else
				r = equipment.equipArmor(i);
			if(!silent)
				System.out.println("You equipped the " + i.getName() + ".");
		}
		
		return r;
	}
	
	public boolean playable() 
	{
		return playable;
	}

	public int getHealth()
	{
		return stats.getHealth() + armor().getHealth();
	}
	
	public void setHealth(int health)
	{
		stats.setHealth(health);
	}
	
	public int getMinDmg()
	{
		return stats.getMinDamage() + weapon().getDamage();
	}
	
	public void setMinDmg(int minDmg)
	{
		stats.setMinDmg(minDmg);
	}
	
	public void setMaxDmg(int maxDmg)
	{
		stats.setMaxDmg(maxDmg);
	}
	
	public int getMaxDmg()
	{
		return stats.getMaxDamage() + weapon().getDamage();
	}
	
	public double getAccuracy()
	{
		return stats.getAccuracy();
	}
	
	public void setAccuracy(double accuracy)
	{
		stats.setAccuracy(accuracy);
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public int getSpeed() 
	{
		return stats.getSpeed();
	}
	
	// for testing alone; TODO comment out when done testing
	public void setSpeed(int speed)
	{
		this.stats.setSpeed(speed);
	}
	
	public int attack()
	{	
		int damage = 0;
		
		Random r = new Random();
		double a = r.nextDouble();
		if(a < stats.getAccuracy())
		{
			damage = r.nextInt(getMaxDmg()-getMinDmg()+1) + getMinDmg();
		}
		
		return damage;
	}
	
	public boolean equals(Character that)
	{
		if(that.name.equals(this.name))
		{
			if(that.getSpeed() == getSpeed())
			{
				if(that.getHealth() == getHealth())
				{
					if(that.getMinDmg() == getMinDmg())
					{
						if(that.getMaxDmg() == getMaxDmg())
						{
							if(that.getAccuracy() == getAccuracy())
							{
								return true;
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
}
