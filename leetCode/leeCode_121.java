package leetCode;

import java.util.HashMap;

/**
 * 买入和售出股票最大的收益。只进行一次交易。假设有一个数组，它的第i项是第i天的股票价格。
 * 如果你最多只能进行一次买卖操作（买一次，卖一次），设计一个算法求出最大的收益。
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * @author 54060
 *
 */
public class leeCode_121 {
	public int maxProfit(int[] prices) {
	    int n = prices.length;
	    if (n == 0) return 0;
	    int soFarMin = prices[0];
	    int max = 0;
	    for (int i = 1; i < n; i++) {
	        if (soFarMin > prices[i]) //第i天买 
	        	soFarMin = prices[i]; 
	        else 
	        	max = Math.max(max, prices[i] - soFarMin);
	    }
	    return max;
	}
	
	public int findString(String str){
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0;i<str.length();i++){
			if(map.containsKey(str.charAt(i))){
				map.put(str.charAt(i), Integer.MIN_VALUE);
			}else{
				map.put(str.charAt(i), i);
			}
		}
		for(int value: map.values()){
			if(value!=Integer.MIN_VALUE){
				return value;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		leeCode_121 leeCode_121 = new leeCode_121();
		System.out.println(leeCode_121.findString("abcdabc"));
	}
}
