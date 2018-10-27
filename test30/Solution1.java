package test30;
/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 例如，以下二叉树层次遍历的结果为：1,2,3,4,5,6,7
 * 
 * 思路：使用队列来进行层次遍历。
 * 不需要使用两个队列分别存储当前层的节点和下一层的节点，
 * 因为在开始遍历一层的节点时，当前队列中的节点数就是当前层的节点数，只要控制遍历这么多节点数，就能保证这次遍历的都是当前层的节点。
 * @author 54060
 *
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import test05.TreeNode;

public class Solution1 {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
	    Queue<TreeNode> queue = new LinkedList<>();
	    ArrayList<Integer> ret = new ArrayList<>();
	    queue.add(root);
	    while (!queue.isEmpty()) { //在一个循环内加入在同一行的节点
	        int cnt = queue.size();
	        while (cnt-- > 0) {
	            TreeNode t = queue.poll();
	            if (t == null)
	                continue;
	            ret.add(t.val);
	            queue.add(t.left);
	            queue.add(t.right);
	        }
	    }
	    return ret;
	}
}
