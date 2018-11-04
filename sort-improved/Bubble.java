package algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author 54060
 *
 * @param <T>
 */
public class Bubble<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        boolean hasSorted = false;
        for (int i = N - 1; i > 0 && !hasSorted; i--) {
            hasSorted = true;
            for (int j = 0; j < i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    hasSorted = false;
                    swap(nums, j, j + 1);
                }
            }
        }
    }
    public static void main(String[] args) {
    	Comparable[] nums = {5,3,6,2,10};
        System.out.println("排序前："+Arrays.toString(nums));
        Bubble bubble = new Bubble<>();
        bubble.sort(nums);
        System.out.println("排序后："+Arrays.toString(nums));
	}
}