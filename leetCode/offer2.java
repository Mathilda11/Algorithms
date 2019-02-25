package leetCode;

import test05.TreeNode;

public class offer2 {
	String Serialize(TreeNode root){ 
		StringBuilder sb = new StringBuilder(); 
		if(root!=null){ 
			sb.append(root.val+","); //不能 +','，因为返回的是整数 
			sb.append(Serialize(root.left)); 
			sb.append(Serialize(root.right)); 
			} 
		else 
			sb.append("#,");
	return sb.toString();
	}
	
	int index = -1; 
	TreeNode Deserialize(String str){
		String[] strs = str.split(","); 
		return Deserialize(strs);
	}
	//返回子树根节点 
	TreeNode Deserialize(String[] strs){
		index++; 
			TreeNode root = null;
		if(!strs[index].equals("#")){ 
			root = new TreeNode(Integer.valueOf(strs[index])); 
			root.left = Deserialize(strs); 
			root.right = Deserialize(strs);
		} 
	return root;
	}
	
	public static void main(String[] args) {
		offer2 offer2 = new offer2();
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
		String str = offer2.Serialize(root);
		System.out.println(str);
		TreeNode treeNode = offer2.Deserialize(str);
		System.out.println(treeNode.left.val);
		System.out.println(treeNode.right.val);
	}

}
