package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 * 442.找出数组重复的数

 * 要求：整型数组取值为 1 ≤ a[i] ≤ n，n是数组大小，一些元素重复出现，找出[1,n]中没出现的数，实现时时间复杂度为O(n)，并不占额外空间
 */
public class leeCode_442 {
	public List<Integer> findDuplicates(int[] nums) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i = 0; i<nums.length; i++){
			while(nums[i]!=i+1){
				if(nums[i]==nums[nums[i]-1]){
					res.add(nums[i]);
					break;
				}
				swap(nums,i,nums[i]);
			}
		}
		return res;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void main(String[] args) {
		leeCode_442 leeCode_442 = new leeCode_442();
		int[] nums = {1,3,3,4};
		System.out.println(leeCode_442.findDuplicates(nums));
	}
}
