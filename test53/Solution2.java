package test53;

import test05.TreeNode;

/**
 * 平衡二叉树
 * 平衡二叉树左右子树深度差不超过 1。
 * 如果我们从叶子节点开始遍历，一层一层往上遍历，那不就实现了每个节点只遍历一次了吗？
 * 思路：
 * 用后序遍历的方法遍历整棵二叉树。在遍历某节点的左、右子节点之后，可以根据它的左、右子节点的深度判断它是不是平衡的，并得到当前节点的深度。
 * 当最后遍历到树的根节点的时候，也就判断了整棵二叉树是不是平衡二叉树。
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
