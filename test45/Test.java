package test45;

public class Test {
	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		Solution2 solution2 = new Solution2();
/*		 int[][] values = {
	                {1, 2, 3},
	                {4, 5, 6},
	                {7, 8, 9}};*/
		int[][] values = {
				{1,10,3,8},
				{12,2,9,6},
				{5,7,4,11},
				{3,7,16,5}};
	  //System.out.println(solution1.getMaxPathValue(values));  //29
	    System.out.println(solution2.getMaxPathValue(values));  //29
	}
}
