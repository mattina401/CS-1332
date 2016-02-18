import java.util.Collection;

/**
 * This is a circular, singly linked list.
 * @author Jongyeon Kim(jkim989)
 * GTID# 903018469
 */
public class LinkedList<E> implements List<E> {

	protected Node<E> head;
	protected int size = 0;
	

	@Override
	public void add(E e) {
		// TODO Auto-generated method stub

		Node<E> newNode = new Node<E>(e);
		
		// when nothing in the list
		if (head == null) {
			
			// make newNode to head
			head = newNode;
			// make direction newNode to head because this is circular list
			newNode.setNext(head);
			size++;
			return;
		} else {
			Node<E> current = head;
			//loop before get head. previous node of head is end of list because this is circular list
			while (current.getNext() != head) {
				current = current.getNext();
			}
			newNode.setNext(current.getNext());
			current.setNext(newNode);
			size++;

		}

	}

	/*
	 * You will want to look at Iterator, Iterable, and 
	 * how to use a for-each loop for this method.
	 */
	@Override
	public void addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		
		for (E i : c) {
			add(i);
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
		// remove all element
		int i = 0;
		while (i < size) {
			head = null;
			i++;
		}
		size = 0;

		}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		
		// list has object o
		if (indexOf(o) != -1) {
			return true;
		
		// list doesn't have object o	
		} else {
			return false;
		}

	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		
		if (index >= size || index <0) {
			throw new IndexOutOfBoundsException("index is out of bound");
		} else {
		Node<E> current = head;
		int i = 0;
		while (i < index) {
			current = current.getNext();
			i++;
		}
		return current.getData();
		}
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		
		boolean found = false;
		int index = 0;
		
		Node<E> current = head;
		while (current.getNext() != head) {
			if ((current.getData() == null && o == null) || (current.getData().equals(o))) {
				found = true;
				
				// stop loop here if current.getData() is null or object o is null
				// when current.getData() is same with object o
				break;
			}
			current = current.getNext();
			index++;
		}
		if (((current.getData() == null && o == null) || (current.getData().equals(o))) || found) {
			return index;
		} else {
			return -1;
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		//when list is not empty
	    if ( size != 0 ) {
	        return false;
	    } else {
	        return true;
	    }
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		
		if (index >= size || index <0) {
			throw new IndexOutOfBoundsException("index is out of bound");
		}
		
		Node<E> current = head;
		int i = 0;
		while (i < index - 1) {
			current = current.getNext();
			i++;
		}

		Node<E> del = current.getNext();
		current.setNext(del.getNext());
		size--;
		
		return del.getData();
		
	}

	@Override
	public E remove(Object o) {
		// TODO Auto-generated method stub
		
		if (indexOf(o) == -1) {
			return null;
		} else if (indexOf(o) >= size || indexOf(o) < 0) {
			throw new IndexOutOfBoundsException("index is out of bound");
		} else {
			return remove(indexOf(o));
		} 
	}

	@Override
	public E set(int index, E e) {
		// TODO Auto-generated method stub
			
		if (index >= size || index <0) {
			throw new IndexOutOfBoundsException("index is out of bound");
		} else {
			
		Node<E> current = head;
		int i = 0;
		while (i < index) {
			current = current.getNext();
			i++;
		}
			E data = current.getData();
			current.setData(e);
		// return data
		return data;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		
		// return size
		return size;
	}

	/*
	 * The following methods are for grading. Do not modify them, and do not use them.
	 */

	public void setSize(int size) {
		this.size = size;
	}

	public Node<E> getHead() {
		return head;
	}

	public void setHead(Node<E> head) {
		this.head = head;
	}
}