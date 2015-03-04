
public interface StatC {
	public void incrementHealth(int increase);
	public void decrementHealth(int damageTaken);
	public void incrementDamage(int increase);
	public void decrementDamage(int damageTaken);
	public void setSpeed(int speed);
	public void setAccuracy(double accuracy);
	public void setHealth(int health);
	public void setDamage(int damage);
	public String display();
	public void setMaxDamage(int maxDamage);
	public void setMaxHealth(int maxHealth);
	public void setMinDamage(int damage);
	public int getDamage();
	public int getHealth();
	public double getAccuracy();
	public int getSpeed();
	public int getMaxDamage();
	public int getMaxHealth();
	public int getMinDamage();
	
}


