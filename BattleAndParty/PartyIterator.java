import java.util.Iterator;

public class PartyIterator implements Iterator<Character> 
{
	private List party;
	private Node cur;
	
	public PartyIterator(List party)
	{
		this.party = party;
		cur = party.head();
	}

	@Override
	public boolean hasNext() 
	{
		if(cur != null)
			return true;
		else
			return false;
	}

	@Override
	public Character next() 
	{
		Character result = (Character)cur.getData();
		cur = cur.getNext();
		return result;
	}
	
	@Override
	public void remove()
	{
		 Node c;
		 for(c = party.head(); c.getNext() != cur; c = c.getNext()); // cycle through until next element is cur
		 party.remove(c.getData());
	}

}
