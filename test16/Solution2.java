package test16;

/**
 * 删除链表中重复的结点
 * 
 * 思路：头结点和第二个结点比较，如果值相等的话，跳过第二个结点，头使结点依次和其他剩余结点比较，若有值相等，则跳过。
 * 第一个结点和第二个结点比较，不等，将第二个结点作为头结点传入函数本函数
 * @author 54060
 *
 */
import test04.ListNode;

public class Solution2 {
	public ListNode deleteDuplication(ListNode pHead) {
	    if (pHead == null || pHead.next == null){
	        return pHead;
	    }
	    ListNode next = pHead.next;
	    if (pHead.val == next.val) {
	        while (next != null && pHead.val == next.val){
	            next = next.next;
	        }
	        return deleteDuplication(next);
	    } else {
	        pHead.next = deleteDuplication(pHead.next);
	        return pHead;
	    }
	}
}
