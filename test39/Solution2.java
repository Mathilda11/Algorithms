 package test39;
 /**
  * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
  * 例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
  * 
  * 因为一个字符(英文）不会超过8位，所以创建一个大小为256的整形数组，（有256种可能出现的字符）
  * 英文和数字占一个字节 (2)、中文占一个字符，也就是两个字节 
  * 创建一个List，存放只出现一次的字符。
  * insert时先对该字符所在数组位置数量+1，再判断该位置的值是否为1，如果为1，就添加到List中，不为1，则表示该字符已出现不止1次，然后从List中移除，取出时先判断List的size是否为0，不为0直接List.get(0)，就可以得到结果，否则返回‘#’
  * @author 54060
  *
  */
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
	private int[] cnts = new int[256];
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
