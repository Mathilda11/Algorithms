package test07;

public class Test {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.push(1);
		solution.push(2);
		solution.push(3);
		try {
			System.out.println(solution.pop());
			System.out.println(solution.pop());
			System.out.println(solution.pop());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
