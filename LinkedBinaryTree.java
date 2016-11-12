import java.util.Iterator;

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

	/** Creates a new left child of Position p storing Element e; returns its Position */
	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> parent = validate(p);
		if(parent.getLeft() != null)
			throw new IllegalArgumentException("p already has a left child");
		Node<E> child = createNode(e, null, null, parent);
		parent.setLeft(child);
		size++;
		return child;
	}

	/** Creates a new right child of Position p storing Element e; returns its Position */
	public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> parent = validate(p);
		if(parent.getRight() != null)
			throw new IllegalArgumentException("p already has a right child");
		Node<E> child = createNode(e, null, null, parent);
		parent.setRight(child);
		size++;
		return child;
	}

	/** Replace the Node at Position p with e and return replaced Element */
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E temp = node.getElement();
		node.setElement(e);
		return temp;
	}

	/** Attaches trees t1 and t2 as the left and right subtrees of external p */
	public void attach(Position <E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) 
		throws IllegalArgumentException {
			Node<E> node  = validate(p); // Validate parent node
			if (isInternal(p)) throw new IllegalArgumentException("root for subtrees must be a leaf");
			size += t1.size + t2.size;
			if(!t1.isEmpty()) {
				t1.root.setParent(node);
				node.setLeft(t1.root);
				t1.root = null;
				t1.size = 0;
			}
			if(!t2.isEmpty()) {
				t2.root.setParent(node);
				node.setRight(t2.root);
				t2.root = null;
				t2.size = 0;
			}
	}

	/** Removes the node at position p and replaces it with its child, if any */
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		// Because of replacing p must have only one child node
		if(numChildren(p) == 2) throw new IllegalArgumentException("p has two children");
		Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
		if(child != null)
			child.setParent(node.getParent());
		if (node == root)
			root = child;
		else {
			Node<E> parent = node.getParent();
			if (node == parent.getLeft())
				parent.setLeft(child);
			else
				parent.setRight(child);
		}
		size--;
		E temp = node.getElement();
		node.setElement(null);
		node.setLeft(null);
		node.setRight(null);
		node.setParent(node); //Self-reference is convention here for defunct node to be GC'd
		return temp;
	}

	// Iterator methods
	private class ElementIterator implements Iterator<E> {
		Iterator<Position<E>> posIterator = positions().iterator();
		public boolean hasNext() { return posIterator.hasNext(); }
		public E next() { return posIterator.next(); }
		public void remove() { posIterator.remove(); }
	}

	public Iterator<E> iterator() { return new ElementIterator(); }

	// Traversal methods
	public Iterable<Position<E>> positions(){ return preorder(); }

	
}