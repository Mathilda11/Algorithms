package test64;

/**
 * 构建乘积数组
 * 给定一个数组 A[0, 1,..., n-1]，请构建一个数组 B[0, 1,..., n-1]，
 * 其中 B 中的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。要求不能使用除法。  A[i]=1
 * 
 * https://blog.csdn.net/rebirth_love/article/details/51612096 
 * 如上图所示，每行跳过红色数字，黑色数字的乘积就是对应的B[i].那么以红色数字为分割线，左侧数组设为D,右侧设为C，则B= C*D； 
 * D[0] = 1; D[i] = D[i-1] * A[i-1]; 从上到下计算 
 * C[len-1] = 1; C[i-1] = C[i] * A[i]; 从下到上计算 
 * 最后的 B[i] = D[i]*C[i]; 
 * 
 * 时间复杂度：O(n)，空间复杂度：O(n)。
 * 
 * @author 54060
 *
 */
public class Solution {
	public int[] multiply(int[] A) {
	    int n = A.length;
	    int[] B = new int[n];
	    for (int i = 0, product = 1; i < n; product *= A[i], i++)       /* 从左往右累乘 */
	        B[i] = product;
	    for (int i = n - 1, product = 1; i >= 0; product *= A[i], i--)  /* 从右往左累乘 */
	        B[i] *= product;
	    return B;
	}
}
