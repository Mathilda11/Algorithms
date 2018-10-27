package test39;
/**
 * 数据流中的中位数
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * @author 54060
 *
 */
import java.util.PriorityQueue;

//Java的PriorityQueue 是从JDK1.5开始提供的新的数据结构接口，默认内部是自然排序，结果为小顶堆，也可以自定义排序器.
//comparator:相当于从小到大排序 大的返回正值，往后放 return obj1.value()-obj2.value(); 
//相当于从大到小排序，大值返回负值，往前放 return -(obj1.value()-obj2.value());

public class Solution1 {
	/* 大顶堆，存储左半边元素 */
	private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
	/* 小顶堆，存储右半边元素，并且右半边元素都大于左半边 */
	private PriorityQueue<Integer> right = new PriorityQueue<>();
	/* 当前数据流读入的元素个数 */
	private int N = 0;
	
	//数据流：3,1,2,4,5  大顶堆：2,1 小顶堆：3,4,5
	public void Insert(Integer val) {
	    /* 插入要保证两个堆存于平衡状态 */
	    if (N % 2 == 0) {
	        /* N 为偶数的情况下插入到右半边。
	         * 因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素来的大，
	         * 因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边 */
	        left.add(val);  //新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
	        right.add(left.poll());//获取和删除队列的第一个元素
	    } else {
	        right.add(val);//筛选后的小根堆中的最小元素进入大根堆
	        left.add(right.poll());
	    }
	    N++;
	}

	public Double GetMedian() {
	    if (N % 2 == 0)
	        return (left.peek() + right.peek()) / 2.0;  //peek()方法只检索的元件在头部但poll() 也与检索移除element
	    else
	        return (double) right.peek();
	}
}
