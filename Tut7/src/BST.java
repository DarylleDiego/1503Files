public class BST<T extends Comparable<T>> {
	class BSTNode implements Comparable<BSTNode> {
		private T data;
		private BSTNode left;
		private BSTNode right;

		public BSTNode(T d) {
			setLeft(null);
			setRight(null);
			setData(d);
		}
		public T getData() { return data; }
		public void setData(T d) { data = d; }
		public void setLeft(BSTNode l) { left = l; }
		public void setRight(BSTNode r) { right = r; }
		public BSTNode getLeft() { return left; }
		public BSTNode getRight() { return right; }
		public boolean isLeaf() { return (getLeft() == null) && (getRight() == null); }
		public int compareTo(BSTNode o) {
			return this.getData().compareTo(o.getData());
		}
	}
	public static final int INORDER = 0;
	public static final int PREORDER = 1;
	public static final int POSTORDER = 2;
	public static final int LEVELORDER = 3;
	
	private BSTNode root;
	private int size;

	public BST() {
		root = null;
		size = 0;
	}

	/**
	 * Return the number of nodes in the tree.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Return true if element d is present in the tree.
	 */
	public T find(T d) {
		return find(d, root);
	}

	/**
	 * Add element d to the tree.
	 */
	public void add(T d) {
		BSTNode n = new BSTNode(d);
		if (root == null) {
			size++;
			root = n;
		} else {
			add(root, n);
		}
	}

	/**
	 * Return the height of the tree.
	 */
	public int height() {
		return height(root);
	}

	public void printInOrder() {
		inOrderTraversal(root);
	}
	
	public void printPreOrder() {
		preOrderTraversal(root);
	}
	
	public void printPostOrder() {
		postOrderTraversal(root);
	}
	
	public void printLevelOrder() {
		levelOrderTraversal(root);
	}
	
	// Private methods.

	private T find(T d, BSTNode r) {
		if (r == null)
			return null;
		int c = d.compareTo(r.getData());
		if (c == 0)
			return r.getData();
		else if (c < 0)
			return find(d, r.getLeft());
		else
			return find(d, r.getRight());
	}

	/* Do the actual add of node r to tree rooted at n */
	private void add(BSTNode r, BSTNode n) {
		int c = n.compareTo(r);
		if (c < 0) {
			if(r.getLeft() == null)
			{
				r.setLeft(n);
				size++;
			}
			else
				add(r.getLeft(), n);
		}
		else if(c > 0)
		{
			if(r.getRight() == null)
			{
				r.setRight(n);
				size++;
			}
			else
				add(r.getRight(), n);
		}
	}

	/* Implement a height method. */
	private int height(BSTNode r) {
		int h = 0;
		if(r != null)
		{
			int rh = height(r.getRight());
			int lh = height(r.getLeft());
			h = (rh > lh ? 1 + rh : 1 + lh);
		}
		return h;
	}

	private void visit(BSTNode r) {
		if (r != null)
			System.out.println(r.getData());
	}
	
	private void inOrderTraversal(BSTNode r) {
		if (r == null)
			return;
		else {
			inOrderTraversal(r.getLeft());
			visit(r);
			inOrderTraversal(r.getRight());
		}
	}
	
	private void preOrderTraversal(BSTNode r) {
		if (r == null)
			return;
		else
		{
			visit(r);
			preOrderTraversal(r.getLeft());
			preOrderTraversal(r.getRight());
		}
	}
	
	private void postOrderTraversal(BSTNode r) {
		if (r == null)
			return;
		else
		{
			preOrderTraversal(r.getLeft());
			preOrderTraversal(r.getRight());
			visit(r);
		}
	}
	
	private void levelOrderTraversal(BSTNode r) {
		BSTNode currNode = r;
		Queue<BSTNode> q = new Queue<BSTNode>();
		
		q.enqueue(currNode);
		
		while(!q.isEmpty())
		{
			currNode = q.dequeue();
			visit(currNode);
			if(currNode.getLeft() != null)
				q.enqueue(currNode.getLeft());
			if(currNode.getRight() != null)
				q.enqueue(currNode.getRight());
			
		}
	}
}