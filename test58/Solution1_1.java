package test58;
/**
 * n 个骰子的点数
 * 把 n 个骰子扔在地上，求点数和为 s 的概率。
 * 
 * 动态规划解法（分阶段求解决策问题的数学思想）
 * 使用一个二维数组 dp 存储点数出现的次数，其中 dp[i][j] 表示前 i 个骰子产生点数 j 的次数。
 * 1.现在变量有：骰子个数，点数和。当有k个骰子，点数和为n时，出现次数记为f(k,n)。那与k-1个骰子阶段之间的关系是怎样的？
 * 
 * 2.当我有k-1个骰子时，再增加一个骰子，这个骰子的点数只可能为1、2、3、4、5或6。那k个骰子得到点数和为n的情况有：
 * 
 * (k-1,n-1)：第k个骰子投了点数1
 * 
 * (k-1,n-2)：第k个骰子投了点数2
 * 
 * (k-1,n-3)：第k个骰子投了点数3
 * 
 * ....
 * 
 * (k-1,n-6)：第k个骰子投了点数6

 * 在k-1个骰子的基础上，再增加一个骰子出现点数和为n的结果只有这6种情况！
 * 
 * 所以：f(k,n)=f(k-1,n-1)+f(k-1,n-2)+f(k-1,n-3)+f(k-1,n-4)+f(k-1,n-5)+f(k-1,n-6)
 * 
 * 3.有1个骰子，f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1。
 * 
 * 
 * 那代码就容易写了，递归函数，返回和为n出现的次数。所有的和出现次数总和为6^n。
 * @author 54060
 *
 */
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution1_1 {
	public List<Map.Entry<Integer, Double>> dicesSum(int n) {
	    final int face = 6;
	    final int pointNum = face * n;
	    long[][] dp = new long[n + 1][pointNum + 1];

	    for (int i = 1; i <= face; i++)
	        dp[1][i] = 1;

	    for (int i = 2; i <= n; i++)
	        for (int j = i; j <= pointNum; j++)     /* 使用 i 个骰子最小点数为 i */
	            for (int k = 1; k <= face && k <= j; k++)
	                dp[i][j] += dp[i - 1][j - k];

	    final double totalNum = Math.pow(6, n);
	    List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
	    for (int i = n; i <= pointNum; i++)
	        ret.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / totalNum));

	    return ret;
	}
}
