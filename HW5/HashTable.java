import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * This class will represent a modified linear probing hash table. The
 * modification is specified in the comments for the put method.
 * 
 * name : Jongyeon Kim(jkim989)
 * GTID# : 903018469
 */
public class HashTable<K, V> {

	/**
	 * Constant determining the max load factor
	 */
	private final double MAX_LOAD_FACTOR = 0.71;

	/**
	 * Constant determining the initial table size
	 */
	private final int INITIAL_TABLE_SIZE = 10;

	/**
	 * Number of elements in the table
	 */
	private int size;

	/**
	 * The backing array of this hash table
	 */
	private MapEntry<K, V>[] table;

	/**
	 * Initialize the instance variables Initialize the backing array to the
	 * initial size given
	 */
	@SuppressWarnings("unchecked")
	public HashTable() {
		
		table = new MapEntry[INITIAL_TABLE_SIZE];
		size = 0;

	}

	/**
	 * Add the key value pair in the form of a MapEntry Use the default hash
	 * code function for hashing This is a linear probing hash table so put the
	 * entry in the table accordingly
	 * 
	 * Make sure to use the given max load factor for resizing Also, resize by
	 * doubling and adding one. In other words:
	 * 
	 * newSize = (oldSize * 2) + 1
	 * 
	 * The load factor should never exceed maxLoadFactor at any point. So if
	 * adding this element will cause the load factor to be exceeded, you should
	 * resize BEFORE adding it. Otherwise do not resize.
	 * 
	 * IMPORTANT Modification: If the given key already exists in the table then
	 * set it as the next entry for the already existing key. This means that
	 * you will never be replacing values in the hashtable, only adding or
	 * removing. This is similar to external chaining
	 * 
	 * @param key
	 *            This will never be null
	 * @param value
	 *            This can be null
	 */

	public void put(K key, V value) {
				
		MapEntry<K, V> entry = new MapEntry<K, V>(key, value);
		
		// load-factor is smaller than max load-factor
		if ((size + 1.0) / (table.length) <= MAX_LOAD_FACTOR) {
			
			// index has element which is not removed
			if (table[(key.hashCode()) % (table.length)] != null) {
				
				// has same key
				if (table[(key.hashCode()) % (table.length)].getKey().equals(key)) {
					chaning(table, entry, (key.hashCode()) % (table.length));
				}
				
				// has different key
				if (!table[(key.hashCode()) % (table.length)].getKey().equals(key)) {
					probe(table, entry, (key.hashCode()) % (table.length));
				}
			}
			
			// index is empty of has removed element
			if ((table[(key.hashCode()) % (table.length)] == null) || (table[(key.hashCode()) % (table.length)].isRemoved())) {
				table[(key.hashCode()) % (table.length)] = entry;
			}
			size++;
			
		}
		
		//load-factor is bigger than max load-factor
		if ((size + 1.0) / (table.length) > MAX_LOAD_FACTOR) {
			
			// make more spaces
			reSize (key, value);
		}
	}

	// helper method for method put by external chaining
	private void chaning(MapEntry<K, V>[] table, MapEntry<K, V> element, int tableIndex) {
		
		MapEntry<K, V> temp = table[tableIndex];
		
		// move to last element
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		
		// put next to last element
		temp.setNext(element);
	}

	// helper method for method put by linear probing
	private void probe(MapEntry<K, V>[] table, MapEntry<K, V> element, int tableIndex) {
		
		// if table has same key
		if (contains(element.getKey())) {
			
			// finding where has same key
			while ((!table[tableIndex].getKey().equals(element.getKey()))) {
				tableIndex++;
				if ( tableIndex == table.length) {
					tableIndex = 0;
				}
			}
			if ((table[tableIndex].getKey().equals(element.getKey()))) {
				
				// chaining with an element with same key
				chaning(table, element, tableIndex);
			}
		}
		
		// if table does not have same key
		if (!contains(element.getKey())) {
			
			// finding where has space
			while ((table[tableIndex] != null) && (!table[tableIndex].isRemoved())) {
				tableIndex++;
				if ( tableIndex == table.length) {
					tableIndex = 0;
				}
			}
			if ((table[tableIndex] == null) || (table[tableIndex].isRemoved())) {
				
				// put element in space
				table[tableIndex] = element;
			}
		}
	}

	// make more spaces when load-factor is bigger than max load-factor
	@SuppressWarnings("unchecked")
	private void reSize(K key, V value) {
		
		MapEntry<K, V>[] temp = new MapEntry[(table.length * 2) + 1];
		
		int i = 0;
		while (i < table.length) {
			if ((table[i] != null) && (!table[i].isRemoved())) {
				
				if (temp[(table[i].getKey().hashCode()) % (temp.length)] == null) {
					temp[(table[i].getKey().hashCode()) % (temp.length)] = table[i];	
				} 
				
				else {
					chaning(temp, table[i], (table[i].getKey().hashCode()) % (temp.length));
				}
			}
			i++;
		}
		putToResized(temp, key, value);
		table = temp;
	}

	// after resize, put elements in resized table
	public void putToResized(MapEntry<K, V>[] temp, K key, V value) {

		MapEntry<K, V> entry = new MapEntry<K, V>(key, value);
		
		// index is empty or has removed element
		if ((temp[(key.hashCode()) % (temp.length)] == null) || (temp[(key.hashCode()) % (temp.length)].isRemoved())) {
			temp[(key.hashCode()) % (temp.length)] = entry;
		}
		
		// has element which is not removed
		else if (temp[(key.hashCode()) % (temp.length)] != null) {
			
			// has same key
			if (temp[(key.hashCode()) % (temp.length)].equals(key)) {
				chaning(temp, entry, (key.hashCode()) % (temp.length));
			}
			
			// has different key
			if (!temp[(key.hashCode()) % (temp.length)].equals(key)) {
				probe(temp, entry, (key.hashCode()) % (temp.length));
			}
		}
	}

	/**
	 * Remove the entry with the given key.
	 * 
	 * If there are multiple entries with the same key then remove the last one
	 * 
	 * @param key
	 * @return The value associated with the key removed
	 */
	public V remove(K key) {
		
		int index = (key.hashCode()) % (table.length);
		int i = 0;
		V removed = null;
		while (i < table.length) {
			if ((table[index] != null) && (table[index].getKey().equals(key)) && (!table[index].isRemoved())) {
				
				// element has chaining other elements
				if (table[index].getNext() != null) {
					MapEntry<K, V> temp1 = table[index];
					MapEntry<K, V> temp2 = table[index];
					while (temp1.getNext() != null) {
						temp2 = temp1;
						temp1 = temp1.getNext();
					}
					
					// last element set to null
					temp2.setNext(null);
				}
				
				// element is head
				else if (table[index].getNext() == null) {
					
					// change flag to true(removed)
					table[index].setRemoved(true);
				}
				removed = table[index].getValue();
			}
			i++;
			index = index + 1;
			
			if (index == table.length) {
				index = 0;
			}
		}
		size--;
		
		// return removed
		return removed;
	}

	/**
	 * Checks whether an entry with the given key exists in the hash table
	 * 
	 * @param key
	 * @return
	 */
	public boolean contains(K key) {
		
		int index = (key.hashCode()) % (table.length);
		int i = 0;
		
		// check key
		while (i < table.length) {
			if ((table[index] != null) && (table[index].getKey().equals(key)) && (!table[index].isRemoved())) {
				
				// found same key
				return true;
			}
			i++;
			index = index + 1;
			if (index == table.length) {
				index = 0;
			}
	}
		// did not found same key
		return false;
	}

	/**
	 * Return a collection of all the values
	 * 
	 * We recommend using an ArrayList here
	 * 
	 * @return
	 */
	public Collection<V> values() {
		
		ArrayList<V> list = new ArrayList<V>();
		
		int i = 0;
		
		while (i < table.length) {
			
			// empty of removed value
			if ((table[i] != null) && (!table[i].isRemoved())) {
				if (table[i].getNext() == null) {
					list.add(table[i].getValue());
				}
				
				if (table[i].getNext() != null) {
					MapEntry<K, V> temp = table[i];
					while (temp != null) {
						list.add(temp.getValue());
						temp = temp.getNext();
					}
				}
			}
			i++;
		}
		return list;
	}

	/**
	 * Return a set of all the distinct keys
	 * 
	 * We recommend using a HashSet here
	 * 
	 * Note that the map can contain multiple entries with the same key
	 * 
	 * @return
	 */
	public Set<K> keySet() {
		
		HashSet<K> keys = new HashSet<K>();
		
		int i = 0;
		while (i < table.length) {
			if ((table[i] != null) && (!table[i].isRemoved())) {
				keys.add(table[i].getKey());
			}
			i++;
		}
		return keys;
	}

	/**
	 * Return the number of values associated with one key Return -1 if the key
	 * does not exist in this table
	 * 
	 * @param key
	 * @return
	 */
	public int keyValues(K key) {
		
		int numberOfValues = 0;
		if ((table[(key.hashCode()) % (table.length)] != null) && (!table[(key.hashCode()) % (table.length)].isRemoved())) {
			if (table[(key.hashCode()) % (table.length)].getNext() == null) {
				numberOfValues++;
			} 
			
			if (table[(key.hashCode()) % (table.length)].getNext() != null) {
				MapEntry<K, V> temp = table[(key.hashCode()) % (table.length)];
				while (temp != null) {
					numberOfValues++;
					temp = temp.getNext();
				}
			}
		} else {
			
			// values associated with one key
			numberOfValues = -1;
		}
		return numberOfValues;
	}

	/**
	 * Return a set of all the unique key-value entries
	 * 
	 * Note that two map entries with both the same key and value could exist in
	 * the map.
	 * 
	 * @return
	 */
	public Set<MapEntry<K, V>> entrySet() {
		
		HashSet<MapEntry<K, V>> entry = new HashSet<>();
		
		int i= 0;
		while (i < table.length) {
			if ((table[i] != null) && (!table[i].isRemoved())) {
				entry.add(table[i]);
			}
			i++;
		}
		return entry;
	}

	/**
	 * Clears the hash table
	 */
	public void clear() {
		
		int i= 0;
		while (i < table.length) {
			table[i] = null;
			i++;
		}
		size = 0;
	}

	/*
	 * The following methods will be used for grading purposes do not modify
	 * them
	 */

	public int size() {
		
		return this.size;
	}

	public void setSize(int size) {
		
		this.size = size;
	}

	public MapEntry<K, V>[] getTable() {
		
		return table;
	}

	public void setTable(MapEntry<K, V>[] table) {
		
		this.table = table;
	}	
}
