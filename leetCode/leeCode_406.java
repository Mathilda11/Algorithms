package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 根据身高和序号重组队列
 * 一个学生用两个分量 (h, k) 描述，h 表示身高，k 表示排在前面的有 k 个学生的身高比他高或者和他一样高。
 * @author 54060
 *
 */
public class leeCode_406 {
	public int[][] reconstructQueue(int[][] people) {
	    if (people == null || people.length == 0 || people[0].length == 0) {
	        return new int[0][0];
	    }
	    Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0])); //h降序，k升序。
	    List<int[]> queue = new ArrayList<>();
	    for (int[] p : people) {
	        queue.add(p[1], p); 	//身高较高的学生应该先做插入操作
	    }
	    return queue.toArray(new int[queue.size()][]);
	}
	
	public static void main(String[] args) {
		leeCode_406 leeCode_406 = new leeCode_406();
		int[][] people = {{7,0},{4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		leeCode_406.reconstructQueue(people);
	}
}
