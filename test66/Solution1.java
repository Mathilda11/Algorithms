package test66;

import test05.TreeNode;

/**
 * 树中两个节点的最低公共祖先
 * 二叉查找树
 * 
 * 二叉查找树中，两个节点 p, q 的公共祖先 root 满足 root.val >= p.val && root.val <= q.val。
 * @author 54060
 *
 */
public class Solution1 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    if (root == null)
	        return root;
	    if (root.val > p.val && root.val > q.val)
	        return lowestCommonAncestor(root.left, p, q);
	    if (root.val < p.val && root.val < q.val)
	        return lowestCommonAncestor(root.right, p, q);
	    return root;
	}
}
