package leetCode;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class Knapsack {
	public int knapsack(int W, int N, int[] weights, int[] values) {
	    int[] dp = new int[W + 1];
	    for (int i = 1; i <= N; i++) {
	        int w = weights[i - 1], v = values[i - 1];
	        for (int j = W; j >= weights[i-1]; j--) {
	            if (j >= w) {
	                dp[j] = Math.max(dp[j], dp[j - w] + v);
	            }
	        }
	    }
	    return dp[W];
	}
	/**
     * 第二类背包：完全背包
     * 思路分析：
     * 01背包问题是在前一个子问题（i-1种物品）的基础上来解决当前问题（i种物品），
     * 向i-1种物品时的背包添加第i种物品；
     * 而完全背包问题是在解决当前问题（i种物品），向i种物品时的背包添加第i种物品。
     * 推公式计算时，f[i][y] = max{f[i-1][y], (f[i][y-weight[i]]+value[i])}，
     * 注意这里当考虑放入一个物品 i 时应当考虑还可能继续放入 i，
     * 因此这里是f[i][y-weight[i]]+value[i], 而不是f[i-1][y-weight[i]]+value[i]。
     * @param V
     * @param N
     * @param weight
     * @param value
     * @return
     */
	public int completePack(int W, int N, int[] weights, int[] values) {
	    int[] dp = new int[W + 1];
	    for (int i = 1; i <= N; i++) {
	        int w = weights[i - 1], v = values[i - 1];
	        for (int j = weights[i - 1]; j <= W; j++) { //如果当前物品的重量大于背包容量j，则不装入背包
	            if (j >= w) {
	                dp[j] = Math.max(dp[j], dp[j - w] + v);
	            }
	        }
	    }
	    return dp[W];
	}

	/**
     * 第三类背包：多重背包
     * 
     * @param args
     */
	 public static int multiplePack(int W, int N,int[] weight,int[] value,int[] num){
		//初始化动态规划数组
		 int[][] dp = new int[N+1][W+1];
		 //为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
	        for(int i=1;i<=N;i++){
	        	for(int j=1;j<=W;j++){
	        		//如果第i件物品的重量大于背包容量j,则不装入背包
	                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
	        		 if(weight[i-1] > j)
	                     dp[i][j] = dp[i-1][j];
	        		 else{
	                     //考虑物品的件数限制
	                     int maxV = Math.min(num[i-1],j/weight[i-1]);
	                     for(int k=0;k<=maxV;k++){
	                    	 dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-k*weight[i-1]]+k*value[i-1]);
	                     }
	        	}
	        }
	        }
	        return dp[N][W];
	 }
	public static void main(String[] args) {
		Knapsack knapsack = new Knapsack();
		int[] weights = {1,2,3};
		int[] values = {6,10,12};
		int[] num = {3,3,3};
		System.out.println(knapsack.knapsack(5, 3, weights, values));
		System.out.println(knapsack.completePack(5, 3, weights, values));
		System.out.println(knapsack.multiplePack(5, 3, weights, values, num));
	}
}
