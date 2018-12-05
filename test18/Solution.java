package test18;

/**
 * 
        true
	
	"+100"
	"5e2"
	"-123"
	"3.1416"
	"-1E-16"

	false

	"12e"
	"1a3.14"
	"1.2.3"
	"+-5"
	"12e+4.3"
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
	    //*：0次，1次或多次
	    //+：1次或多次
	    //?：0次或1次
	    //表示数值的字符串遵循模式A.[.[B]][E|eC]或.B[E|eC]
	    return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");//()?表示是可选的
	}
	
	//使用java中异常的方式
	public static boolean isNumeric(String str) { 
		try { 
			double res = Double.parseDouble(str); 
		} catch (Exception e) { 
			return false; 
		} 
		return true; 
		}

}
