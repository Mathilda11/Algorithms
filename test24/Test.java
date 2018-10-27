package test24;

import test05.TreeNode;

public class Test {
	public static void main(String[] args) {
		TreeNode treeLinkNode = new TreeNode(3);
		TreeNode treeLinkNode2 = new TreeNode(9);
		TreeNode treeLinkNode3 = new TreeNode(20);
		TreeNode treeLinkNode4 = new TreeNode(15);
		TreeNode treeLinkNode5 = new TreeNode(7);
		treeLinkNode.left = treeLinkNode2;
		treeLinkNode.right = treeLinkNode3;
		treeLinkNode3.left = treeLinkNode4;
		treeLinkNode3.right = treeLinkNode5;
		
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		node3.left = node4;
		node3.right = node5;
		
		Solution solution = new Solution();
		System.out.println(solution.HasSubtree(treeLinkNode, node3));
	}
}
