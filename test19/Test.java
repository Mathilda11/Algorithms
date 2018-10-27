package test19;

public class Test {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1,2,3,4,5};
		solution.reOrderArray(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}
}
