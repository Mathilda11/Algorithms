package test61;

/**
 * 股票的最大利润
 * 可以有一次买入和一次卖出，那么买入必须在前。求最大收益。
 * 
 * 使用贪心策略，假设第 i 轮进行卖出操作，买入操作价格应该在 i 之前并且价格最低。
 * 时间复杂度：O(n)
 * @author 54060
 *
 */
public class Solution {
	public int maxProfit(int[] prices) {
	    if (prices == null || prices.length == 0)
	        return 0;
	    int soFarMin = prices[0]; //soFarMin来记录之前的i-1个数字中的最小值
	    int maxProfit = 0; //maxProfit来记录当卖出价为数组中第i个数字时可能获得的最大利润
	    
	    for (int i = 1; i < prices.length; i++) {
	        soFarMin = Math.min(soFarMin, prices[i]);
	        maxProfit = Math.max(maxProfit, prices[i] - soFarMin);
	    }
	    return maxProfit;
	}
}
