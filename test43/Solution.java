package test43;
/**
 * 把数组排成最小的数
 * 
 * 输入一个正整数数组，
 * 把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组 {3，32，321}，则打印出这三个数字能排成的最小数字为 321323。
 * 可以看成是一个排序问题，在比较两个字符串 S1 和 S2 的大小时，应该比较的是 S1+S2 和 S2+S1 的大小，如果 S1+S2 < S2+S1，那么应该把 S1 排在前面，否则应该把 S2 排在前面。
 * CompareTo()返回值： int 字典序比较
 * 
 * 返回值类型分别有三种，小于0，等于0，大于0
 * 1. 如果字符串相等返回值0；
 * 2. 如果第一个字符和参数的第一个字符不等,结束比较,返回他们之间的差值（ascii码值）（负值前字符串的值小于后字符串，正值前字符串大于后字符串）；
 * 3. 如果第一个字符和参数的第一个字符相等，则以第二个字符和参数的第二个字符做比较，以此类推，直至比较的字符或被比较的字符有一方全比较完，这时就比较字符的长度。

 * @author 54060
 *
 */
import java.util.Arrays;

public class Solution {
	public String PrintMinNumber(int[] numbers) {
	    if (numbers == null || numbers.length == 0)
	        return "";
	    int n = numbers.length;
	    String[] nums = new String[n];
	    for (int i = 0; i < n; i++)
	        nums[i] = numbers[i] + ""; //将数字转换成字符串
	    Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1)); //使字符串之和小，排在前面 比如将2,4,1,5变成1,2,4,5
	    					//不能直接使用Arrays.sort(nums)，这只适用于个位数比较。3，32，321应该将两个字符串拼接再比较 如果仅按单个数字大小 则不一定是最小的
	    String ret = "";
	    for (String str : nums)
	        ret += str;
	    return ret;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] numbers = {2,4,10};
		String printMinNumber = solution.PrintMinNumber(numbers);
		System.out.println(printMinNumber);
	}
}
