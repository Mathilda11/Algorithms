package leetCode;

public class leeCode_76 {
	private final static int[][] direction = {{0, 1}, {0, -1},{1, 0}, {-1, 0}};
	private int m;
	private int n;

	public boolean exist(char[][] board, String word) {
	    if (word == null || word.length() == 0) {
	        return true;
	    }
	    if (board == null || board.length == 0 || board[0].length == 0) {
	        return false;
	    }

	    m = board.length;
	    n = board[0].length;
	    boolean[][] hasVisited = new boolean[m][n];
	    //确定入口
	    for (int r = 0; r < m; r++) {
	        for (int c = 0; c < n; c++) {
	            if (backtracking(0, r, c, hasVisited, board, word)) {
	                return true;
	            }
	        }
	    }

	    return false;
	}

	private boolean backtracking(int curLen, int r, int c, boolean[][] visited, final char[][] board, final String word) {
	    if (curLen == word.length()) {
	        return true;
	    }
	    if (r < 0 || r >= m || c < 0 || c >= n
	            || board[r][c] != word.charAt(curLen) || visited[r][c]) {

	        return false;//不符合条件的返回到上一节点，然后，对于上一节点，按照下一d的方向移动。如果是true，则curLen+1
	    }

	    visited[r][c] = true;

	    for (int[] d : direction) {
	        if (backtracking(curLen + 1, r + d[0], c + d[1], visited, board, word)) {
	            return true;
	        }
	    }

	    visited[r][c] = false; //表名从该入口board[r][c]进去对于某字母不可达。需要重新进入。恢复原态。

	    return false;
	}
	
	public static void main(String[] args) {
		/**
		 * [
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
		 */
		char[][] board = {{'A','B','C','E'},{'S'
,'F','C','S'},{'A','D','E','E'}	};
		leeCode_76 leeCode_76 = new leeCode_76();
		leeCode_76.exist(board, "SEE");
	}
}
