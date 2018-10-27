package test01;
/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * @author 54060
 * 
 *
 */
public class Soluction {
    public  boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null || numbers.length<0){
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
}
