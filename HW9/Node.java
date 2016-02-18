import java.util.Map.Entry;
//author Jongyeon Kim(jkim989)
//GTID# 903018469

public class Node<K, V>  implements Entry<K, V> {
	
	private K key;
	private V value;
	private Node<K, V> right;
	private Node<K, V> left;
	private Node<K, V> up;
	private Node<K, V> down;
	
	public Node(K key, V value) {
		this.key = key;
		this.value = value;
		right = null;
		left = null;
		up = null;
		down = null;
	}
	
	public V getValue() {
		return value;
	}
	
	public K getKey() {
		return key;
	}
	
	public Node<K, V> getRight() {
		return right;
	}
	
	public Node<K, V> getLeft() {
		return left;
	}
	
	public Node<K, V> getUp() {
		return up;
	}
		
	public Node<K,V> getDown() {
		return down;
	}

	public V setValue(V value) {
		V temp = this.value;
		this.value = value;
		return temp;
	}
	
	public K setKey(K key) {
		K temp = this.key;
		this.key = key;
		return temp;
	}
	
	public void setRight(Node <K, V> right) {
		this.right = right;
	}
	
	public void setLeft(Node<K,V> left) {
		this.left = left;
	}
	
	public void setUp(Node<K,V> up) {
		this.up = up;
	}
	public void setDown(Node<K,V> down) {
		this.down = down;
	}

}
