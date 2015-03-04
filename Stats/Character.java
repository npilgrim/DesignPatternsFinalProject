import java.util.*;

@SuppressWarnings("rawtypes")
public abstract class Character implements Comparable
{
	private int speed;
	private int health;
	private int minDmg;
	private int maxDmg;
	private double accuracy;
	private String name;
	private boolean playable;
	private Equipment equipment;
	private Stats stats;
	
	public Character(boolean playable)
	{
		speed = 1;
		health = 100;
		minDmg = 20;
		maxDmg = 40;
		accuracy = 0.7;
		name = "Character";
		
		this.playable = playable;
		equipment = new Equipment();
		//setting stats stuff
		stats.setStats(100, 40, 0.7, 1, 40, 100, 20);
		stats.setName(name); //not really needed
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
	
	public void equipWeapon(Weapon weapon)
	{
		equipment.setWeapon(weapon);
	}
	
	public void equipArmor(Armor armor)
	{
		equipment.setArmor(armor);
	}
/*	
	public void equipHead(Item head)
	{
		equipment.setHead(head);
	}
*/	
	public Weapon unequipWeapon()
	{
		Weapon w = equipment.getWeapon();
		
		equipment.setWeapon(null);
		
		return w;
	}
	
	public Item unequipArmor()
	{
		Item a = equipment.getArmor();
		equipment.setArmor(null);
		return a;
	}
/*	
	public Item unequipHead()
	{
		Item h = equipment.getHead();
		equipment.setHead(null);
		return h;
	}
*/	
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
		if(health > 0)
			this.health = health;
		else
			health = 0;
		
		stats.setHealth(health);
	}
	
	public int getMinDmg()
	{
		return stats.getMinDamage() + weapon().getDamage();
	}
	
	public int getMaxDmg()
	{	
		
		return stats.getMaxDamage() + weapon().getDamage();
	}
	
	public double getAccuracy()
	{
		return stats.getAccuracy();
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
		stats.setName(name);
	}

	public int getSpeed() 
	{
		return stats.getSpeed();
	}
	
	// for testing alone; TODO comment out when done testing
	public void setSpeed(int speed)
	{
		this.speed = speed;
		stats.setSpeed(speed);
	}
	
	public int attack()
	{	
		int damage = 0;
		
		Random r = new Random();
		double a = r.nextDouble();
		if(a < stats.getAccuracy())
		{
			damage = r.nextInt(stats.getMaxDamage()-stats.getMinDamage()+1) + stats.getMinDamage();
		}
		
		return damage;
	}
	
	public boolean equals(Character that)
	{
        if(that.name.equals(this.name))
		{
			if(that.getSpeed() == this.getSpeed())
			{
				if(that.getHealth() == this.getHealth())
				{
					if(that.getMinDmg()== this.getMinDmg())
					{
						if(that.getMinDmg() == this.getMinDmg())
						{
							if(that.getAccuracy() == this.getAccuracy())
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
