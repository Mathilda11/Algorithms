package test04;

/**
 * 输入链表的第一个节点，从尾到头反过来打印出每个结点的值。
 * 思路4：使用头插法
 * 直接遍历链表，按照头插法依次插入ArrayList即可
 * @author 54060
 *
 */

import java.util.ArrayList;

public class Solution1_4 {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
	    // 头插法构建逆序链表
	    ListNode head = new ListNode(-1);
	    while (listNode != null) {
	        ListNode memo = listNode.next;
	        listNode.next = head.next;
	        head.next = listNode;
	        listNode = memo;
	    }
	    // 构建 ArrayList
	    ArrayList<Integer> ret = new ArrayList<>();
	    head = head.next;
	    while (head != null) {
	        ret.add(head.val);
	        head = head.next;
	    }
	    return ret;
	}
}
