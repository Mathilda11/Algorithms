package test04;

/**
 * 输入链表的第一个节点，从尾到头反过来打印出每个结点的值。
 * 使用栈
 * 思路1：此题明显想到是利用栈的思想，后进先出，先遍历链表，依次将结点值进栈。最后在遍历栈出栈。
 * @author 54060
 *
 */

import java.util.ArrayList;
import java.util.Stack;

public class Solution1_1 {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
		Stack<Integer> stack = new Stack<>();
		while(listNode!=null){
			stack.add(listNode.val);
			listNode = listNode.next;
		}
		ArrayList<Integer> ret = new ArrayList<>();
	    while (!stack.isEmpty()){
	        ret.add(stack.pop());
	    }
	    return ret;
	}
}
