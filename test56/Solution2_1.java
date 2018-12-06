package test56;

/**
 * 左旋转字符串
 * Input:S="abcXYZdef" K=3 Output: "XYZdefabc"
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 定义字符串的左旋转操作：把字符串前面的几个字符移动到字符串后面去，比如"ABCDEFGHI"，左旋转2位得到"CDEFGHIAB"；
 * 
 * 同样右旋转操作：把字符串后面的几个字符移动到字符串前面去，比如“ABCDEFGHI”右旋转2位得到“HIABCDEFG”。
 * 
 * 思路：先将 "abc" 和 "XYZdef" 分别翻转，得到 "cbafedZYX"，然后再把整个字符串翻转得到 "XYZdefabc"。
 * @author 54060
 *
 */
public class Solution2_1 {
	public String LeftRotateString(String str, int n) {
	    if (n >= str.length())
	        return str;
	    char[] chars = str.toCharArray();
	    reverse(chars, 0, n - 1);
	    reverse(chars, n, chars.length - 1);
	    reverse(chars, 0, chars.length - 1);
	    return new String(chars);
	}

	private void reverse(char[] chars, int i, int j) {
	    while (i < j)
	        swap(chars, i++, j--);
	}

	private void swap(char[] chars, int i, int j) {
	    char t = chars[i];
	    chars[i] = chars[j];
	    chars[j] = t;
	}
}
