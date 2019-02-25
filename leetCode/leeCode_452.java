package leetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 气球在一个水平数轴上摆放，可以重叠，飞镖垂直投向坐标轴，使得路径上的气球都会刺破。求解最小的投飞镖次数使所有气球都被刺破。
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 * 
 * Output:
 * 2
 * @author 54060
 *
 */
public class leeCode_452 {
	public int findMinArrowShots(int[][] points) {
	    if (points.length == 0) {
	        return 0;
	    }
	    Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
	    int cnt = 1, end = points[0][1];
	    for (int i = 1; i < points.length; i++) {
	        if (points[i][0] <= end) {
	            continue;
	        }
	        cnt++;
	        end = points[i][1];
	    }
	    return cnt;
	}
}
