import java.util.Random;

public class Monster extends Character 
{	
	private Random r;
	private RandomNameGenerator nameMaker = RandomNameGenerator.getGenerator();
	
	public Monster(boolean boss)
	{
		super(false, boss);
		fillEquipment();
		setName(nameMaker.randomName());
	}

	@Override
	public int compareTo(Object o)
	{
		Monster h = (Monster)o;
		
		if(this.equals(h))
		{
			return 0;
		}
		else
		{
			return h.getName().compareTo(this.getName());
		}
	}
	
	public Character cloneCharacter()
	{
		Character c = new Monster(false);
		
		c.setName(getName());
		c.setSpeed(getSpeed());
		
		return c;
	}
	
	public void fillEquipment()
	{
		r = new Random();
		double x = r.nextDouble();
		
		if(x < 0.35) // chance to generate weapon
		{
			super.equip((Item)WeaponCreator.makeRandom(), true);
		}
		else if(x >= 0.35 && x < 0.7) // chance to generate armor
		{
			super.equip((Item)ArmorCreator.makeRandom(), true);
		}
		
	}
}
