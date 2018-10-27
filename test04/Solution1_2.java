package test04;

/**
 * 输入链表的第一个节点，从尾到头反过来打印出每个结点的值。
 * 思路2：使用递归（本质也是栈的思想）
 * @author 54060
 *
 */

import java.util.ArrayList;

public class Solution1_2 {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
	    ArrayList<Integer> ret = new ArrayList<>();
	    if (listNode != null) {
	        ret.addAll(printListFromTailToHead(listNode.next));
	        ret.add(listNode.val);
	    }
	    return ret;
	}
}
