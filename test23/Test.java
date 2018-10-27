package test23;

import test04.ListNode;

public class Test {
	public static void main(String[] args) {
		Solution1_1 solution1 = new Solution1_1();
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		ListNode listNode6 = new ListNode(6);
		listNode1.next = listNode5;
		listNode2.next = listNode6;
		solution1.Merge(listNode1, listNode4);
	}
}
