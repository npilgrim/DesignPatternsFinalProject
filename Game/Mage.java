
public class Mage extends Hero {

	public Mage()
	{
		super();
		setName("Mage " + getName());
		setSpeed(5);
		setAccuracy(0.6);
		setMinDmg(50);
		setMaxDmg(70);
		setHealth(90);
	}
	
	@Override
	public Character cloneCharacter() {
		Character c = new Mage();
		
		c.setName(getName());
		c.setSpeed(getSpeed());
		c.equip(this.armor(), true);
		c.equip(this.weapon(), true);
		
		return c;
	}
}
