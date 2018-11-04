package algorithm.sort;

/**
 * 待排序的元素需要实现 Java 的 Comparable 接口，该接口有 compareTo() 方法，可以用它来判断两个元素的大小关系。

        研究排序算法的成本模型时，计算的是比较和交换的次数。
	
        使用辅助函数 less() 和 swap() 来进行比较和交换的操作，使得代码的可读性和可移植性更好。
 * @author 54060
 *
 * @param <T>
 */
public abstract class Sort<T extends Comparable<T>> {
	public abstract void sort(T[] nums);
	
	protected boolean less(T v, T w) {
	    return v.compareTo(w)<0;	//v<w，返回-1,true。v>w，返回1。v=w，返回0,false。
	}
	
	protected void swap(T[] a, int i, int j) {
	    T t = a[i];
	    a[i] = a[j];
	    a[j] = t;
	}
}
