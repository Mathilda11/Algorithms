package test29;

public class Test {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] pushSequence = {1,2,3,4,5}; 
		int[] popSequence = {5,4,2,3,1};
		System.out.println(solution.IsPopOrder(pushSequence, popSequence));
	}
}
