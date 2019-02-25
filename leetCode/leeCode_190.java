package leetCode;

public class leeCode_190 {
	public int reverseBits(int n) {
	    int ret = 0;
	    for (int i = 0; i < 32; i++) {
	        ret <<= 1;
	        ret |= (n & 1);
	        n >>>= 1;
	    }
	    return ret;
	}
	
	public static void main(String[] args) {
		leeCode_190 leeCode_190 = new leeCode_190();
		leeCode_190.reverseBits(6);
	}
}
