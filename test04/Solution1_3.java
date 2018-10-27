package test04;

/**
 * 输入链表的第一个节点，从尾到头反过来打印出每个结点的值。
 * 思路3：使用Collections.reverse()
 * @author 54060
 *
 */

import java.util.ArrayList;
import java.util.Collections;

public class Solution1_3 {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
	    ArrayList<Integer> ret = new ArrayList<>();
	    while (listNode != null) {
	        ret.add(listNode.val);
	        listNode = listNode.next;
	    }
	    Collections.reverse(ret);
	    return ret;
	}
}
