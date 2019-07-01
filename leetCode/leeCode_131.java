package leetCode;
/*
 * 给定一个字符串s，将s分割成一些子串，使每个子串都是回文串。
 * 返回s所有可能的回文串分割方案。
 */
import java.util.ArrayList;
import java.util.List;

public class leeCode_131 {
	public List<List<String>> partition(String s) {
	    List<List<String>> partitions = new ArrayList<>();
	    List<String> tempPartition = new ArrayList<>();
	    doPartition(s, partitions, tempPartition);
	    return partitions;
	}

	private void doPartition(String s, List<List<String>> partitions, List<String> tempPartition) {
	    if (s.length() == 0) {
	        partitions.add(new ArrayList<>(tempPartition));
	        return;
	    }
	    for (int i = 0; i < s.length(); i++) {
 	        if (isPalindrome(s, 0, i)) {
	            tempPartition.add(s.substring(0, i + 1));
	            doPartition(s.substring(i + 1), partitions, tempPartition);
	            tempPartition.remove(tempPartition.size() - 1);//每次结束后退回到初始进入时的状态
	        }
	    }
	}

	private boolean isPalindrome(String s, int begin, int end) {
	    while (begin < end) {
	        if (s.charAt(begin++) != s.charAt(end--)) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		leeCode_131 leeCode_131 = new leeCode_131();
		leeCode_131.partition("aab");
	}
}
