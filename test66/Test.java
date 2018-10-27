package test66;

import test05.TreeNode;

public class Test {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);
		TreeNode node3 = new TreeNode(10);
		TreeNode node4 = new TreeNode(28);
		root.left = node1;
		root.right = node2;
		node2.left = node3;
		node2.right = node4;
		
		Solution1 solution1 = new Solution1();
		System.out.println(solution1.lowestCommonAncestor(root, node3, node4).val);
		
		TreeNode root1 = new TreeNode(3);
		TreeNode node5 = new TreeNode(9);
		TreeNode node6 = new TreeNode(10);
		TreeNode node7 = new TreeNode(20);
		TreeNode node8 = new TreeNode(5);
		root1.left = node5;
		root1.right = node6;
		node6.left = node7;
		node6.right = node8;
		
		Solution2 solution2 = new Solution2();
		System.out.println(solution2.lowestCommonAncestor(root1, node7, node8).val);

	}
}
