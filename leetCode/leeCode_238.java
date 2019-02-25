package leetCode;
/*
 * 给定一个数组，创建一个新数组，新数组的每个元素为原始数组中除了该位置上的元素之外所有元素的乘积。

*  要求时间复杂度为 O(N)，并且不能使用除法。
 */
import java.util.Arrays;

public class leeCode_238 {
	public int[] productExceptSelf(int[] nums) {
	    int n = nums.length;
	    int[] products = new int[n];
	    Arrays.fill(products, 1);
	    int left = 1;
	    for (int i = 1; i < n; i++) {
	        left *= nums[i - 1];
	        products[i] *= left;
	    }
	    int right = 1;
	    for (int i = n - 2; i >= 0; i--) {
	        right *= nums[i + 1];
	        products[i] *= right;
	    }
	    return products;
	}
	
	public static void main(String[] args) {
		leeCode_238 leeCode_238 = new leeCode_238();
		leeCode_238.productExceptSelf(new int[]{1,2,3,4});
	}
}
