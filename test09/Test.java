package test09;

public class Test {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {0,0,1,1,1};
		int minNumberInRotateArray = solution.minNumberInRotateArray(nums);
		System.out.println(minNumberInRotateArray);
	}
}
