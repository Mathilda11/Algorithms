package test50;

import test04.ListNode;

public class Test {
	public static void main(String[] args) {
		// 1->2->3-->10
		// 4->5->6->7-->10
		ListNode pHead1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode pHead2 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		ListNode listNode6 = new ListNode(6);
		ListNode listNode7 = new ListNode(7);
		ListNode publicNode = new ListNode(10);
		pHead1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = publicNode;
		
		pHead2.next = listNode5;
		listNode5.next = listNode6;
		listNode6.next = listNode7;
		listNode7.next=publicNode;
		Solution solution = new Solution();
		System.out.println(solution.FindFirstCommonNode(pHead1, pHead2).val);
}
}