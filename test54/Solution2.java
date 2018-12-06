package test54;
/*
 * 在一个数组中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 思路：我们把数组中所有数字的二进制表示的每一位都加起来。如果某一位的和能被3整除，那么那个只出现一次的数字二进制表示中对应的那一位是0；否则就是1。
 * 
 * 
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class Solution2 {
	public int FindNumberAppearingOnce(int[] numbers){
	        int result=0;
	        for(int i=0;i<32;i++){
	            int bit=0;
	            for(int j=0;j<numbers.length;j++){
	                bit+=(numbers[j]>>i)&1;
	            }
	            result |= (bit%3)<<i;
	        }
	        return result;
	    }
}
