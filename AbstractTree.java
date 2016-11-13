import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public abstract class AbstractTree<E> implements Tree<E> {
	public boolean isInternal(Position<E> p){ return numChildren(p) > 0; }
	public boolean isExternal(Position<E> p){ return numChildren(p) == 0; }
	public boolean isRoot(Position<E> p){ return p == root(); }
	public boolean isEmpty(){ return size() == 0; }

	public int depth(Position<E> p){
		if(isRoot(p))
			return 0;
		else
			return 1 + depth(parent(p));
	}

	public int height(Position<E> p){
		int h = 0; // base case if tree is empty
		for (Position<E> c : children(p))
			h = Math.max(h, 1 + height(c));
		return h;
	}

	// Iterator methods
	private class ElementIterator implements Iterator<E> {
		Iterator<Position<E>> posIterator = positions().iterator();
		public boolean hasNext() { return posIterator.hasNext(); }
		public E next() { return posIterator.next().getElement(); }
		public void remove() { posIterator.remove(); }
	}

	/** Adds positions of the subtree rooted at Position p to the snapshot */
	private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		snapshot.add(p); // Position added before recursion
		for(Position<E> c : children(p))
			preorderSubtree(c, snapshot);
	}

	/** Adds positions of the subtree rooted at Position p to the snapshot */
	private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		for(Position<E> c: children(p))
			postorderSubtree(c, snapshot);
		snapshot.add(p); // Position added after recursion
	}

	/** Returns an iterable list of positions in a tree, reported in preorder */
	public Iterable<Position<E>> preorder() {
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty())
			preorderSubtree(root(), snapshot);
		return snapshot;
	}

	/** Returns an iterable list of positions in a tree, reported in postorder */
	public Iterable<Position<E>> postorder() {
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty())
			postorderSubtree(root(), snapshot);
		return snapshot;
	}

	/** Returns an iterable collection of positions of the tree in breadth-first order */
	// public Iterable<Position<E>> breadthfirst() {
	// 	List<Position<E>> snapshot = new ArrayList<>();
	// 	if(!isEmpty()) {
	// 		Queue<Position<E>> fringe = new LinkedQueue<>();
	// 		fringe.enqueue(root());
	// 		while (!fringe.isEmpty()) {
	// 			Position<E> p = fringe.dequeue(); //Remove from front of queue
	// 			snapshot.add(p);
	// 			for(Position<E> c : children(p))
	// 				fringe.enqueue(c);
	// 		}
	// 	}
	// 	return snapshot;
	// }


	public Iterator<E> iterator() { return new ElementIterator(); }

}