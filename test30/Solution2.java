package test30;
/**
 * 把二叉树打印成多行
 * @author 54060
 *
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import test05.TreeNode;

public class Solution2 {
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
	    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();//ArrayList嵌套 多行列表
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.add(pRoot);
	    while (!queue.isEmpty()) {
	        ArrayList<Integer> list = new ArrayList<>(); //每行一个集合，如何保证？cnt保证有queue中的cnt个节点共用一个集合
	        int cnt = queue.size();
	        while (cnt-- > 0) {
	            TreeNode node = queue.poll();
	            if (node == null)
	                continue;
	            list.add(node.val);
	            queue.add(node.left);
	            queue.add(node.right);
	        }
	        if (list.size() != 0){
	            ret.add(list);
	            //如果要求：
	            //1 
	            //2 3
	            //4 5 7
	            for (int i : list) {
			System.out.print(i+" "); //一行中，各元素，空一格
		    }
	            System.out.println(); //换行
	        }
	          
	    }
	    return ret;
	}
}
