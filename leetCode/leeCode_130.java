package leetCode;

/**
 * 使被 'X' 包围的 'O' 转换为 'X'。
 * 先填充最外侧，剩下的就是里侧了。
 * @author 54060
 *
 */
public class leeCode_130 {
	private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	private int m, n;

	public void solve(char[][] board) {
	    if (board == null || board.length == 0) {
	        return;
	    }

	    m = board.length;
	    n = board[0].length;
	    
	    //board[0][0] board[0][3]  board[1][0] board[1][3] board[2][0] board[2][3] board[3][0] board[3][3]
	    //矩阵的第一列和最后一列
	    for (int i = 0; i < m; i++) {
	        dfs(board, i, 0);
	        dfs(board, i, n - 1);
	    }
	    ////矩阵的第一行和最后一行
	    for (int i = 0; i < n; i++) {
	        dfs(board, 0, i);
	        dfs(board, m - 1, i);
	    }

	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            if (board[i][j] == 'T') {
	                board[i][j] = 'O';
	            } else if (board[i][j] == 'O') {
	                board[i][j] = 'X';
	            }
	        }
	    }
	}

	private void dfs(char[][] board, int r, int c) {
	    if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O') {
	        return;
	    }
	    board[r][c] = 'T';
	    for (int[] d : direction) {	     //如果O的右/左/上/下还是O的，替换成T
	    							   	//因为此时由O找到的O的周围肯定不全是X了，最终要留住
	        dfs(board, r + d[0], c + d[1]);
	    }
	}
	public static void main(String[] args) {

		char[][] board = {{'X','X','X','X'},{'X','O','O','X',},{'X','X','O','X'},{'X','O','X','X'}};
		leeCode_130 leeCode_130 = new leeCode_130();
		leeCode_130.solve(board);
	}
}
