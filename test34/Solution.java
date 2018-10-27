package test34;
/**
 * 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 方法二：递归版
 * 解题思路：
 * 1.将左子树构造成双链表，并返回链表头节点。
 * 2.定位至左子树双链表最后一个节点。
 * 3.如果左子树链表不为空的话，将当前root追加到左子树链表。
 * 4.将右子树构造成双链表，并返回链表头节点。
 * 5.如果右子树链表不为空的话，将该链表追加到root节点之后。
 * 6.根据左子树链表是否为空确定返回的节点。
 * @author 54060
 *
 */
import test05.TreeNode;

public class Solution {
	/**
	 * 排序的双向链表：中序：左中右
	 * 左子树：找到左子树的最后一个节点p
	 * 右子树：构造成双链表
	 */
    // 记录子树链表的最后一个节点，终结点只可能为只含左子树的非叶节点与叶节点
    protected TreeNode leftLast = null;
    public TreeNode Convert(TreeNode root) {
       if(root==null){//假如根节点为空，返回空
        return null;
    }
    if(root.left==null&&root.right==null){//假如只有一个根节点，则返回根节点
    	leftLast = root;// 最后的一个节点可能为最右侧的叶节点
        return root;
    }
    //1、将左子树构造成双链表，并返回该链表头结点left
    TreeNode left=Convert(root.left);
 
    //2、定位到左子树链表的最后一个节点（左子树最右边的节点）
    TreeNode p=left;//创建一个临时节点P,用来遍历找到左链表的最后一个节点(左子树最右边的节点)，p初始化指向做左子树的根节点，
    while(p!=null&&p.right!=null){
        p=p.right;//最终p为左子树最右边的节点
    }
    //3、如果左子树链表不为空，将当前root追加到左子树链表后
    if(left!=null){//左子树链表不为空
        p.right=root;//左子树链表的最后一个节点p（左子树最右边节点）的右指针指向当前root节点
        root.left=p;//当前root节点的左指针指向左子树链表的最后一个节点p（左子树最右边节点）
    }
    leftLast = root;// 当根节点只含左子树时，则该根节点为最后一个节点
    //4、将右子树构造成双链表，并返回该链表的头结点right
    TreeNode right=Convert(root.right);
 
    //5、如果右子树链表不为空，将右子树链表追加到当前root后
    if(right!=null){//右子树链表不为空
        right.left=root;//右子树链表的头结点right的左指针指向当前root
        root.right=right;//当前root的右指针指向右子树链表的头结点right
    }
    return left!=null?left:root;//根据左子树链表是否为空返回整个双向链表的头指针。    
    }
}
