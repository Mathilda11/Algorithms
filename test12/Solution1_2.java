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
	        	//在n<8时，两种计算结果是相同的，因为dp[5]=6
	        	//当n=8时，上：dp[8]=dp[5]*3=18，下：dp[8]=4*4=16。
	        	//所以要保留dp[j]
	        	//在求dp[i]之前，对于每个j(0<j<i)而言，dp[j]都已经求解出来了，结果保存在dp[j]。
	            dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
	        	//dp[i] = Math.max(dp[i], (j * (i - j)));
	    return dp[n];
	}
}
