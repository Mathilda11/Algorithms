package leetCode;

import java.util.HashMap;

/*
 * 众数
 * 要求：找出数组中出现次数超过n / 2的数，已设数组非空，并且众数肯定存在（若没此假设就要判断是否为空数组，最多的出现次数是否超过n / 2
 * 思路一：摩尔投票
 * 思路二：利用HashMap，key用来表示数组的值，每增加1次，key对应的值+ 1，空间复杂度高
 */
public class leeCode_169 {
	public int majorityElement(int[] nums) {
		int number = nums[0];
		int count = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == number){
				count++;
			}else if(count==0){
				number = nums[i];
				count++;
			}else{
				count--;
			}
		}
		return number;
	}
	
	public int majorityElement2(int[] nums) {
		int number = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(nums[i])){
				map.put(nums[i], map.get(nums[i])+1);
			}else{
				map.put(nums[i], 1);
			}
			
		    if(map.get(nums[i]) > nums.length / 2){
                number = nums[i];
            }
		}
		return number;
	}
}
