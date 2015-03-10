
public class StatImp implements StatC {

   private int health;
   private int damage;
   private int speed;
   private double accuracy;
   private int maxDamage;
   private int maxHealth;
   private int minDamage;

   @Override
   public void incrementHealth(int increase) {
      if(increase>0){
         if((this.health += increase)>= this.maxHealth){
            this.health = this.maxHealth;
         }
         else
            this.health += increase;
         System.out.println(increase+" hp increase in health!");
      }
   	
   }
   @Override
   public void decrementHealth(int damageTaken) {
   	
      this.health-= damageTaken;
      if(damageTaken>0)
         System.out.println(damageTaken+" hp was taken by attack!");
   }

   @Override
   public void incrementDamage(int increase) {
      if(increase>0){
         if((this.damage += increase)>= this.maxDamage){
            this.damage = this.maxDamage;
         }
         else
            this.damage += increase;
         System.out.println(increase+" attack damage increase!");
      }
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
   public void setMinDamage(int damage){
      this.minDamage = damage;
   }
   @Override
   public void setDamage(int damage) {
      this.damage = damage; 
   	
   }
   @Override
   public String display() {
   	
      return "HP: ["+health+"],dmg: ["+damage+"],acc: ["+accuracy+"],spd: ["+speed+"]";
   }
//   @Override
//   public Sting getDescription(){
//      if(this.health=>(maxHealth-10)

   @Override
   public void setSpeed(int speed) {
      this.speed=speed;
   	
   }
   @Override
   public void setAccuracy(double accuracy) {
      this.accuracy=accuracy;
   	
   }
	
   @Override
   public void setMaxDamage(int maxDamage){
      this.maxDamage = maxDamage;
   }
	
   @Override
   public void setMaxHealth(int maxHealth){
      this.maxHealth = maxHealth;
   }
	
   @Override
   public int getHealth(){
      return this.health;
   }
   @Override
   public int getDamage(){
      return this.damage;
   }
   @Override
   public double getAccuracy(){
      return this.accuracy;
   }
	// get maxDamage, maxHealth
	
   @Override
   public int getMaxDamage(){
      return this.maxDamage;
   }
   @Override
   public int getMaxHealth(){
      return this.maxHealth;
   }
   @Override 
   public int getSpeed(){
      return this.speed;
   }
   @Override
   public int getMinDamage(){
      return this.minDamage;
   }
}
