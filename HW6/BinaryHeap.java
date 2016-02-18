import java.util.Arrays;
import java.util.Comparator;

/**
 * name : Jongyeon Kim(jkim989)
 * GTID# : 903018469
 * 
 * This is an implementation of a heap that is backed by an array.
 * 
 * This implementation will accept a comparator object that can be used to
 * define an ordering of the items contained in this heap, other than the
 * objects' default compareTo method (if they are comparable). This is useful if
 * you wanted to sort strings by their length rather than their lexicographic
 * ordering. That's just one example.
 * 
 * Null should be treated as positive infinity if no comparator is provided. If
 * a comparator is provided, you should let it handle nulls, which means it
 * could possibly throw a NullPointerException, which in this case would be
 * fine.
 * 
 * If a comparator is provided that should always be what you use to compare
 * objects. If no comparator is provided you may assume the objects are
 * Comparable and cast them to type Comparable<T> for comparisons. If they
 * happen to not be Comparable you do not need to handle anything, and you can
 * just let your cast throw a ClassCastException.
 * 
 * This is a minimum heap, so the smallest item should always be at the root.
 * 
 * @param <T>
 *            The type of objects in this heap
 */
public class BinaryHeap<T> implements Heap<T> {

	/**
	 * The comparator that should be used to order the elements in this heap
	 */
	private Comparator<T> comp;

	/**
	 * The backing array of this heap
	 */
	private T[] data;

	/**
	 * The number of elements that have been added to this heap, this is NOT the
	 * same as data.length
	 */
	private int size;

	/**
	 * Default constructor, this should initialize data to a default size (11 is
	 * normally a good choice)
	 * 
	 * This assumes that the generic objects are Comparable, you will need to
	 * cast them when comparing since there are no bounds on the generic
	 * parameter
	 */
	@SuppressWarnings("unchecked")
	public BinaryHeap() {
		// TODO Implement this.
		
		data = (T[]) new Object[11];
	}

	/**
	 * Constructor that accepts a comparator to use with this heap. Also
	 * initializes data to a default size.
	 * 
	 * When a comparator is provided it should be preferred over the objects'
	 * compareTo method
	 * 
	 * If the comparator given is null you should attempt to cast the objects to
	 * Comparable as if a comparator were not given
	 * 
	 * @param comp
	 */
	@SuppressWarnings("unchecked")
	public BinaryHeap(Comparator<T> comp) {
		// TODO Implement this.
		
		data = (T[]) new Object[11];
		this.comp = comp;
	}

	@Override
	public void add(T item) {
		// TODO Implement this.
		
		// if there is not space for adding
		if (size == data.length - 1) {
			
			// make more space(original * 2 +1) and copy original elements to new array
			this.data = (T[]) Arrays.copyOf(data, (data.length * 2) + 1);
		}
		
		int next = size +1;
		data[next] = item;
		size++;
		
		// after add, do heapify
		while (next > 1) {
			if (compare(data[next], data[next/2]) < 0) {
				
				// swap
				T temp = data[next];
				data[next] = data[next/2];
				data[next/2] = temp;
				
				next = next/2;
			} else {
				break;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private int compare(T obj1, T obj2) {
		
		// when comp is not null
		if (comp != null) {
			return comp.compare(obj1, obj2);
		}
		
		//  when comp is null
		else {
			
			// when object1 and object2 are null
			if ((obj1 == null) && (obj2 == null)) {
				return 0;
			}
			
			// when only objext1 is null
			else if (obj1 == null) {
				return 1;
			} 
			
			// when only object2 is null
			else if (obj2 == null) {
				return -1;
			} 
			
			// when both object1 and object2 are not null
			else {
				
				// use normal compareTo
				return ((Comparable<T>)obj1).compareTo(obj2);
			}
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Implement this.
		
		return size == 0;
	}

	@Override
	public T peek() {
		// TODO Implement this.
		
		// when there is no element
		if (isEmpty()) {
			return null;
		}
		
		// if there is more than one  elements, pick first element 
		return data[1];
	}

	@Override
	public T remove() {
		// TODO Implement this.
		
		T min = data[1];
		
		// swap
		T temp = data[1];
		data[1] = data[size];
		data[size] = temp;
		data[size] = null;
		size--;	
		removeAfterHeapify(1);
		
		return min;
	}

	private void removeAfterHeapify(int i) {
		
		int mostSmall = i;
		
		// if left is smaller than size and left value is smaller than mostSmall
		if((i*2 < size) && (compare(data[i*2 ], data[mostSmall]) < 0)) {
			mostSmall = i*2 ;
		}
		
		// if right is smaller than size and right value is smaller than mostSmall
		if((i*2 + 1 < size) && (compare(data[i*2 + 1], data[mostSmall]) < 0)) {
			mostSmall = i*2 + 1;
		}
		
		if(mostSmall != i) {
			
			// swap
			T temp = data[mostSmall];
			data[mostSmall] = data[i];
			data[i] = temp;
			
			removeAfterHeapify(mostSmall);
		}
	}	
	
	@Override
	public int size() {
		// TODO Implement this.
		
		// return size
		return size;
	}
}