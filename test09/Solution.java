package test09;

/**
 * 
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组 {3, 4, 5, 1, 2} 为 {1, 2, 3, 4, 5} 的一个旋转，该数组的最小值为 1。
 * 
 * 本题可以修改二分查找算法进行求解：当 nums[m] <= nums[h] 的情况下，说明解在 [l, m] 之间，此时令 h = m；否则解在 [m + 1, h] 之间，令 l = m + 1。
 * @author 54060
 *
 */
public class Solution {
	public int minNumberInRotateArray(int[] nums) {
	    if (nums.length == 0)
	        return 0;
	    int l = 0, h = nums.length - 1;
	    while (l < h) {
	        int m = l + (h - l) / 2;
	        if (nums[m] <= nums[h])
	            h = m;
	        else
	            l = m + 1;
	    }
	    return nums[l];
	}
}
