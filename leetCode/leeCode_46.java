package leetCode;

import java.util.ArrayList;
import java.util.List;

public class leeCode_46 {
	public List<List<Integer>> permute(int[] nums) {
	    List<List<Integer>> permutes = new ArrayList<>();
	    List<Integer> permuteList = new ArrayList<>();
	    boolean[] hasVisited = new boolean[nums.length];
	    backtracking(permuteList, permutes, hasVisited, nums);
	    return permutes;
	}

	private void backtracking(List<Integer> permuteList, List<List<Integer>> permutes, boolean[] visited, final int[] nums) {
	    if (permuteList.size() == nums.length) {
	        permutes.add(new ArrayList<>(permuteList)); // 重新构造一个 List
	        return;
	    }
	    
	    
	    //进入时i=0，退出时i=0，即首位是nums[0]=1。
	    //进入时i=i+1=1，退出时i=1，即首位是nums[1]=2.
	    //进入时i=i+1=2，退出时i=2，即首位是nums[2]=3.
	    for (int i = 0; i < visited.length; i++) {
	        if (visited[i]) {
	            continue;
	        }
	        visited[i] = true;
	        permuteList.add(nums[i]);
	        backtracking(permuteList, permutes, visited, nums);
	        permuteList.remove(permuteList.size() - 1);
	        visited[i] = false;
	    }
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		leeCode_46 leeCode_46 = new leeCode_46();
		leeCode_46.permute(nums);
		}
	}
