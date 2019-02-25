package leetCode;
/**
 * 计算让一组区间不重叠所需要移除的区间个数。
 * Input: [ [1,2], [1,2], [1,2] ]
 * 
 * Output: 2
 * 先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
 */
import java.util.Arrays;
import java.util.Comparator;

//Definition for an interval.
class Interval {
     int start;
     int end;
     Interval() { 
    	 start = 0; 
    	 end = 0; 
    }
     Interval(int s, int e) { 
    	 start = s; 
    	 end = e; 
    }
}

public class leeCode_435 {
    public int eraseOverlapIntervals(Interval[] intervals) {
    	  if (intervals.length == 0) {
    	        return 0;
    	    }
    	  //Arrays.sort(intervals, Comparator.comparingInt(o -> o.end));
    	  //使用 lambda 表示式创建 Comparator 会导致算法运行时间过长，如果注重运行时间，可以修改为普通创建 Comparator 语句
    	  Arrays.sort(intervals, new Comparator<Interval>() {
    		    @Override
    		    public int compare(Interval o1, Interval o2) {
    		        return o1.end - o2.end;
    		    }
    		});
    	    int cnt = 1;
    	    int end = intervals[0].end;
    	    for (int i = 1; i < intervals.length; i++) {
    	        if (intervals[i].start < end) {
    	            continue;
    	        }
    	        end = intervals[i].end;
    	        cnt++;
    	    }
    	    return intervals.length - cnt;
    }
}

