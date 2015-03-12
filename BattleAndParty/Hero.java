
public class Hero extends Character
{	
	public Hero()
	{
		super(true);
		setName("Hero");
	}

	@Override
	public int compareTo(Object o)
	{
		Hero h = (Hero)o;
		
		if(this.equals(h))
		{
			return 0;
		}
		else
		{
			return h.getName().compareTo(this.getName());
		}
	}
	
	// TODO abstract this method; concrete implementation in concrete classes
	public Character cloneCharacter()
	{
		Character c = new Hero();
		
		c.setName(getName());
		c.setSpeed(getSpeed());
		c.equip(this.armor(), true);
		c.equip(this.weapon(), true);
		
		return c;
	}
}
