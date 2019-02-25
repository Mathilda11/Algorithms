package leetCode;

import java.util.ArrayList;
import java.util.List;

public class leeCode_207 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
	    List<Integer>[] graphic = new List[numCourses]; //{{},{0}};
	    for (int i = 0; i < numCourses; i++) {
	        graphic[i] = new ArrayList<>();
	    }
	    for (int[] pre : prerequisites) {
	        graphic[pre[0]].add(pre[1]);
	    }
	    boolean[] globalMarked = new boolean[numCourses];
	    boolean[] localMarked = new boolean[numCourses];
	    for (int i = 0; i < numCourses; i++) {
	        if (hasCycle(globalMarked, localMarked, graphic, i)) {
	            return false;
	        }
	    }
	    return true;
	}

	private boolean hasCycle(boolean[] globalMarked, boolean[] localMarked,
	                         List<Integer>[] graphic, int curNode) {

	    if (localMarked[curNode]) { //{-1,1}
	        return true;
	    }
	    if (globalMarked[curNode]) { //{1,1}
	        return false;
	    }
	    globalMarked[curNode] = true;
	    localMarked[curNode] = true;
	    for (int nextNode : graphic[curNode]) {
	        if (hasCycle(globalMarked, localMarked, graphic, nextNode)) {
	            return true;
	        }
	    }
	    localMarked[curNode] = false;
	    return false;
	}
	
	public static void main(String[] args) {
		leeCode_207 leeCode_207 = new leeCode_207();
		int[][] prerequisites = {{1,0}};
		leeCode_207.canFinish(2, prerequisites);
		System.out.println((char) (1+'0'));
	}
}
