package test55;

import java.util.ArrayList;

/**
 * 和为 S 的连续正数序列
 * 输出所有和为 S 的连续正数序列。
 * 
 * 例如和为 100 的连续序列有：
 * 
 * [9, 10, 11, 12, 13, 14, 15, 16]
 * [18, 19, 20, 21, 22]。
 * 
 * @author 54060
 *
 */
public class Solution2_1 {
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
	    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
	    int start = 1, end = 2;
	    int curSum = 3;
	    while (end < sum) {
	        if (curSum > sum) {   //当前的序列和大于sum
	            curSum -= start;
	            start++;
	        } else if (curSum < sum) { 	//当前的序列和小于sum
	            end++;
	            curSum += end;
	        } else {
				//当前序列和为sum了，则将这些数加入到list中
	            ArrayList<Integer> list = new ArrayList<>();
	            for (int i = start; i <= end; i++)
	                list.add(i);
	            ret.add(list);
	            curSum -= start;
	            start++;
	            end++;
	            curSum += end;
	        }
	    }
	    return ret;
	}
}
