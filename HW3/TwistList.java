
/**
 * This class extends LinkedList, but there's a twist. Read the documentation
 * for each method. Note that the data here is Comparable.
 * 
 * @author Jongyeon Kim(jkim989)
 * GTID# 903018469
 * 
 */
public class TwistList<E extends Comparable<E>> extends LinkedList<E> {

	/**
	 * If the data is less than the head, add to the front of the list.
	 * Otherwise, find the first index where one of the two adjacent nodes
	 * are greater than the data, and the other is less than the data. If
	 * such an index does not exist, add the data to the end of the list.
	 * 
	 * When the above process is complete call swing with the index of the
	 * newly added data. 
	 */
	@Override
	public void add(E e) {
		// TODO Auto-generated method stub
		
		// when list is empty
		if (head == null) {
			super.add(e);
			return;
		}
		
		int added = 0;
		Node<E> addNode = new Node<E>(e);
		Node<E> current = head;

		while (true) {
			if (added == size) {
				
				// if added is same with size, then stop loop here
				break;
			}
			
			// compare between current.getData() and e
			if ((current.getData().compareTo(e) < 0) && (current.getNext().getData().compareTo(e) > 0)) { 
				break;
			}
			
			// compare between current.getData() and e
			if ((current.getData().compareTo(e) > 0) && (current == head)) {
				break;

			} else {
				current = current.getNext();
				added++;
			}
		}
		if (added != 0) {
			current = head;
			
			int i = 0;
			while (i < added - 1) {
				current = current.getNext();
				i++;
			}

			addNode.setNext(current.getNext());
			current.setNext(addNode);
		}
		
		if (added == 0) {
			addNode.setNext(head);
			current = head;
			int i =0;
			while (i < size - 1) {
				current = current.getNext();
				i++;
			}
			current.setNext(addNode);
			head = addNode;
		} 
		size++;
		swing(added);
	}

	
	/**
	 * Reverses the order of the list between the start and stop index inclusively.
	 * 
	 * Assume the indices given are valid and start <= stop
	 * 
	 * @param start The beginning index of the sub section to be reversed
	 * @param stop The end index (inclusive) of the sub section to be reversed
	 */
	public void reverse(int start, int stop) {
		// TODO Auto-generated method stub
		
		int i;
		i = 0;
		
		if (start == stop) {
			return;
		}
		
		boolean x;
		x = false;
		Node<E>	right = head;
		Node<E> left = head;
		Node<E>	end = head;
		
		// left point
		if (start == 0) {
			while (i < size - 1) {
				left = left.getNext();
				i++;
			}
			x = true;
		} else if (start != 0)  
			
			i = 0;
			while (i < start - 1) {
				left = left.getNext();
				i++;
			}
			
			// end
			i = 0;
			while (i < stop) {
				end = end.getNext();
				i++;
			}
			
			// right point
			i = 0;
			while (i < stop - 1) {
				right = right.getNext();
				i++;
			}
		
		// reverse from start to end of list	
		if ((start == 0) && (stop == size - 1)) {
			head = end;
			reverse(start + 1, stop);
			
		} else if ((start != 0) || (stop != size - 1)) {
			right.setNext(end.getNext());
			end.setNext(left.getNext());
			
			if (x) {
				head = end;
			}
			left.setNext(end);
			reverse(start + 1, stop);
			
		
		}
		
	}
	
	/**
	 * This method will take in an index and move everything after 
	 * that index to the front of the list
	 * 
	 * Assume the index given is valid
	 * 
	 * @param index The index at which to cut the list
	 */
	public void flipFlop(int index) {
		// TODO Auto-generated method stub		

		
		Node<E> current = head;
		int i = 0;
		while (i < index) {
			current = current.getNext();
			i++;
		}
		
		// can flipFlop by just changing head because this is circular list
		head = current.getNext();
	}
	
	/**
	 * This method will reverse the order of the first half of the list up to 
	 * the index argument (inclusive), and also reverse the second half of the 
	 * list from index + 1 to the end of the list
	 * 
	 * Assume the index given is valid, however the second half may be empty
	 * 
	 * @param index The index to swing around
	 */
	public void swing(int index) {
		// TODO Auto-generated method stub
		
		if (index <= size - 2) {
			reverse(index + 1, size - 1);
		}
		
		if (index < 0) {
			throw new IndexOutOfBoundsException("index is out of bound");
		}
		reverse(0, index);
		

	}
}