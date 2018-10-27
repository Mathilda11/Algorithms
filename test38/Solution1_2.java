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
public class Solution1_2 {
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
	    if (k > nums.length || k <= 0)
	        return new ArrayList<>();
	    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);//队列（大->小）
	    for (int num : nums) {
	        maxHeap.add(num);//加入到队列头
	        if (maxHeap.size() > k)
	            maxHeap.poll();//使大的出队列（删除） peek()不删除
	    }
	    return new ArrayList<>(maxHeap);
	}
}
