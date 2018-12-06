package test53;

import test05.TreeNode;

/**
 * 二叉树的深度
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @author 54060
 *
 */
public class Solution1 {
	public int TreeDepth(TreeNode root) {
		//如果一棵树只有一个节点，那么它的深度为1。
		//如果根节点只有左子树而没有右子树，那么树的深度应该是其左子树的深度+1。
		//如果根节点既有左子树又有右子树，那么树的深度就是其左、右子树深度的较大值+1。
	    return root == null ? 0 : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
	}
}
