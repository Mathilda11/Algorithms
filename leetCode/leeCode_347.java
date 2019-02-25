package leetCode;

/**
 * 找出数组中出现次数最多的前k个元素
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leeCode_347 {
	public List<Integer> topKFrequent(int[] nums, int k) {
	    Map<Integer, Integer> frequencyForNum = new HashMap<>();
	    for (int num : nums) {
	        frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
	    }
	    List<Integer>[] buckets = new ArrayList[nums.length + 1];
	    for (int key : frequencyForNum.keySet()) {
	        int frequency = frequencyForNum.get(key);
	        if (buckets[frequency] == null) {
	            buckets[frequency] = new ArrayList<>();
	        }
	        buckets[frequency].add(key);
	    }
	    List<Integer> topK = new ArrayList<>();
	    for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) { //如果等于2，已不必在判断了
	        if (buckets[i] != null) {
	            topK.addAll(buckets[i]);
	        }
	    }
	    return topK;
	}
	
	public static void main(String[] args) {
		leeCode_347 leeCode_347 = new leeCode_347();
		int[] nums = {1,1,1,2,2,3,4,5};
		leeCode_347.topKFrequent(nums, 2);
	}
}
