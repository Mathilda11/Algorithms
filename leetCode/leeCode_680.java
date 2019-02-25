package leetCode;

public class leeCode_680 {
	 //如果先比较后自增、自减
	 //while(i++ < j--){
	 // 		...
	 //}
	 //则在i,j不满足条件时，还要其自增、自减。则改变了指针所指的元素。
	public boolean validPalindrome(String s) {  ////s = "abeabea";
	    int i = -1, j = s.length();
	    while (++i < --j) {
	        if (s.charAt(i) != s.charAt(j)) {
	            return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
	        }
	    }
	    return true;
	}

	private boolean isPalindrome(String s, int i, int j) {
		// beab      eabe  还要再继续移动指针比较
	    while (i < j) {
	        if (s.charAt(i++) != s.charAt(j--)) {
	            return false;
	        }
	    }
	    return true;
	}
}
