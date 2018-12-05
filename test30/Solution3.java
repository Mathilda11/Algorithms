package test30;
/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * @author 54060
 *
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import test05.TreeNode;

public class Solution3 {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
	    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
	    Queue<TreeNode> queue = new LinkedList<>(); //节点按先进先出排序
	    queue.add(pRoot);
	    boolean reverse = false; //用来控制左->右、右->左。
	    while (!queue.isEmpty()) {
	        ArrayList<Integer> list = new ArrayList<>();  //每行一个集合
	        int cnt = queue.size();
	        while (cnt-- > 0) {
	            TreeNode node = queue.poll();
	            if (node == null)
	                continue;
	            list.add(node.val);
	            queue.add(node.left);
	            queue.add(node.right);
	        }
	        if (reverse)
	            Collections.reverse(list);
	        reverse = !reverse;  //每行遍历完，取反。
	        if (list.size() != 0)
	            ret.add(list);
	    }
	    return ret;
	}
}
