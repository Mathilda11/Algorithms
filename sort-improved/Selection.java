package algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author 54060
 *
 * @param <T>
 */
public class Selection<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }
    
    public static void main(String[] args) {
    	Comparable[] nums = {5,3,6,2,10,20,4,8,9};
        System.out.println("排序前："+Arrays.toString(nums));
        Selection selection = new Selection<>();
        selection.sort(nums);
        System.out.println("排序后："+Arrays.toString(nums));
	}
}
