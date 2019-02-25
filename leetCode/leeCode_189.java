package leetCode;
/*
 * 旋转数组

 * 要求：旋转n长度的数组，位数为k，用三种以上方法，其中最好消耗O(1)额外空间（即原地）
 * 
 * 思路：三次反转
 */
public class leeCode_189 {
	public void rotate(int[] nums, int k) {
		//nums = {1,2,3,4,5,6,7}
		//k=3
		k = k % nums.length; //防止k大于数组长度
		reverse(nums, 0, nums.length-1);  //{7,6,5,4,3,2,1}
		reverse(nums, 0, k-1);  //{5,6,7,4,3,2,1}
		reverse(nums, k, nums.length-1);  ////{5,6,7,1,2,3,4}
	}

	private void reverse(int[] nums, int start, int end) {
		while(start < end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		leeCode_189 leeCode_189 = new leeCode_189();
		int[] nums = {1,2,3,4,5,6,7};
		leeCode_189.rotate(nums, 3);
		for (int i : nums) {
			System.out.println(i);
		}
	}
}
