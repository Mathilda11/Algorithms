package test28;
/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的 min 函数。
 * @author 54060
 *
 */
import java.util.Stack;

public class Solution {
	private Stack<Integer> dataStack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>(); //只把最小的元素放在栈顶

	public void push(int node) {
	    dataStack.push(node);
	    minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
	}

	public void pop() {
	    dataStack.pop();
	    minStack.pop();
	}

	public int top() {
	    return dataStack.peek();
	}

	public int min() {
	    return minStack.peek();
	}
}
