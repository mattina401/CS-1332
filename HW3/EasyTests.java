import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import struct.Worth;

public class EasyTests {

	@Test(timeout = 300)
	@Worth(points = 2)
	public void testAdd0() {
		LinkedList<Thing> l = linkedList(0);
		l.add(thing(0));
		Node<Thing> r = l.getHead();
		assertEquals(thing(0), advance(r, 0));
		assertEquals(thing(0), advance(r, 1));
		assertEquals(1, l.size());
	}
	
	@Test(timeout = 300)
	@Worth(points = 2)
	public void testAdd1() {
		LinkedList<Thing> l = linkedList(1);
		l.add(thing(1));
		Node<Thing> r = l.getHead();
		assertEquals(thing(0), advance(r, 0));
		assertEquals(thing(1), advance(r, 1));
		assertEquals(thing(0), advance(r, 2));
	}
	
	@Test(timeout = 300)
	@Worth(points = 3)
	public void testAdd2() {
		LinkedList<Thing> l = linkedList(2);
		l.add(thing(2));
		Node<Thing> r = l.getHead();
		assertEquals(thing(0), advance(r, 0));
		assertEquals(thing(1), advance(r, 1));
		assertEquals(thing(2), advance(r, 2));
		assertEquals(thing(0), advance(r, 3));
	}
	
	@Test(timeout = 300)
	@Worth(points = 3)
	public void testAdd3() {
		LinkedList<Thing> l = linkedList(5);
		l.add(thing(5));
		Node<Thing> r = l.getHead();
		assertEquals(thing(0), advance(r, 0));
		assertEquals(thing(1), advance(r, 1));
		assertEquals(thing(2), advance(r, 2));
		assertEquals(thing(3), advance(r, 3));
		assertEquals(thing(4), advance(r, 4));
		assertEquals(thing(5), advance(r, 5));
		assertEquals(thing(0), advance(r, 6));
	}
	
	@Test(timeout = 300)
	@Worth(points = 4)
	public void testAddAll() {
		ArrayList<Thing> al = new ArrayList<>();
		al.add(thing(5));
		al.add(thing(6));
		al.add(thing(7));
		LinkedList<Thing> l = linkedList(5);
		l.addAll(al);
		Node<Thing> r = l.getHead();
		assertEquals(thing(0), advance(r, 0));
		assertEquals(thing(1), advance(r, 1));
		assertEquals(thing(2), advance(r, 2));
		assertEquals(thing(3), advance(r, 3));
		assertEquals(thing(4), advance(r, 4));
		assertEquals(thing(5), advance(r, 5));
		assertEquals(thing(6), advance(r, 6));
		assertEquals(thing(7), advance(r, 7));
		assertEquals(thing(0), advance(r, 8));
	}

	@Test(timeout = 300)
	@Worth(points = 2)
	public void testClear() {
		LinkedList<Thing> l = linkedList(5);
		assertEquals(5, l.size());
		l.clear();
		assertEquals(0, l.size());
		assertEquals(null, l.getHead());
	}

	@Test(timeout = 300)
	@Worth(points = 3)
	public void testContains0() {
		LinkedList<Thing> l = linkedList(5);
		assertTrue(l.contains(thing(0)));
	}
	
	@Test(timeout = 300)
	@Worth(points = 3)
	public void testContains1() {
		LinkedList<Thing> l = linkedList(5);
		assertTrue(l.contains(thing(3)));
	}
	
	@Test(timeout = 300)
	@Worth(points = 4)
	public void testContains2() {
		LinkedList<Thing> l = linkedList(5);
		assertEquals(5, l.size());
		assertFalse(l.contains(thing(6)));
	}
	
	@Test(timeout = 300)
	@Worth(points = 3)
	public void testGet0() {
		LinkedList<Thing> l = linkedList(1);
		assertEquals(thing(0), l.get(0));
	}
	
	@Test(timeout = 300)
	@Worth(points = 3)
	public void testGet1() {
		LinkedList<Thing> l = linkedList(2);
		assertEquals(thing(0), l.get(0));
		assertEquals(thing(1), l.get(1));
	}
	
	@Test(timeout = 300)
	@Worth(points = 4)
	public void testGet2() {
		LinkedList<Thing> l = linkedList(6);
		assertEquals(thing(0), l.get(0));
		assertEquals(thing(1), l.get(1));
		assertEquals(thing(5), l.get(5));
	}

	@Test(timeout = 300)
	@Worth(points = 2)
	public void testIndexOf0() {
		LinkedList<Thing> l = linkedList(1);
		assertEquals(0, l.indexOf(thing(0)));
		assertEquals(1, l.size());
	}
	
	@Test(timeout = 300)
	@Worth(points = 2)
	public void testIndexOf1() {
		LinkedList<Thing> l = linkedList(2);
		assertEquals(0, l.indexOf(thing(0)));
		assertEquals(1, l.indexOf(thing(1)));
	}

	@Test(timeout = 300)
	@Worth(points = 3)
	public void testIndexOf2() {
		LinkedList<Thing> l = linkedList(6);
		assertEquals(0, l.indexOf(thing(0)));
		assertEquals(1, l.indexOf(thing(1)));
		assertEquals(5, l.indexOf(thing(5)));
	}

	@Test(timeout = 300)
	@Worth(points = 3)
	public void testIndexOf3() {
		LinkedList<Thing> l = linkedList(6);
		assertEquals(0, l.indexOf(thing(0)));
		assertEquals(1, l.indexOf(thing(1)));
		assertEquals(5, l.indexOf(thing(5)));
		assertEquals(-1, l.indexOf(thing(6)));
	}
	

	@Test(timeout = 300)
	@Worth(points = 2)
	public void testIsEmpty() {
		LinkedList<Thing> ll = linkedList(3);
		assertFalse(ll.isEmpty());
		ll = linkedList(0);
		assertTrue(ll.isEmpty());
	}

	@Test(timeout = 300)
	@Worth(points = 2)
	public void testRemoveInt0() {
		LinkedList<Thing> ll = linkedList(1);
		Node<Thing> r = ll.getHead();
		assertEquals(thing(0), advance(r, 0));
		assertEquals(thing(0), advance(r, 1));
		ll.remove(0);
		r = ll.getHead();
		assertEquals(null, r);
		assertTrue(ll.isEmpty());
	}
	
	@Test(timeout = 300)
	@Worth(points = 2)
	public void testRemoveInt1() {
		LinkedList<Thing> ll = linkedList(2);
		Node<Thing> r = ll.getHead();
		assertEquals(thing(0), advance(r, 0));
		assertEquals(thing(1), advance(r, 1));
		assertEquals(thing(0), advance(r, 2));
		ll.remove(0);
		r = ll.getHead();
		assertEquals(thing(1), advance(r, 0));
		assertEquals(thing(1), advance(r, 1));
	}
	
	@Test(timeout = 300)
	@Worth(points = 2)
	public void testRemoveInt2() {
		LinkedList<Thing> ll = linkedList(5);
		Node<Thing> r = ll.getHead();
		assertEquals(thing(0), advance(r, 0));
		assertEquals(thing(1), advance(r, 1));
		assertEquals(thing(2), advance(r, 2));
		assertEquals(thing(3), advance(r, 3));
		assertEquals(thing(4), advance(r, 4));
		assertEquals(thing(0), advance(r, 5));
		ll.remove(2);
		r = ll.getHead();
		assertEquals(thing(0), advance(r, 0));
		assertEquals(thing(1), advance(r, 1));
		assertEquals(thing(3), advance(r, 2));
		assertEquals(thing(4), advance(r, 3));
		assertEquals(thing(0), advance(r, 4));
		assertEquals(4, ll.size());
	}
	
	@Test(timeout = 300)
	@Worth(points = 2)
	public void testRemoveInt3() {
		LinkedList<Thing> ll = linkedList(5);
		Node<Thing> r = ll.getHead();
		assertEquals(thing(0), advance(r, 0));
		assertEquals(thing(1), advance(r, 1));
		assertEquals(thing(2), advance(r, 2));
		assertEquals(thing(3), advance(r, 3));
		assertEquals(thing(4), advance(r, 4));
		assertEquals(thing(0), advance(r, 5));
		ll.remove(0);
		r = ll.getHead();
		assertEquals(thing(1), advance(r, 0));
		assertEquals(thing(2), advance(r, 1));
		assertEquals(thing(3), advance(r, 2));
		assertEquals(thing(4), advance(r, 3));
		assertEquals(thing(1), advance(r, 4));
	}
	
	@Test(timeout = 300)
	@Worth(points = 2)
	public void testRemoveInt4() {
		LinkedList<Thing> ll = linkedList(5);
		Node<Thing> r = ll.getHead();
		assertEquals(thing(0), advance(r, 0));
		assertEquals(thing(1), advance(r, 1));
		assertEquals(thing(2), advance(r, 2));
		assertEquals(thing(3), advance(r, 3));
		assertEquals(thing(4), advance(r, 4));
		assertEquals(thing(0), advance(r, 5));
		ll.remove(4);
		r = ll.getHead();
		assertEquals(thing(0), advance(r, 0));
		assertEquals(thing(1), advance(r, 1));
		assertEquals(thing(2), advance(r, 2));
		assertEquals(thing(3), advance(r, 3));
		assertEquals(thing(0), advance(r, 4));
	}
	
	@Test(timeout = 300)
	@Worth(points = 2)
	public void testRemoveObject0() {
		LinkedList<Thing> l = linkedList(1);
		assertEquals(1, l.size());
		assertEquals(thing(0), l.remove(thing(0)));
		assertEquals(0, l.size());
	}
	
	@Test(timeout = 300)
	@Worth(points = 2)
	public void testRemoveObject1() {
		LinkedList<Thing> l = linkedList(3);
		assertEquals(thing(1), l.remove(thing(1)));
		assertEquals(2, l.size());
	}
	
	@Test(timeout = 300)
	@Worth(points = 2)
	public void testRemoveObject2() {
		LinkedList<Thing> l = linkedList(10);
		assertEquals(thing(9), l.remove(thing(9)));
		assertEquals(9, l.size());
	}
	
	@Test(timeout = 300)
	@Worth(points = 4)
	public void testRemoveObject3() {
		LinkedList<Thing> l = linkedList(10);
		Thing h = l.getHead().getData();
		Thing r = l.remove(thing(0));
		assertEquals(h.id, r.id);
		assertEquals(9, l.size());
	}
	
	@Test(timeout = 300)
	@Worth(points = 1)
	public void testSet0() {
		LinkedList<Thing> l = linkedList(1);
		l.set(0, thing(1));
		Node<Thing> r = l.getHead();
		assertEquals(thing(1), advance(r, 0));
		assertEquals(thing(1), advance(r, 1));
	}
	
	@Test(timeout = 300)
	@Worth(points = 1)
	public void testSet1() {
		LinkedList<Thing> l = linkedList(4);
		l.set(3, thing(10));
		Node<Thing> r = l.getHead();
		assertEquals(thing(0), advance(r, 0));
		assertEquals(thing(1), advance(r, 1));
		assertEquals(thing(2), advance(r, 2));
		assertEquals(thing(10), advance(r, 3));
	}
	
	@Test(timeout = 300)
	@Worth(points = 3)
	public void testSet2() {
		LinkedList<Thing> l = linkedList(4);
		l.set(2, thing(8));
		l.set(3, thing(9));
		l.set(3, thing(10));
		Node<Thing> r = l.getHead();
		assertEquals(thing(0), advance(r, 0));
		assertEquals(thing(1), advance(r, 1));
		assertEquals(thing(8), advance(r, 2));
		assertEquals(thing(10), advance(r, 3));
	}

	@Test(timeout = 300)
	@Worth(points = 2)
	public void testSize() {
		LinkedList<Thing> ll = linkedList(3);
		assertEquals(3, ll.size());
		ll.add(thing(4));
		assertEquals(4, ll.size());
	}

	/*
	 * Twist list things
	 */
	
	@Test(timeout = 300)
	@Worth(points = 5)
	public void testTwistAdd0() {
		TwistList<Thing> tl = twistList();
		tl.add(thing(0));
		tl.add(thing(1));
		tl.add(thing(2));
		tl.add(thing(3));
		tl.add(thing(4));
		tl.add(thing(5));
		Node<Thing> r = tl.getHead();
		assertEquals(thing(5), advance(r, 0));
		assertEquals(thing(3), advance(r, 1));
		assertEquals(thing(1), advance(r, 2));
		assertEquals(thing(0), advance(r, 3));
		assertEquals(thing(2), advance(r, 4));
		assertEquals(thing(4), advance(r, 5));
		assertEquals(thing(5), advance(r, 6));
	}
	
	@Test(timeout = 300)
	@Worth(points = 5)
	public void testTwistAdd1() {
		TwistList<Thing> tl = twistList();
		tl.add(thing(1));
		tl.add(thing(0));
		
		Node<Thing> r = tl.getHead();
		assertEquals(thing(0), advance(r, 0));
		assertEquals(thing(1), advance(r, 1));
		assertEquals(thing(0), advance(r, 2));
		
		tl.add(thing(4));
		r = tl.getHead();
		assertEquals(thing(4), advance(r, 0));
		assertEquals(thing(1), advance(r, 1));
		assertEquals(thing(0), advance(r, 2));
		assertEquals(thing(4), advance(r, 3));
		
		tl.add(thing(10));
		r = tl.getHead();
		assertEquals(thing(10), advance(r, 0));
		assertEquals(thing(0), advance(r, 1));
		assertEquals(thing(1), advance(r, 2));
		assertEquals(thing(4), advance(r, 3));
		assertEquals(thing(10), advance(r, 4));
		
		tl.add(thing(3));
		r = tl.getHead();
		assertEquals(thing(3), advance(r, 0));
		assertEquals(thing(4), advance(r, 1));
		assertEquals(thing(1), advance(r, 2));
		assertEquals(thing(0), advance(r, 3));
		assertEquals(thing(10), advance(r, 4));
		assertEquals(thing(3), advance(r, 5));
	}
	
	@Test(timeout = 300)
	@Worth(points = 5)
	public void testTwistSwing0() {
		TwistList<Thing> tl = twistList();
		tl.add(thing(1));
		tl.add(thing(2));
		tl.add(thing(0));
		tl.swing(1);
		Node<Thing> r = tl.getHead();
		assertEquals(thing(1), advance(r, 0));
		assertEquals(thing(0), advance(r, 1));
		assertEquals(thing(2), advance(r, 2));
		assertEquals(thing(1), advance(r, 3));
	}
	
	@Test(timeout = 300)
	@Worth(points = 5)
	public void testTwistReverse0() {
		TwistList<Thing> tl = twistList();
		tl.add(thing(1));
		tl.add(thing(2));
		tl.add(thing(0));
		tl.reverse(1, 2);
		Node<Thing> r = tl.getHead();
		assertEquals(thing(0), advance(r, 0));
		assertEquals(thing(2), advance(r, 1));
		assertEquals(thing(1), advance(r, 2));
		assertEquals(thing(0), advance(r, 3));
	}
	
	@Test(timeout = 300)
	@Worth(points = 5)
	public void testTwistFlipFlop0() {
		TwistList<Thing> tl = twistList();
		tl.add(thing(1));
		tl.add(thing(2));
		tl.add(thing(0));
		tl.flipFlop(1);
		Node<Thing> r = tl.getHead();
		assertEquals(thing(2), advance(r, 0));
		assertEquals(thing(0), advance(r, 1));
		assertEquals(thing(1), advance(r, 2));
		assertEquals(thing(2), advance(r, 3));
	}
	
	/*
	 * Some methods for testing
	 */
	
	
	/**
	 * constructs a linked list containing 0 to n-1 (inclusive)
	 */
	public LinkedList<Thing> linkedList(int n) {
		LinkedList<Thing> ll = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			ll.add(thing(i));
		}
		return ll;
	}
	
	/**
	 * constructs a twist list containing 0 to n-1 (inclusive)
	 */
	public TwistList<Thing> twistList() {
		return new TwistList<>();
	}
	
	/**
	 * Manually advances the node n, a nodes forward,
	 * then returns the data
	 */
	public Thing advance(Node<Thing> n, int a) {
		for (int i = 0; i < a; i++) {
			n = n.getNext();
		}
		return n.getData();
	}
	
	
	/**
	 * Prints out your Linked List
	 */
	public void print(LinkedList<?> l) {
		if (l == null) return;
		Node<?> n = l.getHead(), p = n;
		System.out.print("[");
		do {
			if (p == null) continue;
			System.out.print(p.getData() + ", ");
			p = p.getNext();
		} while(p != n && p != null);
		System.out.println("]");
	}
	
	/**
	 * Returns a thing representing the given integer
	 */
	public Thing thing(int i) {
		return new Thing(i);
	}
	
	/**
	 * A comparable class used for testing, gives each object
	 * created a unique identifier, that is not factored into
	 * equals or compareTo. Useful for testing purposes.
	 */
	public static class Thing implements Comparable<Thing> {
		private static int counter = 0;
		
		final int id = counter++;
		int i;
		
		public Thing(int i) {
			this.i = i;
		}
		
		@Override
		public int compareTo(Thing tht) {
			return Integer.compare(i, tht.i);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Thing) {
				return ((Thing) obj).i == i;
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return i;
		}
		
		@Override
		public String toString() {
			return i + " (" + id + ")";
		}
	}
}
