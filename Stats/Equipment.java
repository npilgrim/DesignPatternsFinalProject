public class Equipment 
{
	//private Item head;
	private Armor armor;
	private Weapon weapon;
	
	public Equipment()
	{
		//this.head = null;
		this.armor = null;
		this.weapon = null;
	}
/*
	public Item getHead() {
		if(head != null)
			return head;
		else
			System.out.println("You have nothing on your head.");
		
		return null;
	}

	public void setHead(Item head) {
		this.head = head;
	}
*/
	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	
}
