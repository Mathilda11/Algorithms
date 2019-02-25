package leetCode;

/**
 * 判断是否为子序列
 * @author 54060
 *
 */
public class leeCode_392 {
	public static void main(String[] args) {
		String s = "abc", t = "ahbgdc";
		leeCode_392 solution = new leeCode_392();
		solution.isSubsequence(s, t);
	}

	public boolean isSubsequence(String s, String t) {
		int index = -1;
		for (char c : s.toCharArray()) {
			index = t.indexOf(c, index + 1);
			if (index == -1) {
				return false;
			}
		}
		return true;
	}
}
