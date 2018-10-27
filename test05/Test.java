package test05;

public class Test {

	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder =  {9,3,15,20,7};
		Solution solution = new Solution();
		TreeNode treeNode = solution.reConstructBinaryTree(preorder, inorder);
	}

}
