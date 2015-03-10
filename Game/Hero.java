
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
	
	// TODO abstract this method; concrete implementation in concrete classes
	public abstract Character cloneCharacter();
}
