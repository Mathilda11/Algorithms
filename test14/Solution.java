package test14;
/**
 * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方。
 * @author 54060
 *
 */
import java.lang.Throwable;
public class Solution {
	//时间复杂度：O(log n)
	public double Power(double base, int exponent) {
	    if (exponent == 0)
	        return 1;
	    if (exponent == 1)
	        return base;
	    boolean isNegative = false;
	    if (exponent < 0) {
	        exponent = -exponent;
	        isNegative = true;
	    }
	    double pow = Power(base * base, exponent >> 1);
	    if ((exponent & 1) == 1)
	        pow = pow * base;
	    return isNegative ? 1 / pow : pow;
	}
	
    //时间复杂度：O(n)
    //使用累乘
    public double powerAnother(double base, int exponent) {
        double result = 1.0;
        for (int i = 0; i < Math.abs(exponent); i++) {
            result *= base;
        }
        if (exponent >= 0)
            return result;
        else
            return 1 / result;
    }
}
