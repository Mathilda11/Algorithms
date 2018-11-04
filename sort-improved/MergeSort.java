package algorithm.sort;

import java.util.Arrays;

/**
 * 归并方法将数组中两个已经排序的部分归并成一个
 * @author 54060
 *
 * @param <T>
 */
public  class MergeSort<T extends Comparable<T>> extends Sort<T> {

    protected T[] aux;

    protected void merge(T[] nums, int l, int m, int h) {

        int i = l, j = m + 1;

        for (int k = l; k <= h; k++) {
            aux[k] = nums[k]; // 将数据复制到辅助数组
        }

        for (int k = l; k <= h; k++) {
            if (i > m) {
                nums[k] = aux[j++];

            } else if (j > h) {
                nums[k] = aux[i++];

            } else if (aux[i].compareTo(nums[j]) <= 0) {
                nums[k] = aux[i++]; // 先进行这一步，保证稳定性

            } else {
                nums[k] = aux[j++];
            }
        }
    }
    
    @Override
    public void sort(T[] nums) {
    	
        aux = (T[]) new Comparable[nums.length];
        
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        
        int mid = l + (h - l) / 2;
        
        sort(nums, l, mid);
        
        sort(nums, mid + 1, h);
        
        merge(nums, l, mid, h);
    }
    
    public static void main(String[] args) {
    	Comparable[] nums = {5,3,6,2,10,20,4,8,9};
    	
    	System.out.println("排序前："+Arrays.toString(nums));
    	
    	MergeSort up2newDownMergeSort = new MergeSort<>();
    	up2newDownMergeSort.sort(nums);
    	
        System.out.println("排序后："+Arrays.toString(nums));
	}
}