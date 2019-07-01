package leetCode;

/*
 * 请判断一个链表是否为回文链表。
 */
import test04.ListNode;

public class leeCode_234 {
	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(2);
		root.next.next.next = new ListNode(1);
		System.out.println(isPalindrome(root));

	}
	public static boolean isPalindrome(ListNode head) {
	    if (head == null || head.next == null) 
	    	return true;
	    ListNode slow = head, fast = head;
	    while (fast.next != null && fast.next.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    if (fast != null) 
	    	slow = slow.next;  // 偶数节点，让 slow 指向下一个节点
	    cut(head, slow);                     // 切成两个链表
	    slow = reverse(slow);
	    boolean result = isEqual(head, slow);
	    recover(head, reverse(slow));//恢复成原链表
	    return result;
	}

	private static void recover(ListNode l1, ListNode l2) {
		while(l1.next != null){
			l1 = l1.next;
		}
		l1.next = l2;
	}

	private static void cut(ListNode head, ListNode cutNode) {
	    while (head.next != cutNode) {
	        head = head.next;
	    }
	    head.next = null;
	}

	private static ListNode reverse(ListNode head) {
	    ListNode newHead = null;
        ListNode next = null;
	    while (head != null) {
	    	next = head.next;
	        head.next = newHead;
	        newHead = head;
	        head = next;
	    }
	    return newHead;
	}

	private static boolean isEqual(ListNode l1, ListNode l2) {
	    while (l1 != null && l2 != null) {
	        if (l1.val != l2.val) 
	        	return false;
	        l1 = l1.next;
	        l2 = l2.next;
	    }
	    return true;
	}
}
