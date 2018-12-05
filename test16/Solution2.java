package test16;

/**
 * 删除链表中重复的结点
 * 
 * 思路：头结点和第二个结点比较，如果值相等的话，跳过第二个结点，头使结点依次和其他剩余结点比较，若有值相等，则跳过。
 * 第一个结点和第二个结点比较，不等，将第二个结点作为头结点传入本函数
 * @author 54060
 *
 */
import test04.ListNode;

public class Solution2 {
	//1->2->2->3->3->4
	public ListNode deleteDuplication(ListNode pHead) {
	    if (pHead == null || pHead.next == null){
	        return pHead;
	    }
	    ListNode next = pHead.next;
	    if (pHead.val == next.val) {
	        while (next != null && pHead.val == next.val){
	            next = next.next; //next=3  next=4
	        }
	        return deleteDuplication(next);//d(3->3->4) d(4)
	    } else {
	        pHead.next = deleteDuplication(pHead.next);//1->d(2->2->3->3->4) 1->4
	        return pHead;
	    }
	}
}
