package test17;
/**
 * 请实现一个函数用来匹配包括 '.' 和 '*' 的正则表达式。模式中的字符 '.' 表示任意一个字符，而 '*' 表示它前面的字符可以出现任意次（包含 0 次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串 "aaa" 与模式 "a.a" 和 "ab*ac*a" 匹配，但是与 "aa.a" 和 "ab*a" 均不匹配。
 * 
 * 分析:
 * https://blog.csdn.net/u011080472/article/details/51283717
 * @author 54060
 * 
 *
 */
public class Solution1_1 {
	/*
	 * 不要看 这个解法！！！
	 */
	public boolean match(char[] str, char[] pattern) {

	    int m = str.length, n = pattern.length;
	    boolean[][] dp = new boolean[m + 1][n + 1];

	    dp[0][0] = true;
	    for (int i = 1; i <= n; i++)
	        if (pattern[i - 1] == '*')
	            dp[0][i] = dp[0][i - 2];

	    for (int i = 1; i <= m; i++)
	        for (int j = 1; j <= n; j++)
	            if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
	                dp[i][j] = dp[i - 1][j - 1];
	            else if (pattern[j - 1] == '*')
	            	//如果pattern[j - 1]=='*'，说明pattern[j-2]可以出现0次，1次，若干次。
	            	//如果pattern[j-2]和str[i-1]相等，或者pattern[j-2]为任意字符'.'
	                if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
	                    dp[i][j] |= dp[i][j - 1]; // a* counts as single a 当前字符匹配成功，模式上移动两个字符
	                    dp[i][j] |= dp[i - 1][j]; // a* counts as multiple a 当前字符匹配成功，模式上保持不变
	                    dp[i][j] |= dp[i][j - 2]; // a* counts as empty 模式上移动两个字符，相当于忽略*和它前面的字符
	                } else
	                // 如果pattern[j-2]和str[i-1]不相等 
	                // 忽略'*'和它前面的字符
	                    dp[i][j] = dp[i][j - 2];   // a* only counts as empty

	    return dp[m][n];
	}
}
