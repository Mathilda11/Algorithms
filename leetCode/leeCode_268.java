package leetCode;

/*
 * 要求：数组包含n个数，从0...n取值，找出缺失的那个值，时间复杂度要线性，空间复杂度恒定
 * 求和法：不缺失数组和（n+1项）减去缺失数组和（n项）
 */
public class leeCode_268 {
	public int missingNumber(int[] nums) {
		int n = nums.length;
		int s = n * (n + 1) / 2; //1+2+...+n = n(n+1)/2
		int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return s - sum;
	}
}
