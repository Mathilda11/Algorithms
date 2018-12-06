package test44;

/**
 * 把数字翻译成字符串
 * 给定一个数字，按照如下规则翻译成字符串：0 翻译成“a”，1 翻译成“b”... 25 翻译成“z”。
 * 一个数字有多种翻译可能，例如 12258 一共有 5 种，分别是 bccfi，bwfi，bczi，mcfi，mzi。实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 
 * 此种解法不能解决0开头的数字
 * @author 54060
 *
 */
public class Solution {
	/* dp=[1 1 _ _ _ _]  [  1 12 122 1225 12258]能翻译的种数
	 * s=12258
	 * i=2,one=2,dp[2]=dp[2]+dp[1]=1,two=12,dp[2]=dp[2]+dp[0]=2   12能翻译的种数=1翻译的种树+[if 1不为0 且 12<=26]  翻译的种数
	 * i=3,one=2,dp[3]=dp[3]+dp[2]=2,two=22,dp[3]=dp[3]+dp[1]=3   122能翻译的种数=12翻译的种数+ [if 2不为0 且 22<=26] 1翻译的种数
	 *                                                            1225能翻译的种数=122翻译的种数+[if 2不为0 且 25<=26] 12翻译的种数
	 *                                                            12258能翻译的种数=1225翻译的种数+[if 5不为0 且 58<=26] 122翻译的种数
	 *                                                            
	 * s=10258
	 * i=2,one=0,two=10,dp[2]=dp[2]+dp[0]=1
	 * i=2,one=2,dp[3]=dp[3]+dp[2]=1 退出本次循环
	 * 
	 */
	public int numDecodings(String s) {
	    if (s == null || s.length() == 0)
	        return 0;
	    int n = s.length();
	    int[] dp = new int[n + 1];
	    dp[0] = 1;
	    dp[1] = s.charAt(0) == '0' ? 0 : 1;
	    for (int i = 2; i <= n; i++) {
	        int one = Integer.valueOf(s.substring(i - 1, i));
	        if (one != 0)
	            dp[i] += dp[i - 1];
	        if (s.charAt(i - 2) == '0')
	            continue;
	        int two = Integer.valueOf(s.substring(i - 2, i));
	        if (two <= 26)
	            dp[i] += dp[i - 2];
	    }
	    return dp[n];
	}
}
