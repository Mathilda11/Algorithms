package leetCode;

import java.util.ArrayList;
import java.util.List;

import test05.TreeNode;

/**
 * 输出二叉树中所有从根到叶子节点的路径。
 * @author 54060
 *
 */
public class leeCode_257 {
	public List<String> binaryTreePaths(TreeNode root) {
	    List<String> paths = new ArrayList<>();
	    if (root == null) {
	        return paths;
	    }
	    List<Integer> values = new ArrayList<>();
	    backtracking(root, values, paths);
	    return paths;
	}

	private void backtracking(TreeNode node, List<Integer> values, List<String> paths) {
	    if (node == null) {
	        return;
	    }
	    values.add(node.val);
	    if (isLeaf(node)) {
	        paths.add(buildPath(values));
	    } else {
	        backtracking(node.left, values, paths);
	        backtracking(node.right, values, paths);
	    }
	    values.remove(values.size() - 1);//删除集合的最后一个节点，即回退到上一节点。
	}

	private boolean isLeaf(TreeNode node) {
	    return node.left == null && node.right == null;
	}

	private String buildPath(List<Integer> values) {
	    StringBuilder str = new StringBuilder();
	    for (int i = 0; i < values.size(); i++) {
	        str.append(values.get(i));
	        if (i != values.size() - 1) {
	            str.append("->");
	        }
	    }
	    return str.toString();
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(3);
		root.left = node1;
		node1.left = node2;
		root.right = node3;
		leeCode_257 leeCode_257 = new leeCode_257();
		leeCode_257.binaryTreePaths(root);
	}
}
