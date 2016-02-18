import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Jongyeon Kim(jkim989)
 * GTID# 903018469
 * 
 * CS 1332 Fall 2013
 * Binary Search Tree
 * 
 * In this assignment, you will be coding methods to make a functional
 * binary search tree. If you do this right, you will save a lot of time
 * in the next two assignments (since they are just augmenting the BST to 
 * make it efficient). Let's get started!
 * 
 * **************************NOTE************************
 * YOU WILL HAVE TO HANDLE NULL DATA IN THIS ASSIGNMENT!!
 * PLEASE TREAT NULL AS POSITIVE INFINITY!!!!
 * **************************NOTE************************
 * 
 * DO NOT CHANGE ANY OF THE PUBLIC METHOD HEADERS
 * 
 * Please make any extra inner classes, instance fields, and methods private
 */
public class BST<T extends Comparable<T>> {
	
	private Node<T> root = null;
	private int size = 0;
	
	/**
	 * Add data to the binary search tree. Remember to adhere to the BST Invariant:
	 * All data to the left of a node must be smaller and all data to the right of
	 * a node must be larger. Don't forget to update the size. 
	 * 
	 * For this method, you will need to traverse the tree and find the appropriate
	 * location of the data. Depending on the data's value, you will either explore
	 * the right subtree or the left subtree. When you reach a dead end (you have 
	 * reached a null value), simply return a new node with the data that was passed
	 * in.
	 * 
	 * PLEASE TREAT NULL DATA AS POSITIVE INFINITY!!!!
	 * 
	 * @param data A comparable object to be added to the tree.
	 */
	public void add(T data) {
		
		Node<T> newNode = new Node<T>(data);
		
		// tree is empty
		if (root == null) {
			root = newNode;
		}
		
		// tree is not empty
		if (root != null) {
			addNode(root, newNode);
		}
		
		size++;
	}
	
	// helper method for method 'add'
	private void addNode(Node<T> parent, Node<T> newNode) {
		
		// case 1: parent and newNode have same data
		if (compare(parent.getData(), newNode.getData()) == 0) {
			return;
		}
		
		// case 2: parent has smaller data than newNode
		if (compare(parent.getData(), newNode.getData()) > 0) {
			
			// parent does not have a left child
			if (parent.getLeft() == null) {
				parent.setLeft(newNode);
			} 
			
			// parent have a left child
			if (parent.getLeft() != null) {
				addNode(parent.getLeft(), newNode);
			}
		}
		
		// case 3: parent has bigger data than newNode
		if (compare(parent.getData(), newNode.getData()) < 0) {
			
			// parent does not have a right child
			if (parent.getRight() == null) {
				parent.setRight(newNode);
			} 
			
			// parent have a right child
			if (parent.getRight() != null) {
				addNode(parent.getRight(), newNode);
			}
		}
	}
	
	/**
	 * Add the contents of the collection to the BST. To do this method, notice that
	 * most every collection in the java collections API implements the iterable 
	 * interface. This means that you can iterate through every element in these 
	 * structures with a for-each loop. Don't forget to update the size.
	 * 
	 * @param collection A collection of data to be added to the tree.
	 */
	public void addAll(Collection<? extends T> c) {
		
		for (T i : c) {
			add(i);
		}
	}
	
	/**
	 * Remove the data element from the tree. Use the removeChild helper method.
	 *  
	 * PLEASE TREAT NULL DATA AS POSITIVE INFINITY!
	 *  
	 * @param data The data element to be searched for.
	 * @return retData The data that was removed from the tree. Return null if the
	 * data doesn't exist.
	 */
	public T remove(T data) {
		
		// for get deleted data
		T deletedData = get(data);
		
		root = removeChild(root, data);
		size--;
		
		// return deleted data
		return deletedData;
	}

	/**
	 * This is the helper method we suggest using, you may code remove in other
	 * ways though.
	 * 
	 * There are three cases you have to deal with:
	 * 1. The node to remove has no children
	 * 2. The node to remove has one child
	 * 2. The node to remove has two children
	 * 
	 * In the first case, return null. In the second case, return the non-null 
	 * child. The third case is where things get interesting. Here, you have two 
	 * you will have to find the predecessor and then copy their data 
	 * into the node you want to remove. You will also have to fix the
	 * predecessor's children if necessary. Don't forget to update the size.
	 *
	 * @param Node<T> node The node to be removed
	 * @param Node<T> The new child node
	 */
	private Node<T> removeChild(Node<T> node, T data) {
		
		// tree is empty or tree dose not have same data to remove
		if (node == null) {
			return null;
		}

		// node has same data to remove
		if (compare(node.getData(), data) == 0) {
			
			// node does not have a left child
			if (node.getLeft() == null) {
				return node.getRight();
			} 
			
			// node does not have a right child
			if (node.getRight() == null) {
				return node.getLeft();
			}
			
			// node has a left node or right node
			if (node.getLeft() != null || node.getRight() != null) {

				node.setData(predecessor(node.getLeft()).getData());
				node.setLeft(removeChild(node.getLeft(), predecessor(node.getLeft()).getData()));
			}
		}
		
		// node has bigger data to remove
		if (compare(node.getData(), data) > 0) {
			node.setLeft(removeChild(node.getLeft(), data));
		} 
		
		// node has smaller data to remove
		if (compare(node.getData(), data) < 0) {
			node.setRight(removeChild(node.getRight(), data));
		}
		
		return node;
	}
	
	// find predecessor node
	private Node<T> predecessor(Node<T> node) {
		
		if (node == null) {
			return null;
		}
		
		// node has a right child
		if (node.getRight() != null) {
			node = node.getRight();
		}
		
		return node;
	}
	
	/**
	 * Get the data from the tree.
	 * 
	 * This method simply returns the data that was stored in the tree.
	 * 
	 * TREAT NULL DATA AS POSITIVE INFINITY!
	 * 
	 * @param data The datum to search for in the tree.
	 * @return The data that was found in the tree. Return null if the data doesn't
	 * exist.
	 */
	public T get(T data) {
		
		// get data is null
		if (find(root, data) == null) {
			return null;
		}
		
		return find(root, data).getData();
	}
	
	// helper method for method get
	private Node<T> find(Node<T> node, T data) {
		
		// node is null
		if (node == null) {
			return null;
		}
		
		// node has same data
		if (compare(node.getData(), data) == 0) {
			return node;
		}
		
		// node has bigger data
		if (compare(node.getData(), data) > 0) {
			return find(node.getLeft(), data);
		}
		
		// node has smaller data
		else {
			return find(node.getRight(), data);

		}

	}
	
	/**
	 * See if the tree contains the data.
	 * 
	 * TREAT NULL DATA AS POSITIVE INFINITY!
	 * 
	 * @param data The data to search for in the tree.
	 * @return Return true if the data is in the tree, false otherwise.
	 */
	public boolean contains(T data) {
		
		if (get(data) != null) {
		return true;
		}
		
		else
			return false;
	}
	
	/**
	 * Linearize the tree using the pre-order traversal.
	 * 
	 * @return A list that contains every element in pre-order.
	 */
	public List<T> preOrder() {
		
		// tree is empty or root has null data
		if (root == null) {
			return null;
		}
		
		ArrayList<T> list = new ArrayList<T>();
		preOrderTravel(root, list);
		return list;
	}
	

	// helper method for method preOrder
	private void preOrderTravel(Node<T> node, ArrayList<T> preList) {
		
		// node is null
		if (node == null) {
			return;
		}
		
		preList.add(node.getData());
		preOrderTravel(node.getLeft(), preList);
		preOrderTravel(node.getRight(), preList);
	}
	
	
	/**
	 * Linearize the tree using the in-order traversal.
	 * 
	 * @return A list that contains every element in-order.
	 */
	public List<T> inOrder() {
		
		// tree is empty or root has null data
		if (root == null) {
			return null;
		}
		
		ArrayList<T> list = new ArrayList<T>();
		inOrderTravel(root, list);
		return list;
	}

	// helper method for method inOrder
	private void inOrderTravel(Node<T> node, ArrayList<T> inList) {
		
		// node is null
		if (node == null) {
			return;
		}
		
		inOrderTravel(node.getLeft(), inList);
		inList.add(node.getData());
		inOrderTravel(node.getRight(), inList);
	}

	
	/**
	 * Linearize the tree using the post-order traversal.
	 * 
	 * @return A list that contains every element in post-order.
	 */
	public List<T> postOrder() {
		
		// tree is empty or root has null data
		if (root == null) {
			return null;
		}
		
		ArrayList<T> list = new ArrayList<T>();
		postOrderTraversal(root, list);
		return list;
	}

	// helper method for method postOrder
	private void postOrderTraversal(Node<T> node, ArrayList<T> postList) {
		
		// node is null
		if (node == null) {
			return;
		}
		
		postOrderTraversal(node.getLeft(), postList);
		postOrderTraversal(node.getRight(), postList);
		postList.add(node.getData());
	}
	
	/**
	 * Test to see if the tree is empty.
	 * 
	 * @return Return true if the tree is empty, false otherwise.
	 */
	public boolean isEmpty() {
		
		return (root == null);
	}
	
	/**
	 * 
	 * @return Return the number of elements in the tree.
	 */
	public int size() {
		
		return size;
	}
	
	/**
	 * Clear the tree. (ie. set root to null and size to 0)
	 */
	public void clear() {
		
		root = null;
		size = 0;
	}
	
	/**
	 * Clear the existing tree, and rebuilds a unique binary search tree 
	 * with the pre-order and post-order traversals that are passed in.
	 * Draw a tree out on paper and generate the appropriate traversals.
	 * See if you can manipulate these lists to generate the same tree.
	 * 
	 * TL;DR - at the end of this method, the tree better have the same
	 * pre-order and post-order as what was passed in.
	 * 
	 * @param preOrder A list containing the data in a pre-order linearization.
	 * @param postOrder A list containing the data in a post-order linearization.
	 */
	public void reconstruct(List<? extends T> preOrder, List<? extends T> postOrder) {
		
		root = recursiveToReconstruct(preOrder, postOrder);
		
		// has same size of preOrder because this is reconstruct
		size = preOrder.size();
	}
	
	// helper method for method reconstruct
	private Node<T> recursiveToReconstruct(List<? extends T> preOrder, List<? extends T> postOrder) {
		
		if ((postOrder.size() != 0) && (preOrder.size() != 0)) {
			T root = preOrder.get(0);
			Node<T> newNode = new Node<T>(root);

			// node does not have any children
			if (preOrder.size() == 1) {
				return newNode;
			}

			List<? extends T> leftPostOrder = postOrder.subList(0, postOrder.indexOf(preOrder.get(1)) + 1);
			List<? extends T> rightPostOrder = postOrder.subList(postOrder.indexOf(preOrder.get(1)) + 1, postOrder.size() - 1);

			List<? extends T> leftPreOrder = preOrder.subList(1, leftPostOrder.size() + 1);
			List<? extends T> rightPreOrder = preOrder.subList(leftPostOrder.size() + 1, preOrder.size());

			// node has two children
			if (compare(preOrder.get(1), preOrder.get(0)) < 0) {
				newNode.setRight(recursiveToReconstruct(rightPreOrder, rightPostOrder));
				newNode.setLeft(recursiveToReconstruct(leftPreOrder, leftPostOrder));
			}
			
			// node has one child
			if (compare(preOrder.get(1), preOrder.get(0)) > 0) {
				newNode.setRight(recursiveToReconstruct(leftPreOrder, leftPostOrder));
			}
			
			return newNode;
		}

		return null;
	}
	
	// treat null as a positive infinity
	public int compare(T a, T b) {
		
		// a and b are null
		if (a == null && b == null) {
			return 0;
		}
		
		// a is null
		if (a == null) {
			return 1;
		}
		
		// b is null
		if (b == null) {
			return -1;
		}
		
		// both are not null, then use normal compareTo
		else
			return a.compareTo(b);
	}
}
