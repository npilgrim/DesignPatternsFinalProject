
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
   public String characterStatus(){
      int pers = (int)(this.health*100/this.maxHealth);
   	String status;
      
      if(pers<=10){
         return "You feel cold and are now quickly going in and out of consciousness.";
      }
      else if(pers<=20){
         return "You begin to see a faint light and feel like taking a nap.";
      }
      else if(pers<=30){
         return "Your vision has begin to blur and you've become very tired";
      }
      else if(pers<=50){
        return "You've lost about half your blood but still have some fight left in you.";
      }
      else if(pers<=60){
         return "You notice you've lost quite a bit of blood.";
      }
      else if(pers<=70){
         return "You start feel blood running down your body.";
      }
      else if(pers<=90){
         return "It's really just a flesh wound.";
      }
      else
         return "";
   }
   @Override
   public String display() {
   	
      return characterStatus()+"/nHP: ["+health+"] DMG: ["+damage+"] ACC: ["+accuracy+"] SPD: ["+speed+"]"; //need to work on adding weopon damage to DMG
   }
  
   public String getDescription(){
      if(this.health>=(this.maxHealth-10)){}
      return "";
   }
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
