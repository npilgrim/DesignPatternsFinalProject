
public class Monster extends Character 
{
	
	public Monster()
	{
		super(false);
		setName("Monster");
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
		Character c = new Monster();
		
		c.setName(getName());
		c.setSpeed(getSpeed());
		
		return c;
	}
}
