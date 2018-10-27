package test24;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author 54060
 *
 */
import test05.TreeNode;

public class Solution {
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
	    if (root1 == null || root2 == null)
	        return false;
	    return isSubtreeWithRoot(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
	}

	private boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
	    if (root2 == null)
	        return true;
	    if (root1 == null)
	        return false;
	    if (root1.val != root2.val)
	        return false;
	    //相等之后才会继续判断子节点 如果子节点为空 则说明所有节点比较完毕
	    return isSubtreeWithRoot(root1.left, root2.left) && isSubtreeWithRoot(root1.right, root2.right);
	}
}
