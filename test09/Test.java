package test09;

public class Test {
	public static void main(String[] args) {
		Solution solution = new Solution();
		//int[] nums = {3,4,5,1,2};
		int[] nums = {1,1,1,0,1};
		int minNumberInRotateArray = solution.minNumberInRotateArray(nums);
		System.out.println(minNumberInRotateArray);
	}
}
