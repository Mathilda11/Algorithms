package leetCode;
/*
 * 给定一个正确的表达式（不用担心不规范的输入），比如2-1-1，通过在不同位置添加左右括号，改变求值的优先级顺序，求出所有的这些值。
 */
import java.util.ArrayList;
import java.util.List;

public class leeCode_241 {
	public List<Integer> diffWaysToCompute(String input) {
	    List<Integer> ways = new ArrayList<>();
	    for (int i = 0; i < input.length(); i++) {
	        char c = input.charAt(i);
	        if (c == '+' || c == '-' || c == '*') {
	            List<Integer> left = diffWaysToCompute(input.substring(0, i));
	            List<Integer> right = diffWaysToCompute(input.substring(i + 1));
	            for (int l : left) {
	                for (int r : right) {
	                    switch (c) {
	                        case '+':
	                            ways.add(l + r);
	                            break;
	                        case '-':
	                            ways.add(l - r);
	                            break;
	                        case '*':
	                            ways.add(l * r);
	                            break;
	                    }
	                }
	            }
	        }
	    }
	    if (ways.size() == 0) {
	        ways.add(Integer.valueOf(input));
	    }
	    return ways;
	}
	public static void main(String[] args) {
		String input = "2-1-1";
		leeCode_241 leeCode_241 = new leeCode_241();
		leeCode_241.diffWaysToCompute(input);
		
	}
}
