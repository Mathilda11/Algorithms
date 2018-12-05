package test45;
/**
 * 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。
 * 给定一个棋盘，求拿到礼物的最大价值。例如，对于如下棋盘
 * 
 * 1    10   3    8
 * 12   2    9    6
 * 5    7    4    11
 * 3    7    16   5
 * 
 * 礼物的最大价值为 1+12+5+7+7+16+5=53。
 * 
 * @author 54060
 *
 */
public class Solution2 {
	public static int getMaxPathValue(int[][] values)
    {
		int rows = values.length;
		int cols = values[0].length;
		
        if (values == null || rows <= 0 || cols <= 0) 
        	return 0;

        //(0,0)…(0,j-1)保存的是(i,0)…(i,j-1)的最大价值；(0,j)…(0,cols-1)保存的是(i-1,j)…(i-1,cols-1)的最大价值。
        int[] maxValues = new int[cols];//辅助的一维数组
        
        for (int i = 0; i < rows; ++i)
        {
            for (int j = 0; j < cols; ++j)
            {
                int fromLeft = 0;
                int fromUp = 0; 

                if (i > 0)
                    fromUp = maxValues[j];
                if (j > 0)
                    fromLeft = maxValues[j - 1];

                maxValues[j] = Math.max(fromLeft, fromUp) + values[i][j];
            }
        }
        return maxValues[cols - 1];
    }
}
