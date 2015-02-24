import java.util.*;

public abstract class Character implements Comparable
{
	private int speed;
	private int health;
	private int minDmg;
	private int maxDmg;
	private double accuracy;
	private String name;
	private boolean playable;
	
	public Character(boolean playable)
	{
		speed = 1;
		health = 100;
		minDmg = 20;
		maxDmg = 40;
		accuracy = 0.7;
		name = "Character";
		
		this.playable = playable;
	}
	
	public boolean playable() 
	{
		return playable;
	}

	public int getHealth()
	{
		return health;
	}
	
	public void setHealth(int health)
	{
		if(health > 0)
			this.health = health;
		else
			health = 0;
	}
	
	public int getMinDmg()
	{
		return minDmg;
	}
	
	public int getMaxDmg()
	{
		return maxDmg;
	}
	
	public double getAccuracy()
	{
		return accuracy;
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
		return speed;
	}
	
	// for testing alone; TODO comment out when done testing
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	public int attack()
	{	
		int damage = 0;
		
		Random r = new Random();
		double a = r.nextDouble();
		if(a < accuracy)
		{
			damage = r.nextInt(maxDmg-minDmg+1) + minDmg;
		}
		
		return damage;
	}
	
	public boolean equals(Character that)
	{
		if(that.name.equals(this.name))
		{
			if(that.speed == this.speed)
			{
				if(that.health == this.health)
				{
					if(that.minDmg == this.minDmg)
					{
						if(that.maxDmg == this.minDmg)
						{
							if(that.accuracy == this.accuracy)
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
