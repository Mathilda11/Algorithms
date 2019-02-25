package leetCode;
/**
 * 按照字符出现次数对字符串排序
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leeCode_451 {
	public String frequencySort(String s) {
	    Map<Character, Integer> frequencyForNum = new HashMap<>();
	    for (char c : s.toCharArray())
	        frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);
	    //frequencyForNum = {r=1,t=1,e=2};
	    List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];
	    for (char c : frequencyForNum.keySet()) {
	        int f = frequencyForNum.get(c);
	        if (frequencyBucket[f] == null) {
	            frequencyBucket[f] = new ArrayList<>();
	        }
	        frequencyBucket[f].add(c);
	    }
	    StringBuilder str = new StringBuilder();
	    for (int i = frequencyBucket.length - 1; i >= 0; i--) {
	        if (frequencyBucket[i] == null) {
	            continue;
	        }
	        //frequencyBucket = [null,[r,t],[e],null,null];
	        for (char c : frequencyBucket[i]) {
	            for (int j = 0; j < i; j++) { //j控制次数
	                str.append(c);
	            }
	        }
	    }
	    return str.toString();
	}
	
	public static void main(String[] args) {
		leeCode_451 leeCode_451 = new leeCode_451();
		leeCode_451.frequencySort("tree");
	}
}
