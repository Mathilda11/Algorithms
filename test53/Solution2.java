package test53;

import test05.TreeNode;

/**
 * 平衡二叉树
 * 平衡二叉树左右子树高度差不超过 1。
 * 如果我们从叶子节点开始遍历，一层一层往上遍历，那不就实现了每个节点只遍历一次了吗？
 * 思路开始形成了，我们要先遍历左右子树，再左右子树组成的这颗树是不是平衡二叉树。这不就是后序遍历吗！！！
 * @author 54060
 *
 */
public class Solution2 {
	private boolean isBalanced = true;

	public boolean IsBalanced_Solution(TreeNode root) {
	    height(root);
	    return isBalanced;
	}

	private int height(TreeNode root) {
	    if (root == null || !isBalanced) //如果已经不是平衡的，就不用再判断了。
	        return 0;
	    int left = height(root.left);
	    int right = height(root.right);
	    if (Math.abs(left - right) > 1)
	        isBalanced = false;
	    return 1 + Math.max(left, right); //下层的深度，上层可以接着用免得再遍历
	}
}
