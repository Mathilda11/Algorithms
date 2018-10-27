package test22;

/**
 * 反转链表
 * 方法一：递归
 * @author 54060
 *
 */
import test04.ListNode;

public class Solution1_1 {
	//5->4   4->3  3->2   2->1
	public ListNode ReverseList(ListNode head) {
	    if (head == null || head.next == null)
	        return head;
	    ListNode next = head.next;
	    head.next = null;
	    ListNode newHead = ReverseList(next);
	    next.next = head;
	    return newHead;
	}
}
