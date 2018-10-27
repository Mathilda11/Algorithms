package test01;

public class Test {

	public static void main(String[] args) {	
		Soluction soluction = new Soluction();
	    int numbers[] = {2,3,1,0,2,5,3};
	    int duplication[] = new int[1];
	    int output;
        boolean bool = soluction.duplicate(numbers, numbers.length, duplication);
        System.out.println(bool + " "+ duplication[0]);
	    
	}

    
    

}