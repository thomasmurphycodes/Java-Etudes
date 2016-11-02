public interface BinaryTree<E> extends Tree<E> {
	/** Return Position of p's left child or null */
	Position<E> left(Position<E>  p) throws IllegalArgumentException;
	/** Return Position of p's right child or null */
	Position<E> right(Position<E>  p) throws IllegalArgumentException;
	/** Return Position that is p's sibling */
	Position<E> sibling(Position<E>  p) throws IllegalArgumentException;
}