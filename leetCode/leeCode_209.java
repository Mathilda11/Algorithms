package leetCode;

/*
 * 最小子数组之和

 * 要求：给出含有n个正数的数组，用最短的子数组各项加起来能够大于等于给定的正数s，若找不到则返回0

 * 思路：“Two Pointers”用两个指针和一个记录最短长度的min，首先第一个指针用来叠加，第二个指针用来大于s时减去前面的数，并且更新最短长度min,时间复杂度为O(n)（虽然用了两层while）
 */
public class leeCode_209 {
	public int minSubArrayLen(int s, int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		int l = 0, r = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
        while (r < nums.length) {
            sum += nums[r++];
            while (sum >= s) {
                //超过s就减去前面一位，保留最短长度
                min = Math.min(min, r - l);
                sum -= nums[l++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
	}
	
	public static void main(String[] args) {
		leeCode_209 leeCode_209 = new leeCode_209();
		int[] nums = {2,3,1,2,4,3};
		System.out.println(leeCode_209.minSubArrayLen(7, nums));
	}
}
