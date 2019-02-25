package leetCode;

/*
 * 152.最大乘积连续子数组

 * 要求：找出子数组的最大乘积，子数组最少包含1个数
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * 
 * 注意：要考虑到一种特殊情况，即负数和负数相乘：如果前面得到一个较小的负数，和后面一个较大的负数相乘，
 * 得到的反而是一个较大的数，如{2，-3，-7}，所以，我们在处理乘法的时候，除了需要维护一个局部最大值，
 * 同时还要维护一个局部最小值
 */
public class leeCode_152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        int maxTemp = 0;
        int minTemp = 0;
        for (int i = 1; i < nums.length; i++) {
            maxTemp = Math.max(max * nums[i], min * nums[i]);
            minTemp = Math.min(max * nums[i], min * nums[i]);
            max = Math.max(maxTemp, nums[i]);
            min = Math.min(minTemp, nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }
    public static void main(String[] args) {
		leeCode_152 leeCode_152 = new leeCode_152();
		int[] nums = {2,-3,-7};
		System.out.println(leeCode_152.maxProduct(nums));
	}
}
