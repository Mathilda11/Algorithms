package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 * 448.找出数组中所有消失的数

 * 要求：整型数组取值为 1 ≤ a[i] ≤ n，n是数组大小，一些元素重复出现，找出[1,n]中没出现的数，实现时时间复杂度为O(n)，并不占额外空间
 
 * 注意：取值是从1开始，而不是0。
 */
public class leeCode_448 {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			while(nums[i]!=i+1 && nums[i]!=nums[nums[i]-1]){
				swap(nums,i,nums[i]);
			}
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=i+1){
				res.add(i+1);
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
		leeCode_448 leeCode_448 = new leeCode_448();
		int[] nums = {1,3,3};
		System.out.println(leeCode_448.findDisappearedNumbers(nums));
	}
}
