package leetCode;

import java.util.HashMap;
import java.util.Map;

public class leeCode_128 {
	public int longestConsecutive(int[] nums) {
	    Map<Integer, Integer> countForNum = new HashMap<>();
	    for (int num : nums) {
	        countForNum.put(num, 1);
	    }
	    for (int num : nums) {
	        forward(countForNum, num);
	    }
	    return maxCount(countForNum);
	}

	private int forward(Map<Integer, Integer> countForNum, int num) {
	    if (!countForNum.containsKey(num)) {
	        return 0;
	    }
	    int cnt = countForNum.get(num);
	    if (cnt > 1) {
	        return cnt;
	    }
	    cnt = forward(countForNum, num + 1) + 1;
	    countForNum.put(num, cnt);
	    return cnt;
	}

	private int maxCount(Map<Integer, Integer> countForNum) {
	    int max = 0;
	    for (int num : countForNum.keySet()) {
	        max = Math.max(max, countForNum.get(num));
	    }
	    return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {100, 4, 200, 1, 3, 2};
		leeCode_128 leeCode_128 = new leeCode_128();
		leeCode_128.longestConsecutive(nums);
	}
}
