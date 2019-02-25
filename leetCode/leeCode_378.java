package leetCode;

import java.util.PriorityQueue;

public class leeCode_378 {
	public int kthSmallest(int[][] matrix, int k) {
	    int m = matrix.length, n = matrix[0].length;
	    PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
	    for(int j = 0; j < n; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
	    for(int i = 0; i < k - 1; i++) { // 小根堆，去掉 k - 1 个堆顶元素，此时堆顶元素就是第 k 的数
	        Tuple t = pq.poll();
	        if(t.x == m - 1) continue;
	        pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
	    }
	    return pq.poll().val;
	}

	class Tuple implements Comparable<Tuple> {
	    int x, y, val;
	    public Tuple(int x, int y, int val) {
	        this.x = x; this.y = y; this.val = val;
	    }

	    @Override
	    public int compareTo(Tuple that) {
	        return this.val - that.val;
	    }
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,5,9,},{10,11,13},{12,13,15}};
		leeCode_378 leeCode_378 = new leeCode_378();
		leeCode_378.kthSmallest(matrix, 8);
	}
}
