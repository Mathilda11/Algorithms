package test01;

import java.util.List;

/**
 * 1.在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 
 * 2.在一个长度为n+1的数组里的所有数字都在1到n的范围内。
 * 所以数组中至少有一个数字是重复的。请找出数组中任意一个重复的数字，但是不能修改输入的数组。
 * 
 * 3.在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中所有重复的数字。
 * 
 * 4.在一个长度为 n+1 的数组里的所有数字都在 1 到 n 的范围内。
 * 数组中至少有一个数字是重复的，在不修改数组的情况下，找出数组中所有重复的数字。
 * @author 54060
 * 
 *
 */
public class Soluction {
	//1.此方法是找出数组中任意一个重复的数字。时间复杂度O(n)，空间复杂度O(1)。
    public  boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null || numbers.length==0){
            return false;
        }
        //numbers:{2,3,1,0,2,5,3}
        for(int i=0; i < numbers.length;i++){
        	//只有当索引≠值时，才可能出现重复
            while(numbers[i] != i){  //i=0,numbers[i] = 2 != 0
                if(numbers[i] == numbers[numbers[i]]){  //i = 4, numbers[4] == numbers[2]
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i ,numbers[i]);//交换对应位置的值，使索引=值排好
            }
        }
        return false;
    }
    public void swap(int numbers[], int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    
    //2.此方法是找出数组中任意一个重复的数字。时间复杂度O(n)，空间复杂度O(n)。
    public static int getDuplication(int[] numbers) { 
    	if (numbers == null || numbers.length == 0) { 
    		return -1; 
    	} 
    	
    	for (int i = 0; i < numbers.length; i++) { 
    		if (numbers[i] < 1 || numbers[i] >= numbers.length) { 
    			return -1; 
    		} 
    	} 
    	
    	int[] nums = new int[numbers.length]; 
    	
    	for (int i = 0; i < numbers.length; i++) { 
    		if (numbers[i] == nums[numbers[i]]) { 
    			return numbers[i]; 
    		} 
    		nums[numbers[i]] = numbers[i]; 
    	} 
    	return -1;
    	
    } 
    
    //2.此方法是找出数组中任意一个重复的数字。时间复杂度O(n)，空间复杂度O(1)。
/*  把从1~n的数字从中间的数字m分为两部分，前面一半为1~m，后面一半为m+1~n。
          如果1~m的数字的数目等于m，则不能直接判断这一半区间是否包含重复的数字，反之，如果大于m，那么这一半的区间一定包含重复的数字；
          如果小于m，另一半m+1~n的区间里一定包含重复的数字。
          接下来，我们可以继续把包含重复的数字的区间一分为二，直到找到一个重复的数字。*/
    public static int getDuplication2(int[] numbers) { 
    	if (numbers == null || numbers.length == 0) { 
    		return -1; 
    	} 
    	
    	for (int i = 0; i < numbers.length; i++) { 
    		if (numbers[i] < 1 || numbers[i] >= numbers.length) { 
    			return -1; 
    		} 
    	} 
    	
    	int start = 1; 
    	int end = numbers.length - 1; 
    	int mid = 0; 
    	int count = 0; 
    	
    	while (start <= end) { 
    		if (start == end) { 
	    		count = countRange(numbers, start, end); 
	    		if (count > 1) { 
	    			return start; 
	    		} else { 
	    			break; 
	    		} 
    		} 
	    	mid = start + (end - start) / 2; 
	    	count = countRange(numbers, start, mid); 
	    	if (count > mid - start + 1) { 
	    		end = mid; 
	    	} else { 
	    		start = mid + 1; 
	    	} 
    	} 
    	return -1; 
    } 
    public static int countRange(int[] numbers, int start, int end) { 
    	int count = 0; 
    	for (int i = 0; i < numbers.length; i++) { 
    		if (numbers[i] >= start && numbers[i] <= end) { 
    			count++;
    		} 
    	} 
    	return count; 
    }

    //3.此方法是找出数组中所有重复的数字。
    public  boolean duplicateAll(int numbers[],int length,List<Integer> list) {
        if(numbers==null || numbers.length==0){
            return false;
        }
        //numbers:{2,3,1,0,2,5,3}
        for(int i=0; i < numbers.length;i++){
        	//只有当索引≠值时，才可能出现重复
            while(numbers[i] != i){  //i=0,numbers[i] = 2 != 0
                if(numbers[i] == numbers[numbers[i]]){  //i = 4, numbers[4] == numbers[2]
                	list.add(numbers[i]);
                	break;//退出当前while循环，开始下一次for循环
                }
                swap(numbers, i ,numbers[i]);//交换对应位置的值，使索引=值排好
            }
        }
        if(list.size()>0){
        	return true;
        }
        return false;
    }
    
    //4.此方法是不修改数组，找出重复的数字
    public List<Integer> duplicateNotModify(int numbers[],int length,List<Integer> list) {
    	int[] nums = new int[numbers.length];//辅助数组
    	for(int i=0;i<numbers.length;i++){
    		if(nums[numbers[i]]!=numbers[i]){
    			nums[numbers[i]] = numbers[i];
    		}else{
    			list.add(numbers[i]);
    		}
    	}
    	return list;
    }
}
