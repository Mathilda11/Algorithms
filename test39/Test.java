package test39;

public class Test {
	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		solution1.Insert(3);
		solution1.Insert(1);
		solution1.Insert(2);
		solution1.Insert(4);
		solution1.Insert(5);
		System.out.println(solution1.GetMedian());
		
		Solution2 solution2 = new Solution2();
		solution2.Insert('g');
		solution2.Insert('o');
		solution2.Insert('o');
		solution2.Insert('g');
		solution2.Insert('l');
		solution2.Insert('e');
		System.out.println(solution2.FirstAppearingOnce());
	}
}
