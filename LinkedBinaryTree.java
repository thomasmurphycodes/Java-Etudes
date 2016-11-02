/** Concrete implemention of a binary tree using a node based link structure */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
	protected static class Node<E> implements Position<E> {
		private E element;
		private Node<E> left;
		private Node<E> right;
		private Node<E> parent;

		/** Constructs a node with given element and neighbors */
		public Node(E e, Node<E> leftChild, Node<E> rightChild, Node<E> above) {
			element = e;
			left = leftChild;
			right = rightChild;
			parent = above;
		}
		// Accessors
		public E getElement() { return element; }
		public Node<E> getParent() { return parent; }
		public Node<E> getLeft() { return left; }
		public Node<E> getRight() { return right; }

		// update Methods
		public void setElement(E e) { element = e; }
		public void setParent(Node<E> parentNode) { parent = parentNode; }
		public void setLeft(Node<E> leftNode) { left = leftNode; }
		public void setRight(Node<E> rightNode) { right = rightNode; }
	}

	protected Node<E> createNode(E e, Node<E> left, Node<E> right, Node<E> parent) {
			return new Node<E>(e, left, right, parent);
		}

	// Instance methods
	protected Node<E> root = null;
	private int size = 0;

	//Constructor
	public LinkedBinaryTree(){};

	//Private utililty class
	/** Validate position and return it as a node */
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if(!(p instanceof Node)) {
			throw new IllegalArgumentException("Not a valid Node");
		}
		Node<E> node = (Node<E>) p; // Safe casting
		if(node.getParent() == node) // convention for a removed node
			throw new IllegalArgumentException("Node no longer in the tree");
		return node;
	}

	// accessor methods not yet implemented
	/** returns number of nodes in the tree */
	public int getSize() {
		return size;
	}

	/** Return root of tree */
	public Position<E> getRoot() {
		return root;
	}

	/** Return the position of p's parent */
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p); // validate, then operate
		return node.getParent();
	}

	/** Return the position of p's left child */
	public Position<E> left(Position<E> p)  throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getLeft();
	}

	/** Return the position ofp's right child */
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getRight();
	}

	// Update methods for class
	/** Places element E at root of empty tree and returns the Position */
	public Position<E> addRoot(E e) throws IllegalStateException {
		if(!isEmpty()) throw new IllegalStateException("Tree is not empty");
		root = createNode(e, null, null, null); // root has no parent, left, or right initially
		size = 1;
		return root;
	}

}