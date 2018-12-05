package test09;

/**
 * 
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组 {3, 4, 5, 1, 2} 为 {1, 2, 3, 4, 5} 的一个旋转，该数组的最小值为 1。
 * 
 * 本题可以修改二分查找算法进行求解：
 * 当 nums[m] <= nums[h] 的情况下，说明解在 [l, m] 之间，此时令 h = m；
 * 否则解在 [m + 1, h] 之间，令 l = m + 1。
 * @author 54060
 *
 */
public class Solution {
	public int minNumberInRotateArray(int[] nums) {
	    if (nums.length == 0)
	        return 0;
	    int l = 0, h = nums.length - 1;
	    while (l < h) {//当不满足该条件时，l指针已经指向第二个数组的开头
	        int m = l + (h - l) / 2;
	        //如果数组元素允许重复的话，那么就会出现一个特殊的情况：nums[l] == nums[m] == nums[h]，那么此时无法确定解在哪个区间，需要切换到顺序查找。
	        if (nums[l] == nums[m] && nums[m] == nums[h])
	            return minNumber(nums, l, h);
	        else if (nums[m] <= nums[h])
	            h = m;
	        else
	            l = m + 1;
	    }
	    return nums[l];
	}
	//返回最小的元素
	private int minNumber(int[] nums, int l, int h) {
	    for (int i = l; i < h; i++)
	        if (nums[i] > nums[i + 1])
	            return nums[i + 1];
	    return nums[l];
	}
}
