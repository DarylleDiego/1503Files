/** Node class starting code. 
 */
public class Node<data>
{
   
    private Object data;
    private Node next;
    
    /**
     * Constructor for objects of class Node
     */
    public Node()
    {
       data = null;
       next = null;
    }

    public Object getData() { return data;}
    public void setData(Object o) { data = o;}
    
    public Node getNext() { return next;}
    public void setNext(Node n) { next = n;}
 
    public String toString() 
    {
        return "Node: " + getData().toString();
    }
}