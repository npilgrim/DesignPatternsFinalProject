public class Jedi extends Hero 
{
	public Jedi()
	{
		super();
		setName("Master " + getName());
		setSpeed(2);
		setAccuracy(0.85);
		setMinDmg(40);
		setMaxDmg(50);
		setHealth(80);
	}

	@Override
	public Character cloneCharacter() {
		Character c = new Jedi();
		
		c.setName(getName());
		c.setSpeed(getSpeed());
		c.equip(this.armor(), true);
		c.equip(this.weapon(), true);
		
		return c;
	}
	
	
}
