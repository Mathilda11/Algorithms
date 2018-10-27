package test53;

import test05.TreeNode;
import test53.Solution2;

public class Test {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node5 = new TreeNode(5);
		TreeNode node4 = new TreeNode(4);
		TreeNode node6 = new TreeNode(6);
		root.left = node1;
		root.right = node5;
		node5.left = node4;
		node5.right = node6;
		Solution2 solution = new Solution2();
		System.out.println(solution.IsBalanced_Solution(root));
	}
}
