
public abstract class Hero extends Character
{	
	public Hero()
	{
		super(true);
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
	
	public abstract Character cloneCharacter();
}
