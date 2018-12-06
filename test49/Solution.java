package test49;
/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007。
 * 已知左右两个子数组left，right是有序的，设置两个指针，分别在左右两个数组的第一个元素leftPoint、rightPoint上面，比较两个数值大小，
 * 如果leftPoint<rightPoint，表示这两个数不构成逆序对，于是将leftPoint++，再次比较；
 * 如果leftPoint> rightPoint,说明这是一个逆序对，并且leftPoint后面的数都比leftPoint要大，所以与rightPoint都可以构成逆序对，
 * 所以由leftPoint产生的逆序对数目是leftPoint数组中leftPoint以及后面元素的数目即middle-leftPoint+1；
 * 然后将rightPoint++再次比较leftPoint和rightPoint。
 * 
 * 当left、right两个数组遍历完成后就可以知道在合并过程中产生的逆序对的数目；
 * 在leftPoint和rightPoint的比较过程中，除了计算逆序对数目之外还要对合并后的数组排序，排序在leftPoint和rightPoint逐一比较的过程中进行，
 * 每次leftPoint和rightPoint比较，将较小的值放入到创建的temp[]数组上面，如果left或者right一侧的数组提前遍历完成，
 * 那么逆序对不再增加，将right或者left数组中剩下的元素全部直接复制到temp[]中即可；
 * 最终当left和right数组遍历合完成后这个数组对应在temp中就是有序的，由于下一次合并在array[]数组基础上进行而不是在temp基础上进行，
 * 因此需要将temp[]从start到end的部分重新对array进行覆盖。
 * https://www.cnblogs.com/coffy/p/5896541.html
 * 逆序对的总数=左边数组中的逆序对的数量+右边数组中逆序对的数量+左右结合成新的顺序数组时中出现的逆序对的数量；
 * 
 * 第一次 temp存放5,7,4,6给num  temp记录排序后的数组 
 * 由于已经统计了这两对子数组内部的逆序对，因此需要把这两对子数组进行排序，避免在之后的统计过程中重复统计。 
 * @author 54060
 *
 */
public class Solution {
	private long cnt = 0;
	private int[] tmp;  // 在这里声明辅助数组，而不是在 merge() 递归函数中声明

	public int InversePairs(int[] nums) {
	    tmp = new int[nums.length];
	    mergeSort(nums, 0, nums.length - 1);
	    return (int) (cnt % 1000000007);
	}
	
	/**
	 * 先把数组分解成两个长度为2的子数组，再把这两个子数组分解成两个长度为1的子数组。接下来一边合并相邻的子数组，一边统计逆序对的数目。
	 * @param nums
	 * @param l
	 * @param h
	 */
	private void mergeSort(int[] nums, int l, int h) {
	    if (h - l < 1)
	        return;
	    int m = l + (h - l) / 2;
	    mergeSort(nums, l, m);
	    mergeSort(nums, m + 1, h);
	    merge(nums, l, m, h);
	    //mergeSort(nums,0,1) { mergeSort(0,0), mergeSort(1,1), merge(0,0,1) }
	    //mergeSort(nums,2,3) { mergeSort(2,2), mergeSort(3,3), merge(2,2,3) }
	    //merge(nums,0,1,3)      
	}
	
	//两个子数组
	//i:0~m j:m+1~h 
	private void merge(int[] nums, int l, int m, int h) {
	    int i = l, j = m + 1, k = l;
	    while (i <= m || j <= h) {
	        if (i > m)
	            tmp[k] = nums[j++];//如果超过该子数组的范围，就算剩下的那个。
	        else if (j > h)
	            tmp[k] = nums[i++];
	        else if (nums[i] < nums[j])
	            tmp[k] = nums[i++];
	        else {
	            tmp[k] = nums[j++]; //++：移动指针
	            this.cnt += m - i + 1;  // 归并排序后， nums[i] >= nums[j]，说明 nums[i...mid] 都大于 nums[j]
	        }
	        k++;
	    }
	    for (k = l; k <= h; k++)
	        nums[k] = tmp[k];
	}
}
