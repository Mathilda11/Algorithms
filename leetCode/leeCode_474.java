package leetCode;

public class leeCode_474 {
	public int findMaxForm(String[] strs, int m, int n) {
	    if (strs == null || strs.length == 0) {
	        return 0;
	    }
	    int[][] dp = new int[m + 1][n + 1];
	    for (String s : strs) {    // 每个字符串只能用一次
	        int ones = 0, zeros = 0;
	        for (char c : s.toCharArray()) {
	            if (c == '0') {
	                zeros++;
	            } else {
	                ones++;
	            }
	        }
	        for (int i = m; i >= zeros; i--) {
	            for (int j = n; j >= ones; j--) {
	                dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
	            }
	        }
	    }
	    return dp[m][n];
	}
	
	public static void main(String[] args) {
		String[] strs = {"10", "0001", "111001", "1", "0"};
		leeCode_474 leeCode_474 = new leeCode_474();
		leeCode_474.findMaxForm(strs, 5, 3);
	}
}
