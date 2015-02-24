
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
	public void setStats(int health, int damage, double accuracy, int speed){
		stat.setDamage(damage);
		stat.setHealth(health);
		stat.setAccuracy(accuracy);
		stat.setSpeed(speed);
	}
		
	public void displayStats(){
		System.out.println(""+name+"::"+stat.display()+"\n");
	}

}



