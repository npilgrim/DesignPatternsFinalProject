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
	
	public void equipHead(Item head)
	{
		equipment.setHead(head);
	}
	
	public Item unequipHead()
	{
		Item h = equipment.getHead();
		equipment.setHead(null);
		return h;
	}
*/
	public Armor getArmor() {
		return armor;
	}

	public Weapon getWeapon() {
		return weapon;
	}
	
	public Armor equipArmor(Item armor)
	{
		Armor a = null;
		
		if(this.armor == null)
		{
			this.armor = (Armor)armor;
		}
		else
		{
			a = unequipArmor();
			this.armor = (Armor)armor;
		}
		
		System.out.println("You equip the " + a.getDescription() + ".");
		return a;
	}
	
	public Weapon equipWeapon(Item weapon)
	{	
		Weapon w = null;
		
		if(this.weapon == null)
		{
			this.weapon = (Weapon)weapon;
		}
		else
		{
			w = unequipWeapon();
			this.weapon = (Weapon)weapon;
		}
		
		System.out.println("You equip the " + w.getDescription() + ".");
		return w;
	}
	
	public Weapon unequipWeapon()
	{
		Weapon w = getWeapon();
		
		this.weapon = null;
		
		return w;
	}
	
	public Armor unequipArmor()
	{
		Armor a = getArmor();
		this.armor = null;
		return a;
	}
}
