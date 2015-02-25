
public class StatImp implements StatC {

	private int health;
	private int damage;
	private int speed;
	private double accuracy;

	@Override
	public void incrementHealth(int increase) {
		this.health += increase;
		if(increase>0)
			System.out.println(increase+" hp increase in health!");
		
	}
	@Override
	public void decrementHealth(int damageTaken) {
		
		this.health-= damageTaken;
		if(damageTaken>0)
			System.out.println(damageTaken+" hp was taken by attack!");
	}

	@Override
	public void incrementDamage(int increase) {
		this.damage += increase;
		if(increase>0)
			System.out.println(increase+" point increase in damage!");
		
	}

	@Override
	public void decrementDamage(int damageTaken) {
		this.damage-= damageTaken;
		if(damageTaken>0)
			System.out.println(damageTaken+" damage points were taken by attack!");
	}

	@Override
	public void setHealth(int health) {
		this.health = health;
		
	}
	@Override
	public void setDamage(int damage) {
		this.damage = damage; 
		
	}
	@Override
	public String display() {
		
		return "health: "+health+",damage: "+damage+",accuracy: "+accuracy+",speed: "+speed;
	}

	@Override
	public void setSpeed(int speed) {
		this.speed=speed;
		
	}
	@Override
	public void setAccuracy(double accuracy) {
		this.accuracy=accuracy;
		
	}

	
}
