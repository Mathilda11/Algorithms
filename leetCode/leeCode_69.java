package leetCode;

/**
 * 求开方。
 * Input: 4
 * Output: 2
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
 * @author 54060
 *
 */
public class leeCode_69 {
	public int mySqrt(int x) { //x=8
	    if (x <= 1) {
	        return x;
	    }
	    int l = 1, h = x;
	    // l m h s
	    // 1 4 8 2
	    // 1 2 3 4
	    // 3 3 3 2
	    //     2
	    //此时应该返回2而不是3，即返回h而不是l。
	    while (l <= h) {
	        int mid = l + (h - l) / 2;
	        int sqrt = x / mid;
	        if (sqrt == mid) {
	            return mid;
	        } else if (mid > sqrt) {
	            h = mid - 1;
	        } else {
	            l = mid + 1;
	        }
	    }
	    return h;
	}
}
