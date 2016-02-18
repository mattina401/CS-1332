import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import struct.Worth;


public class SkipListMapTest {
	
	IListMap<Integer, Integer> listmap;
	CoinFlipper2 coinflipper;
	int seed;
	int n = 100;
	static final int TIMEOUT = 150;
	static final int LONGTIMEOUT = 750;
	
	@Before
	public void setup(){
		listmap = createSkipList(1332);
	}

	@Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
	@Worth(points = 1)
	public void containsKeyException(){
		listmap.containsKey(null);
	}
	
	@Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
	@Worth(points = 1)
	public void containsValueException(){
		listmap.containsValue(null);
	}
	
	@Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
	@Worth(points = 1)
	public void putKeyException(){
		listmap.put(null, 2);
	}
	
	@Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
	@Worth(points = 1)
	public void putValueException(){
		listmap.put(2, null);
	}
	
	@Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
	@Worth(points = 1)
	public void getException(){
		listmap.get(null);
	}
	
	@Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
	@Worth(points = 1)
	public void removeException(){
		listmap.remove(null);
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void emptySizeTest() {
		assertEquals(0, listmap.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void emptySetTest() {
		assertTrue(listmap.keySet().isEmpty());
		assertTrue(listmap.values().isEmpty());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void emptyContainsTest() {
		assertTrue(listmap.keySet().isEmpty());
		assertTrue(listmap.values().isEmpty());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void emptyIndexTest() {
		assertEquals(null, listmap.firstKey());
		assertEquals(null, listmap.lastKey());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void emptyGetTest() {
		assertEquals(null, listmap.get(3));
	}	

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void emptyRemoveTest() {
		assertEquals(null, listmap.remove(3));
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void emptyAllTest() {
		assertEquals(0, listmap.size());
		assertEquals(null, listmap.firstKey());
		assertEquals(null, listmap.lastKey());
		assertEquals(null, listmap.remove(3));
		assertTrue(listmap.keySet().isEmpty());
		assertTrue(listmap.values().isEmpty());
		assertEquals(null, listmap.get(3));
		assertFalse(listmap.containsKey(3));
		assertFalse(listmap.containsValue(4));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void clearSizeTest() {
		clearCase();
		assertEquals(0, listmap.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void clearRemoveTest() {
		clearCase();
		assertEquals(null, listmap.remove(3));
	}	
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void clearIndexTest() {
		clearCase();
		assertEquals(null, listmap.firstKey());
		assertEquals(null, listmap.lastKey());
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void clearSetTest() {
		clearCase();
		assertTrue(listmap.keySet().isEmpty());
		assertTrue(listmap.values().isEmpty());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void clearContainsTest() {
		clearCase();
		assertFalse(listmap.containsKey(3));
		assertFalse(listmap.containsValue(4));		
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void clearAllTest() {
		clearCase();
		assertEquals(0, listmap.size());
		assertEquals(null, listmap.remove(3));
		assertEquals(null, listmap.firstKey());
		assertEquals(null, listmap.lastKey());
		assertTrue(listmap.keySet().isEmpty());
		assertTrue(listmap.values().isEmpty());
		assertFalse(listmap.containsKey(3));
		assertFalse(listmap.containsValue(4));		
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void oneItemIndexTest(){
		oneItemCase();
		assertEquals((Integer) 3, listmap.firstKey());
		assertEquals((Integer) 3, listmap.lastKey());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void oneItemContainsTest(){
		oneItemCase();
		assertFalse(listmap.containsValue(3));
		assertTrue(listmap.containsValue(4));
		assertTrue(listmap.containsKey(3));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void oneItemGetTest(){
		oneItemCase();
		assertEquals((Integer) 4, listmap.get(3));
		assertEquals(null, listmap.get(4));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void oneItemSetTest(){
		oneItemCase();
		assertEquals(1, listmap.keySet().size());
		assertTrue(listmap.keySet().contains(3));
		assertEquals(1, listmap.values().size());
		assertTrue(listmap.values().contains(4));
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void oneItemSizeTest(){
		oneItemCase();
		assertEquals(1, listmap.size());
	}
	
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void oneItemAllTest(){
		oneItemCase();

		assertEquals(1, listmap.size());

		assertEquals((Integer) 3, listmap.firstKey());
		assertEquals((Integer) 3, listmap.lastKey());
		
		assertFalse(listmap.containsValue(3));
		assertTrue(listmap.containsValue(4));
		assertTrue(listmap.containsKey(3));
		
		assertEquals((Integer) 4, listmap.get(3));
		assertEquals(null, listmap.get(4));
		
		assertEquals(1, listmap.keySet().size());
		assertTrue(listmap.keySet().contains(3));
		assertEquals(1, listmap.values().size());
		assertTrue(listmap.values().contains(4));
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void twoItemSizeTest(){
		twoItemCase();
		assertEquals(2, listmap.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void twoItemIndexTest(){
		twoItemCase();
		assertEquals((Integer) 2, listmap.firstKey());
		assertEquals((Integer) 3, listmap.lastKey());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void twoItemContainsTest(){
		twoItemCase();
		assertFalse(listmap.containsValue(2));
		assertTrue(listmap.containsValue(4));
		assertTrue(listmap.containsValue(5));
		assertTrue(listmap.containsKey(3));
		assertTrue(listmap.containsKey(2));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void twoItemGetTest(){
		twoItemCase();
		assertEquals((Integer) 4, listmap.get(3));
		assertEquals((Integer) 5, listmap.get(2));
		assertEquals(null, listmap.get(4));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void twoItemSetTest(){
		twoItemCase();
		assertEquals(2, listmap.keySet().size());
		assertTrue(listmap.keySet().contains(3));
		assertTrue(listmap.keySet().contains(2));
		assertEquals(2, listmap.values().size());
		assertTrue(listmap.values().contains(4));
		assertTrue(listmap.values().contains(5));		
	}

	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void twoItemAllTest(){
		twoItemCase();

		assertEquals(2, listmap.size());
		
		assertEquals((Integer) 2, listmap.firstKey());
		assertEquals((Integer) 3, listmap.lastKey());
		
		assertFalse(listmap.containsValue(2));
		assertTrue(listmap.containsValue(4));
		assertTrue(listmap.containsValue(5));
		assertTrue(listmap.containsKey(3));
		assertTrue(listmap.containsKey(2));
		
		assertEquals((Integer) 4, listmap.get(3));
		assertEquals((Integer) 5, listmap.get(2));
		assertEquals(null, listmap.get(4));
		
		assertEquals(2, listmap.keySet().size());
		assertTrue(listmap.keySet().contains(3));
		assertTrue(listmap.keySet().contains(2));
		assertEquals(2, listmap.values().size());
		assertTrue(listmap.values().contains(4));
		assertTrue(listmap.values().contains(5));		
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void twoItemDuplicateSizeTest(){
		twoItemDuplicateCase();
		assertEquals(2, listmap.size());
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void twoItemDuplicateIndexTest(){
		twoItemDuplicateCase();
		assertEquals((Integer) 2, listmap.firstKey());
		assertEquals((Integer) 3, listmap.lastKey());
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void twoItemDuplicateContainsTest(){
		twoItemDuplicateCase();
		assertFalse(listmap.containsValue(2));
		assertTrue(listmap.containsValue(4));
		assertTrue(listmap.containsKey(3));
		assertTrue(listmap.containsKey(2));
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void twoItemDuplicateGetTest(){
		twoItemDuplicateCase();
		assertEquals((Integer) 4, listmap.get(3));
		assertEquals((Integer) 4, listmap.get(2));
		assertEquals(null, listmap.get(4));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void twoItemDuplicateSetTest(){
		twoItemDuplicateCase();	
		assertEquals(2, listmap.keySet().size());
		assertTrue(listmap.keySet().contains(3));
		assertTrue(listmap.keySet().contains(2));
		assertEquals(2, listmap.values().size());
		assertTrue(listmap.values().contains(4));
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void twoItemDuplicateAllTest(){
		twoItemDuplicateCase();
		
		assertEquals(2, listmap.size());
		
		assertEquals((Integer) 2, listmap.firstKey());
		assertEquals((Integer) 3, listmap.lastKey());
		
		assertFalse(listmap.containsValue(2));
		assertTrue(listmap.containsValue(4));
		assertTrue(listmap.containsKey(3));
		assertTrue(listmap.containsKey(2));
		
		assertEquals((Integer) 4, listmap.get(3));
		assertEquals((Integer) 4, listmap.get(2));
		assertEquals(null, listmap.get(4));
		
		assertEquals(2, listmap.keySet().size());
		assertTrue(listmap.keySet().contains(3));
		assertTrue(listmap.keySet().contains(2));
		assertEquals(2, listmap.values().size());
		assertTrue(listmap.values().contains(4));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void threeItemSizeTest(){
		threeItemCase();
		assertEquals(3, listmap.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void threeItemIndexTest(){
		threeItemCase();
		assertEquals((Integer) 1, listmap.firstKey());
		assertEquals((Integer) 7, listmap.lastKey());		
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void threeItemContainsTest(){
		threeItemCase();		
		assertFalse(listmap.containsValue(3));
		assertTrue(listmap.containsValue(4));
		assertTrue(listmap.containsValue(6));
		assertTrue(listmap.containsValue(2));
		assertTrue(listmap.containsKey(3));
		assertTrue(listmap.containsKey(1));
		assertTrue(listmap.containsKey(7));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void threeItemGetTest(){
		threeItemCase();		
		assertEquals((Integer) 4, listmap.get(3));
		assertEquals((Integer) 2, listmap.get(1));
		assertEquals((Integer) 6, listmap.get(7));
		assertEquals(null, listmap.get(4));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void threeItemSetTest(){
		threeItemCase();
		assertEquals(3, listmap.keySet().size());
		assertTrue(listmap.keySet().contains(3));
		assertTrue(listmap.keySet().contains(1));
		assertTrue(listmap.keySet().contains(7));
		assertEquals(3, listmap.values().size());
		assertTrue(listmap.values().contains(4));
		assertTrue(listmap.values().contains(2));
		assertTrue(listmap.values().contains(6));
	}

	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void threeItemAllTest(){
		threeItemCase();

		assertEquals(3, listmap.size());
		
		assertEquals((Integer) 1, listmap.firstKey());
		assertEquals((Integer) 7, listmap.lastKey());
		
		assertFalse(listmap.containsValue(3));
		assertTrue(listmap.containsValue(4));
		assertTrue(listmap.containsValue(6));
		assertTrue(listmap.containsValue(2));
		assertTrue(listmap.containsKey(3));
		assertTrue(listmap.containsKey(1));
		assertTrue(listmap.containsKey(7));
		
		assertEquals((Integer) 4, listmap.get(3));
		assertEquals((Integer) 2, listmap.get(1));
		assertEquals((Integer) 6, listmap.get(7));
		assertEquals(null, listmap.get(4));
		
		assertEquals(3, listmap.keySet().size());
		assertTrue(listmap.keySet().contains(3));
		assertTrue(listmap.keySet().contains(1));
		assertTrue(listmap.keySet().contains(7));
		assertEquals(3, listmap.values().size());
		assertTrue(listmap.values().contains(4));
		assertTrue(listmap.values().contains(2));
		assertTrue(listmap.values().contains(6));
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void threeItemReplaceSizeTest(){
		threeItemReplaceCase();
		assertEquals(3, listmap.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void threeItemReplaceIndexTest(){
		threeItemReplaceCase();
		assertEquals((Integer) 1, listmap.firstKey());
		assertEquals((Integer) 7, listmap.lastKey());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void threeItemReplaceContainsTest(){
		threeItemReplaceCase();
		assertFalse(listmap.containsValue(3));
		assertTrue(listmap.containsValue(9));
		assertTrue(listmap.containsValue(6));
		assertTrue(listmap.containsValue(2));
		assertTrue(listmap.containsKey(3));
		assertTrue(listmap.containsKey(1));
		assertTrue(listmap.containsKey(7));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void threeItemReplaceGetTest(){
		threeItemReplaceCase();
		assertEquals((Integer) 9, listmap.get(3));
		assertEquals((Integer) 2, listmap.get(1));
		assertEquals((Integer) 6, listmap.get(7));
		assertEquals(null, listmap.get(4));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void threeItemReplaceSetTest(){
		threeItemReplaceCase();		
		assertEquals(3, listmap.keySet().size());
		assertTrue(listmap.keySet().contains(3));
		assertTrue(listmap.keySet().contains(1));
		assertTrue(listmap.keySet().contains(7));
		assertEquals(3, listmap.values().size());
		assertTrue(listmap.values().contains(9));
		assertTrue(listmap.values().contains(2));
		assertTrue(listmap.values().contains(6));
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void threeItemReplaceAllTest(){
		threeItemReplaceCase();

		assertEquals(3, listmap.size());
		
		assertEquals((Integer) 1, listmap.firstKey());
		assertEquals((Integer) 7, listmap.lastKey());
		
		assertFalse(listmap.containsValue(3));
		assertTrue(listmap.containsValue(9));
		assertTrue(listmap.containsValue(6));
		assertTrue(listmap.containsValue(2));
		assertTrue(listmap.containsKey(3));
		assertTrue(listmap.containsKey(1));
		assertTrue(listmap.containsKey(7));
		
		assertEquals((Integer) 9, listmap.get(3));
		assertEquals((Integer) 2, listmap.get(1));
		assertEquals((Integer) 6, listmap.get(7));
		assertEquals(null, listmap.get(4));
		
		assertEquals(3, listmap.keySet().size());
		assertTrue(listmap.keySet().contains(3));
		assertTrue(listmap.keySet().contains(1));
		assertTrue(listmap.keySet().contains(7));
		assertEquals(3, listmap.values().size());
		assertTrue(listmap.values().contains(9));
		assertTrue(listmap.values().contains(2));
		assertTrue(listmap.values().contains(6));
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeOneSizeTest() {
		removeOneCase();
		assertEquals(0, listmap.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeOneRemoveTest() {
		removeOneCase();
		assertEquals(null, listmap.remove(3));
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeOneIndexTest() {
		removeOneCase();
		assertEquals(null, listmap.firstKey());
		assertEquals(null, listmap.lastKey());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeOneSetTest() {
		removeOneCase();
		assertFalse(listmap.containsKey(3));
		assertFalse(listmap.containsValue(4));		
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeOneContainsTest() {
		removeOneCase();
		assertFalse(listmap.containsKey(3));
		assertFalse(listmap.containsValue(4));		
	}

	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeOneAllTest() {
		removeOneCase();
		
		assertEquals(0, listmap.size());
		
		assertEquals(null, listmap.remove(3));
		
		assertEquals(null, listmap.firstKey());
		assertEquals(null, listmap.lastKey());
		
		assertTrue(listmap.keySet().isEmpty());
		assertTrue(listmap.values().isEmpty());
		
		assertFalse(listmap.containsKey(3));
		assertFalse(listmap.containsValue(4));		
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeToThreeItemSizeTest(){
		removeToThreeItemCase();
		assertEquals(3, listmap.size());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeToThreeItemIndexTest(){
		removeToThreeItemCase();
		assertEquals((Integer) 1, listmap.firstKey());
		assertEquals((Integer) 7, listmap.lastKey());
	}

	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeToThreeItemContainsTest(){
		removeToThreeItemCase();
		assertFalse(listmap.containsValue(3));
		assertTrue(listmap.containsValue(4));
		assertTrue(listmap.containsValue(6));
		assertTrue(listmap.containsValue(2));
		assertTrue(listmap.containsKey(3));
		assertTrue(listmap.containsKey(1));
		assertTrue(listmap.containsKey(7));
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeToThreeItemGetTest(){
		removeToThreeItemCase();
		assertEquals((Integer) 4, listmap.get(3));
		assertEquals((Integer) 2, listmap.get(1));
		assertEquals((Integer) 6, listmap.get(7));
		assertEquals(null, listmap.get(4));
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeToThreeItemSetTest(){
		removeToThreeItemCase();	
		assertEquals(3, listmap.keySet().size());
		assertTrue(listmap.keySet().contains(3));
		assertTrue(listmap.keySet().contains(1));
		assertTrue(listmap.keySet().contains(7));
		assertEquals(3, listmap.values().size());
		assertTrue(listmap.values().contains(4));
		assertTrue(listmap.values().contains(2));
		assertTrue(listmap.values().contains(6));
	}
	
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 1)
	public void removeToThreeItemAllTest(){
		removeToThreeItemCase();
		
		assertEquals(3, listmap.size());
		
		assertEquals((Integer) 1, listmap.firstKey());
		assertEquals((Integer) 7, listmap.lastKey());
		
		assertFalse(listmap.containsValue(3));
		assertTrue(listmap.containsValue(4));
		assertTrue(listmap.containsValue(6));
		assertTrue(listmap.containsValue(2));
		assertTrue(listmap.containsKey(3));
		assertTrue(listmap.containsKey(1));
		assertTrue(listmap.containsKey(7));
		
		assertEquals((Integer) 4, listmap.get(3));
		assertEquals((Integer) 2, listmap.get(1));
		assertEquals((Integer) 6, listmap.get(7));
		assertEquals(null, listmap.get(4));
		
		assertEquals(3, listmap.keySet().size());
		assertTrue(listmap.keySet().contains(3));
		assertTrue(listmap.keySet().contains(1));
		assertTrue(listmap.keySet().contains(7));
		assertEquals(3, listmap.values().size());
		assertTrue(listmap.values().contains(4));
		assertTrue(listmap.values().contains(2));
		assertTrue(listmap.values().contains(6));
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 6)
	public void nItemSizeTest(){
		Map<Integer, Integer> map = new HashMap<>();
		boolean validPut = true;
		for(int i = 0; i < n;i++){
			map.put(i, i + n);
			if(listmap.put(i, i + n) != null){
				validPut = false;
			}
		}
		if(!validPut){
			fail();
		}
		assertEquals(n, listmap.size());	
		assertCoinFlipper(n);
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 6)
	public void nItemIndexTest(){
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < n;i++){
			map.put(i, i + n);
			assertEquals(null, listmap.put(i, i + n));
		}
		
		assertEquals((Integer) 0, listmap.firstKey());
		assertEquals((Integer) (n - 1), listmap.lastKey());	
		assertCoinFlipper(n);
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 6)
	public void nItemSetTest(){
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < n;i++){
			map.put(i, i + n);
			assertEquals(null, listmap.put(i, i + n));
		}
		
		assertFalse(listmap.containsKey(-1));
		for(Integer i : map.keySet()){
			assertTrue(listmap.containsKey(i));
		}
		assertFalse(listmap.containsValue(-1));
		for(Integer i : map.values()){
			assertTrue(listmap.containsValue(i));
		}	
		assertCoinFlipper(n);
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 6)
	public void nItemAllTest(){
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < n;i++){
			map.put(i, i + n);
			assertEquals(null, listmap.put(i, i + n));
		}
		
		assertEquals(n, listmap.size());
		
		assertEquals((Integer) 0, listmap.firstKey());
		assertEquals((Integer) (n - 1), listmap.lastKey());
		
		assertFalse(listmap.containsKey(-1));
		for(Integer i : map.keySet()){
			assertTrue(listmap.containsKey(i));
		}
		assertFalse(listmap.containsValue(-1));
		for(Integer i : map.values()){
			assertTrue(listmap.containsValue(i));
		}	
		assertCoinFlipper(n);
	}
	
	@Test(timeout = LONGTIMEOUT)
	@Worth(points = 10)
	public void finalTest(){
		int g1 = 785678;
		int g2 = 64357;
		Random gen = new Random(g1);
		int max = 1000;
		
		for(int runs = 0; runs < 100; runs++){
			listmap = createSkipList(g2);
			int n = Math.abs(gen.nextInt() % max);
			Map<Integer, Integer> map = new HashMap<>();
			Integer lowest = Integer.MAX_VALUE;
			Integer highest = Integer.MIN_VALUE;
			List<Integer> removable = new LinkedList<>();
			boolean usedPut = false;
			int numPuts = 0;
			
			for(int i = 0; i < n;i++){
				int operation = gen.nextInt();
				if(operation % 3 == 0 && !removable.isEmpty()){
					int remove = removable.get((int) Math.floor((gen.nextDouble() * removable.size())));
					assertEquals(map.remove(remove), listmap.remove(remove));
				} else {
					int key = gen.nextInt() % n;
					int value = gen.nextInt() % n;
					if(operation % 2 == 0) removable.add(key);
					if(!map.containsKey(key)){
						numPuts++;
					}
					assertEquals(map.put(key, value), listmap.put(key, value));
					usedPut = true;
				}
			}
			if(usedPut){
				assertCoinFlipper(numPuts);
			}
			for(Integer i : map.keySet()){
				if(i > highest) highest = i;
				if(i < lowest) lowest = i;
			}
			
			assertEquals(map.size(), listmap.size());
			
			if(map.size() > 0){
				assertEquals(lowest, listmap.firstKey());
				assertEquals(highest, listmap.lastKey());
			}
			assertFalse(listmap.containsKey(100000));
			for(Integer i : map.keySet()){
				assertTrue(listmap.containsKey(i));
			}
			assertFalse(listmap.containsValue(100000));
			for(Integer i : map.values()){
				assertTrue(listmap.containsValue(i));
			}
		}
	}
	
	@Test(timeout = TIMEOUT)
	@Worth(points = 5)
	public void skipListTest(){
		Random gen = new Random(54534);
		for(int i = 0; i < 1000;i++){
			listmap.put(gen.nextInt(), gen.nextInt());	
		}
		for(int i = 0; i < 1000000;i++){
			listmap.lastKey();
		}
		assertTrue(listmap.size() > 0);
		//assertCoinFlipper(1000);
	}
	
	private void clearCase() {
		listmap.put(3, 4);
		listmap.put(2, 4);
		listmap.clear();
		assertCoinFlipper(2);
	}

	private void oneItemCase() {
		listmap = createSkipList(1332);
		assertEquals(null, listmap.put(3, 4));
		assertCoinFlipper(1);
	}

	private void twoItemCase() {
		listmap = createSkipList(756567567);
		assertEquals(null, listmap.put(3, 4));
		assertEquals(null, listmap.put(2, 5));
		assertCoinFlipper(2);
	}

	private void twoItemDuplicateCase() {
		assertEquals(null, listmap.put(3, 4));
		assertEquals(null, listmap.put(2, 4));
		assertCoinFlipper(2);
	}

	private void threeItemCase() {
		listmap = createSkipList(65474564);
		assertEquals(null, listmap.put(3, 4));
		assertEquals(null, listmap.put(7, 6));
		assertEquals(null, listmap.put(1, 2));
		assertCoinFlipper(3);
	}

	private void threeItemReplaceCase() {
		assertEquals(null, listmap.put(3, 4));
		assertEquals(null, listmap.put(7, 6));
		assertEquals(null, listmap.put(1, 2));
		assertEquals((Integer) 4, listmap.put(3, 9));
		assertCoinFlipper(3);
	}

	private void removeOneCase() {
		listmap.put(3, 4);
		assertEquals((Integer) 4, listmap.remove(3));
		assertCoinFlipper(1);
	}
	
	private void removeToThreeItemCase() {
		listmap = createSkipList(6544);
		assertEquals(null, listmap.put(3, 4));
		assertEquals(null, listmap.put(7, 6));
		assertEquals(null, listmap.put(1, 2));
		assertEquals(null, listmap.put(4, 0));
		assertEquals((Integer) 0, listmap.remove(4));
		assertCoinFlipper(4);
	}
	
	private void assertCoinFlipper(int numPuts){
		if (coinflipper.numFlips < numPuts){
			throw new AssertionError("Does not use CoinFlipper correctly.");
		}
	}
	
	public IListMap<Integer, Integer> createSkipList(int seed){
		this.seed = seed;
		coinflipper = new CoinFlipper2(new Random(seed));
		//return new TASkipListMap<>(coinflipper);
		//return new SortedListMap<>(coinflipper);
		//return new HashListMap<>(coinflipper);
		return new SkipListMap<>(coinflipper);
		//return new TreeListMap<>(coinflipper);
	}
}