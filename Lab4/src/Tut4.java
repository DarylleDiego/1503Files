public class Tut4 {
	   private Node<String> head;
	   private Node<String> tail;
	   
	   private void addHead(Node<String> n)
	   {
	       // add a node to the head of the list.
		   if(head == null)
		   {
			   this.head = n;
		   }
		   else
		   {
			   n.setNext(head);
			   this.head = n;
		   }
	   }
	   
	   private void addTail(Node<String> n) 
	   {
		   if(tail != null)
		   {
			   tail.setNext(n);
			   tail = n;
		   }
		   else
		   {
			   addHead(n);
		   }
	   }

	   private void addInOrder(Node<String> n) 
	   {
		   if(head == null || compare(n, head) < 0)
		   {
			   addHead(n);
		   }
		   else if(compare(n, tail) > 0)
		   {
			   addTail(n);
		   }
		   else 
		   {
			   Node<String> mover = head;
			   
			   while(mover.getNext() != null && compare(n, mover.getNext()) > 0)
			   {
				   mover = mover.getNext();
			   }
			   n.setNext(mover.getNext());
			   mover.setNext(n);
		   }
	   }
	   
	   
	   private Node<String> find(String key) 
	   {
	       // implement find
		   Node<String> curr = head;
		   
		   while(curr != null)
		   {
			   if(curr.getData().equals(key))
			   {
				   return curr;
			   }
			   curr = curr.getNext();
		   }
		   
		   return curr;
	   }
	   
	   private Node<String> delete (String key) 
	   {   
		  // implement delete
		  Node<String> mover = head;
		  Node<String> prevNode = head;
		  
		  while(mover != null)
		  {
			  // Visit each node:
			  // IF the data in this node that my mover is pointing to is equal to the key,
			  // remove the node my mover is pointing to by updating the reference key for my prevNode
			  // return the mover Node
			  // Otherwise, continue traversing through the list.
			  if (mover.getData().contentEquals(key))
			  {
				  if(mover == head && mover == tail)
				  {
					  head = tail = null;
					  return mover;
				  }
				  if(mover == head)
				  {
					  head = mover.getNext();
				  }
				  else
				  {
					  prevNode.setNext(mover.getNext());
				  }
				  if(mover == tail)
				  {
					  tail = prevNode;
				  }
				  return mover;
			  }
			  else
			  {
				  prevNode = mover;
				  mover = mover.getNext();
			  }
		  }
		  //Return null if the item key is not in the list.
	      return null;
	   }
	   
	   private void printList()
	   {
	       Node<String> currentNode = head;
	       while (currentNode != null) 
	       {
	          // Visit the node. In this case, print it out. 
	           System.out.println(currentNode.toString());
	           currentNode = currentNode.getNext();
	       }
	       System.out.println();
	   }
	   
	   public void emptyList()
	   {
	       head = null;
	   }
	   
	   public void run() 
	   {
	       head = null;
	       tail = null;
	       
		   Node<String> a = new Node<String>("Athabasca");
	       Node<String> b = new Node<String>("Andromeda");
	       Node<String> c = new Node<String>("Hector");
	       Node<String> d = new Node<String>("Victoria");      
	       addHead(a);
	       addHead(b);
	       addHead(c);
	       addTail(d);
	       printList();   
	       
	       System.out.println(find("Athabasca").toString() + "\n");
	       emptyList();
	       
	       addInOrder(a);
	       addInOrder(b);
	       addInOrder(c);
	       addInOrder(d);
	       printList();
	       
	       delete("Hector");
	       printList();
	   }

	public static void main(String[] args) {
		Tut4 tut = new Tut4();
		tut.run();
	}
	
	private int compare(Node<String> n1, Node<String> n2)
	{
		if(n1 == null || n2 == null)
		{
			return 0;
		}
		else
		{
			return n1.getData().compareTo(n2.getData());
		}
	}
}