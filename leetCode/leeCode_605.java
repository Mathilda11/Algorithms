package leetCode;
/**
 * 种植花朵：花朵之间至少需要一个单位的间隔，求解是否能种下 n 朵花。
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * @author 54060
 *
 */
public class leeCode_605 {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
	    int len = flowerbed.length;
	    int cnt = 0;
	    for (int i = 0; i < len && cnt < n; i++) {
	    	//如果此位有花，则肯定不能再种花
	        if (flowerbed[i] == 1) {
	            continue;
	        }
	        //第一位的前一位和最后一位的后一位都是无花的。
	        int pre = i == 0 ? 0 : flowerbed[i - 1];
	        int next = i == len - 1 ? 0 : flowerbed[i + 1];
	        //如果此处的前一位和后一位都是无花的，则此处可以种花。
	        if (pre == 0 && next == 0) {
	            cnt++;
	            flowerbed[i] = 1;
	        }
	    }
	    return cnt >= n;
	}
}
