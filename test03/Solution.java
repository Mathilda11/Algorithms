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
	//此方法需要创建StringBuffer，且数组中很多字符都移动了很多次
	//假设字符的长度是n。对每个空格字符，需要移动后面O(n)个字符，因此对含有O(n)个空格字符串而言，总的时间效率是O(n^2).
/*    public String replaceSpace(StringBuffer str) {
        StringBuffer out=new StringBuffer();
        for (int i = 0; i < str.toString().length(); i++) {
            char b=str.charAt(i);
            if(String.valueOf(b).equals(" ")){
                out.append("%20");
            }else{
                out.append(b);
            }
        }
        return out.toString();     
    }*/
	
	//所有的字符都只复制一次，因此这个算法的时间效率是O(n)
	public String replaceSpace(StringBuffer str) {
		if(str==null||str.length()==0){
			return "";  //考虑字符串是个null，或者是一个空字符串
		}
		//所有字符只移动一次
	    int P1 = str.length() - 1;
	    for (int i = 0; i < P1 + 1; i++){
	        if (str.charAt(i) == ' '){
	            str.append("  ");}
	    }
/*	    int count = 0;
	    for (int i = 0; i < P1 + 1; i++){
	        if (str.charAt(i) == ' '){
	            count++;
	        }
	    }
	    int P2 = P1 + count * 2;*/
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
