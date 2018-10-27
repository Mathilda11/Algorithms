package test26;

import test05.TreeNode;

public class Test {
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		root.left = node1;
		root.right = node2;
		System.out.println(solution.isSymmetrical(root));

	}
}
