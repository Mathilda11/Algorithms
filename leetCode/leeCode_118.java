package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 * 杨辉三角形：

 * 要求：输入行数得到对应的三角形阵列
 *     1
 *  1     1
 * 1   2    1
 * 

 * 思路： 利用上下层的关系即可，用另一数组保存上层结果

 * warn：每次赋值备用数组前记得清空！！！
 */
public class leeCode_118 {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ans = new ArrayList<>();
		if(numRows < 1){
			return ans;
		}
		List<Integer> pre = new ArrayList<>();
		for(int i = 1; i <= numRows; i++){
			List<Integer> pas = new ArrayList<>();
			pas.add(1);
			for(int j = 0; j < pre.size()-1; j++){
				pas.add(pre.get(i)+pre.get(i+1));
			}
			if(i>1){
				pas.add(1);
			}
			//add是将传入的参数作为当前List中的一个Item存储，即使你传入一个List也只会另当前的List增加1个元素
			//addAll是传入一个List，将此List中的所有元素加入到当前List中，也就是当前List会增加的元素个数为传入的List的大小
			ans.add(pas);
			pre.clear();
			pre.addAll(pas);
		}
		return ans;
	}
}
