package test05;

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