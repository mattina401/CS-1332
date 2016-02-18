import java.util.LinkedList;

/**
 * 
 * 
 * name : Jongyeon Kim(jkim989)
 * GTID# : 903018469
 * A structure that behaves like a queue but implements the Structure interface
 * Feel free to build on existing java implementations, no need to build from
 * scratch. (you can import and use something like LinkedList for example)
 * 
 * @param <T>
 */
public class StructureQueue<T> implements Structure<T> {
	
	LinkedList<T> list = new LinkedList<T>();

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		return list.isEmpty();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
		list.clear();

	}

	@Override
	public void add(T node) {
		// TODO Auto-generated method stub
		
		list.add(node);

	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		
		return list.remove();
	}

}
