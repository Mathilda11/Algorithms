package test32;

/**
 * 二叉树和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 下图的二叉树有两条和为 22 的路径：10, 5, 7 和 10, 12
 * @author 54060
 *
 */
import java.util.ArrayList;

import test05.TreeNode;

public class Solution {
	private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
	    backtracking(root, target, new ArrayList<Integer>());
	    return ret;
	}

	private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
	    if (node == null)
	        return;
	    path.add(node.val);
	    target -= node.val;
	    if (target == 0 && node.left == null && node.right == null) {
	        ret.add(new ArrayList<>(path));
	    } else {
	        backtracking(node.left, target, path);
	        backtracking(node.right, target, path);
	    }
	   //移除最后一个元素,深度遍历完一条路径后要回退递.归到叶子节点如果还没有找到路径，就要回退到父节点继续寻找，依次类推
	    path.remove(path.size() - 1);
	}
}
