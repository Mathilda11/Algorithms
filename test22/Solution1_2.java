package test22;
/**
 * 反转链表
 * 方法二：迭代
 * @author 54060
 *
 */
import test04.ListNode;

public class Solution1_2 {
	//1->2->3
	//-1->1->null   -1->2->1->null  -1->3->2->1->null
	public ListNode ReverseList(ListNode head) {
	    ListNode newList = new ListNode(-1);
	    while (head != null) {
	        ListNode next = head.next;
	        head.next = newList.next;
	        newList.next = head;
	        head = next;
	    }
	    return newList.next;
	}
}
