package test56;

/**
 * 翻转单词顺序列
 * Input:
 * "I am a student."
 * 
 * Output:
 * "student. a am I"
 * @author 54060
 *
 */
public class Solution1_2 {

	public String ReverseSentence(String str) {
	        String res = "", tmp = "";
	        for(int i = 0; i < str.length(); ++i){
	            if(str.charAt(i) == ' '){
	            	res = " " + tmp + res;
	            	tmp = "";
	            }
	            else {
	            	tmp += str.charAt(i);
	            }
	        }
	        if(tmp.length()>0) {
	        	res = tmp + res;
	        }
	        return res;
	    }
	}; 
