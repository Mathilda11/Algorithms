package leetCode;
/**
 * 
 * 荷兰国旗包含三种颜色：红、白、蓝。
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * @author 54060
 *
 */
public class leeCode_75 {
	public void sortColors(int[] nums) {
	    int zero = -1, one = 0, two = nums.length;  //zero:0, one:1, two:2
	    while (one < two) {
	        if (nums[one] == 0) {
	            swap(nums, ++zero, one++);
	        } else if (nums[one] == 2) {
	            swap(nums, --two, one);
	        } else {
	            ++one;
	        }
	    }
	}

	private void swap(int[] nums, int i, int j) {
	    int t = nums[i];
	    nums[i] = nums[j];
	    nums[j] = t;
	}
}
