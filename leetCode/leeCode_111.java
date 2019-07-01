package leetCode;
/*
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
import test05.TreeNode;

public class leeCode_111 {
	public int minDepth(TreeNode root) {
	    if (root == null) return 0;
	    int left = minDepth(root.left);
	    int right = minDepth(root.right);
	    if (left == 0 || right == 0) return left + right + 1;
	    return Math.min(left, right) + 1;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(1);
		root.left = node1;
		root.right = node2;
		node2.left = node3;
		leeCode_111 leeCode_111 = new leeCode_111();
		System.out.println(leeCode_111.minDepth(root));
	}
}
