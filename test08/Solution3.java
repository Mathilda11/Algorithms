package test08;
/**
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 * 类似于青蛙跳台阶,当n=1时，只有一种横向排列的方式。当n等于二时，2*2有两种选择，横向或者是竖向。当n等于3的时候对于2*3来说,如果选择的是竖向排列，则剩下的就是2*2排列，如果选择的是横向,则对于2*n剩下的则只有1*n的一种选择。所以依次类推，找到迭代
 * @author 54060
 *
 */
public class Solution3 {
	public int RectCover(int n) {
	    if (n <= 2)
	        return n;
	    int pre2 = 1, pre1 = 2;
	    int result = 0;
	    for (int i = 3; i <= n; i++) {
	        result = pre2 + pre1;
	        pre2 = pre1;
	        pre1 = result;
	    }
	    return result;
	}
}
