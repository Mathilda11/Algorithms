package test35;
/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * @author 54060
 *
 */
import test05.TreeNode;
//# b表示空节点
public class Solution {
	private String deserializeStr; //全局变量
	
	//2 1 3
	public String Serialize(TreeNode root) {
	    if (root == null)//遇到空节点才返回
	        return "#";
	    return root.val + " " + Serialize(root.left) + " " + Serialize(root.right); //2 1 # # 3 # #
	}
	//反序列化：2 1 # # 3 # #
	public TreeNode Deserialize(String str) {
	    deserializeStr = str;
	    return Deserialize();
	}
/**
 * dS = 2 1 # # 3 # #     dS = 1 # # 3 # #        dS = # # 3 # #
 * node = 2               node = 1				  node = #
 * dS = 1 # # 3 # #       dS = # # 3 # #          dS = # 3 # #
 * t = 2			      t = 1                   return null
 * t.left = D()   ==>     t.left = D()      ==> 
 *        = t(1)                 = null     <==
 *                        t.right = D()     ==>   dS = # 3 # #, node = #, dS = 3 # #, return null
 *                                = null    <==
 *                        return t
 * t.right = D()
 * 
 * @return                      
 */
	private TreeNode Deserialize() {
	    if (deserializeStr.length() == 0)
	        return null;
	    int index = deserializeStr.indexOf(" ");
	    String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index); //取出一个节点
	    deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
	    if (node.equals("#"))
	        return null;
	    int val = Integer.valueOf(node);
	    TreeNode t = new TreeNode(val);
	    t.left = Deserialize();  //t.left = # t.right = # 返回null
	    t.right = Deserialize();
	    return t;
	}
}
