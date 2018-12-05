package test08;

/**
 * 求斐波那契数列的第 n 项。。
 * 
 * @author 54060
 *
 */

public class Solution1 {
	/**
	 * 如果待求解的 n 小于 40，因此可以将前 40 项的结果先进行计算，之后就能以 O(1) 时间复杂度得到第 n 项的值了。
	 */
/*	private int[] fib = new int[40];

    public Solution1() {
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++)
            fib[i] = fib[i - 1] + fib[i - 2];
    }

    public int Fibonacci(int n) {
        return fib[n];
    }*/
    
	
	 /* 动态规划会把子问题的解缓存起来，从而避免重复求解子问题。
	 * 考虑到第 i 项只与第 i-1 和第 i-2 项有关，因此只需要存储前两项的值就能求解第 i项，
	 * 从而将空间复杂度由 O(n)降低为 O(1)。
	 * 时间复杂度O(n)。
	 * 
	 */
	public int Fibonacci(int n) {
		    if (n <= 1)
		        return n;
		    int pre2 = 0, pre1 = 1;
		    int fib = 0;
		    for (int i = 2; i <= n; i++) {
		        fib = pre2 + pre1;
		        pre2 = pre1;
		        pre1 = fib;
		    }
		    return fib;
	  }
}
