package trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class bst {
	
	TreeNode root;
	
	//Iterative calculate height of tree
	public int heightIter(TreeNode root) {
		//empty tree has height 0
		if(root == null) {
			return 0;
		}
		
		//create empty queue and enqueue root node
		Queue<TreeNode> qTree = new ArrayDeque<>();
		qTree.add(root);
		
		TreeNode front = null;
		int height = 0;
		
		//do till queue is not empty;
		while(!qTree.isEmpty()) {
			//calculate nodes in current level
			int size = qTree.size();
			
			//process each node of current level and enqueue their non empty left and right child to queue
			while(size-- > 0) {
				front = qTree.poll();
				
				if(front.left != null) {
					qTree.add(front.left);
				}
				if(front.right != null) {
					qTree.add(front.right);
				}
			}
			
			//increment height by 1 for each level
			height++;
		}
		return height;
	}
	//recursive insert
	public TreeNode insertRecursive(TreeNode root, int value) {
		
		if(root == null) {
			return new TreeNode(value);
		}
		
		if(value < (int) root.data) {
			root.left = insertRecursive(root.left, value);
		}else if(value > (int) root.data) {
			root.right = insertRecursive(root.right, value);
		}
		
		return root;
	}
	
	//iterative insert
	
	public TreeNode insertIterative(TreeNode root, int value) {
		
		TreeNode current, parent;
		
		TreeNode tempNode = new TreeNode(value);
		
		if(root == null) {
			root = tempNode;
			return root;
		}else {
			current = root;
		}
		while(true) {
			parent = current;
			
			if (value < (int) current.data) {
				current = current.left;
				if(current == null) {
					parent.left = tempNode;
					return root;
				}
			}else if(value > (int) current.data) {
				current = current.right;
				if(current == null) {
					parent.right = tempNode;
					return root;
				}
			}
		}
		
	}
	
	public int inOrderSuccessor(TreeNode root) {
		int minimum = (int)root.data;
		while(root.left != null) {
			minimum = (int) root.left.data;
			root = root.left;
		}
		return minimum;
	}
	
	//remove recursive
	public TreeNode removeRecursive(TreeNode root, int value) {
		if(root == null) {
			return root;
		}
		if(value < (int) root.data) {
			root.left = removeRecursive(root.left, value);
		}else if(value > (int) root.data) {
			root.right = removeRecursive(root.right, value);
		}else {
			if(root.left == null) {
				return root.right;
			}else if(root.right == null) {
				return root.left;
			}
			root.data = inOrderSuccessor(root.right);
			root.right = removeRecursive(root.right, (int)root.data);
		}
		return root;
	}
	
	public TreeNode removeIterative(TreeNode root, int value) {
		TreeNode parent = null, current = root;
		boolean hasLeft = false;
		
		if(root == null) {
			return root;
		}
		while(current != null) {
			if((int)current.data == value) {
				break;
			}
			parent = current;
			if(value < (int) current.data) {
				hasLeft = true;
				current = current.left;
			}else {
				hasLeft = false;
				current = current.right;
			}
		}
		if(parent == null) {
			return removeIterative(current);
		}
		if(hasLeft) {
			parent.left = removeIterative(current);
		}else {
			parent.right = removeIterative(current);
		}
		return root;
	}
	
	private TreeNode removeIterative(TreeNode node) {
		if(node!= null) {
			if(node.left == null && node.right == null) {
				return null;
			}
			if(node.left != null && node.right != null) {
				TreeNode inOrderSuccessor = removeInOrderSuccessorDuplicate(node);
				node.data = inOrderSuccessor.data;
			}else if(node.left != null) {
				node = node.left;
			}else {
				node = node.right;
			}
		}
		return node;
	}
	
	private TreeNode removeInOrderSuccessorDuplicate(TreeNode node) {
		TreeNode parent = node;
		node = node.right;
		boolean rightChild = node.left == null;
		while(node.left != null) {
			parent = node;
			node = node.left;
		}
		if(rightChild) {
			parent.right = node.right;
		}else {
			parent.left = node.right;
		}
		node.right = null;
		return node;
	}
	
	//validate bst
	
	public boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBSTUtil(TreeNode node, int min, int max) {
		//an empty tree is BST
		if(node == null) {
			return true;
		}
		//false if this node violates the min max constraints
		if((int)node.data < min || (int)node.data > max) {
			return false;
		}
		
		//else check the subtrees in a recursive manner tightening the min/max constraints
		return(isBSTUtil(node.left, min, (int)node.data - 1) && isBSTUtil(node.right, (int)node.data + 1, max));
	}
	
	
	
	
	
	public void printInOrderTraversal(TreeNode root) {
		if(root != null) {
			printInOrderTraversal(root.left);
			System.out.println(root.data + " ");
			printInOrderTraversal(root.right);
		}
	}

}
