import java.util.Iterator;


public class Party implements Iterable<Character>
{
	private List party;
	
	public Party()
	{
		party = new List();
	}

	@Override
	public Iterator<Character> iterator() 
	{
		return new PartyIterator(party);
	}
	
	public void addCharacter(Character h)
	{
		party.add(h);
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
	
	public void remove(Character c)
	{
		party.remove(c);
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
	
}
