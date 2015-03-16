import java.util.*;

@SuppressWarnings("rawtypes")
public abstract class Character implements Comparable
{
	private static final int TURN_COST = 1000, RES_LIMIT = 500, THRESHOLD = 1000;
	
	private Stats stats;
	private int health;
	private String name;
	private boolean playable;
	private boolean boss;
	private Equipment equipment;
	// for determining turn order
	private int counter, reserve;
	
	public Character(boolean playable, boolean boss)
	{
		stats = new Stats();
		stats.setStats(0, 0.7, 100, 40, 200, 20);
		health = stats.getHealth();
		name = "Character";
		
		this.playable = playable;
		this.boss = boss;
		equipment = new Equipment();
		
		this.counter = 0;
		this.reserve = 0;
	}
	
	public boolean boss()
	{
		return this.boss;
	}
	
	public int getCounter() {
		return counter;
	}
	
	public void decCounter(int c)
	{
		if(counter - c < 0)
			counter = 0;
		else
			counter -= c;
	}
	
	public void incCounter()
	{
		counter += stats.getSpeed() + reserve;
		reserve = 0;
	}

	public int getReserve() {
		return reserve;
	}

	public void setReserve(int reserve) {
		if(reserve > RES_LIMIT)
			reserve = RES_LIMIT;
		else
			this.reserve += reserve;
	}
	
	public static int getBaseRes(Character[] c)
	{
		int big = 0;
		
		for(int i = 0; i < c.length; i++)
		{
			if(c[i].counter > c[big].counter)
				big = i;
		}
		
		if(c[big].counter-THRESHOLD < 0)
			return 0;
		else if(c[big].counter-THRESHOLD > RES_LIMIT)
			return RES_LIMIT;
		else
			return c[big].counter-THRESHOLD;
	}
	
	public static void setAllReserve(Character [] c, int base)
	{
		for(Character x : c)
		{
			if(x.counter < base)
			{
				x.reserve = x.counter;
				x.counter = 0;
			}
			else
			{
				x.reserve = base;
				x.counter -= base;
			}
		}
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
		return this.health + armor().getHealth();
	}
	
	public void setHealth(int health)
	{
		if(health < 0)
			this.health = 0;
		else
			this.health = health;
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
	
	public void setSpeed(int speed)
	{
		this.stats.setSpeed(speed);
	}
   
   public void getStats()
   {
		this.stats.displayStats();
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
		
		decCounter(TURN_COST);
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
