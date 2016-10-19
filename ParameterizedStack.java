public class ParameterizedStack<T> {
	private int depth = 0;
	private static final int MAX_DEPTH = 100;
	private T[] stack;

	public ParameterizedStack() {
		this(MAX_DEPTH);
	}

	public ParameterizedStack(int size) {
		stack = (T[])new Object[size];
	}

	public boolean empty(){
		return depth == 0;
	}

	public void push(T obj){
		stack[depth++] = obj;
	}

	public T pop(T obj){
		--depth;
		T tmp = stack[depth];
		stack[depth] = null;
		return tmp;
	}

	public T peek(){
		if(depth == 0){
			return null;
		}
		return stack[depth - 1];
	}

	public boolean hasNext(){
		return depth > 0;
	}

	public boolean hasRoom() {
		return depth < stack.length;
	}

	public int getStackDepth() {
		return depth;
	}
}