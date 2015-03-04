public class List
{	
	private Node head;
	private int size;
	
	public List()
	{
		this.head = null;
		this.size = 0;
	}
	
	public Node head()
	{
		return this.head;
	}
	
	public int size()
	{
		return this.size;
	}
	
	public void add(Object data)
	{
		Node nn = new Node(data);
		Node cur;
		
		if(head == null)
		{
			head = nn;
			size++;
		}
		else
		{
			for(cur = this.head; cur.getNext() != null; cur = cur.getNext()); // semi-colon here to loop to end
			
			cur.setNext(nn);
			nn.setPrev(cur);
			size++;
		}
	}
	
	public void remove(Object data)
	{
		Node cur, result = null;
		
		for(cur = head; cur != null; cur = cur.getNext()) // loop to correct node
		{
			if(cur.getData().equals(data))
			{
				result = cur;
			}
		}
		
		if(size == 1)
		{
			head = null;
			size--;
		}
		else if(result.getPrev() == null)
		{
			head = result.getNext();
			result.getNext().setPrev(null);
			result.setPrev(null);
			size--;
		}
		else if(result.getNext() == null)
		{
			result.getPrev().setNext(null);
			result.setPrev(null);
			size--;
		}
		else
		{
			result.getPrev().setNext(result.getNext());
			result.getNext().setPrev(result.getPrev());
			size--;
		}
	}
	
	public void clear()
	{
		this.head = null;
		this.size = 0;
	}
}
