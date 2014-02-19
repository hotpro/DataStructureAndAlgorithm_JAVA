package me.yutao.ds.tree;

public class BinarySearchTree {
	private Node root;

	public void insert(int key) {
		if (root == null) {
			root = new Node(key);
		} else {
			insert(key, root);
		}
		
	}
	
	private void insert(int key, Node node) {
		

		if (key > node.key) {
			if (node.right != null) {
				insert(key, node.right);
			} else {
				node.right = new Node(key);
				return;
			}
		} else if (key < node.key) {
			if (node.left != null) {
				insert(key, node.left);
			} else {
				node.left = new Node(key);
				return;
			}
		}
	}

	public void delete(int key) {
		if (root == null) {
			return;
		}
		
		Node current = root;
		Node parent = null;
		boolean isLeftChild = false;
		while (true) {
			
			
			if (key > current.key) {
				parent = current;
				current = current.right;
				isLeftChild = false;
			} else if (key < current.key) {
				parent = current;
				current = current.left;
				isLeftChild = true;
			} else {
				break;
			}
			if (current == null) {
				break;
			}
		}
		
		// not found
		if (current == null) {
			return;
		}
		
		// leaf
		if (current.left == null && current.right == null) {
			if (parent == null) {
				root = null;
			} else {
				if (isLeftChild) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}
		}
		
		// one child
		if (current.left == null && current.right != null) {
			if (parent == null) {
				root = root.right;
			} else {
				if (isLeftChild) {
					parent.left = current.right;
				} else {
					parent.right = current.right;
				}
			}
		}
		
		if (current.right == null && current.left != null) {
			if (parent == null) {
				root = current.left;
			} else {
				if (isLeftChild) {
					parent.left = current.left;
				} else {
					parent.right = current.left;
				}
			}
		}
		
		// two children
		if (current.left != null && current.right != null) {
			if (parent == null) {
				Node minRight = current.right;
				Node minRightParent = current;
				while (minRight.left != null) {
					minRightParent = minRight;
					minRight = minRight.left;
				}
				
				if (minRight.right != null) {
					minRightParent.left = minRight.right;
				}
				
				minRight.left = root.left;
				minRight.right = root.right;
				root = minRight;
			} else {
				Node minRight = current.right;
				Node minRightParent = current;
				while (minRight.left != null) {
					minRightParent = minRight;
					minRight = minRight.left;
				}
				
				if (minRight.right != null) {
					minRightParent.left = minRight.right;
				}
				
				minRight.left = parent.left;
				minRight.right = parent.right;
				if (isLeftChild) {
					parent.left = current.left;
				} else {
					parent.right = current.left;
				}
			}
		}
	}
	
//	private Node findMin(Node node) {
//		if (node == null) {
//			return null;
//		}
//		
//		
//		
//		return node;
//	}

	public boolean find(int key) {
		return find(key, root);
	}
	
	private boolean find(int key, Node node) {
		if (node == null) {
			return false;
		}
		
		if (key > node.key) {
			return find(key, node.right);
		} else if (key < node.key) {
			return find(key, node.left);
		} else {
			return true;
		}
		
	}

	public void traverse() {
		inOrderTraverse(root);
	}
	
	private void inOrderTraverse(Node node) {
		if (node != null) {
			inOrderTraverse(node.left);
			System.out.print(node.key);
			System.out.print("    ");
			inOrderTraverse(node.right);
		}
	}
	
	private static class Node {
		private int key;
		private Node left, right;
		
		private Node(int key) {
			this.key = key;
		}
	}

}
