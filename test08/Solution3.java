package test08;
/**
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 * 
 * 把2*3的覆盖方法记为f(3)。有两种覆盖方法，横向或者是竖向。
 * 竖向：则剩下的就是2*2，记为f(2)；横向：则剩下的就是2*1，记为f(1)。因此f(3)=f(2)+f(1)。所以依次类推，找到迭代。
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
