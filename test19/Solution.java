package test19;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 需要保证奇数和奇数，偶数和偶数之间的相对位置不变，这和书本不太一样。
 * @author 54060
 *
 */
public class Solution {
	public void reOrderArray(int[] nums) {
	    // 奇数个数
	    int oddCnt = 0;
	    for (int val : nums)
	        if (val % 2 == 1)
	            oddCnt++;
	    int[] copy = nums.clone();
	    int i = 0, j = oddCnt;
	    for (int num : copy) {
	        if (num % 2 == 1)
	            nums[i++] = num;
	        else
	            nums[j++] = num;
	    }
	}

}
