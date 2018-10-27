package test18;

/**
 * 表示数值的字符串
 * []  ： 字符集合
 * ()  ： 分组
 * ?   ： 重复 0 ~ 1
 * +   ： 重复 1 ~ n
 * *   ： 重复 0 ~ n
 * .   ： 任意字符
 * \\. ： 转义后的 .
 * \\d ： 数字
 * @author 54060
 *
 */
public class Solution {
	public boolean isNumeric(char[] str) {
	    if (str == null || str.length == 0)
	        return false;
	    //在java和python中 .2也是数字
	    return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");//()?表示是可选的
	}
}
