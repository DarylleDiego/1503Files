public class Stack<T extends Comparable<T>> extends SLL<T> {
	private Node<T> head, tail;
	private int size;
	
	public Stack()
	{
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public void push(Node<T> data)
	{
		if (head == null) // empty list
		{
			head = data;
			tail = data;
		} else {
			data.setNext(head);
			head = data;
		}
		size++;
	}
	
	public Node<T> pop()
	{
		Node<T> n = null;
		if (head != null) {
			n = head;
			if (head == tail)
				tail = head.getNext();
			head = head.getNext();
			size--;
		}
		return n;
	}
	
	public Node<T> peek()
	{
		if(head != null)
		{
			return head;
		}
		
		return null;
	}
	
	public boolean isEmpty()
	{
		if(head == null)
		{
			return true;
		}
		
		return false;
	}
	
	public int size()
	{
		return size;
	}
}