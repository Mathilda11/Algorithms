package leetCode;

/*
 * 两数之和

 * 要求：给出target，从数组找出两数相加是它，并返回对应下标，假设只有一个解
 * 
 * 思路：用 HashMap 存储数组元素和下标的映射，该方法的时间复杂度为 O(N)，空间复杂度为 O(N)，使用空间来换取时间。
 */
import java.util.HashMap;

public class leeCode_1 {
	public int[] twoSum(int[] nums, int target) {
	    HashMap<Integer, Integer> indexForNum = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        if (indexForNum.containsKey(target - nums[i])) {
	            return new int[]{indexForNum.get(target - nums[i]), i};
	        } else {
	            indexForNum.put(nums[i], i);
	        }
	    }
	    return null;
	}
	
	public static void main(String[] args) {
		leeCode_1 leeCode_1 = new leeCode_1();
		int[] nums = {1,2,3,4,5};
		int[] twoSum = leeCode_1.twoSum(nums,5);
		for (int i : twoSum) {
			System.out.println(i);
		}
	}
}
