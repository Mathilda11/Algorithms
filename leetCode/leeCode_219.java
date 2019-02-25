package leetCode;

import java.util.HashMap;

/*
 * 包含重复II

 * 要求：给出数组和整数k，求是否在最大间隔j - i = k以内有重复数出现
 * 
 * 思路：根据HashMap特性键不能重复，把数组的值当作map键，数组的下标当作map值，求长度时比较map值（对应数组下标）
 */
public class leeCode_219 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i<nums.length; i++){
			if(map.containsKey(nums[i])){
				if(i-map.get(nums[i])<=k){
					return true;
				}
				map.put(nums[i], i); //更新最近出现的数组值的下标
			}
			map.put(nums[i], i);//插入
		}
		return false;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,2,4};
		leeCode_219 leeCode_219 = new leeCode_219();
		System.out.println(leeCode_219.containsNearbyDuplicate(nums, 2));
	}
}
