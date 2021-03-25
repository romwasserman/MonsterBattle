 // Dylan Widecki
// Rom Wasserman
// Bryan Soto
// Monster class that sets methods that contains getters and setters methods to create a new monster with properties.
	public class Monster
	{
		// monster properties
	  public String name;
	  public double health;
	  public double strength;
	  public int speed;

	  // Default monster constructor
	  public Monster(){
		this.name = "";
		this.health = 0.0;
		this.strength = 0.0;
		this.speed = 0;
	  }
	  // set a new monster constructor with the monster's properties
	  public Monster(String newName, double newHealth, double newStrength, int newSpeed){
	    this.name = newName;
	    this.health = newHealth;
	    this.strength = newStrength;
	    this.speed = newSpeed;
	  }
	  // getters/setters
	  public String getName() {
		  return name;
	  }
	  public int getSpeed() {
		  if (speed >= 1 && speed <= 5) {
			  return speed;
		  }
		  else {
			 return speed = 0;
		  }
		  
	  }
	 
	  public void setName(String newName) {
		  name = newName;
	  }
	  public void setSpeed(int newSpeed) {
		  speed = newSpeed;
	  }
	  public double getAttackPriority() {
		  return speed * Math.random();  
	  }
	  public String toString() {
		  // converts the monster's properties to a string 
		  double newHealth = Math.round(health * 100.0) / 100.0;
		  double newStrength = Math.round(strength * 100.0) / 100.0;
		  return "name: " + name + ", health: " + newHealth + ",strength: " + newStrength + ",speed: " + speed;
	  }
	  
	  public double getHealth(){
	    return health;
	  }
	  public double getStrength(){
	    return strength;
	  }
	  public void setHealth(double newHealth){
	    health = newHealth;
	  }
	  public void setStrength(double newStrength){
	    strength = newStrength;
	  }
	  public double attack(){
	    double atk = Math.random() * strength;
	    return atk;
	  }
	  
	  public void takeDamage(double damage){
	    health = health - damage;
	    setHealth(health);
	  }
	  // checks if the monnster's health is greater than 0
	  public boolean isAlive(){
	    if(health <= 0){
	      return false;
	    }
	    else {
	    	return true;
	    }
	  }
	}


