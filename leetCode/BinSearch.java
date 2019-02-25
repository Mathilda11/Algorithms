package leetCode;
/**
 * 二分查找
 * 时间复杂度：O(log n)
 * @author 54060
 *
 */
public class BinSearch {
	  public static int binSearch(int nums[], int key) {   
          int m = nums.length / 2;   
          if (key == nums[m]) {   
              return m;   
          }   

          int l = 0;   
          int h = nums.length - 1;   
          while (l <= h) {   
              m = l + (h - l) / 2;
              if (nums[m] == key) {
                  return m;
              } else if (nums[m] > key) {
                  h = m - 1;
              } else {
                  l = m + 1;
              } 
          }
          //return -1; //以一个错误码表示没有查找到 key。
          return l;   //如果查询不到返回的是表中小于它的键的数量，也即将 key插入到 nums中的正确位置。
      } 
	  
	   public static void main(String[] args) { 
           int nums[] = {3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};   
           System.out.println(binSearch(nums,20));  
       } 
}
