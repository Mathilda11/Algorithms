package test10;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 
 * 回溯法：首先任意一个点都有可能成为起点，所以要获得任意一点的坐标(位于第几行，第几列)
 * 其次要有一个数组记录这个点是否被访问过，同时要有一个指针来记录字符串中字符的位置。
 * 当某个点成为合法的起点时，即这个点与字符串中第一个字符相等，则可以继续朝上下左右搜索下一个点；
 * 如果这个点不能成为合法的起点，则恢复现场(这个点没有被访问过且字符串指针后退)
 * @author 54060
 *
 */
public class Solution {
	//全局变量
	private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};//左,右,上,下
	private int rows;
	private int cols;

	public boolean hasPath(char[] array, int rows, int cols, char[] str) {
	    if (rows == 0 || cols == 0)
	        return false;
	    this.rows = rows;
	    this.cols = cols;
	    boolean[][] marked = new boolean[rows][cols];
	    //将传入的array按指定行数row,指定列数cols组装成matrix
	    char[][] matrix = buildMatrix(array);
	    for (int i = 0; i < rows; i++)
	        for (int j = 0; j < cols; j++)
	            if (backtracking(matrix, str, marked, 0, i, j))  //只要选择其中一个入口进行存在这条路径即可。
	                return true;
	    return false;
	}

	private boolean backtracking(char[][] matrix, char[] str, boolean[][] marked, int pathLen, int r, int c) {
	    if (pathLen == str.length)
	        return true;
	    if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] != str[pathLen] || marked[r][c]) //为真 已走过 不算
	        return false;
	    marked[r][c] = true;
	    for (int[] n : next)
	        if (backtracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1]))
	            return true;
	    marked[r][c] = false;
	    return false;
	}

	private char[][] buildMatrix(char[] array) {
	    char[][] matrix = new char[rows][cols];
	    for (int i = 0, idx = 0; i < rows; i++) //外循环 行
	        for (int j = 0; j < cols; j++) //内循环 列
	            matrix[i][j] = array[idx++];  //只需限制matrix的索引
	    return matrix;
	}
}
