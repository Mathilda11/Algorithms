package test52;
/**
 * 二叉查找树的第 K 个结点
 * 解题思路：利用二叉查找树中序遍历有序的特点。
 * @author 54060
 *
 */
import test05.TreeNode;

public class Solution {
	private TreeNode ret;
	private int cnt = 0; //计数器

	public TreeNode KthNode(TreeNode pRoot, int k) {
	    inOrder(pRoot, k);
	    return ret;
	}
	
	/**
	 * {1,2,4,5,6}中序遍历 inOrder(2,3)
	 * 递归调用没有返回值 接着下一行运行
	 * 
	 * inOrder(1,3) ==> inOrder(null,3) return; cnt=1; inOrder(null,3) ==> return;
	 * cnt=2;
	 * inOrder(5,3) ==> inOrder(4,3) return; cnt=3; ret=root;
	 *                  
	 * @param root
	 * @param k
	 */
	private void inOrder(TreeNode root, int k) {
	    if (root == null || cnt >= k)
	        return; //结束方法的执行
	    inOrder(root.left, k);
	    cnt++;
	    if (cnt == k)
	        ret = root;
	    inOrder(root.right, k);
	}
}
