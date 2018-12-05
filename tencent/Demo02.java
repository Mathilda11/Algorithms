package tencent;

import java.util.Arrays;
import java.util.Scanner;
/*
2、字符移位

小Q最近遇到了一个难题：把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
你能帮帮小Q吗？

输入描述:

输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.

输出描述:

对于每组数据，输出移位后的字符串。

输入例子:

AkleBiCeilD

输出例子:

kleieilABCD

思路：采用冒泡排序的思想，大写字母向后移动，小写字母向前移动
*/

public class Demo02 {
	public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            System.out.println(getResult(str));
        }
    }
	/*
	 * java如何修改String中的一个字符
	 * String str = "Test string";
	   StringBuilder strBuilder = new StringBuilder(str);
	   strBuilder.setCharAt(1, 'X');
	   str=Builder.toString();
	   
	   java判断是否为大写字母：https://blog.csdn.net/weixin_38506291/article/details/79267980
	 */
    public static String getResult(String str){
    	StringBuilder s  = new StringBuilder(str);
    	int j;
    	int n = s.length();
    	for(int i = n-1;i>0;i--){
    		if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
    			j = i;
    			while(s.charAt(j) >= 'a' && s.charAt(j) <= 'z' && j>=1){
    				j--;
    			}
    			
    			if(j==0 && s.charAt(j) >= 'a' && s.charAt(j) <= 'z'){
    				break;
    			}
    			
    			if(s.charAt(j) >= 'A' && s.charAt(j) <= 'Z'){
    				char c = s.charAt(j);
    				for(int k = j; k<i; k++){
    					s.setCharAt(k,s.charAt(k+1));
    				}
    				s.setCharAt(i, c);
    			}
    		}
    	}
		return s.toString();
    }
}
