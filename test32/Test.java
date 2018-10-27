package test32;

import java.util.ArrayList;

import test05.TreeNode;

public class Test {
	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(10);
		TreeNode treeNode1 = new TreeNode(5);
		TreeNode treeNode2 = new TreeNode(12);
		treeNode.left = treeNode1;
		treeNode.right = treeNode2;
		
		TreeNode treeNode3 = new TreeNode(4);
		TreeNode treeNode4 = new TreeNode(7);
		treeNode1.left = treeNode3;
		treeNode1.right = treeNode4;
		Solution solution = new Solution();
		ArrayList<ArrayList<Integer>> findPath = solution.FindPath(treeNode, 22);
		for (ArrayList<Integer> arrayList : findPath) {
			for (Integer i : arrayList) {
				System.out.println(i);
			}
			System.out.println("---------");
		}

	}
}
