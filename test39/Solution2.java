 package test39;
 /**
  * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
  * 例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
  * 
  * insert时先对该字符所在数组位置数量+1，再判断该位置的值是否为1，如果为1，就添加到List中，不为1，则表示该字符已出现不止1次，然后从List中移除，取出时先判断List的size是否为0，不为0直接List.get(0)，就可以得到结果，否则返回‘#’
  * @author 54060
  *
  */
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
	private int[] cnts = new int[256]; //英文字母和数字占一个字节，一个字节8位，所以用长度256的数组存放每个字符出现的次数。
	private Queue<Character> queue = new LinkedList<>();

	public void Insert(char ch) {
	    cnts[ch]++;
	    queue.add(ch);
	    while (!queue.isEmpty() && cnts[queue.peek()] > 1)
	        queue.poll();
	}

	public char FirstAppearingOnce() {
	    return queue.isEmpty() ? '#' : queue.peek();
	}

}
