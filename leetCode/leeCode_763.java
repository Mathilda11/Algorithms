package leetCode;
/**
 * 分隔字符串使同种字符出现在一起
 */
import java.util.ArrayList;
import java.util.List;

public class leeCode_763 {
	public List<Integer> partitionLabels(String S) {
	    int[] lastIndexsOfChar = new int[26];
	    for (int i = 0; i < S.length(); i++) {
	        lastIndexsOfChar[char2Index(S.charAt(i))] = i;
	    }
	    // S = "ababcbacadefegdehijhklij";
	    //lastIndexOfChar = [8, 5, 7, 14, 15, 11, 13, 19, 22, 23, 20, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	    //索引代表字符串，值代表该字符串最后一次出现的位置
	    
	    List<Integer> partitions = new ArrayList<>();
	    int firstIndex = 0;
	    while (firstIndex < S.length()) {
	        int lastIndex = firstIndex;
	        for (int i = firstIndex; i < S.length() && i <= lastIndex; i++) {
	            int index = lastIndexsOfChar[char2Index(S.charAt(i))];
	            if (index > lastIndex) {
	                lastIndex = index;
	            }
	        }
	        partitions.add(lastIndex - firstIndex + 1);
	        firstIndex = lastIndex + 1;
	    }
	    return partitions;
	}

	private int char2Index(char c) {
	    return c - 'a';
	}
	public static void main(String[] args) {
		leeCode_763 leeCode_763 = new leeCode_763();
		leeCode_763.partitionLabels("ababcbacadefegdehijhklij");
	}
}
