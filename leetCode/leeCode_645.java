package leetCode;

public class leeCode_645 {
	public int[] findErrorNums(int[] nums) {
	    for (int i = 0; i < nums.length; i++) {
	        while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
	            swap(nums, i, nums[i] - 1);
	        }
	    }
	    for (int i = 0; i < nums.length; i++) {
	        if (nums[i] != i + 1) {
	            return new int[]{nums[i], i + 1};
	        }
	    }
	    return null;
	}

	private void swap(int[] nums, int i, int j) {
	    int tmp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = tmp;
	}
	
	public static void main(String[] args) {
		leeCode_645 leeCode_645 = new leeCode_645();
		leeCode_645.findErrorNums(new int[]{1,2,1,4});
	}
}
