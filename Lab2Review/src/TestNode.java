public class TestNode {
	
	public static void main(String[] args)
	{
		Node<String> a = new Node<String>();
		a.setData("Athabasca");
		Node<String> b = new Node<String>();
		b.setData("Andromeda");
		Node<String> c = new Node<String>();
		c.setData("Snow Dome");
		
		a.setNext(b);
		b.setNext(c);

		Node<String> nodes = a;
		
		while(nodes != null)
		{
			System.out.println(nodes.toString());
			nodes = nodes.getNext();
		}
	}
}
