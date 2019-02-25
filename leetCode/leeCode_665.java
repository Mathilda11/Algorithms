package leetCode;
/**
 * 判断一个数组能不能只修改一个数就成为非递减数组
 * @author 54060
 *
 */
public class leeCode_665 {
	public boolean checkPossibility(int[] nums) {
	    int cnt = 0;
	    for (int i = 1; i < nums.length && cnt < 2; i++) {
	        if (nums[i] >= nums[i - 1]) {
	            continue;
	        }
	        cnt++;
	        if (i - 2 >= 0 && nums[i - 2] > nums[i]) {//{3,3,2}只能修改2为3
	            nums[i] = nums[i - 1];
	        } else {
	            nums[i - 1] = nums[i]; //{6,3,5}只能把6修改成3,而不能把3修改成6
	        }
	    }
	    return cnt <= 1;
	}
	public static void main(String[] args) {
		leeCode_665 leeCode_665 = new leeCode_665();
		int[] nums = {4,3,2};
		leeCode_665.checkPossibility(nums);
	}
}
