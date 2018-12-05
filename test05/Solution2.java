package test05;
/**
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 
 * 思路：先根据前序遍历序列的第一个数字创建根节点，接下来在中序遍历序列中找到根节点的位置，这样就能确定左右子树的节点数量。
 * 在前序遍历和中序遍历序列中划分了左右子树节点的值之后，我们就可以递归地调用函数去分别构建它的左子树和右子树。
 * 
 * @author 54060
 */
public class Solution2 {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
         
        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);
         
        for(int i=startIn;i<=endIn;i++){
            if(in[i]==pre[startPre]){//i是中序根节点的下标
            	//左子树：前序的起始下标：前序的起始下标+1      前序的结束下标：前序的起始下标+（中序根节点的下标-中序起始下标）
            	//      中序的起始下标：中序的起始下标           中序的结束下标：中序根节点的下标-1
            	//右子树：前序的起始下标：前序的结束下标+1      前序的结束下标：前序的结束下标
            	//      中序的起始下标：中序根节点的下标+1  中序的结束下标：中序的结束下标
            	
            	//左子树长度=i-startIn  左子树的末尾=左子树起始+左子树长度
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }

    	}
        return root;
	}
}
