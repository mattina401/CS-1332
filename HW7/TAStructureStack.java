import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * A structure that behaves like a stack but implements the Structure interface
 * Feel free to build on existing java implementations, 
 * no need to build from scratch.
 *
 * @param <T>
 */
public class TAStructureStack<T> implements Structure<T> {

	public Stack<T> s= new Stack<T>();
	ArrayList<T> popped= new ArrayList<T>();
	
	@Override
	public boolean isEmpty() {
		return s.empty();
	}

	@Override
	public void clear() {
		s=new Stack<T>();
		
	}

	@Override
	public void add(T node) {
		s.push(node);
		
	}

	@Override
	public T remove() {
		T temp=s.pop();
		popped.add(temp);
		return temp;
	}
	
	public List<T> getPopped(){
		return popped;
	}
	
	
}
