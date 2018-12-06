package test38;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 大小为 K 的最小堆
 * 
 * 复杂度：O(NlogK) + O(K)
 * 特别适合处理海量数据
 * 
 * 应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。
 * 
 * 维护一个大小为 K 的最小堆过程如下：在添加一个元素之后，如果大顶堆的大小大于 K，那么需要将大顶堆的堆顶元素去除。
 * 
 * add或者offer方法完成新添一个元素到堆结构中
 * 实际上add方法的内部调用的还是offer方法
 * @author 54060
 *
 */
/*
 * https://blog.csdn.net/u013066244/article/details/78997869
 * 
 * java comparator 升序、降序
 * 
 * ① jdk官方默认是升序，是基于：
 * 
 * < return -1
 * = return 0
 * > return 1
 * 
 * 
 * 官方的源码就是基于这个写的；可以理解为硬性规定。
 * 也就是说，排序是由这三个参数同时决定的。
 * 
 * 如果要降序就必须完全相反：
 * 
 * < return 1
 * = return 0
 * > return -1
 * 
 */
public class Solution1_2 {
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
	    if (k > nums.length || k <= 0) //鲁棒性
	        return new ArrayList<>();
	    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);//优先队列/堆 （大->小）
	    for (int num : nums) {
	        maxHeap.add(num);//加入到堆
	        if (maxHeap.size() > k)
	            maxHeap.poll();//使大的出堆（删除）。则下面的k个元素就是小的
	    }
	    return new ArrayList<>(maxHeap);
	}
}
