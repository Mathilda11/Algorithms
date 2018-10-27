package test57;
/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 及滑动窗口的大小 3，那么一共存在 6 个滑动窗口，他们的最大值分别为 {4, 4, 6, 6, 6, 5}。
 * @author 54060
 *
 */
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
	    ArrayList<Integer> ret = new ArrayList<>();  //方法里de声明不加访问修饰符
	    if (size > num.length || size < 1)
	        return ret;
	    PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);  /* 大顶堆 */
	    for (int i = 0; i < size; i++)
	        heap.add(num[i]);
	    ret.add(heap.peek());
	    for (int i = 1, j = i + size - 1; j < num.length; i++, j++) {            /* 维护一个大小为 size 的大顶堆 */
	        heap.remove(num[i - 1]);  // remove(Object o) 方法用于从该队列中移除指定元素的单个实例(如果存在)。
	        heap.add(num[j]);
	        ret.add(heap.peek());
	    }
	    return ret;
	}
}
