package test20;
/**
 * 链表中倒数第 K 个结点，本题从1开始计数。
 * 思路：设链表的长度为 N。设两个指针 P1 和 P2，先让 P1 移动 第K 个节点，则还有 N - K个节点可以移动。
 * 此时让 P1 和 P2 同时移动，可以知道当 P1 移动到链表结尾时，P2 移动到 第N - K + 1个节点处，该位置就是倒数第 K 个节点。
 * @author 54060
 *
 */

import test04.ListNode;

public class Solution {
	public ListNode FindKthToTail(ListNode head, int k) {
	    if (head == null) //输入的头节点为空
	        return null;
	    ListNode P1 = head; //P1先走k步
	    while (P1 != null && k-- > 0) //先取值后运算 2 1 0
	        P1 = P1.next;
	    if (k > 0) //节点总数小于k
	        return null;
	    ListNode P2 = head;
	    //此时P1.val=4
	    while (P1 != null) {
	        P1 = P1.next;
	        P2 = P2.next;
	    }
	    return P2;
	}
	//https://www.cnblogs.com/edisonchou/p/4769164.html
	public static ListNode FindKthToTail2(ListNode head, int k)
    {
        if(head == null || k == 0)
        {
            return null;
        }

        ListNode ahead = head; 
        ListNode behind = null;
        
        //ahead先走k-1步
        for (int i = 0; i < k - 1; i++)
        {
            if(ahead.next != null)
            {
                ahead = ahead.next;
            }
            else
            {
                return null;
            }
        }

        behind = head;

        while (ahead.next != null)
        {
            ahead = ahead.next;
            behind = behind.next;
        }

        return behind;
    }
}
