package test03;

public class Test {
	public static void main(String[] args) {
		StringBuffer input = new StringBuffer("We are happy");
		Solution solution = new Solution();
		String output = solution.replaceSpace(input);
		System.out.println(output);
	}
}
