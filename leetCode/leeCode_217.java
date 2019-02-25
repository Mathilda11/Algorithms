package leetCode;

import java.util.HashMap;

/*
 * 包含重复

 * 要求：找出数组是否有重复数
 */
public class leeCode_217 {
	public boolean containsDuplicate(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i<nums.length; i++){
			if(map.containsKey(nums[i])){
				return true;
			}
			map.put(nums[i], i);
		}
		return false;
	}

}
