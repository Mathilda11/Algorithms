package test28;

import test04.ListNode;

public class Test {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.push(1);
		solution.push(2);
		solution.push(3);

		solution.push(4);

		System.out.println(solution.min());
	}
}
