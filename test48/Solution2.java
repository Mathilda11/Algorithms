package test48;
/*
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。 如果当前字符流没有存在出现一次的字符，返回‘#’
 * 
 * 思路
 * 创建一个List，存放只出现一次的字符。insert时先对该字符所在数组位置数量+1，再判断该位置的值是否为1，
 * 如果为1，就添加到List中，不为1，则表示该字符已出现不止1次，然后从List中移除，
 * 取出时先判断List的size是否为0，不为0直接List.get(0)，就可以得到结果，否则返回‘#’

 */
import java.util.ArrayList;
import java.util.List;
public class Solution2 {
        int[] countArr = new int[256];
        List<Character> charList = new ArrayList<Character>();
 
        //Insert one char from stringstream
        public void Insert(char ch){
            countArr[ch] ++;
            if (countArr[ch] == 1) {
                charList.add(ch);
            } else {
                charList.remove((Character)ch);
            }
        }
 
        //return the first appearence once char in current stringstream
        public char FirstAppearingOnce(){
            if (charList.size() == 0) {
                return '#';
            } else {
                return charList.get(0);
            }
        }
}
