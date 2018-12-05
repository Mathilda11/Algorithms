package test36;
/**
 * 输入一个字符串，按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
 * @author 54060
 *
 */
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
 
public class Solution1_2 {
    public static void main(String[] args) {
        Solution1_1 p = new Solution1_1();
        System.out.println(p.Permutation("abc").toString());
    }
 
    public ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return (ArrayList)res;
    }
    
    //abc ->  abc, acb 
    //恢复成abc
    //bac ->  bac,bca
    //恢复成abc
    //cba ->  cba,cab
    //恢复成abc
    //外部  i   j   内部 i  j
    //    0   0      1  1   1  2
    //    0   1      1  1   1  2 
    //    0   2      1  1   1  2
    public void PermutationHelper(char[] cs, int i, List<String> list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
        } else {
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);
                PermutationHelper(cs, i+1, list);
                swap(cs, i, j); //每次从递归中出来后，将上面交换过的恢复成原来的
            }
        }
    }
 
    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
