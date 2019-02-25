package leetCode;

import java.util.ArrayList;
import java.util.List;

public class leeCode_39 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
	    List<List<Integer>> combinations = new ArrayList<>();
	    backtracking(new ArrayList<>(), combinations, 0, target, candidates);
	    return combinations;
	}

	private void backtracking(List<Integer> tempCombination, List<List<Integer>> combinations,
	                          int start, int target, final int[] candidates) {

	    if (target == 0) {
	        combinations.add(new ArrayList<>(tempCombination));
	        return;
	    }
	    /*
	     * i=0,{2} ==> i=0,{2,2} ==> i=0,{2,2,2} ==> 退出for循环
	     *                           i=0,{2,2}   <==
	     *                           i=1,{2,2,3} ==> return
	     *                           i=1,{2,2}
	     *                           i=2,{2,3},{2,6},{2,7}退出for循环
	     *                           {2}
	     *             i=1,{2,3} <==
	     *                       ==> i=1,{2,3,6},{2,3,7}都不符合 退出for循环
	     *                       <== {2,3}
	     *             i=1,{2,6},{2,7}不符合,退出for循环
	     *         <== {}
	     * i=1,{3} ==> i=1,{3,3}            ==> i=1,{3,3,3-7}  退出for循环
	     *             i=2,{3,6-7} 退出循环      <== {3,3}
	     *         <== {}
	     * i=2,{6} ==> i=2,{6,6-7}退出循环
	     *         <== {}
	     * i=3,{7} ==> return
	     * 
	     */
	    for (int i = start; i < candidates.length; i++) {
	        if (candidates[i] <= target) {
	            tempCombination.add(candidates[i]);
	            ////注意下次是从i开始，因为可以重复。
	            backtracking(tempCombination, combinations, i, target - candidates[i], candidates);
	            tempCombination.remove(tempCombination.size() - 1);
	        }
	    }
	}
	
	public static void main(String[] args) {
		int[] candidates =  {2, 3, 6, 7};
		leeCode_39 leeCode_39 = new leeCode_39();
		System.out.println(leeCode_39.combinationSum(candidates, 7));
	}
}
