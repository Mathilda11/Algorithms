package test56;

/**
 * 翻转单词顺序列
 * Input:
 * "I am a student."
 * 
 * Output:
 * "student. a am I"
 * 题目应该有一个隐含条件，就是不能用额外的空间。虽然 Java 的题目输入参数为 String 类型，需要先创建一个字符数组使得空间复杂度为 O(N)，
 * 但是正确的参数类型应该和原书一样，为字符数组，并且只能使用该字符数组的空间。任何使用了额外空间的解法在面试时都会大打折扣，包括递归解法。
 * 
 * 正确的解法应该是和书上一样，先旋转每个单词，再旋转整个字符串。
 * @author 54060
 *
 */
public class Solution1_1 {
	public String ReverseSentence(String str) {
	    int n = str.length();
	    char[] chars = str.toCharArray();
	    int i = 0, j = 0;
	    while (j <= n) {
	        if (j == n || chars[j] == ' ') {
	            reverse(chars, i, j - 1); //先旋转每个单词
	            i = j + 1;
	        }
	        j++;
	    }
	    
	    //[I, ,a,m, ]->[I, ,m,a, ]
	    reverse(chars, 0, n - 1); //再旋转整个字符串
	    return new String(chars);
	}

	private void reverse(char[] c, int i, int j) {
		//如果是单个字符不交换
	    while (i < j)
	        swap(c, i++, j--);  //是先按下标i,j比较一次后再++，--
	}

	private void swap(char[] c, int i, int j) {
	    char t = c[i];
	    c[i] = c[j];
	    c[j] = t;
	}
}
