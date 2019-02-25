package leetCode;
/**
 * 删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。如果有多个相同长度的结果，返回字典序的最大字符串。
 * @author 54060
 *
 */
import java.util.ArrayList;
import java.util.List;

//public int compareTo(String anotherString)

//compareTo()的返回值是整型，它是先比较对应字符的大小（ASCII码顺序），

//如果第一个字符和参数的第一个字符不等，结束比较，返回他们之间的差值。

//如果第一个字符和参数的第一个字符相等，则以第二个字符和参数的第二个字符作比较，

//以此类推，直至比较的字符或被比较的字符有一方全比较完，这时就比较字符的长度。

//如果这个字符串是等参数字符串那么返回值0，如果这个字符串是按字典顺序小于字符串参数那么返回小于0的差值，

//如果此字符串是按字典顺序大于字符串参数那么返回一个大于0的差值
public class leeCode_524 {
	public String findLongestWord(String s, List<String> d) {
	    String longestWord = "";
	    for (String target : d) {
	        int l1 = longestWord.length(), l2 = target.length();
	        if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) { //String的CompareTo方法即字典序比较
	            continue;
	        }
	        if (isValid(s, target)) {
	            longestWord = target;
	        }
	    }
	    return longestWord;
	}

	private boolean isValid(String s, String target) {
	    int i = 0, j = 0;
	    while (i < s.length() && j < target.length()) {
	        if (s.charAt(i) == target.charAt(j)) {
	            j++;
	        }
	        i++;
	    }
	    return j == target.length();
	}
	
	//List<String>的初始化
	//
	//List<String> list = new ArrayList(); list.add("xxx");
	//List<String> list = Arrays.asList("xxx","yyy","zzz"); list的size就固定了，不能再add了。
	//List<String> list = new ArrayList<>(Arrays.asList("xxx","yyy","zzz"));
	public static void main(String[] args) {
		String s = "abpcplea";
		List<String> d = new ArrayList<>();
		d.add("pcp");
		d.add("lea");
		d.add("acpb");
		leeCode_524 leeCode_524 = new leeCode_524();
		System.out.println(leeCode_524.findLongestWord(s, d));
		System.out.println("pcp".compareTo("lea"));
		String s1 = "abc";
		String s2 = "abcd";
		String s3 = "abcdfg";
		String s4 = "1bcdfg";
		String s5 = "cdfg";
		System.out.println( s1.compareTo(s2) ); // -1 (前面相等,s1长度小1)
		System.out.println( s1.compareTo(s3) ); // -3 (前面相等,s1长度小3)
		System.out.println( s1.compareTo(s4) ); // 48 ("a"的ASCII码是97,"1"的的ASCII码是49,所以返回48)
		System.out.println( s1.compareTo(s5) ); // -2 ("a"的ASCII码是97,"c"的ASCII码是99,所以返回-2) 

	}
}
