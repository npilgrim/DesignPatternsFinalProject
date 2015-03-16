
public class Stats {
	private StatC stat = StatFactory.getStats();
	private String name;

	public void takeDamage(int healthDec, int damageDec){	
		stat.decrementDamage(damageDec);
		stat.decrementHealth(healthDec);
		
	}
	public void incrementHealth(int increase){
		stat.incrementHealth(increase);
	}
	public void incrementDamage(int increase){
		stat.incrementDamage(increase);
	}
	public void setName(String name){
		this.name = name;
	}
	public void setStats(int health, int damage, double accuracy, int speed, int maxDamage, int maxHealth, int minDamage){
		stat.setDamage(damage);
		stat.setHealth(health);
		stat.setAccuracy(accuracy);
		stat.setSpeed(speed);
		stat.setMaxDamage(maxDamage);
		stat.setMaxHealth(maxHealth);
		stat.setMinDamage(minDamage);
	}
		
	public void displayStats(){
		System.out.println("::"+stat.display());
	}
	
	public void setHealth(int health){
		stat.setHealth(health);
	}
	
	public void setDamage(int damage){
		stat.setDamage(damage);
	}
	
	
	public int getDamage(){
		return stat.getDamage();
	}
	
	public int getHealth(){
		return stat.getHealth();
	}
	public double getAccuracy() {
		
		return stat.getAccuracy();
	}
	public int getSpeed() {
		return stat.getSpeed();
	}
	public int getMaxDamage(){
		return stat.getMaxDamage();
	}
	public int getMinDamage(){
		return stat.getMinDamage();
		
	}
	public void setSpeed(int speed) {
		stat.setSpeed(speed);
		
	}

}



