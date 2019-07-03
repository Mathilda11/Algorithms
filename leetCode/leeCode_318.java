package leetCode;
/*
 * 给出一些字符串，找出两个不同的字符串之间长度之积的最大值，但要求这两个字符串之间不能拥有相同的字符。（字符只考虑小写字母）。
 */

public class leeCode_318 {
	public int maxProduct(String[] words) {
	    int n = words.length;
	    int[] val = new int[n];
	    for (int i = 0; i < n; i++) {
	        for (char c : words[i].toCharArray()) {
	            val[i] |= 1 << (c - 'a');
	        }
	    }
	    int ret = 0;
	    for (int i = 0; i < n; i++) {
	        for (int j = i + 1; j < n; j++) {
	            if ((val[i] & val[j]) == 0) {
	                ret = Math.max(ret, words[i].length() * words[j].length());
	            }
	        }
	    }
	    return ret;
	}
	
	public static void main(String[] args) {
		leeCode_318 leeCode_318 = new leeCode_318();
		String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		leeCode_318.maxProduct(words);
	}
}
