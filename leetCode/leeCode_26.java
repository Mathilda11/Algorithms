package leetCode;

/*
 * 从排序数组中删除重复项
 * 要求：去掉有序数组中所有重复的数，并返回新的长度，不能分配额外的空间，只能在原数组本地进行

 * 思路：用长度length作为指针来更新数组
 */
public class leeCode_26 {
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0 || nums.length == 1){
			return 0;
		}
		int length = 1;
		for(int i =1; i< nums.length; i++){
			if(nums[i]!=nums[i-1]){ //如果一个元素和它前面的元素不同，则该元素是非重复元素
				nums[length++] = nums[i];
			}
		}
		return length;
	}
}
