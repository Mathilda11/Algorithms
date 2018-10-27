package test41;

/**
 * 从 1 到 n 整数中 1 出现的次数
 * 我们从一个5位的数字讲起，先考虑其百位为1的情况。分3种情况讨论：
 * 
 * 百位数字>=2  example: 31256  当其百位为>=时，有以下这些情况满足(为方便起见，计312为a，56为b)：
 * 
 * 100 ~   199
 * 
 * 1100 ~  1199
 * 
 *    .....
 * 
 * 31100 ~ 31199
 * 
 *  余下的都不满足！（31200 ~ 31256）此时百位>=2 肯定不含1 不用考虑了
 * 
 * 因此，百位>=2的5位数字，其百位为1的情况有（a/10+1）*100个数字   （a/10+1）=>对应于 0 ~ 31，且每一个数字，对应范围是100个数（末尾0-99）
 * 
 * 百位数字 ==1 example: 31156 当其百位为1时，有以下这些情况满足：
 * 
 *      100 ~   199
 * 
 *    1100 ~  1199
 * 
 *           ......
 * 
 *   30100 ~ 30199
 * 
 *   31100 ~ 31156
 * 
 * 因此，百位为1的5位数字，共有（a/10）*100+(b+1) (a/10)=>0~30 b+1=>31100 ~ 31156的对应的57个1
 * 
 * 百位数字 ==0 example: 31056 当其百位为0时，有以下这些情况满足：
 * 
 *     100 ~   199
 * 
 *   1100 ~  1199
 * 
 *  30100 ~ 30199
 * 
 * 其余都不满足
 * 
 * 因此，百位数为0的5位数字，共有(a/10)*100个数字满足要求
 * 
 * 我们可以进一步统一以下表达方式，即当百位>=2或=0时，有[(a+8)/10]*100，当百位=1时，有[(a+8)/10]*100+(b+1)。用代码表示就是： [(a+8)/10]*100+(a%10==1)?(b+1):0；
 * 
 * 为什么要加8呢？因为只有大于2的时候才会产生进位等价于（a/10+1），当等于0和1时就等价于(a/10)。另外，等于1时要单独加上(b+1)，这里我们用a对10取余是否等于1的方式判断该百位是否为1。
 *  
 * for (long m = 1; m <= n; m *= 10) 在这里的作用是，从个位开始考虑，再到十位，百位，千位，一直到超出这个数！
 * 为什么m要用long型呢？因为n可能没有超过整型的表达范围（int刚好可以表示n），
 * 而10*m恰恰有可能刚刚超过！ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0); 
 * 这里cnt用于表示1的个数，当m=100时，n/m其实代表的是a，而n%m代表的是b,此时考虑的是百位为1的情况；
 * 当m=1000，自然考虑的就是千位等于1的情况了~ 至于为什么加8，那个三目运算符是干嘛子用的上面都已经讲过了。@author 54060
 * 
 * 当a的个位为2及以上时，次数是(a/10+1)*m。a的个位为1时，次数是(a/10)*m+(b+1)。a的个位为0时，次数是(a/10)*m
 * m=1,a=31156,b=0
 * a
 * 00001 ~ 31151 （3116个）a/10+1 *1 当a的个位为2及以上时 该位为1的全覆盖了，所以要加上自己，从0开始。 3116
 * 31152 ~ 31156 不符合
 * 
 * m=10,a=3115,b=6
 * a
 * 00010 ~ 31119 （3120个）a/10+1 * 10 当a的个位为2及以上时 该位为1的全覆盖了，所以要加上自己，从0开始。3120
 * 31120 ~ 31156 不符合
 * 
 * m=100,a=311,b=56
 * 00100 ~ 30099 (3100个） a/10 * 100  3157
 * 31100 ~ 31156 (56+1) 57个
 * 
 * m=1000,a=31,b=156
 * a
 * 01000 ~ 01999 1000个
 * 11000 ~ 11999 1000个
 * 21000 ~ 21999 1000个  a/10 * 1000
 * 31000 ~ 31156 157个  (56+1) 57个
 * 
 * m=10000,a=3,b=1156
 * a
 * 10000 ~ 19999 10000 a/10 +1 * 10000
 * 20000 ~ 31156 不符合
 *
 */
public class Solution {
	public int NumberOf1Between1AndN_Solution(int n) {
	    int cnt = 0;
	    //通过m求从1到n中，每个十进制位出现1的次数，把每进制位计算1的个数拆开，然后求和
 	    for (int m = 1; m <= n; m *= 10) {
	        int a = n / m, b = n % m;
	        cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);//如果a的个位是1，要把b的值算上。
	    }
	    return cnt;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.NumberOf1Between1AndN_Solution(31156));
	}
}
