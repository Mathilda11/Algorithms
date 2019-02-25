package leetCode;

import test05.TreeNode;

/**
 * 二叉查找树的第 K 个结点
 * 解题思路：利用二叉查找树中序遍历有序的特点。
 * @author 54060
 *
 */
public class offer1 {
	int count = 0; int K; 
	TreeNode kNode = null;
	TreeNode KthNode(TreeNode pRoot, int k){ 
		if(k==0) 
			return null; 
		K = k;
		KthNode(pRoot); 
		return kNode;
	}
	void KthNode(TreeNode root){ 
		if(root==null) 
			return;
	KthNode(root.left);
	count++; 
	if(count==K){
		kNode = root; 
		return; 
	}
	KthNode(root.right);
	}
	public static void main(String[] args) {
		offer1 offer1 = new offer1();
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(7);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(8);
		root.left = node1;
		root.right = node4;
		node1.left = node2;
		node2.right = node3;
		node4.left = node5;
		node4.right = node6;
		offer1.KthNode(root, 3);
		
	}
}
