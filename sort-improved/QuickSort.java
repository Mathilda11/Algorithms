package algorithm.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 快速排序
 * @author 54060
 *
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        shuffle(nums);  //为了防止数组最开始就是有序的，在进行快速排序时需要随机打乱数组。
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l)
            return;
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }
    
    //返回一个整数 j 使得 a[l..j-1] 小于等于 a[j]，且 a[j+1..h] 大于等于 a[j]，此时 a[j] 就是数组的第 j 大元素。
    private int partition(T[] nums, int l, int h) {
        int i = l, j = h + 1;
        T v = nums[l];
        while (true) {
            while (less(nums[++i], v) && i != h) ;  //当nums[i]<v时，左指针向右移。否则不移动。
            while (less(v, nums[--j]) && j != l) ;  //当nums[j]>v时，右指针向左移。否则不移动。
            if (i >= j)
                break;	//退出循环
            swap(nums, i, j);	//交换两个元素
        }
        swap(nums, l, j);	//定位到num[l]应在的下标j，返回j。此时j左边的元均小于v，右边的均大于v。
        return j;
    }

    private void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }
    
    //基于切分的快速选择算法
    public T select(T[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (h > l) {
            int j = partition(nums, l, h);

            if (j == k) {
                return nums[k];

            } else if (j > k) {
                h = j - 1;

            } else {
                l = j + 1;
            }
        }
        return nums[k];
    }
    public static void main(String[] args) {
    	Comparable[] nums = {5,3,6,2,10,20,4,8,9};
        System.out.println("排序前："+Arrays.toString(nums));
        QuickSort quickSort = new QuickSort<>();
        quickSort.sort(nums);
        System.out.println("排序后："+Arrays.toString(nums));
	}
}