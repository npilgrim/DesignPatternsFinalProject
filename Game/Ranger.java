public class Ranger extends Hero 
{
	public Ranger()
	{
		super();
		setName(getName() + " the Ranger");
		setSpeed(9);
		setAccuracy(0.9);
		setMinDmg(25);
		setMaxDmg(40);
		setHealth(120);
	}
	
	@Override
	public Character cloneCharacter() {
		Character c = new Ranger();
		
		c.setName(getName());
		c.setSpeed(getSpeed());
		c.equip(this.armor(), true);
		c.equip(this.weapon(), true);
		
		return c;
	}
}
