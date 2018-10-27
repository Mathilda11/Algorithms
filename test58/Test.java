package test58;

import java.util.List;
import java.util.Map.Entry;

public class Test {
	public static void main(String[] args) {
		Solution1_1 solution1_1 = new Solution1_1();
		List<Entry<Integer, Double>> sum = solution1_1.dicesSum(6);
		for (Entry<Integer, Double> entry : sum) {
			System.out.print(entry.getKey() + ": ");
			System.out.println(entry.getValue());
		}
	}
}
