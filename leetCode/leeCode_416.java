package leetCode;

import java.util.Arrays;

public class leeCode_416 {
	public boolean canPartition(int[] nums) {
	    int sum = computeArraySum(nums);
	    if (sum % 2 != 0) {
	        return false;
	    }
	    int W = sum / 2;
	    boolean[] dp = new boolean[W + 1];
	    dp[0] = true;
	    Arrays.sort(nums);
	    for (int num : nums) {                 // 0-1 背包一个物品只能用一次
	        for (int i = W; i >= num; i--) {   // 从后往前，先计算 dp[i] 再计算 dp[i-num]
	            dp[i] = dp[i] || dp[i - num];
	        }
	    }
	    return dp[W];
	}

	private int computeArraySum(int[] nums) {
	    int sum = 0;
	    for (int num : nums) {
	        sum += num;
	    }
	    return sum;
	}
	
	public static void main(String[] args) {
		leeCode_416 leeCode_416 = new leeCode_416();
		int[] nums = {4,5,5,10};
		leeCode_416.canPartition(nums);
	}
}
