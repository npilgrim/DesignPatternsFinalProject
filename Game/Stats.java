
public class Stats {
	private StatC stat = StatImp.getStatImp();

	public void takeDamage(int healthDec, int damageDec){	
		stat.decrementDamage(damageDec);
		stat.decrementHealth(healthDec);
		
	}
	public void incrementDamage(int increase){
		stat.incrementDamage(increase);
	}
	public void setStats(int damage, double accuracy, int speed, int maxDamage, int maxHealth, int minDamage){
		stat.setDamage(damage);
		stat.setHealth(100);
		stat.setAccuracy(accuracy);
		stat.setSpeed(speed);
		stat.setMaxDamage(maxDamage);
		stat.setMaxHealth(maxHealth);
		stat.setMinDamage(minDamage);
	}
		
	public void displayStats(){
		System.out.println("::"+stat.display()+"\n");
	}
	
	public void setDamage(int damage){
		stat.setDamage(damage);
	}
	
   public void setHealth(int health){
      stat.setHealth(health);
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
	
	public void setAccuracy(double accuracy)
	{
		stat.setAccuracy(accuracy);
	}
	
	public void setMinDmg(int minDmg)
	{
		stat.setMinDamage(minDmg);
	}
	
	public void setMaxDmg(int maxDmg)
	{
		stat.setMaxDamage(maxDmg);
	}

}



