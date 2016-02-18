import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

//author Jongyeon Kim(jkim989)
//GTID# 903018469

public class SkipListMap<K extends Comparable<? super K>, V> implements IListMap<K, V> {
	protected CoinFlipper flipper;
	protected int size;
	protected Node<K, V> head;
	protected Node<K, V> tail;
	protected Node<K, V> bottomHead;
	protected Node<K, V> bottomTail;
	protected int h;
	@SuppressWarnings("unchecked")
	protected K negativeInfinity = (K) "-oo";
	@SuppressWarnings("unchecked")
	protected K positiveInfinity = (K) "oo";
	
	/**
	 * constructs a SkipListMap object that stores keys in ascending order
	 * when a key value pair is inserted, the flipper is called until it returns a tails
	 * if for an pair the flipper returns n heads, the corresponding node has n + 1 levels
	 * 
	 * the skip list should have an empty node at the beginning and end that do not store any data
	 * these are called sentinel nodes  
	 * @param flipper the source of randomness 
	 */
	public SkipListMap(CoinFlipper flipper) {
		
		Node<K, V> neg = new Node<K, V>(negativeInfinity, null);
		Node<K, V> pos = new Node<K ,V>(positiveInfinity, null);
		neg.setRight(pos);
		pos.setLeft(neg);
		size = 0;
		h = 0;
		head = neg;
		tail = pos;
		bottomHead = neg;
		bottomTail = pos;
		this.flipper = flipper;
	}

	@Override
	public K firstKey() {
		// TODO Auto-generated method stub

		if (size == 0) {
			return null;
		} else
		return bottomHead.getRight().getKey();
	}

	@Override
	public K lastKey() {
		// TODO Auto-generated method stub
	
		if (size == 0) {
			return null;
		} else
		return bottomTail.getLeft().getKey();
	}

	@Override
	public boolean containsKey(K key) {
		// TODO Auto-generated method stub
		
		if (key == null) {
			throw new IllegalArgumentException();
		}
		
		Node<K, V> node = search(key);
		if (node.getKey().equals(key)) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean containsValue(V value) {
		// TODO Auto-generated method stub
		
		if (value == null) {
			throw new IllegalArgumentException();
		}
		
		Node<K, V> nd;
		nd = bottomHead;
		while (nd.getRight().getValue() != value) {
			nd = nd.getRight();
			if (nd.getValue() == null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * {@link IListMap#put(Comparable, Object) IListMap}
	 * 
	 * if a node is updated, only the key value pair should be changed  
	 */
	@Override
	public V put(K key, V newValue) {
		// TODO Auto-generated method stub
		
		if (key == null || newValue == null) {
			throw new IllegalArgumentException();
		} else {
			Node<K, V> node;
			node = search(key);
			V oldNd = node.getValue();
			Node<K, V> newNd;
			newNd = new Node<K, V>(key, newValue);
			int level = 0;
			
			if (key.equals(node.getKey())) {
				
				while (node.getUp() != null) {
					node.setValue(newValue);
					node = node.getUp();
				}
				node.setValue(newValue);
				return oldNd;
			} 
			else if (!key.equals(node.getKey())) {
				newNd.setLeft(node);
				newNd.setRight(node.getRight());
				node.getRight().setLeft(newNd);
				node.setRight(newNd);
				
				while (flipper.flipCoin() == CoinFlipper.Coin.HEADS) {
					if (level >= h) {
						floor();
					}
					while (node.getUp() == null) {
						node = node.getLeft();
					}
					node = node.getUp();
					Node<K, V> tempNode = new Node<K, V>(key, newValue);
					
					tempNode.setLeft(node);
					tempNode.setRight(node.getRight());
					tempNode.setDown(newNd);
					node.getRight().setLeft(tempNode);
					node.setRight(tempNode);
					newNd.setUp(tempNode);
					newNd = tempNode;
					level++;
				
				}
				size++;
			}
		}
		return null;
	}

	private void floor() {
		Node<K, V> node1 = new Node<K, V>(negativeInfinity, null);
		Node<K, V> node2 = new Node<K, V>(positiveInfinity, null);
		
		node1.setRight(node2);
		node2.setLeft(node1);
		node1.setDown(head);
		node2.setDown(tail);
		
		head.setUp(node1);
		tail.setUp(node2);
		
		head = node1;
		tail = node2;
		
		h++;
	}
	
	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		
		if (key == null) {
			throw new IllegalArgumentException();
		}
		
		Node<K, V> node;
		node = search(key);
		if (key.equals(node.getKey())) {
			return node.getValue();
		} else
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		
		return size;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
		Node<K, V> node1 = head;
		Node<K, V> node2 = tail;

		while (node1 != null) {
			node1.setRight(node2);
			node2.setLeft(node1);
			node1 = node1.getDown();
			node2 = node2.getDown();
		}

		size = 0;
		h = 0;
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		
		Set<K> key = new TreeSet<K>();
		Node<K, V> node = bottomHead;

		while (node.getRight().getKey() != positiveInfinity) {
			node = node.getRight();
			key.add(node.getKey());
		}
		
		return key;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		
		Collection<V> value = new LinkedList<V>();
		Node<K, V> node = bottomHead;

		while (node.getRight().getKey() != positiveInfinity) {
			node = node.getRight();
			value.add(node.getValue());
		}
		
		return value;
	}
	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		V RN = null;
		if (key == null) {
			throw new IllegalArgumentException();
		} else {
			
			if (containsKey(key)) {
				Node<K, V> node = search(key);
				RN = node.getValue();
				
				while (node.getUp() != null) {
					
					node = node.getUp();
				}
				
				if (node.getLeft().getKey().equals(negativeInfinity) && node.getRight().getKey().equals(positiveInfinity)) {
					head = head.getDown();
					tail = tail.getDown();
					h--;
				}
				
				while (node.getDown() != null) {
					node.getLeft().setRight(node.getRight());
					node.getRight().setLeft(node.getLeft());
					node = node.getDown();
				}
				node.getLeft().setRight(node.getRight());
				node.getRight().setLeft(node.getLeft());
			}
			size--;
		}
		return RN;
	}
	
	private Node<K, V> search(K key) {
		
		if (key == null) {
			throw new IllegalArgumentException();
		}
		Node<K, V> nd;
		nd = head;
		while (true) {
			while (nd.getRight().getKey() != positiveInfinity && nd.getRight().getKey().compareTo(key) <= 0) {
				nd = nd.getRight();
			}
			if (nd.getDown() != null) {
				nd = nd.getDown();
			} else
				break;
		}	
		return nd;
	}
}