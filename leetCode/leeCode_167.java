package leetCode;

public class leeCode_167 {
	public int[] twoSum(int[] nums, int target){
		int i=0, j=nums.length;
		while(i<j){
			int sum = nums[i] + nums[j];
			if(sum==target){
				return new int[]{i+1,j+1};
			}else if(sum<target){
				i++;
			}else{
				j--;
			}
		}
		return null;
	}
}
