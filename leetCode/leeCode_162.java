package leetCode;
/*
 * 找峰值
 * 要求：找出数组中任意的峰值，且数组没有重复的数
 * 
 * 思路：二分查找，中值比其右边小就抛弃左边，比右边大就抛弃右边，时间复杂度为O(logn)
 */
public class leeCode_162 {
	 public int findPeakElement(int[] nums) {
		 int l = 0, h = nums.length - 1;
		 while(l < h){
			 int m = l + (h - l)/2;
			 if(nums[m]<nums[m+1]){
				 l = m+1;
			 }else{
				 h = m;
			 }
		 }
		 return l;
	 }

}
