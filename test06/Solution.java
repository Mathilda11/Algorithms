package test06;
/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 
 * 1.该节点有右子树
 * 直接将其右节点进行中序遍历即可，并将一个遍历到的最右节点返回.
 * 2.该节点没有右子树
 * 第二种情况又分为两种情况
 * 该节点是父节点的左子节点：
 * 直接将父节点返回即可
 * 该节点是父节点的右子节点：
 * 需要不断的向上移动，直到对应的节点不是父节点的右节点（即左节点），既然他是父节点的左节点，此时将这个节点父节点返回即可。
 * 或者遍历到了根节点，返回null。
 * @author 54060
 *
 */
public class Solution {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
	    if (pNode.right != null) {
	        TreeLinkNode node = pNode.right;
	        while (node.left != null)//如果右节点有左子节点，则继续遍历，找到最下面的左节点
	            node = node.left;
	        return node;//如果右子节点没有左子节点，那么该右子节点就是下一个节点
	    } else {
	        while (pNode.next != null) {
	            TreeLinkNode parent = pNode.next; //next指向父节点
	            System.out.println(parent.val);
	            if (parent.left == pNode) //该节点是父节点的左子节点，直接返回父节点
	                return parent;
	            pNode = pNode.next;
	        }
	    }
	    return null;
	}
}
