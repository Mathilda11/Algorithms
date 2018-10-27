package test56;
/**
 * 左旋转字符串
 * Input:S="abcXYZdef" K=3 Output: "XYZdefabc"
 * @author 54060
 *
 */
public class Solution2_2 {
	public String LeftRotateString(String str, int n){  //str="abcde" n = 3
		int len = str.length(); //len=5
		if(len==0 || n==0){
			return str;
		}
		n = n%len;//n = 3
		str+=str;//str = "abcdeabcde"
		return str.substring(n, n+len);
		
	}
}
