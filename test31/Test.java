package test31;

import test05.TreeNode;

public class Test {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		Solution solution = new Solution();
		int[] sequence = {2,1,3};
		System.out.println(solution.VerifySquenceOfBST(sequence));
	}
}
