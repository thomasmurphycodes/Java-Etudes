public class GenericEtude<T> {
	// This represents a stack whose type is instantiated at initialiation for the push and pop methods
	 private int depth = 0;
	 private static final int DEFAULT_INITIAL = 10;
	 private T[] stack;

	 public GenericEtude() {
	 	this(DEFAULT_INITIAL);
	 }

	 public GenericEtude(int size) {
	 	stack = (T[])new Object[size];
	 }

	 public boolean empty() {
	 	return depth == 0;
	 }

	 public void push(T obj) {
	 	stack[depth++] = obj;
	 }

	 public T pop() {
	 	--depth;
	 	T tmp = stack[depth];
	 	stack[depth] = null;
	 	return tmp;
	 }

	 public T peek() {
	 	if (depth == 0) {
	 		return null;
	 	}

	 	return stack[depth-1];
	 }

	 public boolean hasNext() {
	 	return depth > 0;
	 }

	 public boolean hasRoom() {
	 	return depth < stack.length;
	 }

	 public int getStackDepth() {
	 	return depth;
	 }
}