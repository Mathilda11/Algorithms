package leetCode;
/*
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 */
import java.util.ArrayList;
import java.util.List;

public class leeCode_17 {
	private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
	    List<String> combinations = new ArrayList<>();
	    if (digits == null || digits.length() == 0) {
	        return combinations;
	    }
	    doCombination(new StringBuilder(), combinations, digits);
	    return combinations;
	}

	private void doCombination(StringBuilder prefix, List<String> combinations, final String digits) {
	    if (prefix.length() == digits.length()) {
	        combinations.add(prefix.toString());
	        return;
	    }
	    int curDigits = digits.charAt(prefix.length()) - '0';
	    String letters = KEYS[curDigits];
	    for (char c : letters.toCharArray()) {
	        prefix.append(c);                         // 添加
	        doCombination(prefix, combinations, digits);
	        prefix.deleteCharAt(prefix.length() - 1); // 删除
	    }
	}
	
	public static void main(String[] args) {
		leeCode_17 leeCode_17 = new leeCode_17();
		List<String> letterCombinations = leeCode_17.letterCombinations("23");
	}
}
