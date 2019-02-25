package leetCode;

/*
 * 组合和III

 * 要求：用k个1-9的数，求所有加起来等于n的集合，每个集合中的元素不重复
 * 思路： （经典算法）“BackTracking回溯算法”，满足条件就添加，不满足就继续递归

 * backTracking：1、判断是否满足条件，是就添加并返回;2、循环：2.1、添加新循环元素 2.2、递归表达式 2.3、弹出最后一项
 */
import java.util.ArrayList;
import java.util.List;

public class leeCode_216 {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> comb = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		backtracking(k,n,1,path,comb);
		return comb;
	}

	private void backtracking(int k, int n, int start, List<Integer> path, List<List<Integer>> comb) {
		if(k==0 && n==0){
			comb.add(new ArrayList<>(path));
			return;
		}
	    if (k == 0 || n == 0) {
	        return;
	    }
	    for(int i = start; i<=9; i++){
	    	path.add(i);
	    	backtracking(k-1, n-i, start+1, path, comb);
	    	path.remove(path.size()-1);
	    }
	}
}
