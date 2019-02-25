package leetCode;
/*
 * 第三大数
 * 要求：给出非空整型数组，返回第三大的数；若不存在，则返回最大数。时间复杂度要为O(n)
 * 注意：如果采用堆实现，时间复杂度 O(NlogK) 、空间复杂度 O(K)
 */
import java.util.TreeSet;

public class leeCode_414 {
	public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int num : nums) {
            set.add(num);
            //超过3个则去除
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        //少于3个输出最大值
        return set.size() < 3 ? set.last() : set.first();
	}
	public static void main(String[] args) {
		leeCode_414 leeCode_414 = new leeCode_414();
		int[] nums = {3,2,1,5,6,4};
		System.out.println(leeCode_414.thirdMax(nums));
	}
}
