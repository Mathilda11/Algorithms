package leetCode;

public class leeCode_64 {
/*	public int minPathSum(int[][] grid) {
		 int dp[][]=new int [grid.length][grid[0].length]; 
		 dp[0][0]=grid[0][0]; 
		 for(int i=1;i<grid.length;i++) { 
			 dp[i][0]=dp[i-1][0]+grid[i][0]; //第一列只能由上向下 
		 } 
		 
		 for(int j=1;j<grid[0].length;j++) { 
			 dp[0][j]=dp[0][j-1]+grid[0][j]; 
			 //第一行只能由左向右 
			 } 
		 for(int i=1;i<grid.length;i++) 
			 for(int j=1;j<grid[0].length;j++) {
				 dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];//dp存放的是和值。
				 } 
		 return dp[grid.length-1][grid[0].length-1];
		 }*/
	
	//用一维数组表示，空间压缩。
	public int minPathSum(int[][] grid) {
	    if (grid.length == 0 || grid[0].length == 0) {
	        return 0;
	    }
	    int m = grid.length, n = grid[0].length;
	    int[] dp = new int[n];
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            if (i == 0 && j>0) {
	                dp[j] = dp[j - 1];
	            } else {
	               if(j>0){
	            	   dp[j] = Math.min(dp[j - 1], dp[j]);
	               }
	            }
	            dp[j] += grid[i][j];
	        }
	    }
	    return dp[n - 1];
	}
	
	public static void main(String[] args) {
		leeCode_64 leeCode_64 = new leeCode_64();
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(leeCode_64.minPathSum(grid));
	}
}
