package test31;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。假设输入的数组的任意两个数字都互不相同。
 * 
 * 于一个二叉树的后序遍历序列来说，最后一个数一定是根节点，然后前面的数中，从最开始到第一个大于根节点的数-1都是左子树中的数，
 * 而第一个大于根节点的数到倒数第二个数应该都是大于根节点的，是右子树，如果后面的数中有小于根节点的，那么说明这个序列不是二叉搜索树的后序遍历序列
 * @author 54060
 *
 */
public class Solution {
	public boolean VerifySquenceOfBST(int[] sequence) {
	    if (sequence == null || sequence.length == 0)
	        return false;
	    return verify(sequence, 0, sequence.length - 1);
	}
	//后序遍历 ： 左 右 根 不一定是完全二叉树 可能只有左子树或者是右子树
	private boolean verify(int[] sequence, int first, int last) {
	    if (last - first <= 1)
	        return true;
	    int rootVal = sequence[last];  //若是后序遍历，根结点必是最后一个结点
	    int cutIndex = first;
	    while (cutIndex < last && sequence[cutIndex] <= rootVal)
	        cutIndex++;
	    //此时得到的cutIndex是小于根节点的个数+一个大于根节点的个数。
	    for (int i = cutIndex; i < last; i++)
	        if (sequence[i] < rootVal)  //右子树中有比根节点小的，则违背了二叉搜索树的定义。
	            return false;
	    return verify(sequence, first, cutIndex - 1) && verify(sequence, cutIndex, last - 1);//左子树和右子树都是二叉搜索树才返回true
	}
}
