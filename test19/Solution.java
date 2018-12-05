package test19;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 需要保证奇数和奇数，偶数和偶数之间的相对位置不变，这和书本不太一样。
 * @author 54060
 *
 */
public class Solution {
	public void reOrderArray(int[] nums) {
	    int oddCnt = 0; //奇数的个数
	    for (int val : nums)
	        if (isOdd(val))
	            oddCnt++;
	    int[] copy = nums.clone();
	    int i = 0, j = oddCnt; //有j个奇数。则偶数是从下标为j开始的。
	    for (int num : copy) {
	        if (isOdd(num))
	            nums[i++] = num;
	        else
	            nums[j++] = num;
	    }
	    
	}
	
	//定义函数来确定分组标准的目的是将解耦
	private boolean isOdd(int num){
		return (num & 1)==1;
	}
}
