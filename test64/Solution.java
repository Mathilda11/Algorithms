package test64;

/**
 * 构建乘积数组
 * 给定一个数组 A[0, 1,..., n-1]，请构建一个数组 B[0, 1,..., n-1]，
 * 其中 B 中的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。要求不能使用除法。  A[i]=1
 * 
 * 
 * 这是一个三角形问题：
 * 
 * 第一步：计算下三角，也就是每行的【】之前的乘积
 * 
 * 第一步：b[0] = 1;
 * 第二步：b[1] = b[0] * a[0] = a[0]
 * 第三步：b[2] = b[1] * a[1] = a[0] * a[1];
 * 第四步：b[3] = b[2] * a[2] = a[0] * a[1] * a[2];
 * 第五步：b[4] = b[3] * a[3] = a[0] * a[1] * a[2] * a[3];
 * 
 * 第二步：计算上三角，也就是每行【】之后的乘积
 * 
 * 第一步
 * temp *= a[4] = a[4]; 
 * b[3] = b[3] * temp = a[0] * a[1] * a[2] * a[4];
 * 第二步
 * temp *= a[3] = a[4] * a[3];
 * b[2] = b[2] * temp = a[0] * a[1] * a[4] * a[3];
 * 第三步
 * temp *= a[2] = a[4] * a[3] * a[2]; 
 * b[1] = b[1] * temp = a[0] * a[4] * a[3] * a[2];
 * 第四步
 * temp *= a[1] = a[4] * a[3] * a[2] * a[1]; 
 * b[0] = b[0] * temp = a[4] * a[3] * a[2] * a[1];
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
