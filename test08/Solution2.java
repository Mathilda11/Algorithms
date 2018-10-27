package test08;

/**
 * 一只青蛙一次可以跳上 1级台阶，也可以跳上 2级。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 * 可以考虑，小青蛙每一步跳跃只有两种选择：一是再跳一级阶梯到达第 i级阶梯，此时小青蛙处于第 i-1级阶梯；或者再跳两级阶梯到达第 i级阶梯，此时小青蛙处于第 i-2级阶梯。
 * 于是，i级阶梯的跳法总和依赖于前 i-1级阶梯的跳法总数f(i-1)和前 i-2级阶梯的跳法总数f(i-2)。因为只有两种可能性，所以，f(i)=f(i-1)+f(i-2);
 * 依次类推，可以递归求出n级阶梯跳法之和。
 * @author 54060
 *
 */
public class Solution2 {
	public int JumpFloor(int n) {
	    if (n <= 2)
	        return n;
	    int pre2 = 1, pre1 = 2;
	    int result = 1;
	    for (int i = 2; i < n; i++) {
	        result = pre2 + pre1;
	        pre2 = pre1;
	        pre1 = result;
	    }
	    return result;
	}
}
