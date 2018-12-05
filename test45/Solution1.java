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
public class Solution1 {
	public static int getMaxPathValue(int[][] values){
		int rows = values.length;
		int cols = values[0].length;
		
        if (values == null || rows <= 0 || cols <= 0) 
        	return 0;


        int[][] maxValues = new int[rows][cols];//辅助的二维数组，缓存中间结果，maxValues[i][j]表示到达坐标(i,j)的格子时能拿到的礼物价值总和的最大值
        
        for (int i = 0; i < rows; ++i)
        {
            for (int j = 0; j < cols; ++j)
            {
                int fromLeft = 0; //左边
                int fromUp = 0; //上边

                if (i > 0)
                    fromUp = maxValues[i - 1][j];
                if (j > 0)
                    fromLeft = maxValues[i][j - 1];

                maxValues[i][j] = Math.max(fromLeft, fromUp) + values[i][j];
            }
        }
        return maxValues[rows - 1][cols - 1];
    }
}
