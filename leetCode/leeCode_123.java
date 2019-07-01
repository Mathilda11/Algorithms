package leetCode;
/*
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class leeCode_123 {
	public int maxProfit(int[] prices) {
	    int sell1 = 0, sell2 = 0;
	    int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
	    /*
	     * buy1，记录的是在从第1天到第i天你能买到的最低价格（买了，所以欠账，所以记录为负数，所以用max），
	     * sell1，记录的是在第1天到第i天中的某天，你卖出，能最多赚到多少钱。
	     */
	    for (int price : prices) {  ////每次循环表示进入新的一天
	        buy1 = Math.max(buy1, -price);  //记录之前所有天最便宜的股价
	        sell1 = Math.max(sell1, buy1 + price); //记录之前所有天只进行1次买卖的最大利益
	        buy2 = Math.max(buy2, sell1 - price);//记录之前天先进行1次交易获得最大利益后，再买到那次交易后最便宜股价时剩余的净利润
	        sell2 = Math.max(sell2, buy2 + price);//记录之前天进行2次完整交易的最大利润
	    }
	    return sell2;
	}
	
	public static void main(String[] args) {
		int[] prices = {1,2,3,0,2};
		leeCode_123 leeCode_123 = new leeCode_123();
		System.out.println(leeCode_123.maxProfit(prices));
	}
}
