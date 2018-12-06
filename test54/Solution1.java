package test54;

/**
 * 数组中只出现一次的数字.一个整型数组里除了两个数字之外，其他的数字都出现了两次，找出这两个数。
 * 
 * 两个不相等的元素在位级表示上必定会有一位存在不同，将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
 * diff &= -diff 得到出 diff 最右侧不为 0 的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来。
 * 
 * 思路：
 * 首先：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
 * 
 * 当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，因为成对儿出现的都抵消了。
 * 
 * 依照这个思路，我们来看两个数（我们假设是AB）出现一次的数组。我们首先还是先异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，表现的是A和B的不同的位。
 * 我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，分组标准是第3位是否为1。如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。
 * 然后把这两个组按照最开始的思路，依次异或，剩余的两个结果就是这两个只出现一次的数字。
 * 现在我们已经把原数组分成了两个子数组，每个子数组都包含一个只出现一次的数字，而其它数字都出现了两次。
 * 如{1,2,3,3,4,2,4,5} 剩下的数字1异或5=0100 按第2位是否为1分为两组{1,2,3,3,2} {4,4,5}
 * @author 54060
 *
 */
public class Solution1 {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length==2){
        	num1[0] = array[0];
        	num2[0] = array[1];
        	return;
        }
        int bitResult = 0;
        for (int i = 0; i < array.length; i++) {
			bitResult^=array[i];
		}
        int index = findFirst1(bitResult);
        for (int i = 0; i < array.length; i++) {
			if(isBit1(array[i],index)){
				num1[0]^=array[i];
			}else{
				num2[0]^=array[i];
			}
		}
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
    
      //找出target从右边起第index位是不是1
	private boolean isBit1(int target, int index) {
		return ((target >> index) & 1) == 1 ? true:false;
	}
	
	//找出bitResult最右边是1的位
	private int findFirst1(int bitResult) {
		int index = 0;
		while(((bitResult & 1)) ==0 && index<32){ //int类型4个字节 占32位
			bitResult >>= 1; //右移一位
			index++;
		}
		return index;
	}

}
