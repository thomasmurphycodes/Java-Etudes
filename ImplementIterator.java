import java.util.Iterator;
import java.util.NoSuchElementException;

public class ImplementIterator<T> implements Iterable<T>, Iterator<T>{

	/** Data for iteration */
	protected T[] data;
	protected int index = 0;

	public ImplementIterator(final T[] d) {
		setData(d);
	}

	public void setData(final T[] d) {
		this.data = d;
		index = 0;
	}

	@Override
	public Iterator<T> iterator() {
		index = 0;
		return this;
	}

	// Methods of Iterator 
	@Override
	public boolean hasNext() {
		return (index < data.length);
	}

	@Override
	public T next(){
		if(hasNext()){
			return data[index++]	;
		}
		throw new NoSuchElementException("We've run out of elements");
	}



}