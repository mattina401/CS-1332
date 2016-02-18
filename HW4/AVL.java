import java.util.Collection;

/**
 * @author Jongyeon Kim(jkim989)
 * GTID# 903018469
 * 
 * CS 1332 Fall 2013
 * AVL Tree
 * 
 * In this class, you will program an AVL Tree (Adelson Veskii-Landis Tree).
 * This is like a better version of a binary search tree in that it 
 * tries to fill out every level of the tree as much as possible. It
 * accomplishes this by keeping track of each node's height and balance
 * factor. As you recurse back up from operations that modify the tree
 * (like add or remove), you will update the height and balance factor
 * of the current node, and perform a rotation on the current node if 
 * necessary. Keeping this in mind, let's get started!
 * 
 * **************************NOTE*************************************
 * please please please  treat null as positive infinity!!!!!!!!
 * PLEASE TREAT NULL AS POSITIVE INFINITY!!!!
 * *************************NOTE**************************************
 * 
 * I STRONLY RECOMMEND THAT YOU IMPLEMENT THIS DATA STRUCTURE RECURSIVELY!
 * 
 * Please make any new internal classes, instance data, and methods private!!
 * 
 * DO NOT CHANGE ANY OF THE PUBLIC METHOD HEADERS
 */
public class AVL<T extends Comparable<T>> {
	
	private AVLNode<T> root = null;
	private int size = 0;
	
	/**
	 * I promise you, this is just like the add() method you coded
	 * in the BST part of the homework! You will start off at the
	 * root and find the proper place to add the data. As you 
	 * recurse back up the tree, you will have to update the
	 * heights and balance factors of each node that you visited
	 * while reaching the proper place to add your data. Immediately
	 * before you return out of each recursive step, you should update
	 * the height and balance factor of the current node and then
	 * call rotate on the current node. You will then return the node
	 * that comes from the rotate(). This way, the re-balanced subtrees
	 * will properly be added back to the whole tree. Also, don't forget
	 * to update the size of the tree as a whole.
	 * 
	 * PLEASE TREAT NULL AS POSITIVE INFINITY!!!!
	 * 
	 * @param data The data do be added to the tree.
	 */
	public void add(T data) {
		
		// tree is empty
		if (root == null) {
			root = new AVLNode<T>(data);

		}
		
		// tree is not empty
		if (root != null) {
			addNode(root, data);
		}
		
		size++;
		root = rotate(root);
	}
	
	// helper method for method add
	private void addNode(AVLNode<T> node, T data) {
		
		// node is bigger than data
		if (compare(node.getData(), data) > 0) {
			
			// node has a left child
			if (node.getLeft() != null) {
				addNode(node.getLeft(), data);
				node.setLeft(rotate(node.getLeft()));
			}
			
			// node does not have a left child
			if (node.getLeft() == null){
				node.setLeft(new AVLNode<T>(data));
			}
		}
		
		// node is smaller than data
		if (compare(node.getData(), data) < 0) {
			
			// node has a right child
			if (node.getRight() != null) {
				addNode(node.getRight(), data);
				node.setRight(rotate(node.getRight()));
			}
			
			// node dose not has a right child
			if (node.getRight() == null){
				node.setRight(new AVLNode<T>(data));
			}
		}

	}
	
	/**
	 * This is a pretty simple method. All you need to do is to get
	 * every element in the collection that is passed in into the tree.
	 * 
	 * Try to think about how you can combine a for-each loop and your
	 * add method to accomplish this.
	 * 
	 * @param c A collection of elements to be added to the tree.
	 */
	public void addAll(Collection<? extends T> c) {
		
		for (T i : c) {
			add(i);
		}
	}
	
	/**
	 * All right, now for the remove method. Just like in the vanilla BST, you
	 * will have to traverse to find the data the user is trying to remove. 
	 * 
	 * You will have three cases:
	 * 
	 * 1. Node to remove has zero children.
	 * 2. Node to remove has one child.
	 * 3. Node to remove has two children.
	 * 
	 * For the first case, you simply return null up the tree. For the second case,
	 * you return the non-null child up the tree. 
	 * 
	 * Just as in add, you'll have to updateHeightAndBF() as well as rotate() just before
	 * you return out of each recursive step.
	 * 
	 * FOR THE THIRD CASE USE THE PREDECESSOR OR YOU WILL LOSE POINTS
	 * 
	 * @param data The data to search in the tree.
	 * @return The data that was removed from the tree.
	 */
	public T remove(T data) {
		
		root = removeChild(root, data);
		size--;
		
		return data;
	}

	// helper method for method remove
	private AVLNode<T> removeChild(AVLNode<T> node, T data) {
		
		// tree is empty or tree dose not have same data to remove
		if (node == null) {
			return node;
		}
		
		// node is bigger than data
		if (compare(node.getData(), data) > 0) {
			node.setLeft(removeChild(node.getLeft(), data));
		} 
		
		// node is smaller than data
		else if (compare(node.getData(), data) < 0) {
			node.setRight(removeChild(node.getRight(), data));
		} 
		
		// node has two children
		else if ((node.getRight() != null) && (node.getLeft() != null)) {
			node.setData(predecessor(node.getLeft()).getData());
			node.setLeft(removeChild(node.getLeft(), node.getData()));
		}
		
		// node does not have any children
		else if ((node.getRight() == null) && (node.getLeft() == null)) {
			
			// node does not have a left child
			if (node.getLeft() != null) {
				node = node.getLeft();
			}
		
			// node does not have a right child
			if (node.getLeft() == null) {
				node = node.getRight();
			}
		}
			
		return rotate(node);

	}

	// find predecessor node
	private AVLNode<T> predecessor(AVLNode<T> node) {

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
	 * This method should be pretty simple, all you have to do is recurse
	 * to the left or to the right and see if the tree contains the data.
	 * 
	 * @param data The data to search for in the tree.
	 * @return The boolean flag that indicates if the data was found in the tree or not.
	 */
	public boolean contains(T data) {
		
		if (get(data) != null) {
		return true;
		}
		
		else
			return false;
	}
	
	
	/**
	 * Again, simply recurse through the tree and find the data that is passed in.
	 * 
	 * @param data The data to fetch from the tree.
	 * @return The data that the user wants from the tree. Return null if not found.
	 */
	public T get(T data) {
		
		// get data is null
		if (find(root, data) == null) {
			return null;
		}
		
		return find(root, data).getData();
	}

	// helper method for method get
	private AVLNode<T> find(AVLNode<T> node, T data) {
		
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
	 * Test to see if the tree is empty.
	 * 
	 * @return A boolean flag that is true if the tree is empty.
	 */
	public boolean isEmpty() {
		
		return (root == null);
	}
	
	/**
	 * Return the number of data in the tree.
	 * 
	 * @return The number of data in the tree.
	 */
	public int size() {
		
		return size;
	}
	
	/**
	 * Reset the tree to its original state. Get rid of every element in the tree.
	 */
	public void clear() {
		
		root = null;
		size = 0;
	}
	
	// The below methods are all private, so we will not be directly grading them,
	// however we strongly recommend you not change them, and make use of them.
	
	
	/**
	 * Use this method to update the height and balance factor for a node.
	 * 
	 * @param node The node whose height and balance factor need to be updated.
	 */
	private AVLNode<T> updateHeightAndBF(AVLNode<T> node) {
		
		// when node is null, height is -1
		int leftHeight = -1;
		int rightHeight = -1;
		
		// node is not null
		if (node != null) {
			
			// node has a left child
			if (node.getLeft() != null) {
				leftHeight = node.getLeft().getHeight();
			}
			
			// node has a right child
			if (node.getRight() != null) {
				rightHeight = node.getRight().getHeight();
			}
			
			// node height = max-height(among children) + 1
			node.setHeight(1 + Math.max(leftHeight, rightHeight));
			node.setBF(leftHeight - rightHeight);
		}

		return node;
	}
	
	/**
	 * In this method, you will check the balance factor of the node that is passed in and
	 * decide whether or not to perform a rotation. If you need to perform a rotation, simply
	 * call the rotation and return the new root of the balanced subtree. If there is no need
	 * for a rotation, simply return the node that was passed in.
	 * 
	 * @param node - a potentially unbalanced node
	 * @return The new root of the balanced subtree.
	 */
	private AVLNode<T> rotate(AVLNode<T> node) {
		
		if (node == null) {
			return node;
		}
		
		node = updateHeightAndBF(node);
		
		// has more nodes on right side
		if (node.getBf() < -1) {
			
			// left rotate
			if (updateHeightAndBF(node.getRight()).getBf() < 0) {
				node = leftRotate(node);
			}
			
			// right-lest rotate
			else if (updateHeightAndBF(node.getRight()).getBf() > 0) {
				node = rightLeftRotate(node);
			}
		}
		
		// has more nodes on left side
		if (node.getBf() > 1) {

			// right rotate
			if (updateHeightAndBF(node.getLeft()).getBf() > 0) {
				node = rightRotate(node);
			}
			
			// left-right rotate
			else if (updateHeightAndBF(node.getLeft()).getBf() < 0) {
				node = leftRightRotate(node);
			}	
		}
		
		return node;
	}
	
	/**
	 * In this method, you will perform a left rotation. Remember, you perform a 
	 * LEFT rotation when the sub-tree is RIGHT heavy. This moves more nodes over to
	 * the LEFT side of the node that is passed in so that the height differences
	 * between the LEFT and RIGHT subtrees differ by at most one.
	 * 
	 * HINT: DO NOT FORGET TO RE-CALCULATE THE HEIGHT OF THE NODES
	 * WHOSE CHILDREN HAVE CHANGED! YES, THIS DOES MAKE A DIFFERENCE!
	 * 
	 * @param node - the current root of the subtree to rotate.
	 * @return The new root of the subtree
	 */
	private AVLNode<T> leftRotate(AVLNode<T> node) {
		
		AVLNode<T> newRoot = node.getRight();
		node.setRight(newRoot.getLeft());
		updateHeightAndBF(node);
		newRoot.setLeft(node);
		updateHeightAndBF(newRoot);

		return newRoot;
	}
	
	/**
	 * In this method, you will perform a right rotation. Remember, you perform a
	 * RIGHT rotation when the sub-tree is LEFT heavy. THis moves more nodes over to
	 * the RIGHT side of the node that is passed in so that the height differences
	 * between the LEFT and RIGHT subtrees differ by at most one.
	 * 
	 * HINT: DO NOT FORGET TO RE-CALCULATE THE HEIGHT OF THE NODES
	 * WHOSE CHILDREN HAVE CHANGED! YES, THIS DOES MAKE A DIFFERENCE!
	 * 
	 * @param node - The current root of the subtree to rotate.
	 * @return The new root of the rotated subtree.
	 */
	private AVLNode<T> rightRotate(AVLNode<T> node) {
		
		AVLNode<T> newRoot = node.getLeft();
		node.setLeft(newRoot.getRight());
		updateHeightAndBF(node);
		newRoot.setRight(node);
		updateHeightAndBF(newRoot);

		return newRoot;
	}
	
	/**
	 * In this method, you will perform a left-right rotation. You can simply use
	 * the left and right rotation methods on the node and the node's child. Remember
	 * that you must perform the rotation on the node's child first, otherwise you will
	 * end up with a mangled tree (sad face). After rotating the child, remember to link up
	 * the new root of the that first rotation with the node that was passed in.
	 * 
	 * The whole point of heterogeneous rotations is to transform the node's 
	 * subtree into one of the cases handled by the left and right rotations.
	 * 
	 * @param node
	 * @return The new root of the subtree.
	 */
	private AVLNode<T> leftRightRotate(AVLNode<T> node) {
		
		node.setLeft(leftRotate(node.getLeft()));
		updateHeightAndBF(node);
		
		return rightRotate(node);
	}
	
	/**
	 * In this method, you will perform a right-left rotation. You can simply use your
	 * right and left rotation methods on the node and the node's child. Remember
	 * that you must perform the rotation on the node's child first, otherwise
	 * you will end up with a mangled tree (super sad face). After rotating the node's child,
	 * remember to link up the new root of that first rotation with the node that was
	 * passed in.
	 * 
	 * Again, the whole point of the heterogeneous rotations is to first transform the
	 * node's subtree into one of the cases handled by the left and right rotations.
	 * 
	 * @param node
	 * @return The new root of the subtree.
	 */
	private AVLNode<T> rightLeftRotate(AVLNode<T> node) {
		
		node.setRight(rightRotate(node.getRight()));
		updateHeightAndBF(node);
		
		return leftRotate(node);
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
