package leetCode;

import java.util.Stack;

public class leeCode_739 {
	public int[] dailyTemperatures(int[] temperatures) {
	    int n = temperatures.length;
	    int[] dist = new int[n];
	    Stack<Integer> indexs = new Stack<>();
	    //{73, 74, 75, 71, 69, 72, 76, 73}
	    for (int curIndex = 0; curIndex < n; curIndex++) {
	        while (!indexs.isEmpty() && temperatures[curIndex] > temperatures[indexs.peek()]) {
	            int preIndex = indexs.pop();
	            dist[preIndex] = curIndex - preIndex;
	        }
	        indexs.add(curIndex);
	    }
	    return dist;
	}
	
	public static void main(String[] args) {
		leeCode_739 leeCode_739 = new leeCode_739();
		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
		leeCode_739.dailyTemperatures(temperatures);
	}
}
