import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A structure that behaves like a queue but implements the Structure interface
 * Feel free to build on existing java implementations, 
 * no need to build from scratch.
 *
 * @param <T>
 */
public class TAStructureQueue<T> implements Structure<T> {

	LinkedList<T> q= new LinkedList<T>();
	private List<T> popped= new ArrayList<T>();
	
	@Override
	public boolean isEmpty() {
		return q.isEmpty();
	}

	@Override
	public void clear() {
		q= new LinkedList<T>();
	}

	@Override
	public void add(T node) {
		q.addFirst(node);
		
	}

	@Override
	public T remove() {
		T temp = q.removeLast();
		popped.add(temp);
		return temp;
	}

	public List<T> getPopped() {
		
		return popped;
	}
	
	
}
