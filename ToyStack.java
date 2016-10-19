public class ToyStack {
	private int depth = 0;
	protected int MAX_DEPTH = 10;

	protected int[] stack = new int[MAX_DEPTH];

	protected void push(int n) {
		stack[depth++] = n;
	}

	protected int pop(){
		return stack[depth--];
	}

	protected int peek(){
		return stack[depth - 1];
	}
}