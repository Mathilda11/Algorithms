package test10;
/**
 * matrix = [ A B C D
 * 			  E F G H
 *            I J K I ]
 * c = ABFJ
 * @author 54060
 *
 */
public class Test {
	public static void main(String[] args) {
		String str = "ABCDEFGHIJKL";
		char[] matrix = str.toCharArray();
		String str2 = "ABFJ";
		char[] c = str2.toCharArray();
		System.out.println(new Solution().hasPath(matrix, 3, 4, c));
	}
}
