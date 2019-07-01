package leetCode;
/*
 * 现在你总共有 n 门课需要选，记为 0 到 n - 1。
 * 一些课程在修之前需要先修另外的一些课程，比如要学习课程 0，你需要先学习课程 1 ，表示为: [0,1]
 * 给定 n 门课以及他们的先决条件，判断是否可能完成所有课程？
 * 示例 1:
 * 输入: 2, [[1,0]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 
 * 示例 2:
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。

 * 思路：只需要检测有向图是否存在环即可。
 */
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
