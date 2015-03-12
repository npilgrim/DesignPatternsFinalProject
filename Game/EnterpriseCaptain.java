
public class EnterpriseCaptain extends Hero {

	public EnterpriseCaptain()
	{
		super();
		setName(getName() + ", captain of the Enterprise");
		setSpeed(135);
		setAccuracy(0.7);
		setMinDmg(10);
		setMaxDmg(30);
		setHealth(90);
		equip(new Phaser(), true);
	}

	@Override
	public Character cloneCharacter() {
		Character c = new EnterpriseCaptain();
		
		c.setName(getName());
		c.setSpeed(getSpeed());
		c.equip(this.armor(), true);
		c.equip(this.weapon(), true);
		
		return c;
	}
}
