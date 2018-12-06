package test51;
/*
 * 0到n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0到n-1之内。在范围0到n-1的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 
 * 实质是找出第一个值和下标不相等的元素。
 
 * 时间复杂度O(log n)
 */
public class Solution2 {
    public int getMissingNumber(int[] nums) {
        if(nums==null || nums.length<=0)
            return -1;
        int l=0;
        int h=nums.length-1;
        while(l<=h) {
            int m = l + (h - l)/2;
            if(nums[m]!=m) { //该元素的值和下标不相等
                if(m==0 || nums[m-1]==m-1) //如果该元素是第一个或者该元素前面的元素值和下标相等，则该元素就是缺少的那个
                    return m;
                h=m-1; //否则，缺少的在前半段
            }else {  
                l=m+1; //缺少的在后半段
            }
        }
        if(l==nums.length){  //数组前面的元素值都和下标相等，说明缺失的是最大的那个元素(n-1)
        	return nums.length;
        }
        return -1; //无效的输入
    }
}
