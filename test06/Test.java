package test06;

public class Test {
	public static void main(String[] args) {
		TreeLinkNode treeLinkNode = new TreeLinkNode(3);
		TreeLinkNode treeLinkNode2 = new TreeLinkNode(9);
		TreeLinkNode treeLinkNode3 = new TreeLinkNode(20);
		TreeLinkNode treeLinkNode4 = new TreeLinkNode(15);
		TreeLinkNode treeLinkNode5 = new TreeLinkNode(7);
		treeLinkNode.left = treeLinkNode2;
		treeLinkNode.right = treeLinkNode3;
		treeLinkNode3.left = treeLinkNode4;
		treeLinkNode3.right = treeLinkNode5;
		treeLinkNode2.next = treeLinkNode;
		Solution solution = new Solution();
		//中序遍历出节点20的下一个节点。
		System.out.println(solution.GetNext(treeLinkNode2).val);
	}
}
