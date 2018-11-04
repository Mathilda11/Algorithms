package algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * @author 54060
 *
 * @param <T>
 */
public class Insertion<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
                swap(nums, j, j - 1);
            }
        }
    }
    public static void main(String[] args) {
    	Comparable[] nums = {5,3,6,2,10};
        System.out.println("排序前："+Arrays.toString(nums));
        Insertion insertion = new Insertion<>();
        insertion.sort(nums);
        System.out.println("排序后："+Arrays.toString(nums));
	}
}