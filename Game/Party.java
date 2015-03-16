import java.util.Iterator;


public class Party implements Iterable<Character>
{
	private List party;
	private Inventory inventory;
	private boolean bossParty = false;
	
	public Party()
	{
		party = new List();
		inventory = new Inventory("party inventory");
	}
	
	public boolean bossParty()
	{
		return bossParty;
	}
	
	public Party(Character c1, Character c2, Character c3, Character c4)
	{
		party = new List();
		party.add(c1);
		party.add(c2);
		party.add(c3);
		party.add(c4);
		
		inventory = new Inventory("party inventory");
	}

	@Override
	public Iterator<Character> iterator() 
	{
		return new PartyIterator(party);
	}
	
	public void addCharacter(Character h)
	{
		party.add(h);
		
		if(h.boss())
			this.bossParty = true;
	}
	
	public int size()
	{
		return party.size();
	}
	
	public Character getCharacter(int index)
	{
		int i = 0;
		for(Node c = party.head(); c != null; c = c.getNext(), i++)
		{
			if(i == index)
				return (Character)c.getData();
		}
		
		return null;
	}
	
	public Character getCharacter(Character target)
	{
		for(Node c = party.head(); c != null; c = c.getNext())
		{
			if(((Character)c.getData()).equals(target))
				return (Character)c.getData();
		}
		
		return null;
	}
	
	public Item[] kill(Character c)
	{
		Item[] loot = new Item[2];
		
		if(!c.armor().getName().equalsIgnoreCase("null"))
			loot[0] = c.armor();
		else
			loot[0] = null;
		if(!c.weapon().getName().equalsIgnoreCase("null"))
			loot[1] = c.weapon();
		else
			loot[1] = null;
		
		party.remove(c);
		
		return loot;
	}
	
	public void printState()
	{
		System.out.println("State of the party:");
		for(Node c = party.head(); c != null; c = c.getNext())
		{
			Character h = (Character)c.getData();
			System.out.println(h.getName() + "'s health: " + h.getHealth());
		}
		System.out.println();
	}
	
	public String printNames()
	{
		String r = "";
		if(size() != 0)
		{
			int i = 0;
			for(Node c = party.head(); c != null; c = c.getNext(), i++)
			{
				if(!((Character)c.getData()).getName().equals(""))
					r += "\t[" + i + "] " + ((Character)c.getData()).getName() + "\n";
				//System.out.println("[" + i + "] " + ((Character)c.getData()).getName());
			}
			
		}
		
		return r;
	}
	
	public Inventory inventory()
	{
		return this.inventory;
	}
	
	public PartyMemento saveParty()
	{
		return new PartyMemento(this);
	}
	
	public void restoreParty(PartyMemento pm)
	{
		this.party.clear();
		
		for(Character c : pm.getSavedParty())
		{
			party.add(c.cloneCharacter());
		}
	}
	
/*
 * Memento class to restore party state after battles
 */
	public static class PartyMemento
	{
		private final Party partyState;
		
		public PartyMemento(Party party)
		{
			partyState = new Party();
			
			for(Character c : party)
			{
				partyState.addCharacter(c.cloneCharacter());
			}
		}
		
		public Party getSavedParty()
		{
			return this.partyState;
		}
	}
	
}
