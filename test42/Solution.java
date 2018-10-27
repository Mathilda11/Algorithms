package test42;
/**
 * 数字序列中的某一位数字
 * 主要思路： 
 * 举例分析，比如找第1001位数字， 
 * 1）1位数的数值有10个：0~9，数字为10×1=10个，显然1001>10，跳过这10个数值，在后面找第991（1001-10）位数字。 
 * 2）2位数的数值有90个：10~99，数字为90×2=180个，且991>180，继续在后面找第811（991-180）位数字。 
 * 3）3位数的数值有900个：100~999，数字为900×3=2700个，且811<2700，说明第811位数字在位数为3的数值中。由于811=270×3+1，所以第811位是从100开始的第270个数值即370的第二个数字，就是7。 
 * 按此规律，可求出其他数字。
 * 
 * 关键点：位数的数值个数


*/
public class Solution {
	public int getDigitAtIndex(int index) {
	    if (index < 0)
	        return -1;
	    int place = 1;  // 1 表示个位，2 表示 十位...
	    while (true) {
	        int amount = getAmountOfPlace(place);//当前位数的数值个数
	        //数值乘上它的位数等于数字个数，
            //比如，两位数有90个（10~99），每个数值有2个数字，总数字个数为180
	        int totalAmount = amount * place;
	        if (index < totalAmount)
	            return getDigitAtIndex(index, place);
	        //在下一位中查找
	        index -= totalAmount;
	        place++;
	    }
	}

	/**
	 * place 位数的数字组成的字符串长度
	 * 10, 90, 900, ...
	 * digits位数的数字个数，两位数有9*10=90个（10~99），三位数有9*100=900个（100~999）
	 */
	private int getAmountOfPlace(int place) {
	    if (place == 1)
	        return 10;
	    return (int) Math.pow(10, place - 1) * 9;
	}

	/**
	 * place 位数的起始数字
	 * 0, 10, 100, ...
	 * 两位数从10开始，三位数从100开始
	 */
	private int getBeginNumberOfPlace(int place) {
	    if (place == 1)
	        return 0;
	    return (int) Math.pow(10, place - 1);
	}

	/**
	 * 在 place 位数组成的字符串中，第 index 个数
	 */
	private int getDigitAtIndex(int index, int place) {
	    int beginNumber = getBeginNumberOfPlace(place);
	    int shiftNumber = index / place;
	    String number = (beginNumber + shiftNumber) + ""; //对应的数值
	    int count = index % place;
	    return number.charAt(count) - '0'; //char转int 直接在后面减去'0'即可
	}
}
