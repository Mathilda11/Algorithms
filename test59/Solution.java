package test59;

/**
 * 扑克牌顺子
 * 五张牌，其中大小鬼为癞子，牌面大小为 0。判断这五张牌是否能组成顺子。
 * @author 54060
 *
 */
import java.util.Arrays;

public class Solution {
	public boolean isContinuous(int[] nums) {

	    if (nums.length < 5)
	        return false;

	    Arrays.sort(nums);

	    // 统计癞子数量
	    int cnt = 0;
	    for (int num : nums)
	        if (num == 0)
	            cnt++;

	    // 使用癞子去补全不连续的顺子
	    for (int i = cnt; i < nums.length - 1; i++){
	        if (nums[i + 1] == nums[i]) //如果从非癞子牌开始算，有相同的非癞子牌，则肯定不能组成顺子
	            return false;
	        cnt -= nums[i + 1] - nums[i] - 1; //如果nums[i+1]-nums[i]-1=0，说明这两个可以组成顺子，不用使用癞子，cnt的数量不变。
	                                          //否则，需要nums[i+1]-nums[i]-1个癞子去组成顺子
	    }

	    return cnt >= 0;
	}
}
