package leetCode;

public class leeCode_287 {
/*	public int findDuplicate(int[] nums) {
	     int l = 1, h = nums.length - 1;
	     while (l <= h) {
	         int mid = l + (h - l) / 2;
	         int cnt = 0;
	         for (int i = 0; i < nums.length; i++) {
	             if (nums[i] <= mid) cnt++;
	         }
	         if (cnt > mid) h = mid - 1;
	         else l = mid + 1;
	     }
	     return l;
	}*/
	public int findDuplicate(int[] nums) {
	    int slow = nums[0], fast = nums[nums[0]];
	    while (slow != fast) {
	        slow = nums[slow];
	        fast = nums[nums[fast]];
	    }
	    fast = 0;
	    while (slow != fast) {
	        slow = nums[slow];
	        fast = nums[fast];
	    }
	    return slow;
	}
	
	public static void main(String[] args) {
		leeCode_287 leeCode_287 = new leeCode_287();
		int[] nums = {1,3,4,2,2};
		leeCode_287.findDuplicate(nums);
	}
}
