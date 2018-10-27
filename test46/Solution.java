package test46;
/**
 * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 * 
 * 主要思路：使用动态规划，记录当前字符之前的最长非重复子字符串长度f(i-1)，其中i为当前字符的位置。每次遍历当前字符时，分两种情况：
 * 
 * 1）若当前字符第一次出现，则最长非重复子字符串长度f(i) = f(i-1)+1。 
 * 2）若当前字符不是第一次出现，则首先计算当前字符与它上次出现位置之间的距离d。若d>于f(i-1)，即说明前一个非重复子字符串中没有包含当前字符，则可以添加当前字符到前一个非重复子字符串中，所以，f(i) = f(i-1)+1。若d小于或等于f(i-1)，即说明前一个非重复子字符串中已经包含当前字符，则不可以添加当前字符，所以，f(i) = d。
 * 
 * 关键点：动态规划，两个重复字符的距离
 * @author 54060
 *
 */
import java.util.Arrays;

public class Solution {
	public int longestSubStringWithoutDuplication(String str) {
	    int curLen = 0;
	    int maxLen = 0;
	    int[] preIndexs = new int[26];
	    Arrays.fill(preIndexs, -1);
	    for (int curI = 0; curI < str.length(); curI++) {
	        int c = str.charAt(curI) - 'a';
	        int preI = preIndexs[c];
	        if (preI == -1 || curI - preI > curLen) {
	            curLen++;
	        } else {
	            maxLen = Math.max(maxLen, curLen);
	            curLen = curI - preI;
	        }
	        preIndexs[c] = curI;
	    }
	    maxLen = Math.max(maxLen, curLen);
	    return maxLen;
	}
}
