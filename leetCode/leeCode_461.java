package leetCode;

public class leeCode_461 {
	public int hammingDistance(int x, int y) {
	    int z = x ^ y;
	    int cnt = 0;
	    while(z != 0) {
	    	//0101 & 0001 = 0001
	    	//0010 & 0001 = 0000
	    	//0001 & 0001 = 0001
	        if ((z & 1) == 1) cnt++;
	        z = z >> 1;
	    }
	    return cnt;
	}
	
	public static void main(String[] args) {
		leeCode_461 leeCode_461 = new leeCode_461();
		leeCode_461.hammingDistance(1, 4);
		System.out.println(Integer.toString(16,4));
	}
}
