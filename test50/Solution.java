package test50;
/**
 * 两个链表的第一个公共结点
 * 解题思路：
 * 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
 * 当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；
 * 同样地，当访问链表 B 的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
 * 
 * 如果链表的长度分别为m和n，那么时间复杂度是O(m+n)。
 * @author 54060
 *
 */
import test04.ListNode;

public class Solution {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
	    ListNode l1 = pHead1, l2 = pHead2;
	    while (l1 != l2) {
	        l1 = (l1 == null) ? pHead2 : l1.next;
	        l2 = (l2 == null) ? pHead1 : l2.next;
	    }
	    return l1;
	}
}
