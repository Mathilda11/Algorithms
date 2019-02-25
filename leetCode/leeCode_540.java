package leetCode;

/**
 * 一个有序数组只有一个数不出现两次，找出这个数。要求以 O(logN) 时间复杂度进行求解。
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * 思路:既然按递增顺序排列，重复的数字总是相邻，用增量法即可解。由于只有一个数出现单次，其余均出现两次，观察易知单次的数必出现在偶数下标(数组从0开始)。
 * 因此用一个计数器求和，遍历数组，下标为奇则取元素负值，累加，下标为偶则取元素正值，累加。
 * 最终求和结果就是只出现一次的数。
 * @author 54060
 *
 */
public class leeCode_540 {
	int singleNonDuplicate(int[] nums) {
        int sum = 0;  //求和
        for (int i = 0; i < nums.length; i++) {
            if (i%2 == 0) 
            	sum += nums[i];  //下标为偶,加之(取正值)
            else sum -= nums[i];  //下标为奇,减之(取负值)
        }
        return sum;
    }
	
}
