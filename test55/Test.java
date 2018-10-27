package test55;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		int[] array = {1,2,3,4,5};
		System.out.println(solution1.FindNumbersWithSum(array, 5));
		
		Solution2_2 solution2_2 = new Solution2_2();
		ArrayList<ArrayList<Integer>> arrayList = solution2_2.FindContinuousSequence(100);
		for (ArrayList<Integer> list : arrayList) {
			for (Integer i : list) {
				System.out.println(i);
			}
			System.out.println("------");
		}
	}
}
