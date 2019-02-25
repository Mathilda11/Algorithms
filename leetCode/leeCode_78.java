package leetCode;

import java.util.ArrayList;
import java.util.List;

public class leeCode_78 {
	public List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> subsets = new ArrayList<>();
	    List<Integer> tempSubset = new ArrayList<>();
	    for (int size = 0; size <= nums.length; size++) {
	        backtracking(0, tempSubset, subsets, size, nums); // 不同的子集大小
	    }
	    return subsets;
	}

	private void backtracking(int start, List<Integer> tempSubset, List<List<Integer>> subsets,
	                          final int size, final int[] nums) {

	    if (tempSubset.size() == size) {
	        subsets.add(new ArrayList<>(tempSubset));
	        return;
	    }
	    /*
	     * size=1,i=0,t={1},t={} ... i=4,t={5},t={}  
	     * size=2.i=0,t={1} ==> i=1,t={1,2} return,t={1} ... i=4,t={1,5} return,t={1} 结束循环 t={}
	     *        t={}
	     *        i=1,t={2} ==> i=3,t={2,3} return,t={2} ... i=5,t={2,5} return,t={2} 结束循环 t={}      
	     */
	    for (int i = start; i < nums.length; i++) {
	        tempSubset.add(nums[i]);
	        backtracking(i + 1, tempSubset, subsets, size, nums);
	        tempSubset.remove(tempSubset.size() - 1);
	    }
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		leeCode_78 leeCode_78 = new leeCode_78();
		leeCode_78.subsets(nums);
	}
}
