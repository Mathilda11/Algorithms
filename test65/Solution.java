package test65;

/**
 * 把字符串转换成整数
 * 将一个字符串转换成一个整数，字符串不是一个合法的数值则返回 0，要求不能使用字符串转换整数的库函数。
 * Iuput:
 * +2147483647
 * 1a33
 * 
 * Output:
 * 2147483647
 * 0
 * @author 54060
 *
 */
public class Solution {
	public int StrToInt(String str) {
	    if (str == null || str.length() == 0)
	        return 0;
	    boolean isNegative = str.charAt(0) == '-';
	    int ret = 0;
	    for (int i = 0; i < str.length(); i++) {
	        char c = str.charAt(i);
	        if (i == 0 && (c == '+' || c == '-'))  /* 符号判定 */
	            continue;
	        if (c < '0' || c > '9')                /* 非法输入 */
	            return 0;
	        ret = ret * 10 + (c - '0'); /*减去字符0，也就是减去0的ASCII码值48，数字字符减去‘0’就得到了该数字。*/
	    }
	    return isNegative ? -ret : ret;
	}
}
