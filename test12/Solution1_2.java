package test12;
/**
 * 
 * 把一根绳子剪成多段，并且使得每段的长度乘积最大。
 * @author 54060
 *
 */
public class Solution1_2 {
	public int integerBreak(int n) {
	    int[] dp = new int[n + 1];
	    dp[1] = 1;
	    for (int i = 2; i <= n; i++)
	        for (int j = 1; j < i; j++)
	            dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
	    return dp[n];
	}
}
