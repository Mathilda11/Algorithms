package test08;

/**
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 
 * 
 * f(1) = 1
 * 
 * f(2) = f(2-1) + f(2-2)         //f(2-2) 表示2阶一次跳2阶的次数。
 * 
 * f(3) = f(3-1) + f(3-2) + f(3-3) 
 * 
 * ...
 * 
 * f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-(n-1)) + f(n-n)  => f(0) + f(1) + f(2) + f(3) + ... + f(n-1) 
 * f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) 
 * 所以 f(n) = 2*f(n-1) (n>=2)
 * @author 54060
 *
 */

import java.util.Arrays;

public class Solution4 {
	public int JumpFloorII(int target) {
        int[] dp = new int[target];
	    Arrays.fill(dp, 1);
	    for (int i = 1; i < target; i++){
	        for (int j = 0; j < i; j++){
	            dp[i] += dp[j];
            }
        }
	    return dp[target - 1];
	}
}
