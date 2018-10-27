package test34;

import test05.TreeNode;

public class Test {
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode treeNode = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		treeNode2.left = treeNode;
		treeNode2.right = treeNode3;
		TreeNode node = solution.Convert(treeNode2);
		System.out.println(node.val);
		System.out.println(node.right.val);
		System.out.println(node.right.right.val);
		
		System.out.println(node.right.left.val);

	}
}
