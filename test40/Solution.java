package test40;

/**
 * 连续子数组的最大和
 * {6, -3, -2, 7, -15, 1, 2, 2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）。
 * @author 54060
 *
 */
public class Solution {
	public int FindGreatestSumOfSubArray(int[] nums) {
	    if (nums == null || nums.length == 0)//考虑无效的输入
	        return 0;
	    int greatestSum = Integer.MIN_VALUE;//用来记录前面已经求和过的最大值
	    int sum = 0;
	    for (int val : nums) {
	        sum = sum <= 0 ? val : sum + val; //sum记录上次求和之后的，如果前面的和小于等于0，则重新计算后面的连续子数组
	        greatestSum = Math.max(greatestSum, sum);//将前面求和过的最大值和新的连续子数组的和比较，greatestSum记录目前为止的最大的连续和。
	    }
	    return greatestSum;
	}
}
