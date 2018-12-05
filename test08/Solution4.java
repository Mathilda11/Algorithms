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
/*	public int JumpFloorII(int target) {
        int[] dp = new int[target];
	    Arrays.fill(dp, 1);
	    for (int i = 1; i < target; i++){
	        for (int j = 0; j < i; j++){
	            dp[i] += dp[j];
            }
        }
	    return dp[target - 1];
	}*/
	/*
	 * 由于青蛙可以调到任意位置，故每个台阶都存在可能,就可以把n个台阶当做n块木板,最后一块木板是青蛙到达的位子,必须存在,

		其他n-1块木板可以任意选择是否存在,则每个木板有存在和不存在两种选择,n-1块木板就有
		
		2^(n-1)种。
	 */
	public int JumpFloorII(int target) {
			return 1 << --target;//2^(number-1)用位移操作进行，更快。(number-1)个2相乘，相当于1向左因为number-1
		}
	/*
	 * java中有三种移位运算符：

    “<<” : 左移运算符，等同于乘2的n次方
    “>>”: 右移运算符，等同于除2的n次方
    “>>>” 无符号右移运算符，不管移动前最高位是0还是1，右移后左侧产生的空位部分都以0来填充。与>>类似。 例： int a = 16; int b = a << 2;//左移2，等同于16 * 2的2次方，也就是16 * 4 int c = a >> 2;//右移2，等同于16 / 2的2次方，也就是16 / 4
	*/
	 
}
