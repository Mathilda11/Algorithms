package algorithm.sort;

/**
 * 三向切分

       对于有大量重复元素的数组，可以将数组切分为三部分，分别对应小于、等于和大于切分元素。

        三向切分快速排序对于只有若干不同主键的随机数组可以在线性时间内完成排序。
 * @author 54060
 *
 * @param <T>
 */
public class ThreeWayQuickSort<T extends Comparable<T>> extends QuickSort<T> {

    protected void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int lt = l, i = l + 1, gt = h;
        T v = nums[l];
        while (i <= gt) {
            int cmp = nums[i].compareTo(v);
            if (cmp < 0) {
                swap(nums, lt++, i++);
            } else if (cmp > 0) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        sort(nums, l, lt - 1); //将比v小的排序
        sort(nums, gt + 1, h); //将比v大的排序
    }
    
    public static void main(String[] args) {
		Comparable[] nums = {5,5,4,3,7,6,6};
		ThreeWayQuickSort threeWayQuickSort = new ThreeWayQuickSort<>();
		threeWayQuickSort.sort(nums,0,6);
	}
}
