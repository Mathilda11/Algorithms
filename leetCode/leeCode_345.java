package leetCode;

import java.util.Arrays;
import java.util.HashSet;

//字符数组转字符串可以通过下面的方式:

//char[] data =  {'a', 'b', 'd'};

//String s = new String(data);

//字符串到字符数组:

//String str = "123abc";

//char[] ar = str.toCharArray();　　//char数组
public class leeCode_345 {
	private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

	public String reverseVowels(String s) {   
		int i = 0, j = s.length()-1;
		char[] result = new char[s.length()];
		while(i<=j){
			char ci = s.charAt(i);
			char cj = s.charAt(j);
			if(!vowels.contains(ci)){  //谁不满足移动谁的索引
				result[i++] = ci;
			}else if(!vowels.contains(cj)){
				result[j--] = cj;
			}else{
				result[i++] = cj;
				result[j--] = ci;
			}
		}
		return new String(result);
	}
}
