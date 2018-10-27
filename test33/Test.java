package test33;

public class Test {
	public static void main(String[] args) {
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		node1.next = node2;
		node2.next = node3;
		node1.random = node3;
		node3.random = node1;
		node2.random = node4;
		node4.random = node2;
		Solution solution = new Solution();
		solution.Clone(node1);
		
	}
}
