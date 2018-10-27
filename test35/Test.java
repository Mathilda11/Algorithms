package test35;

import test05.TreeNode;

public class Test {
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		String serialize = solution.Serialize(root);
		System.out.println(serialize);
		solution.Deserialize(new String("2 1 # # 3 # #"));
		
	}
}
