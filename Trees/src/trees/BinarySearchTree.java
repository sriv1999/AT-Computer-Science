package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	private TreeNode root;

	public BinarySearchTree() {
		root = null;
	}

	public void add(Comparable val) {
		root = add(val, root);
	}

	private TreeNode add(Comparable val, TreeNode tree) {
		if (tree == null)
			return new TreeNode(val);

		Comparable treeValue = tree.getValue();
		int dirTest = val.compareTo(treeValue);

		if (dirTest <= 0)
			tree.setLeft(add(val, tree.getLeft()));
		else if (dirTest > 0)
			tree.setRight(add(val, tree.getRight()));

		return tree;
	}

	public void inOrder() {
		inOrder(root);
		System.out.println("\n\n");
	}

	private void inOrder(TreeNode tree) {
		if (tree != null) {
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	public void preOrder() {
		preOrder(root);
		System.out.println("\n\n");
	}

	private void preOrder(TreeNode tree) {
		if (tree != null) {
			System.out.print(tree.getValue() + " ");
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}

	public void postOrder() {
		postOrder(root);
		System.out.println("\n\n");
	}

	private void postOrder(TreeNode tree) {
		if (tree != null) {
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
		}
	}

	public void revOrder() {
		revOrder(root);
		System.out.println("\n\n");
	}

	private void revOrder(TreeNode tree) {
		if (tree != null) {
			revOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
			revOrder(tree.getLeft());
		}
	}

	public int getNumLevels() {
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode tree) {
		if (tree == null)
			return 0;
		else if (getNumLevels(tree.getLeft()) > getNumLevels(tree.getRight()))
			return 1 + getNumLevels(tree.getLeft());
		else
			return 1 + getNumLevels(tree.getRight());
	}

	public int getNumLeaves() {
		return getNumLeaves(root);
	}

	private int getNumLeaves(TreeNode tree) {
		if (tree != null) {
			if (tree.getLeft() == null && tree.getRight() == null)
				return 1;
			else
				return getNumLeaves(tree.getLeft()) + getNumLeaves(tree.getRight());
		} else
			return 0;
	}

	public int getWidth() {
		return 1 + getNumLevels(root.getRight()) + getNumLevels(root.getLeft());
	}

	public int getHeight() {
		return getHeight(root) - 1;
	}

	private int getHeight(TreeNode tree) {
		if (tree == null)
			return 0;
		else if (getHeight(tree.getLeft()) > getHeight(tree.getRight()))
			return 1 + getHeight(tree.getLeft());
		else
			return 1 + getHeight(tree.getRight());
	}

	public int getNumNodes() {
		return getNumNodes(root);
	}

	private int getNumNodes(TreeNode tree) {
		if (tree == null)
			return 0;
		else
			return 1 + getNumNodes(tree.getLeft()) + getNumNodes(tree.getRight());
	}

	public boolean isFull() {
		return isFull(root);
	}

	private boolean isFull(TreeNode tree) {
		if (tree != null) {
			if (tree.getLeft() != null && tree.getRight() == null)
				return false;
			else if (tree.getLeft() == null && tree.getRight() != null)
				return false;
			else
				return isFull(tree.getLeft()) && isFull(tree.getRight());
		} else
			return true;
	}

	public boolean search(TreeNode tree) {
		return search(tree, root);
	}

	private boolean search(TreeNode tree, TreeNode other) {
		if (other == null)
			return false;
		else if (other.getValue() == tree.getValue())
			return true;
		else
			return (search(tree, other.getLeft()) || search(tree, other.getRight()));
	}

	public TreeNode smallest() {
		return smallest(new TreeNode(Integer.MAX_VALUE), root);
	}

	private TreeNode smallest(TreeNode small, TreeNode current) {
		if (current == null)
			return small;
		else if (current.getValue().compareTo(small.getValue()) < 0) {
			TreeNode left = smallest(current, current.getLeft());
			TreeNode right = smallest(current, current.getRight());
			if (right.getValue().compareTo(left.getValue()) < 0)
				return right;
			else
				return left;
		} else {
			TreeNode left = smallest(small, current.getLeft());
			TreeNode right = smallest(small, current.getRight());
			if (right.getValue().compareTo(left.getValue()) < 0)
				return right;
			else
				return left;
		}
	}

	public TreeNode largest() {
		return largest(new TreeNode(Integer.MIN_VALUE), root);
	}

	private TreeNode largest(TreeNode large, TreeNode current) {
		if (current == null)
			return large;
		else if (current.getValue().compareTo(large.getValue()) > 0) {
			TreeNode left = largest(current, current.getLeft());
			TreeNode right = largest(current, current.getRight());
			if (right.getValue().compareTo(left.getValue()) > 0)
				return right;
			else
				return left;
		} else {
			TreeNode left = largest(large, current.getLeft());
			TreeNode right = largest(large, current.getRight());
			if (right.getValue().compareTo(left.getValue()) > 0)
				return right;
			else
				return left;
		}
	}

	public Queue<TreeNode> levelOrder() {
		Queue<TreeNode> l = new LinkedList<TreeNode>();
		l.add(root);
		return levelOrder(l, root.getLeft(), root.getRight());
	}

	private Queue<TreeNode> levelOrder(Queue<TreeNode> l, TreeNode left, TreeNode right) {
		if (left != null) {
			l.add(left);
			if (right != null)
				l.add(right);
			levelOrder(l, left.getLeft(), left.getRight());
			return l;
		}
		
		if (right != null){
			l.add(right);
			levelOrder(l, right.getLeft(), right.getRight());
		}
		return l;
	}

	public TreeNode removeNode(TreeNode tree) {
		
		Queue<TreeNode> list = levelOrder(); // get list of nodes
		Queue<TreeNode> temp = new LinkedList<TreeNode>(); // temp list
		TreeNode t = new TreeNode(); // node to use temporarily
		while (!list.isEmpty()) { // go through entire list
			t = list.poll(); // pull off each element
			if (tree.getValue() != t.getValue()) // add everything to temp
													// except one to remove
				temp.add(t);
		}
		
		while (!temp.isEmpty()) // add back to list
			list.add(temp.poll());
		
		if (root.getValue() != tree.getValue()) { // if root is not removed
			root = new TreeNode(root.getValue()); // new node with root value
			while (!list.isEmpty()) {// add everything else back in
				t = list.poll();
				if (t.getValue() != root.getValue())
					add(t.getValue());
			}
		}
		else if (root.getValue() == tree.getValue()) { // if root is removed

			if (root.getRight() != null) {
				t = root.getRight();
				while (t.getLeft() != null) {
					t = t.getLeft();
				}
				root = new TreeNode(t.getValue(), null, null);
			}
			while (!list.isEmpty()) { // add everything else back in
				t = list.poll();
				if (t.getValue() != root.getValue() && t.getValue() != tree.getValue()) {
					add(t.getValue());
				}
			}
		}

		return tree;
	}

	public void displayTree() {
		Queue<TreeNode> one = levelOrder();
		int numLevel = getNumLevels();
		int count = 0;
		int oldTabs = 0;
		int tempTabs = 0;
		for (int i = numLevel; i > 0; i--) {
			int numTabs = (int) Math.pow(2, i - 1) - 1;
			while (numTabs > 0) {
				System.out.print("\t");
				numTabs--;
			}
			
			System.out.print(one.poll().getValue());
			int numInt = (int) Math.pow(2, count) - 1;
			while (numInt > 0) {
				tempTabs = oldTabs;
				while (tempTabs > 0) {
					System.out.print("\t");
					tempTabs--;
				}
				if(!one.isEmpty())
					System.out.print(one.poll().getValue());
				numInt--;
			}
			oldTabs = (int) Math.pow(2, i - 1);
			count++;
			System.out.println();
		}
	}

	public String toString() {
		return toString(root);
	}

	private String toString(TreeNode tree) {
		String result = "";
		if (tree != null) {
			result += toString(tree.getLeft());
			result += tree.getValue() + " ";
			result += toString(tree.getRight());
		}
		return result;
	}

	public static void main(String[] args) {
		BinarySearchTree test = new BinarySearchTree();
		test.add(10);
		test.add(9);
		test.add(8);
		test.add(7);
		test.add(6);
		test.add(5);
		test.add(4);

		System.out.println("IN ORDER");
		test.inOrder();
		System.out.println("PRE ORDER");
		test.preOrder();
		System.out.println("POST ORDER");
		test.postOrder();
		System.out.println("REVERSE ORDER");
		test.revOrder();

		System.out.println("Tree height is " + test.getHeight());
		System.out.println("Tree width is " + test.getWidth());
		System.out.println("Number of leaves is " + test.getNumLeaves());
		System.out.println("Number of nodes is " + test.getNumNodes());
		System.out.println("Number of levels is " + test.getNumLevels());
		System.out.println("Tree as a string " + test.toString());
		if (test.isFull())
			System.out.println("The tree is full");
		else if (!test.isFull())
			System.out.println("The tree is not full");
		System.out.println();

		if (test.search(new TreeNode(10)))
			System.out.println("The tree contains 10!");
		else
			System.out.println("The tree does not contain 10!");

		if (test.search(new TreeNode(11)))
			System.out.println("The tree contains 11!");
		else
			System.out.println("The tree does not contain 11!");

		System.out.println("The smallest tree node: " + test.smallest().getValue());
		System.out.println("The largest tree node: " + test.largest().getValue());

		System.out.println();
		System.out.println("Tree before removing any nodes - using level order traversal.");
		for (TreeNode e : test.levelOrder()) {
			System.out.print(e.getValue() + " ");
		}
		
		System.out.println();
		test.removeNode(new TreeNode(9));
		System.out.println();
		System.out.println("Tree after removing 9.");
		for (TreeNode e : test.levelOrder()) {
			System.out.print(e.getValue() + " ");
		}
		
		System.out.println();
		test.removeNode(new TreeNode(7));
		System.out.println();
		System.out.println("Tree after removing 7.");
		for (TreeNode e : test.levelOrder()) {
			System.out.print(e.getValue() + " ");
		}
		
		System.out.println();
		test.removeNode(new TreeNode(8));
		System.out.println();
		System.out.println("Tree after removing 8.");
		for (TreeNode e : test.levelOrder()) {
			System.out.print(e.getValue() + " ");
		}
		
		System.out.println();
		test.removeNode(new TreeNode(6));
		System.out.println();
		System.out.println("Tree after removing 6.");
		for (TreeNode e : test.levelOrder()) {
			System.out.print(e.getValue() + " ");
		}
		
		System.out.println();
		test.removeNode(new TreeNode(5));
		System.out.println();
		System.out.println("Tree after removing 5.");
		for (TreeNode e : test.levelOrder()) {
			System.out.print(e.getValue() + " ");
		}
		
		System.out.println();
		test.removeNode(new TreeNode(4));
		System.out.println();
		System.out.println("Tree after removing 4.");
		for (TreeNode e : test.levelOrder()) {
			System.out.print(e.getValue() + " ");
		}
		
		System.out.println();
		test.removeNode(new TreeNode(3));
		System.out.println();
		System.out.println("Tree after removing 3.");
		for (TreeNode e : test.levelOrder()) {
			System.out.print(e.getValue() + " ");
		}
	}
}