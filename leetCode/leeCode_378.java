package leetCode;

import java.util.Comparator;
/*
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素
 * 请注意，它是排序后的第k小元素，而不是第k个元素。 
 */
import java.util.PriorityQueue;

class Tuple {
    int x, y, val;
    public Tuple(int x, int y, int val) {
        this.x = x; 
        this.y = y; 
        this.val = val;
    }
}
public class leeCode_378 {
	public int kthSmallest(int[][] matrix, int k) {
	    int m = matrix.length, n = matrix[0].length;
	    PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>(new Comparator<Tuple>() {
			public int compare(Tuple t1, Tuple t2) {
				return t1.val - t2.val;
			}
		});
	    for(int j = 0; j < n; j++){
	    	pq.offer(new Tuple(0, j, matrix[0][j]));
	    }
	    for(int i = 0; i < k - 1; i++) { // 小顶堆，去掉 k - 1 个堆顶元素，此时堆顶元素就是第 k 的数
	        Tuple t = pq.poll();
	        if(t.x == m - 1) 
	        	continue;
	        pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
	    }
	    return pq.poll().val;
	}
	public int kthSmallest2(int[][] matrix, int k) {
	    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1); //大根堆
	    for(int i = 0; i < matrix.length; i++){
	    	for(int j = 0; j < matrix[0].length; j++){
	    		pq.offer(matrix[i][j]);
	    		if(pq.size() > k)
	    			pq.poll();
	    	}
	    }
	    return pq.peek();
	}
	public static void main(String[] args) {
		int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
		leeCode_378 leeCode_378 = new leeCode_378();
		System.out.println(leeCode_378.kthSmallest(matrix, 8));
		System.out.println(leeCode_378.kthSmallest2(matrix, 8));
	}
}
