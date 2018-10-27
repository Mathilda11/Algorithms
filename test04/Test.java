package test04;

public class Test {

	public static void main(String[] args) {
		Solution1_1 solution1 = new Solution1_1();
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		System.out.println(solution1.printListFromTailToHead(listNode1));
	}

}
