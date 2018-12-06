package test51;
/**
 * 数字在排序数组中出现的次数
 * Input:
 * nums = 1, 2, 3, 3, 3, 3, 4, 6
 * K = 3
 * Output:
 * 4
 * 有序数组的查找利用二分查找，可以查找k和k+1的下标，做差。就是k在数组中出现的次数
 
 * 时间复杂度O(log n)
 * @author 54060
 *
 */
public class Solution1 {
	public int GetNumberOfK(int[] nums, int K) {
	    int first = binarySearch(nums, K);
	    System.out.println(first);
	    int last = binarySearch(nums, K + 1);
	    //first == nums.length 查找的K不存在且大于数组中的最大值 这样查出来的fisrt是数组的长度，不能用nums[first] != K判定，因为存在数组越界问题
	    //nums[first] != K 查找的K不存在且在数组值的范围内，这样查出来的0<first<length 或 查找的k不存在且小于数组的最小值，这样查出来的first是0
	    return (first == nums.length || nums[first] != K) ? 0 : last - first;
	}

	private int binarySearch(int[] nums, int K) {
	    int l = 0, h = nums.length;
	    while (l < h) {
	        int m = l + (h - l) / 2;
	        if (nums[m] >= K) //注意：>=，为了找到第一个k
	            h = m;
	        else
	            l = m + 1;
	    }
	    return l;
	}
}
