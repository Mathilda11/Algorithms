package test15;
/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 * 
 * 思路：由于 n 可能会非常大，因此不能直接用 int 表示数字，而是用 char 数组进行存储。
 * 把问题转化成数字排列的解法，使用回溯法得到所有的数。
 * @author 54060
 *
 */
public class Solution {
	public void print1ToMaxOfNDigits(int n) {
	    if (n <= 0)
	        return;
	    char[] number = new char[n];
	    print1ToMaxOfNDigits(number, 0);
	}
	
	/*
	 * [0,0,0] == > 使第2位从0~9遍历，打印完一位数
	 * [0,1,0] == > [0,1,0~9]...[0,9,0~9]打印完两位数
	 * [1,0,0] == > [1,1,0~9]...[1,9,0~9]  [9,1,0~9]...[9,9,0~9]打印完三位数
	 */
	//全排列。数字的每一位都可能是0~9中的一个数，然后设置下一位。
	//递归结束的条件是已经设置了数字的最后一位。
	private void print1ToMaxOfNDigits(char[] number, int digit) {
	    if (digit == number.length) {	//digit位都填上后开始打印
	        printNumber(number);
	        return;
	    }
	    for (int i = 0; i < 10; i++) {
	        number[digit] = (char) (i + '0');	//(char) (i + '0') = 'i';
	        print1ToMaxOfNDigits(number, digit + 1);
	    }
	    //000~009，019->p(019,2)->010->p(010,3)
	}
	
	//index确定从n位数的哪一位开始打印。比如001，index=2，打印1后换行
	private void printNumber(char[] number) {
	    int index = 0;
	    while (index < number.length && number[index] == '0')
	        index++;
	    while (index < number.length)
	        System.out.print(number[index++]);
	    System.out.println();
	}

}
