package test16;

import test04.ListNode;

public class Test {
	public static void main(String[] args) {
		Solution1 solution = new Solution1();
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		ListNode deleteNode = solution.deleteNode(listNode1, listNode2);
		System.out.println(deleteNode.next.val);
		
		Solution2 solution2 = new Solution2();
		ListNode listNode4 = new ListNode(1);
		ListNode listNode5 = new ListNode(2);
		ListNode listNode6 = new ListNode(3);
		
		
		listNode4.next = listNode5;
		listNode5.next = listNode6;
		ListNode deleteDuplication = solution2.deleteDuplication(listNode4);
		System.out.println(deleteDuplication.val);
	}
}
