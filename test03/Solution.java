package test03;
/**
 * 
 * 将一个字符串中的空格替换成 "%20"。
 * Input:
 * "We Are Happy"
 * 
 * Output:
 * "We%20Are%20Happy"
 * @author 54060
 *
 */
public class Solution {
	public String replaceSpace(StringBuffer str) {
	    int P1 = str.length() - 1;
	    for (int i = 0; i < P1 + 1; i++){
	        if (str.charAt(i) == ' '){
	            str.append("  ");}
	    }
	    int P2 = str.length() - 1;
	    while (P1 >= 0 && P2 > P1) {
	        char c = str.charAt(P1--);
	        if (c == ' ') {
	            str.setCharAt(P2--, '0');
	            str.setCharAt(P2--, '2');
	            str.setCharAt(P2--, '%');
	        } else {
	            str.setCharAt(P2--, c);
	        }
	    }
	    return str.toString();
	}
}
