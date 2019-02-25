package leetCode;
/*
 * 题目描述：找到第 k 大的元素。
 */
public class leeCode_215 {
	public int findKthElement(int[] nums, int k) {
	    k = nums.length - k;
	    int l = 0, h = nums.length - 1;
	    while (l < h) {
	        int j = partition(nums, l, h);
	        if (j == k) {
	            break;
	        } else if (j < k) {
	            l = j + 1;
	        } else {
	            h = j - 1;
	        }
	    }
	    return nums[k];
	}

	private int partition(int[] a, int l, int h) {
	    int i = l, j = h + 1;
	    while (true) {
	        while (a[++i] < a[l] && i < h) ;
	        while (a[--j] > a[l] && j > l) ;
	        if (i >= j) {
	            break;
	        }
	        swap(a, i, j);
	    }
	    swap(a, l, j);
	    return j;
	}

	private void swap(int[] a, int i, int j) {
	    int t = a[i];
	    a[i] = a[j];
	    a[j] = t;
	}
	
	public static void main(String[] args) {
		leeCode_215 leeCode_215 = new leeCode_215();
		int[] nums = {3,2,1,5,6,4};
		leeCode_215.findKthElement(nums, 3);
	}
}
