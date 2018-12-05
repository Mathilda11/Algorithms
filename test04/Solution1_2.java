package test04;

/**
 * 输入链表的第一个节点，从尾到头反过来打印出每个结点的值。
 * 思路2：使用递归（本质也是栈的思想）
 * 注意：当链表非常长的时候，就会导致函数调用的层级很深，从而有可能导致函数调用栈溢出。
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
