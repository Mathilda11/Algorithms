package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 * 杨辉三角形II：

 * 要求：输入特定第k行的元素
 */
public class leeCode_119 {
	public List<Integer> getRow(int rowIndex) {
        List<Integer> pas = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
            //在新一行的头部插入1
            pas.add(0, 1);
            for (int j = 1; j < pas.size() - 1; j++) {
                //令j指向的为新元素
                pas.set(j, pas.get(j) + pas.get(j + 1));
            }
        }
        return pas;
    }
}
