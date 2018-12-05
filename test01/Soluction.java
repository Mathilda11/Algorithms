package test01;

import java.util.List;

/**
 * 1.在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 
 * 2.在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中所有重复的数字。
 * 
 * 3.在一个长度为 n+1 的数组里的所有数字都在 1 到 n 的范围内。
 * 数组中至少有一个数字是重复的，在不修改数组的情况下，找出数组中重复的数字。
 * @author 54060
 * 
 *
 */
public class Soluction {
	//1.此方法是找出数组中任意一个重复的数字
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
    
    //2.此方法是找出所有重复的数字
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
    
    //3.此方法是不修改数组，找出重复的数字
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
