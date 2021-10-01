
public class Node {
	private String data = "";
	private Node next = null;
	private Node other = null;
	public Node (String d) { data = d;}
	public String getData() { return data;}
	public void setNext( Node link) { next = link; }
	public Node getNext() { return next; }
	public void setOther( Node link) { other = link; }
	public Node getOther() { return other; }
}
