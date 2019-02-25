package leetCode;

/*
 * 要求：把数组中的0都放在末尾，且保持其他数的相对位置
 * 方法：把非0数放在头，其余位置补0
 */
public class leeCode_283 {
	public void moveZeroes(int[] nums) {
        int nonzero = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[nonzero] = num;
                nonzero++;
            }
        }
        //补全0
        while (nonzero < nums.length) {
            nums[nonzero] = 0;
            nonzero++;
        }
    }
}
