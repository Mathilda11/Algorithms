package test48;
/**
 * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。
 * 解题思路：
 * 最直观的解法是使用 HashMap 对出现次数进行统计，但是考虑到要统计的字符范围有限，因此可以使用整型数组代替 HashMap。
 * 
 * 时间复杂度：O(n)，空间复杂度：O(1)
 * @author 54060
 *
 */
public class Solution1_1 {
	public int FirstNotRepeatingChar(String str) {
	    int[] cnts = new int[256];//每个字符根据其ASCII码值作为数组的下标，而数组中存储的是每个字符出现的次数
	    for (int i = 0; i < str.length(); i++){
	        cnts[str.charAt(i)]++;  //比如str是"abcdac",则cnts={...0,...0,2,1,2,1,...0,...0}
	    }
	    for (int i = 0; i < str.length(); i++)
	        if (cnts[str.charAt(i)] == 1)
	            return i;
/*	    for (int i = 0; i < cnts.length; i++) {  //这样写是错误的，需要返回的不是cnts长数组中值为1的索引，而是原字符串中的序号。
			if(1==cnts[i]){
				return i;
			}
		}*/
	    return -1;
	}
}
