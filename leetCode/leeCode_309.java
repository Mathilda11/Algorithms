package leetCode;

/**
 * 交易之后需要有一天的冷却时间。
设计算法以找到最大利润。 您可以通过以下限制完成任意数量的交易（即买入并多次卖出一股股票）： 您不得同时进行多笔交易（即，您必须在再次购买之前卖出股票）。 在您出售股票后，您无法在第二天购买股票。 （即冷却1天）
https://blog.csdn.net/qq_17550379/article/details/82856452
 * @author 54060
 *
 */
public class leeCode_309 {
	public int maxProfit(int[] prices) {
	    if (prices == null || prices.length == 0) {
	        return 0;
	    }
	    int N = prices.length;
	    int[] buy = new int[N];
	    int[] sell = new int[N];
	    int[] cooldown = new int[N];
	    buy[0] = -prices[0];
	    sell[0]=0;
	    cooldown[0]=0;
	    for (int i = 1; i < N; i++) {
	    	cooldown[i] = sell[i-1];
	    	sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
	    	buy[i] = Math.max(buy[i-1], cooldown[i-1] - prices[i]);
	    	
	    }
	    return Math.max(sell[N - 1], cooldown[N - 1]);
	}
	
	public static void main(String[] args) {
		int[] prices = {1,2,3,0,2};
		leeCode_309 leeCode_309 = new leeCode_309();
		System.out.println(leeCode_309.maxProfit(prices));
	}
}
