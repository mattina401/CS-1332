import java.util.List;
import java.util.LinkedList;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import struct.Worth;

public class TATests {
	private BST<Integer> bst;
	private AVL<Integer> avl;
	private static final int TIMEOUT = 250;

	@Before
	public void setup() {
		bst = new BST<Integer>();
		avl = new AVL<Integer>();
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void bstAddTest1() {
		bst.add(1);
		bst.add(2);
		bst.add(3);
		bst.add(4);
		bst.add(5);
		bst.add(null);

		assertEquals(6, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void bstAddTest2() {
		bst.add(-1);
		bst.add(-2);
		bst.add(-3);
		bst.add(-4);
		bst.add(-5);
		bst.add(Integer.MIN_VALUE);

		assertTrue(bst.contains(Integer.MIN_VALUE));
		assertTrue(bst.contains(-3));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void bstAddTest3() {
		bst.add(50);
		bst.add(25);
		bst.add(75);
		bst.add(12);
		bst.add(87);
		bst.add(37);
		bst.add(63);
		bst.add(null);
		bst.add(Integer.MIN_VALUE);

		assertTrue(bst.contains(50));
		assertTrue(bst.contains(null));
		assertTrue(bst.contains(Integer.MIN_VALUE));
		assertTrue(bst.contains(37));
		assertTrue(bst.contains(63));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void bstAddTest4() {
		bst.add(null);
		bst.add(1);
		bst.add(0);
		bst.add(-5);
		bst.add(-4);
		bst.add(-3);
		bst.add(-2);

		assertEquals(7, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void bstRemoveTest1() {
		bst.add(1);
		bst.add(2);
		bst.add(3);
		bst.add(4);
		bst.add(5);
		bst.add(null);

		assertNull(bst.remove(null));
		assertEquals((Integer) 1, bst.remove(1));
		assertEquals((Integer) 2, bst.remove(2));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void bstRemoveTest2() {
		bst.add(-1);
		bst.add(-2);
		bst.add(-3);
		bst.add(-4);
		bst.add(-5);
		bst.add(Integer.MIN_VALUE);

		assertEquals((Integer) Integer.MIN_VALUE, bst.remove(Integer.MIN_VALUE));
		assertEquals((Integer) (-1), bst.remove(-1));
		assertEquals((Integer) (-2), bst.remove(-2));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void bstRemoveTest3() {
		bst.add(10);
		bst.add(-5);
		bst.add(15);
		bst.add(-6);
		bst.add(-4);
		bst.add(4);
		bst.add(16);
		bst.add(-17);
		bst.add(17);

		assertEquals((Integer) (-17), bst.remove(-17));
		assertEquals((Integer) (17), bst.remove(17));
		assertNull(bst.remove(Integer.MAX_VALUE));
		assertNull(bst.remove(Integer.MIN_VALUE));
		assertEquals((Integer) (-4), bst.remove(-4));
		assertEquals((Integer) (4), bst.remove(4));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void bstRemoveTest4() {
		bst.add(10);
		bst.add(50);
		bst.add(30);
		bst.add(40);
		bst.add(45);
		bst.add(43);
		bst.add(44);
		bst.add(42);

		assertEquals((Integer) 44, bst.remove(44));
		assertEquals((Integer) 42, bst.remove(42));
		assertEquals((Integer) 30, bst.remove(30));
		assertEquals((Integer) 10, bst.remove(10));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void bstAddAllTest() {
		List<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(null);
		list.add(Integer.MAX_VALUE);
		list.add(Integer.MIN_VALUE);
		list.add(-9);
		list.add(-10);

		bst.addAll(list);

		assertEquals(6, bst.size());
		assertTrue(bst.contains(1));
		assertTrue(bst.contains(null));
		assertTrue(bst.contains(Integer.MIN_VALUE));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void bstGetTest1() {
		bst.add(50);
		bst.add(25);
		bst.add(75);
		bst.add(null);
		bst.add(Integer.MIN_VALUE);
		bst.add(Integer.MAX_VALUE);

		assertEquals((Integer) Integer.MIN_VALUE, bst.get(Integer.MIN_VALUE));
		assertEquals((Integer) Integer.MAX_VALUE, bst.get(Integer.MAX_VALUE));
		assertNull(bst.get(10));
		assertNull(bst.get(null));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void bstGetTest2() {
		bst.add(10);
		bst.add(20);
		bst.add(30);
		bst.add(40);
		bst.add(50);
		bst.add(60);
		bst.add(null);

		assertNull(bst.remove(null));
		assertNull(bst.remove(99));
		assertEquals((Integer) 60, bst.remove(60));
		assertEquals((Integer) 40, bst.remove(40));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void bstPreOrder() {
		List<Integer> expected = new LinkedList<Integer>();

		bst.add(10);
		bst.add(5);
		bst.add(4);
		bst.add(6);
		bst.add(15);
		bst.add(14);
		bst.add(16);

		expected.add(10);
		expected.add(5);
		expected.add(4);
		expected.add(6);
		expected.add(15);
		expected.add(14);
		expected.add(16);

		assertEquals(expected, bst.preOrder());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void bstInOrder() {
		List<Integer> expected = new LinkedList<Integer>();

		bst.add(10);
		bst.add(5);
		bst.add(4);
		bst.add(6);
		bst.add(15);
		bst.add(14);
		bst.add(16);

		expected.add(4);
		expected.add(6);
		expected.add(5);
		expected.add(14);
		expected.add(16);
		expected.add(15);
		expected.add(10);

		assertEquals(expected, bst.postOrder());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void bstPostOrder() {
		List<Integer> expected = new LinkedList<Integer>();

		bst.add(10);
		bst.add(5);
		bst.add(4);
		bst.add(6);
		bst.add(15);
		bst.add(14);
		bst.add(16);

		expected.add(4);
		expected.add(5);
		expected.add(6);
		expected.add(10);
		expected.add(14);
		expected.add(15);
		expected.add(16);

		assertEquals(expected, bst.inOrder());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void bstReconstruct() {
		List<Integer> preOrderExpected = new LinkedList<Integer>();
		List<Integer> postOrderExpected = new LinkedList<Integer>();

		preOrderExpected.add(10);
		preOrderExpected.add(5);
		preOrderExpected.add(4);
		preOrderExpected.add(6);
		preOrderExpected.add(15);
		preOrderExpected.add(14);
		preOrderExpected.add(16);

		postOrderExpected.add(4);
		postOrderExpected.add(5);
		postOrderExpected.add(6);
		postOrderExpected.add(10);
		postOrderExpected.add(14);
		postOrderExpected.add(15);
		postOrderExpected.add(16);

		bst.clear();
		bst.reconstruct(preOrderExpected, postOrderExpected);

		assertTrue(bst.contains(4));
		assertTrue(bst.contains(5));
		assertTrue(bst.contains(6));
		assertTrue(bst.contains(10));
		assertEquals(7, bst.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void avlAddTest1() {
		// should get a left rotation
		avl.add(1);
		avl.add(2);
		avl.add(3);

		assertTrue(avl.contains(2));
		assertTrue(avl.contains(1));
		assertTrue(avl.contains(3));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void avlAddTest2() {
		// should perform a right rotation
		avl.add(1);
		avl.add(0);
		avl.add(-1);

		assertTrue(avl.contains(0));
		assertTrue(avl.contains(-1));
		assertTrue(avl.contains(1));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void avlAddTest3() {
		// should perform a right-left rotation
		avl.add(0);
		avl.add(5);
		avl.add(4);

		assertTrue(avl.contains(4));
		assertTrue(avl.contains(0));
		assertTrue(avl.contains(5));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void avlAddTest4() {
		// should perform a left-right rotation
		avl.add(0);
		avl.add(-5);
		avl.add(-4);

		assertTrue(avl.contains(-4));
		assertTrue(avl.contains(-5));
		assertTrue(avl.contains(0));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void avlAddTest5() {
		// should perform a left rotation on 10
		avl.add(0);
		avl.add(-10);
		avl.add(10);
		avl.add(20);
		avl.add(-5);
		avl.add(-15);
		avl.add(25);

		assertTrue(avl.contains(20));
		assertTrue(avl.contains(10));
		assertTrue(avl.contains(25));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void avlAddTest6() {
		// should perform a right rotation on -10
		avl.add(0);
		avl.add(-10);
		avl.add(10);
		avl.add(20);
		avl.add(15);
		avl.add(-15);
		avl.add(-25);

		assertTrue(avl.contains(-15));
		assertTrue(avl.contains(-25));
		assertTrue(avl.contains(-10));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void avlAddTest7() {
		// should perform a left-right rotation on 4
		avl.add(10);
		avl.add(13);
		avl.add(5);
		avl.add(17);
		avl.add(4);
		avl.add(6);
		avl.add(2);
		avl.add(3);

		assertTrue(avl.contains(5));
		assertTrue(avl.contains(4));
		assertTrue(avl.contains(2));
		assertTrue(avl.contains(3));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void avlAddTest8() {
		// should perform a right-left rotation on 6
		avl.add(10);
		avl.add(13);
		avl.add(5);
		avl.add(17);
		avl.add(4);
		avl.add(6);
		avl.add(8);
		avl.add(7);

		assertTrue(avl.contains(5));
		assertTrue(avl.contains(8));
		assertTrue(avl.contains(6));
		assertTrue(avl.contains(7));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void avlRemoveTest1() {
		// should perform a left rotation on 15
		avl.add(20);
		avl.add(15);
		avl.add(35);
		avl.add(6);
		avl.add(17);
		avl.add(24);
		avl.add(36);
		avl.add(5);
		avl.add(37);

		assertEquals((Integer) 24, avl.remove(24));
		assertTrue(avl.contains(36));
		assertTrue(avl.contains(35));
		assertTrue(avl.contains(37));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 4)
	public void avlRemoveTest2() {
		// should perform a right rotation on 15
		avl.add(20);
		avl.add(15);
		avl.add(35);
		avl.add(6);
		avl.add(17);
		avl.add(24);
		avl.add(36);
		avl.add(5);
		avl.add(37);

		assertEquals((Integer) (17), avl.remove(17));
		assertTrue(avl.contains(6));
		assertTrue(avl.contains(5));
		assertTrue(avl.contains(15));

	}

	@After
	public void teardown() {
		bst = null;
		avl = null;
	}
}