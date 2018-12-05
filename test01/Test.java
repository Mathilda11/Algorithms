package test01;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {	
		Soluction soluction = new Soluction();
	    int numbers[] = {2,3,1,0,2,5,3};
	    int duplication[] = new int[1];
	    //找出数组中任意一个重复的数字
        boolean bool = soluction.duplicate(numbers, numbers.length, duplication);
        System.out.println(bool + " "+ duplication[0]);
        
        //找出所有的重复数字
        List<Integer> list = new ArrayList<>();
        boolean duplicateAll = soluction.duplicateAll(numbers, numbers.length, list);
        System.out.println(duplicateAll);
        for (Integer integer : list) {
        	System.out.println(integer);
		}
        System.out.println("--------");
        
        int nums[] = {2,3,1,4,2,5,3};
        List<Integer> arraylist = new ArrayList<>();
        soluction.duplicateNotModify(nums, nums.length, arraylist);
        for (Integer integer : arraylist) {
			System.out.println(integer);
		}
	    
	}
    
}
