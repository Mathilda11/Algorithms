package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 组成整数的最小平方数数量
 * 要求解最小的平方数数量，就是求解从节点 n 到节点 0 的最短路径，只是节点与节点之间的路径的长度不一致了。
 * @author 54060
 *
 */
public class leeCode_279 {
	//动态规划
	public int numSquares(int n) {
	    List<Integer> squareList = generateSquareList(n);
	    int[] dp = new int[n + 1];
	    for (int i = 1; i <= n; i++) {
	        int min = Integer.MAX_VALUE;
	        for (int square : squareList) {
	            if (square > i) {
	                break;
	            }
	            min = Math.min(min, dp[i - square] + 1);
	        }
	        dp[i] = min;
	    }
	    return dp[n];
	}
/*	public int numSquares(int n) {
		//节点与节点之间的路径长度
	    List<Integer> squares = generateSquareList(n);
	    Queue<Integer> queue = new LinkedList<>();
	    boolean[] marked = new boolean[n + 1];
	    queue.add(n);
	    marked[n] = true;	//对于本题来说，初始状态：20
	    int level = 0;
	    while (!queue.isEmpty()) {
	        int size = queue.size();
	        level++;
	        while (size-- > 0) {
	            int cur = queue.poll();
	            for (int s : squares) {
	                int next = cur - s;
	                if (next < 0) {
	                    break;
	                }
	                if (next == 0) {
	                    return level;
	                }
	                if (marked[next]) {
	                    continue;
	                }
	                marked[next] = true;
	                queue.add(next); //广度优先搜索一层一层遍历，每一层得到的所有新节点，要用队列存储起来以备下一层遍历的时候再遍历。
	            }
	        }
	    }
	    return n;
	}*/

	/**
	 * 生成小于 n 的平方数序列
	 * @return 1,4,9,...
	 */
	private List<Integer> generateSquareList(int n) {
	    List<Integer> squares = new ArrayList<>();
	    int square = 1;
	    int diff = 3;
	    while (square <= n) {
	        squares.add(square);
	        square += diff;
	        diff += 2;
	    }
	    return squares;
	}
	
	public static void main(String[] args) {
		leeCode_279 leeCode_279 = new leeCode_279();
		leeCode_279.numSquares(3);
	}
}
