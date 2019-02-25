package leetCode;
/*
 * 229.多数元素（众数）II

 * 要求：在大小为n的数组中找出出现次数大于n / 3次的元素，用线性时间和O(1)空间
 * 思路： （经典算法）“摩尔投票法”，这里的含义是先设置两个候选数，相同的时候就计1票，不同的时候就扣1票，当票数为0时，就换另一个候选数，并且计第1票；选好候选数之后，就真正计算各自的票数
 * 
 * tips：背下来思路...1、设候选数、计票器 2、确定候选数 3、真正计票 4、判断是否满足条件

 * warn：考虑空数组，数组长度为1，两个数相等的情况！！！
 */
import java.util.ArrayList;
import java.util.List;

public class leeCode_229 {
	public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int n = nums.length;
        if (nums == null || n == 0) {
            return res;
        }
        if (n == 1) {
            res.add(nums[0]);
            return res;
        }
        
        //设2个候选数，2个对应的计票器
        int number1, number2, count1, count2;
        number1 = number2 = nums[0];
        count1 = count2 = 0;
        
        //挑选候选数
        for (int i = 0; i < n; i++) {
            if (nums[i] == number1) {
                count1++;
            } else if (nums[i] == number2) {
                count2++;
            } else if (count1 == 0) {  //count减为0就换候选数
                number1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                number2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        
        //清空票数，计算两个候选数的真正票数
        count1 = count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == number1) {
                count1++;
            }
            if (nums[i] == number2) {
                count2++;
            }
        }
        
        //判断票数是否达到n/3以上
        if (count1 > n / 3) {
            res.add(number1);
        }
        //考虑两数相等的情况
        if (count2 > n / 3 && number2 != number1) {
            res.add(number2);
        }
        return res;
    }
	public static void main(String[] args) {
		leeCode_229 leeCode_229 = new leeCode_229();
		int[] nums = {1,2,2,2,3};
		leeCode_229.majorityElement(nums);
	}
}
