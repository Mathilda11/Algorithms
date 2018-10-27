package test02;
/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author 54060
 *
 */
public class Solution {
	public boolean find(int target, int[][] matrix){
		if(matrix == null || matrix.length ==0 ||matrix[0].length == 0){
			return false;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int r = 0;
		int c = cols - 1;
		while(r <= rows-1 && c >= 0){
			if(target == matrix[r][c]){
				return true;
			}else if(target > matrix[r][c]){
				r++;
			}else{
				c--;
			}
		}
		return false;
	}
}
